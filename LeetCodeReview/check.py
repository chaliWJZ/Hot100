import os
base = r'C:\Users\zwj90\Desktop\25秋招\3、算法\LeetCodeReview\src\main\java\org\example\BinaryTree\DFS'
folders = sorted([f for f in os.listdir(base) if os.path.isdir(os.path.join(base,f))])
expected = {'226','101','100','572','104','110','257','112','113','106','105','617','543','450','98','108','230','235','114','124'}
actual = {f[2:] for f in folders if f.startswith('No')}
missing = expected - actual
print(f'Actual: {sorted(actual)}')
print(f'Missing: {sorted(missing)}')
total = 75+18+10+7+len(actual)+8
print(f'Total should be: {total} (75+18+10+7+{len(actual)}+8)')
