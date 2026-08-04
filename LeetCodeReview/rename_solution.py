import os, re

BASE = r"C:\Users\zwj90\Desktop\25秋招\3、算法\LeetCodeReview\src\main\java\org\example"
CATS = ['CommonArray', 'CommonString', 'ListNode', 'BinaryTree']

for cat in CATS:
    cat_path = os.path.join(BASE, cat)
    if not os.path.exists(cat_path):
        continue
    for folder_name in os.listdir(cat_path):
        folder_path = os.path.join(cat_path, folder_name)
        if not os.path.isdir(folder_path):
            continue
        
        # Extract number: "No98" → "98"
        m = re.match(r'No(\d+)', folder_name)
        if not m:
            continue
        num = m.group(1)
        
        old_sol = os.path.join(folder_path, 'Solution.java')
        if not os.path.exists(old_sol):
            continue
        
        # Read existing Solution.java
        with open(old_sol, 'r', encoding='utf-8') as f:
            content = f.read()
        
        # Replace class name: ResolutionXXX → SolutionXXX
        content = content.replace(f'Resolution{num}', f'Solution{num}')
        
        # Write as new file: SolutionXXX.java
        new_sol = os.path.join(folder_path, f'Solution{num}.java')
        with open(new_sol, 'w', encoding='utf-8') as f:
            f.write(content)
        
        # Delete old Solution.java
        os.remove(old_sol)
        
        # 2. Update Test.java
        test_path = os.path.join(folder_path, 'Test.java')
        if os.path.exists(test_path):
            with open(test_path, 'r', encoding='utf-8') as f:
                test_content = f.read()
            test_content = test_content.replace(f'Resolution{num}', f'Solution{num}')
            with open(test_path, 'w', encoding='utf-8') as f:
                f.write(test_content)
        
        print(f"  OK: {cat}/{folder_name} → Solution{num}.java")

print("\nDONE!")
