import os, re, shutil

BASE = r"C:\Users\zwj90\Desktop\25秋招\3、算法\LeetCodeReview\src\main\java\org\example"

# ===== ListNode: DummyHead vs NoDummyHead =====
LN_BASE = os.path.join(BASE, 'ListNode')

# Check each solution file for dummyHead usage
dummy_nums = set()
nondummy_nums = set()

for folder in os.listdir(LN_BASE):
    folder_path = os.path.join(LN_BASE, folder)
    if not os.path.isdir(folder_path): continue
    m = re.match(r'No(\d+)', folder)
    if not m: continue
    num = m.group(1)
    
    # Find solution file
    sol_file = os.path.join(folder_path, f'Solution{num}.java')
    if not os.path.exists(sol_file): continue
    
    with open(sol_file, 'r', encoding='utf-8') as f:
        code = f.read()
    
    if 'dummyHead' in code or 'dummy' in code.lower():
        dummy_nums.add(num)
    else:
        nondummy_nums.add(num)

print(f"ListNode DummyHead: {sorted(dummy_nums)}")
print(f"ListNode NoDummyHead: {sorted(nondummy_nums)}")

# Move folders
for sub in ['DummyHead', 'NoDummyHead']:
    os.makedirs(os.path.join(LN_BASE, sub), exist_ok=True)

for num in dummy_nums:
    src = os.path.join(LN_BASE, f'No{num}')
    dst = os.path.join(LN_BASE, 'DummyHead', f'No{num}')
    if os.path.exists(src):
        shutil.move(src, dst)
        print(f"  Moved: ListNode/No{num} -> ListNode/DummyHead/No{num}")

for num in nondummy_nums:
    src = os.path.join(LN_BASE, f'No{num}')
    dst = os.path.join(LN_BASE, 'NoDummyHead', f'No{num}')
    if os.path.exists(src):
        shutil.move(src, dst)
        print(f"  Moved: ListNode/No{num} -> ListNode/NoDummyHead/No{num}")

# ===== BinaryTree: DFS vs BFS =====
BT_BASE = os.path.join(BASE, 'BinaryTree')

dfs_nums = {'226','101','100','572','104','110','257','112','113','106','105','617','543','450','98','108','230','235','114','124'}
bfs_nums = {'107','199','637','429','111','222','404','513'}

for sub in ['DFS', 'BFS']:
    os.makedirs(os.path.join(BT_BASE, sub), exist_ok=True)

for num in dfs_nums:
    src = os.path.join(BT_BASE, f'No{num}')
    dst = os.path.join(BT_BASE, 'DFS', f'No{num}')
    if os.path.exists(src):
        shutil.move(src, dst)
        print(f"  Moved: BinaryTree/No{num} -> BinaryTree/DFS/No{num}")

for num in bfs_nums:
    src = os.path.join(BT_BASE, f'No{num}')
    dst = os.path.join(BT_BASE, 'BFS', f'No{num}')
    if os.path.exists(src):
        shutil.move(src, dst)
        print(f"  Moved: BinaryTree/No{num} -> BinaryTree/BFS/No{num}")

# ===== Update all package declarations =====
def fix_package(filepath, new_pkg):
    with open(filepath, 'r', encoding='utf-8') as f:
        content = f.read()
    content = re.sub(r'^package\s+org\.example\.\S+;', f'package {new_pkg};', content, flags=re.MULTILINE)
    with open(filepath, 'w', encoding='utf-8') as f:
        f.write(content)

# Update ListNode sub-folders
for sub in ['DummyHead', 'NoDummyHead']:
    sub_path = os.path.join(LN_BASE, sub)
    if not os.path.exists(sub_path): continue
    for folder in os.listdir(sub_path):
        folder_path = os.path.join(sub_path, folder)
        if not os.path.isdir(folder_path): continue
        m = re.match(r'No(\d+)', folder)
        if not m: continue
        num = m.group(1)
        new_pkg = f'org.example.ListNode.{sub}.{folder}'
        for fname in os.listdir(folder_path):
            if fname.endswith('.java'):
                fix_package(os.path.join(folder_path, fname), new_pkg)
                print(f"  Fixed package: {sub}/{folder}/{fname}")

# Update BinaryTree sub-folders
for sub in ['DFS', 'BFS']:
    sub_path = os.path.join(BT_BASE, sub)
    if not os.path.exists(sub_path): continue
    for folder in os.listdir(sub_path):
        folder_path = os.path.join(sub_path, folder)
        if not os.path.isdir(folder_path): continue
        m = re.match(r'No(\d+)', folder)
        if not m: continue
        num = m.group(1)
        new_pkg = f'org.example.BinaryTree.{sub}.{folder}'
        for fname in os.listdir(folder_path):
            if fname.endswith('.java'):
                fix_package(os.path.join(folder_path, fname), new_pkg)
                print(f"  Fixed package: {sub}/{folder}/{fname}")

print("\nDONE!")
