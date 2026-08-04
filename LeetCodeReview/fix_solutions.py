import os, re

BASE = r"C:\Users\zwj90\Desktop\25秋招\3、算法\LeetCodeReview\src\main\java\org\example"

for cat in ['CommonArray', 'CommonString', 'ListNode', 'BinaryTree']:
    cat_path = os.path.join(BASE, cat)
    if not os.path.exists(cat_path): continue
    for folder in os.listdir(cat_path):
        folder_path = os.path.join(cat_path, folder)
        solution_path = os.path.join(folder_path, 'Solution.java')
        if not os.path.exists(solution_path): continue
        
        with open(solution_path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        original = content
        
        # Find the "class Solution {" that's inside the file (after the first line with 'package')
        # and remove it along with its trailing }
        # Pattern: the file starts with "package ...;\n\nimport...;\npublic class Solution {\n"
        # Then inside there might be "class Solution {\n...\n}"
        
        # Strategy: find the SECOND occurrence of "class Solution" and remove everything
        # between it and the matching closing brace
        first_class = content.find('class Solution')
        if first_class >= 0:
            second_class = content.find('class Solution', first_class + 1)
            if second_class >= 0:
                # Found a nested class Solution
                before = content[:second_class]
                after_inner = content[second_class:]
                # Find the line with "class Solution {"
                line_end = after_inner.find('\n')
                if line_end >= 0:
                    after_inner = after_inner[line_end+1:]  # skip the class Solution { line
                
                # Now find the matching closing } for the inner class
                # Simply remove the last } before the outer class closing }
                # The outer class has a single } at the very end
                # The inner class also has a } before it
                last_brace = after_inner.rfind('}')
                if last_brace >= 0:
                    after_inner = after_inner[:last_brace] + after_inner[last_brace+1:]
                
                content = before + after_inner
                # Clean up extra blank lines
                content = re.sub(r'\n\s*\n\s*\n', '\n\n', content)
        
        if content != original:
            with open(solution_path, 'w', encoding='utf-8') as f:
                f.write(content)
            print(f"  Fixed: {cat}/{folder}")

print("Done fixing Solution.java files")
