import os, re, shutil

MD = r"C:\Users\zwj90\Desktop\25秋招\3、算法\leetcode刷题笔记.md"
BASE = r"C:\Users\zwj90\Desktop\25秋招\3、算法\LeetCodeReview\src\main\java\org\example"

with open(MD, 'r', encoding='utf-8') as f:
    lines = f.readlines()

SECTIONS = [
    ('CommonArray', 1387, 7252),
    ('CommonString', 7252, 8855),
    ('ListNode', 8855, 10282),
    ('BinaryTree', 10282, 12547),
]

def extract_code_blocks(start_idx):
    blocks = []
    i = start_idx + 1
    while i < len(lines):
        s = lines[i].strip()
        if s.startswith('```java'):
            i += 1
            code_lines = []
            while i < len(lines) and not lines[i].strip().startswith('```'):
                code_lines.append(lines[i].rstrip('\n'))
                i += 1
            code = '\n'.join(code_lines).strip()
            if code: blocks.append(code)
            i += 1
        elif re.match(r'^#{3,4}\s+\d+\s+', s):
            break
        else:
            i += 1
    return blocks

def extract_sample_inputs(start_idx):
    inputs = []
    in_block = False
    for i in range(start_idx, min(start_idx + 80, len(lines))):
        s = lines[i].strip()
        if s.startswith('```') and not in_block:
            in_block = True; continue
        if s.startswith('```') and in_block:
            in_block = False; continue
        if in_block and '输入' in s:
            m = re.search(r'输入[：:]\s*(.+)', s)
            if m: inputs.append(m.group(1).strip())
    return inputs

def sanitize(name):
    return name.replace('/', '_').replace('\\', '_').replace(':', '_').replace('*', '_').replace('?', '_').replace('"', '_').replace('<', '_').replace('>', '_').replace('|', '_')

# ── Helper: ListNode test ──
def gen_listnode_test(samples, code):
    result = ''
    for si in samples:
        arr_m = re.search(r'\[([^\]]+)\]', si)
        if not arr_m: continue
        vals = [v.strip() for v in arr_m.group(1).split(',')]
        result += f'        // {si}\n'
        result += f'        ListNode head = new ListNode({vals[0]});\n'
        if len(vals) > 1:
            result += '        ListNode cur = head;\n'
            for v in vals[1:]:
                result += f'        cur.next = new ListNode({v}); cur = cur.next;\n'
        result += '\n'
        extras = re.findall(r'(\w+)\s*=\s*(\d+)', si)
        for pn, pv in extras:
            if pn not in ('head',):
                result += f'        int {pn} = {pv};\n'
        method_m = re.search(r'public\s+(\w+)\s+(\w+)\s*\(([^)]*)\)', code)
        if method_m:
            rtype, mname, params = method_m.group(1), method_m.group(2), method_m.group(3)
            plist = [x.strip() for x in params.split(',') if x.strip()]
            args = []
            for param in plist:
                parts = param.split()
                if len(parts) >= 2:
                    t = parts[-2]; n = parts[-1]
                    if 'ListNode' in t: args.append('head')
                    elif n in dict(extras): args.append(n)
                    elif 'int' in t: args.append('0')
                    else: args.append('null')
            call = ', '.join(args)
            if 'ListNode' in rtype:
                result += f'        ListNode res = solution.{mname}({call});\n'
                result += '        ListNode p = res;\n'
                result += '        while(p!=null){ System.out.print(p.val+" "); p=p.next; }\n'
                result += '        System.out.println();\n'
            elif rtype == 'void':
                result += f'        solution.{mname}({call});\n'
                result += '        ListNode p = head;\n'
                result += '        while(p!=null){ System.out.print(p.val+" "); p=p.next; }\n'
                result += '        System.out.println();\n'
            else:
                result += f'        System.out.println(solution.{mname}({call}));\n'
        break
    return result

# ── Helper: TreeNode test ──
def gen_treenode_test(samples, code):
    result = ''
    for si in samples:
        arr_m = re.search(r'\[([^\]]+)\]', si)
        if not arr_m: continue
        vals_list = [v.strip() for v in arr_m.group(1).split(',')]
        result += f'        // {si}\n'
        result += f'        TreeNode root = new TreeNode({vals_list[0]});\n'
        if len(vals_list) > 1:
            idx = 1; nodes = ['root']
            while idx < len(vals_list):
                pname = nodes.pop(0)
                if idx < len(vals_list) and vals_list[idx] != 'null':
                    result += f'        {pname}.left = new TreeNode({vals_list[idx]});\n'
                    nodes.append(f'{pname}.left')
                idx += 1
                if idx < len(vals_list) and vals_list[idx] != 'null':
                    result += f'        {pname}.right = new TreeNode({vals_list[idx]});\n'
                    nodes.append(f'{pname}.right')
                idx += 1
        result += '\n'
        method_m = re.search(r'public\s+(\w+)\s+(\w+)\s*\(([^)]*)\)', code)
        if method_m:
            rtype, mname = method_m.group(1), method_m.group(2)
            if 'boolean' in rtype or 'int' in rtype:
                result += f'        System.out.println(solution.{mname}(root));\n'
            elif 'TreeNode' in rtype:
                result += f'        TreeNode res = solution.{mname}(root);\n'
                result += '        System.out.println(res != null ? res.val : "null");\n'
            else:
                result += f'        System.out.println(solution.{mname}(root));\n'
        break
    return result

# ── Helper: General test ──
def gen_general_test(samples, code):
    result = ''
    if samples:
        result += f'        // {samples[0]}\n'
    method_m = re.search(r'public\s+(\w+)\s+(\w+)\s*\(([^)]*)\)', code)
    if not method_m:
        result += '        System.out.println("Test");\n'
        return result
    rtype, mname, params = method_m.group(1), method_m.group(2), method_m.group(3)
    plist = [x.strip() for x in params.split(',') if x.strip()]
    args = []
    for param in plist:
        parts = param.split()
        if len(parts) < 2: continue
        t = parts[-2]; n = parts[-1]
        if 'int[]' in t or 'int [' in t:
            found = False
            for si in samples:
                arr_m = re.search(r'\[([^\]]+)\]', si)
                if arr_m:
                    result += f'        int[] {n} = new int[]{{{arr_m.group(1)}}};\n'
                    args.append(n); found = True; break
            if not found:
                result += f'        int[] {n} = new int[]{{1,2,3}};\n'; args.append(n)
        elif 'int[][]' in t:
            result += f'        int[][] {n} = new int[][]{{{{1,2,3}},{{4,5,6}},{{7,8,9}}}};\n'; args.append(n)
        elif 'char[]' in t:
            found = False
            for si in samples:
                arr_m = re.findall(r'"([^"]*)"', si)
                if arr_m:
                    chars = ','.join([f"'{c}'" for c in arr_m[0]])
                    result += f'        char[] {n} = new char[]{{{chars}}};\n'
                    args.append(n); found = True; break
            if not found:
                result += f'        char[] {n} = new char[]{{\'h\',\'e\',\'l\',\'l\',\'o\'}};\n'; args.append(n)
        elif 'String' in t:
            found = False
            for si in samples:
                str_m = re.search(r'"([^"]+)"', si)
                if str_m:
                    result += f'        String {n} = "{str_m.group(1)}";\n'
                    args.append(n); found = True; break
            if not found:
                result += f'        String {n} = "hello";\n'; args.append(n)
        elif 'int' in t:
            found = False
            for si in samples:
                m2 = re.search(rf'{n}\s*=\s*(\d+)', si.replace(' ', ''))
                if m2:
                    result += f'        int {n} = {m2.group(1)};\n'
                    args.append(n); found = True; break
            if not found:
                for si in samples:
                    m3 = re.search(r'(\d+)', si)
                    if m3:
                        result += f'        int {n} = {m3.group(1)};\n'
                        args.append(n); found = True; break
            if not found:
                result += f'        int {n} = 3;\n'; args.append(n)
        elif 'boolean' in t:
            result += f'        boolean {n} = true;\n'; args.append(n)
        elif 'ListNode' in t:
            result += f'        ListNode {n} = new ListNode(1); {n}.next = new ListNode(2);\n'; args.append(n)
        elif 'TreeNode' in t:
            result += f'        TreeNode {n} = new TreeNode(1); {n}.left = new TreeNode(2); {n}.right = new TreeNode(3);\n'; args.append(n)
        elif 'List' in t:
            result += f'        List<Integer> {n} = new ArrayList<>(Arrays.asList(1,2,3));\n'; args.append(n)
        else:
            args.append('null')
    call = ', '.join(args)
    if 'int[]' in rtype:
        result += f'        int[] res = solution.{mname}({call});\n'
        result += '        System.out.println(java.util.Arrays.toString(res));\n'
    elif 'List' in rtype:
        result += f'        System.out.println(solution.{mname}({call}));\n'
    elif rtype == 'void':
        result += f'        solution.{mname}({call});\n'
        result += '        System.out.println("Done");\n'
    else:
        result += f'        System.out.println(solution.{mname}({call}));\n'
    return result


# ══════ MAIN ══════
# Delete old Chinese-named folders
for old_name in ['数组', '字符串', '链表', '二叉树']:
    old_path = os.path.join(BASE, old_name)
    if os.path.exists(old_path):
        shutil.rmtree(old_path)
        print(f"Deleted: {old_name}")

# Collect
all_problems = []
for cat_folder, start_ln, end_ln in SECTIONS:
    i = start_ln - 1
    while i < end_ln - 1:
        line = lines[i].strip()
        m = re.match(r'^#{3,4}\s+(\d+)\s+(.+)', line)
        if m:
            number = m.group(1)
            name = m.group(2).strip()
            if name in ['常见树的主要类型', '虚拟头节点']:
                i += 1; continue
            code_blocks = extract_code_blocks(i)
            samples = extract_sample_inputs(i)
            all_problems.append({
                'cat': cat_folder, 'num': number, 'name': name,
                'codes': code_blocks, 'samples': samples
            })
            i += 1
        else:
            i += 1

print(f"Total problems: {len(all_problems)}")
for c in ['CommonArray', 'CommonString', 'ListNode', 'BinaryTree']:
    cnt = len([p for p in all_problems if p['cat'] == c])
    print(f"  {c}: {cnt}")

# Generate
for p in all_problems:
    cat = p['cat']; num = p['num']; name = p['name']
    codes = p['codes']; samples = p['samples']
    if not codes:
        print(f"  SKIP [{cat}] {num} {name} - no code")
        continue
    folder_name = sanitize(f"{num} {name}")
    folder_path = os.path.join(BASE, cat, folder_name)
    os.makedirs(folder_path, exist_ok=True)
    
    all_code = '\n'.join(codes)
    needs_listnode = 'ListNode' in all_code
    needs_treenode = 'TreeNode' in all_code
    
    # Solution.java
    imports = ['package org.example.' + cat + ';', '', 'import java.util.*;']
    if needs_listnode: imports.append('import org.example.CodeTemplate.ListNode;')
    if needs_treenode: imports.append('import org.example.CodeTemplate.TreeNode;')
    imports.append('')
    methods = []
    for code in codes:
        code = code.strip()
        code = re.sub(r'.*?class Solution \{', '', code, flags=re.DOTALL).strip()
        code = re.sub(r'\}\s*$', '', code).strip()
        methods.append(code)
    body = '\n\n    // --- 解法一 ---\n' + methods[0]
    for mi in range(1, len(methods)):
        labels = ['一','二','三','四','五']; label = labels[mi] if mi < len(labels) else str(mi+1)
        body += f'\n\n    // --- 解法{label} ---\n' + methods[mi]
    with open(os.path.join(folder_path, 'Solution.java'), 'w', encoding='utf-8') as f:
        f.write('\n'.join(imports) + 'public class Solution {\n' + body + '\n}\n')
    
    # Test.java
    test_pkg = f'package org.example.{cat};\n\nimport java.util.*;\n'
    if needs_listnode: test_pkg += 'import org.example.CodeTemplate.ListNode;\n'
    if needs_treenode: test_pkg += 'import org.example.CodeTemplate.TreeNode;\n'
    test_pkg += '\npublic class Test {\n    public static void main(String[] args) {\n'
    test_pkg += '        Solution solution = new Solution();\n'
    primary_code = codes[0]
    if needs_listnode and samples:
        test_pkg += gen_listnode_test(samples, primary_code)
    elif needs_treenode and samples:
        test_pkg += gen_treenode_test(samples, primary_code)
    else:
        test_pkg += gen_general_test(samples, primary_code)
    test_pkg += '    }\n}\n'
    with open(os.path.join(folder_path, 'Test.java'), 'w', encoding='utf-8') as f:
        f.write(test_pkg)
    
    # show.html
    with open(os.path.join(folder_path, 'show.html'), 'w', encoding='utf-8') as f:
        f.write('')
    print(f"  OK [{cat}] {num} {name}")

print(f"\nDONE. Total: {len(all_problems)}")





