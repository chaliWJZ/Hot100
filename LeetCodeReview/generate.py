import os
import re

# Read the markdown file
md_path = r"C:\Users\zwj90\Desktop\25秋招\3、算法\leetcode刷题笔记.md"
with open(md_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()

# Section boundaries (line numbers, 1-indexed from grep)
# ## 数组: 1387, ## 字符串: 7252, ## 链表: 8855, ## 二叉树: 10282
# Next section after 二叉树: 12547 (## 线程交替打印)
sections = {
    '数组': (1387, 7252),
    '字符串': (7252, 8855),
    '链表': (8855, 10282),
    '二叉树': (10282, 12547),
}

def extract_java_code(start_line_idx):
    """Find the first ```java block starting from start_line_idx. Returns (code, end_line_idx)"""
    i = start_line_idx
    while i < len(lines):
        if lines[i].strip().startswith('```java'):
            i += 1
            code_lines = []
            while i < len(lines) and not lines[i].strip().startswith('```'):
                code_lines.append(lines[i].rstrip('\n'))
                i += 1
            return '\n'.join(code_lines), i + 1
        i += 1
    return None, start_line_idx

def extract_sample_inputs(start_line_idx):
    """Extract sample inputs from the problem description code block"""
    inputs = []
    in_desc_block = False
    i = start_line_idx
    while i < len(lines) and i < start_line_idx + 80:
        line = lines[i].strip()
        if line.startswith('```') and not in_desc_block:
            in_desc_block = True
            i += 1
            continue
        if line.startswith('```') and in_desc_block:
            in_desc_block = False
            i += 1
            continue
        if in_desc_block:
            if '输入' in line:
                input_match = re.search(r'输入[：:]\s*(.+)', line)
                if input_match:
                    inputs.append(input_match.group(1).strip())
        i += 1
    return inputs

def sanitize_filename(name):
    """Remove characters that are invalid in file/directory names"""
    return name.replace('/', '_').replace('\\', '_').replace(':', '_').replace('*', '_').replace('?', '_').replace('"', '_').replace('<', '_').replace('>', '_').replace('|', '_')

base_src = r"C:\Users\zwj90\Desktop\25秋招\3、算法\LeetCodeReview\src\main\java\org\example"

# Collect all problems
all_problems = []

for cat, (start_ln, end_ln) in sections.items():
    i = start_ln - 1  # 0-indexed
    while i < end_ln - 1:
        line = lines[i].strip()
        # Match both ### and #### headers with number + name
        m = re.match(r'^#{3,4}\s+(\d+)\s+(.+)', line)
        if m:
            number = m.group(1)
            name = m.group(2).strip()
            
            # Skip non-problem entries (like "常见树的主要类型", "DFS 深度优先遍历", "虚拟头节点")
            if name in ['常见树的主要类型', '虚拟头节点']:
                i += 1
                continue
            
            code, code_end = extract_java_code(i)
            sample_inputs = extract_sample_inputs(i)
            
            all_problems.append({
                'category': cat,
                'number': number,
                'name': name,
                'code': code,
                'sample_inputs': sample_inputs,
                'line': i + 1
            })
            i = code_end if code else i + 1
        else:
            i += 1

print(f"Total problems found: {len(all_problems)}")
for cat in ['数组', '字符串', '链表', '二叉树']:
    count = len([p for p in all_problems if p['category'] == cat])
    problems = [p for p in all_problems if p['category'] == cat]
    print(f"  {cat}: {count} problems")
    for p in problems:
        has_code = "✓" if p['code'] else "✗ NO CODE"
        print(f"    {p['number']} {p['name']} [{has_code}] samples={p['sample_inputs']}")

# ============ GENERATE FILES ============
print("\n========== Generating files ==========")

for p in all_problems:
    cat = p['category']
    number = p['number']
    name = p['name']
    code = p['code']
    
    if not code:
        print(f"  SKIP [{cat}] {number} {name} - no code found")
        continue
    
    # Folder name: "序号 题目名字"
    folder_name = sanitize_filename(f"{number} {name}")
    folder_path = os.path.join(base_src, cat, folder_name)
    os.makedirs(folder_path, exist_ok=True)
    
    # 1. Java solution class: "序号-题目名字简称.java"
    # Create a short class name
    short_name = sanitize_filename(name)
    # Limit length, remove spaces
    short_name = short_name.replace(' ', '')
    if len(short_name) > 20:
        short_name = short_name[:20]
    class_name = f"{number}-{short_name}"
    java_filename = f"{class_name}.java"
    java_path = os.path.join(folder_path, java_filename)
    
    # Build the Java class content
    # Add necessary imports and wrap code
    # Determine if ListNode or TreeNode is needed
    needs_listnode = 'ListNode' in code
    needs_treenode = 'TreeNode' in code
    
    import_lines = ['package org.example.' + cat.replace(' ', '') + '.' + folder_name.replace(' ', '') + ';', '']
    import_lines.append('import java.util.*;')
    import_lines.append('')
    
    # If code uses ListNode, define it
    if needs_listnode:
        import_lines.append('class ListNode {')
        import_lines.append('    int val;')
        import_lines.append('    ListNode next;')
        import_lines.append('    ListNode() {}')
        import_lines.append('    ListNode(int val) { this.val = val; }')
        import_lines.append('    ListNode(int val, ListNode next) { this.val = val; this.next = next; }')
        import_lines.append('}')
        import_lines.append('')
    
    # If code uses TreeNode, define it
    if needs_treenode:
        import_lines.append('class TreeNode {')
        import_lines.append('    int val;')
        import_lines.append('    TreeNode left;')
        import_lines.append('    TreeNode right;')
        import_lines.append('    TreeNode() {}')
        import_lines.append('    TreeNode(int val) { this.val = val; }')
        import_lines.append('    TreeNode(int val, TreeNode left, TreeNode right) {')
        import_lines.append('        this.val = val;')
        import_lines.append('        this.left = left;')
        import_lines.append('        this.right = right;')
        import_lines.append('    }')
        import_lines.append('}')
        import_lines.append('')
    
    # Clean the code - remove the "class Solution" wrapper and make it the main class
    # Replace "class Solution" with "public class ClassName"
    clean_code = code
    
    # Check if code has "class Solution"
    if 'class Solution' in clean_code:
        clean_code = clean_code.replace('class Solution', 'public class ' + class_name)
    else:
        # Wrap in a class
        clean_code = 'public class ' + class_name + ' {\n' + clean_code + '\n}'
    
    java_content = '\n'.join(import_lines) + '\n' + clean_code
    
    with open(java_path, 'w', encoding='utf-8') as f:
        f.write(java_content)
    
    # 2. Test class: "序号Test.java"
    test_class_name = f"{number}Test"
    test_filename = f"{test_class_name}.java"
    test_path = os.path.join(folder_path, test_filename)
    
    # Generate test main() with sample input
    test_content = f'''package org.example.{cat.replace(' ', '')}.{folder_name.replace(' ', '')};

import java.util.*;

public class {test_class_name} {{
    public static void main(String[] args) {{
        // Solution instance
        {class_name} solution = new {class_name}();
'''
    
    # Add test case construction based on sample inputs and code analysis
    samples = p['sample_inputs']
    
    if needs_listnode and samples:
        for si in samples:
            if 'head' in si or '[' in si:
                # Extract array from input like "head = [1,2,3,4,5], n = 2"
                arr_match = re.search(r'\[([^\]]+)\]', si)
                if arr_match:
                    arr_str = arr_match.group(1)
                    vals = [v.strip() for v in arr_str.split(',')]
                    test_content += f'''        // Test: {si}
        ListNode head = new ListNode({vals[0]});
        ListNode cur = head;
'''
                    for v in vals[1:]:
                        test_content += f'        cur.next = new ListNode({v}); cur = cur.next;\n'
                    test_content += '\n'
                    
                    # Check for additional params
                    extra_params = re.findall(r'(\w+)\s*=\s*(\d+)', si)
                    for param_name, param_val in extra_params:
                        if param_name not in ['head', 'val']:
                            test_content += f'        int {param_name} = {param_val};\n'
                    
                    # Call the method
                    method_match = re.search(r'public\s+\w+\s+(\w+)\s*\(', code)
                    if method_match:
                        method_name = method_match.group(1)
                        params_sig = re.findall(r'(\w+)\s+(\w+)', re.search(r'\(([^)]*)\)', code).group(1))
                        call_args = []
                        for ptype, pname in params_sig:
                            if 'ListNode' in ptype:
                                call_args.append('head')
                            elif pname in ['val', 'n', 'left', 'right', 'k', 'target']:
                                call_args.append(pname)
                            elif 'int' in ptype:
                                call_args.append('0')
                            elif 'String' in ptype:
                                call_args.append('""')
                            elif 'int[]' in ptype:
                                call_args.append('new int[]{}')
                            elif 'int[][]' in ptype:
                                call_args.append('new int[][]{}')
                            elif 'char[]' in ptype:
                                call_args.append('new char[]{}')
                            else:
                                call_args.append('null')
                        
                        call_str = ', '.join(call_args)
                        return_type_match = re.search(r'public\s+(\w+)\s+' + method_name, code)
                        return_type = return_type_match.group(1) if return_type_match else 'void'
                        
                        if return_type == 'void':
                            test_content += f'        solution.{method_name}({call_str});\n'
                            test_content += f'        // Print result\n'
                            test_content += f'        ListNode p = head;\n'
                            test_content += f'        while (p != null) {{ System.out.print(p.val + " "); p = p.next; }}\n'
                            test_content += f'        System.out.println();\n'
                        elif 'ListNode' in return_type:
                            test_content += f'        ListNode result = solution.{method_name}({call_str});\n'
                            test_content += f'        ListNode p = result;\n'
                            test_content += f'        while (p != null) {{ System.out.print(p.val + " "); p = p.next; }}\n'
                            test_content += f'        System.out.println();\n'
                        else:
                            test_content += f'        System.out.println(solution.{method_name}({call_str}));\n'
                    break
    
    elif needs_treenode and samples:
        for si in samples:
            arr_match = re.search(r'\[([^\]]+)\]', si)
            if arr_match:
                arr_str = arr_match.group(1)
                vals = [v.strip() for v in arr_str.split(',')]
                test_content += f'''        // Test: {si}
        Integer[] treeVals = {{{arr_str}}};
        TreeNode root = buildTree(treeVals, 0);
'''
                method_m = re.search(r'public\s+\w+\s+(\w+)\s*\(', code)
                mname = method_m.group(1) if method_m else 'solve'
                test_content += '        System.out.println(solution.' + mname + '(root));\n'
                test_content += '    }\n'
                test_content += '    \n'
                test_content += '    // Helper: build binary tree from array\n'
                test_content += '    private static TreeNode buildTree(Integer[] vals, int i) {\n'
                test_content += '        if (i >= vals.length || vals[i] == null) return null;\n'
                test_content += '        TreeNode node = new TreeNode(vals[i]);\n'
                test_content += '        node.left = buildTree(vals, 2 * i + 1);\n'
                test_content += '        node.right = buildTree(vals, 2 * i + 2);\n'
                test_content += '        return node;\n'
                test_content += '    }\n'
                test_content += '}\n'
                break
    else:
        # General case - arrays, strings, etc.
        if samples:
            test_content += f'        // Sample: {samples[0]}\n'
        
        # Try to generate appropriate test code based on method signature
        method_match = re.search(r'public\s+(\w+)\s+(\w+)\s*\(([^)]*)\)', code)
        if method_match:
            return_type = method_match.group(1)
            method_name = method_match.group(2)
            params_str = method_match.group(3)
            params = [p.strip() for p in params_str.split(',') if p.strip()]
            
            # Generate params
            call_args = []
            for param in params:
                parts = param.split()
                if len(parts) >= 2:
                    ptype = parts[-2]
                    pname = parts[-1]
                    
                    if 'int[]' in ptype:
                        # Check sample for array values
                        arr_found = False
                        for si in samples:
                            arr_match = re.search(r'\[([^\]]+)\]', si)
                            if arr_match:
                                test_content += f'        int[] {pname} = new int[]{{{arr_match.group(1)}}};\n'
                                call_args.append(pname)
                                arr_found = True
                                break
                        if not arr_found:
                            test_content += f'        int[] {pname} = new int[]{{1,2,3}};\n'
                            call_args.append(pname)
                    elif 'int[][]' in ptype:
                        test_content += f'        int[][] {pname} = new int[][]{{{{1,2}},{{3,4}}}};\n'
                        call_args.append(pname)
                    elif 'String' in ptype:
                        for si in samples:
                            str_match = re.search(r'"([^"]+)"', si)
                            if str_match:
                                test_content += f'        String {pname} = "{str_match.group(1)}";\n'
                                call_args.append(pname)
                                break
                        else:
                            if 'char[]' in ptype:
                                test_content += f'        char[] {pname} = new char[]{{{{\'h\',\'e\',\'l\',\'l\',\'o\'}}}};\n'
                            else:
                                test_content += f'        String {pname} = "hello";\n'
                            call_args.append(pname)
                    elif 'int' in ptype:
                        for si in samples:
                            val_match = re.search(rf'{pname}\s*=\s*(\d+)', si.replace(' ', ''))
                            if val_match:
                                test_content += f'        int {pname} = {val_match.group(1)};\n'
                                call_args.append(pname)
                                break
                        else:
                            # Check if a number appears in samples
                            num_match = re.search(r'(\d+)', ' '.join(samples))
                            if num_match and pname == 'target':
                                test_content += f'        int {pname} = {num_match.group(1)};\n'
                                call_args.append(pname)
                            elif pname == 'val':
                                test_content += f'        int {pname} = 6;\n'
                                call_args.append(pname)
                            else:
                                test_content += f'        int {pname} = 3;\n'
                                call_args.append(pname)
                    elif 'char[][]' in ptype:
                        test_content += f'        char[][] {pname} = new char[][]{{{{\'a\',\'b\'}},{{\'c\',\'d\'}}}};\n'
                        call_args.append(pname)
                    elif 'List' in ptype:
                        test_content += f'        List<Integer> {pname} = new ArrayList<>(Arrays.asList(1,2,3));\n'
                        call_args.append(pname)
                    elif 'ListNode' in ptype:
                        test_content += f'        ListNode {pname} = new ListNode(1);\n'
                        test_content += f'        {pname}.next = new ListNode(2);\n'
                        call_args.append(pname)
                    elif 'TreeNode' in ptype:
                        test_content += f'        TreeNode {pname} = new TreeNode(1);\n'
                        call_args.append(pname)
                    else:
                        call_args.append('null')
            
            call_str = ', '.join(call_args)
            if return_type == 'void':
                test_content += f'        solution.{method_name}({call_str});\n'
                test_content += f'        System.out.println("Done");\n'
            elif 'int[]' in return_type:
                test_content += f'        int[] result = solution.{method_name}({call_str});\n'
                test_content += f'        System.out.println(java.util.Arrays.toString(result));\n'
            elif 'List' in return_type:
                test_content += f'        System.out.println(solution.{method_name}({call_str}));\n'
            elif 'boolean' in return_type:
                test_content += f'        System.out.println(solution.{method_name}({call_str}));\n'
            else:
                test_content += f'        System.out.println(solution.{method_name}({call_str}));\n'
    
    test_content += '    }\n}\n'
    
    with open(test_path, 'w', encoding='utf-8') as f:
        f.write(test_content)
    
    # 3. Empty HTML file
    html_filename = f"{number} {name}.html"
    html_path = os.path.join(folder_path, html_filename)
    with open(html_path, 'w', encoding='utf-8') as f:
        f.write('')
    
    print(f"  ✓ [{cat}] {number} {name} -> {folder_name}/")

print("\n========== DONE ==========")
print(f"Total problems processed: {len(all_problems)}")
