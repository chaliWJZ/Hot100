import os

BASE = r"C:\Users\zwj90\Desktop\25秋招\3、算法\LeetCodeReview\src\main\java\org\example"

for cat in ['CommonArray', 'CommonString', 'ListNode', 'BinaryTree']:
    cat_path = os.path.join(BASE, cat)
    if not os.path.exists(cat_path):
        continue
    for folder_name in os.listdir(cat_path):
        folder_path = os.path.join(cat_path, folder_name)
        sol_path = os.path.join(folder_path, 'Solution.java')
        if not os.path.exists(sol_path):
            continue
        with open(sol_path, 'r', encoding='utf-8') as f:
            content = f.read()
        content = content.rstrip()
        # Count opening { vs closing }
        opens = content.count('{')
        closes = content.count('}')
        missing = opens - closes
        if missing > 0:
            content += '\n' + '}' * missing
            with open(sol_path, 'w', encoding='utf-8') as f:
                f.write(content)
            print(f"  Fixed {missing} missing brace(s): {cat}/{folder_name}")

print("Done!")
