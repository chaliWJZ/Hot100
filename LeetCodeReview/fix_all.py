import os, re, shutil

BASE = r"C:\Users\zwj90\Desktop\25秋招\3、算法\LeetCodeReview\src\main\java\org\example"
CATS = ['CommonArray', 'CommonString', 'ListNode', 'BinaryTree']

for cat in CATS:
    cat_path = os.path.join(BASE, cat)
    if not os.path.exists(cat_path):
        continue
    for folder_name in os.listdir(cat_path):
        old_folder = os.path.join(cat_path, folder_name)
        if not os.path.isdir(old_folder):
            continue
        
        # Extract number from folder name like "98 验证二叉搜索树"
        m = re.match(r'(\d+)\s+', folder_name)
        if not m:
            print(f"  SKIP (no number): {cat}/{folder_name}")
            continue
        num = m.group(1)
        new_folder_name = f"No{num}"
        new_folder = os.path.join(cat_path, new_folder_name)
        
        # 1. Rename folder
        if old_folder != new_folder:
            if os.path.exists(new_folder):
                shutil.rmtree(new_folder)
            os.rename(old_folder, new_folder)
            print(f"  RENAMED: {cat}/{folder_name} -> {new_folder_name}")
        
        # 2. Fix Solution.java
        sol_path = os.path.join(new_folder, 'Solution.java')
        if os.path.exists(sol_path):
            with open(sol_path, 'r', encoding='utf-8') as f:
                content = f.read()
            
            # Fix package
            content = re.sub(r'package\s+org\.example\.\S+;',
                           f'package org.example.{cat}.{new_folder_name};', content)
            
            # Replace class name
            content = content.replace('public class Solution {',
                                     f'public class Resolution{num} {{')
            
            # Ensure closing brace at end (class-level)
            content = content.rstrip()
            # Count braces: opening { at class level + each method = N open, N close needed at end
            # The outermost class { is at the start, so we always need to append one }
            content += '\n}'
            
            with open(sol_path, 'w', encoding='utf-8') as f:
                f.write(content)
            print(f"    Fixed Solution.java -> Resolution{num}")
        
        # 3. Fix Test.java
        test_path = os.path.join(new_folder, 'Test.java')
        if os.path.exists(test_path):
            with open(test_path, 'r', encoding='utf-8') as f:
                content = f.read()
            
            # Fix package
            content = re.sub(r'package\s+org\.example\.\S+;',
                           f'package org.example.{cat}.{new_folder_name};', content)
            
            # Replace Solution with ResolutionXXX
            content = content.replace('Solution solution', f'Resolution{num} solution')
            content = content.replace('new Solution()', f'new Resolution{num}()')
            
            with open(test_path, 'w', encoding='utf-8') as f:
                f.write(content)
            print(f"    Fixed Test.java")

print("\nDONE!")
