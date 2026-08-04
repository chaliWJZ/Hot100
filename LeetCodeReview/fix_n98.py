import os, re

MD = r"C:\Users\zwj90\Desktop\25秋招\3、算法\leetcode刷题笔记.md"
with open(MD, 'r', encoding='utf-8') as f:
    lines = f.readlines()

# Problem 98 is at line 11780 area (in BinaryTree section)
# Find "#### 98 " around line 11700+
for i, line in enumerate(lines):
    if re.match(r'^####\s+98\s+', line.strip()):
        start = i
        break

# Extract code
i = start + 1
blocks = []
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
    elif re.match(r'^####\s+\d+\s+', s):
        break
    else:
        i += 1

print(f"Found {len(blocks)} code blocks for problem 98")

target = r'C:\Users\zwj90\Desktop\25秋招\3、算法\LeetCodeReview\src\main\java\org\example\BinaryTree\DFS\No98'
os.makedirs(target, exist_ok=True)

all_code = '\n'.join(blocks)
needs_treenode = 'TreeNode' in all_code

# Solution98.java
imports = ['package org.example.BinaryTree.DFS.No98;', '', 'import java.util.*;']
if needs_treenode: imports.append('import org.example.CodeTemplate.TreeNode;')
imports.append('')

methods = []
for code in blocks:
    code = code.strip()
    code = re.sub(r'.*?class Solution \{', '', code, flags=re.DOTALL).strip()
    code = re.sub(r'\}\s*$', '', code).strip()
    methods.append(code)

body = '\n\n    // --- 解法一 ---\n' + methods[0]
for mi in range(1, len(methods)):
    labels = ['一','二','三']; label = labels[mi] if mi < len(labels) else str(mi+1)
    body += f'\n\n    // --- 解法{label} ---\n' + methods[mi]

sol = '\n'.join(imports) + 'public class Solution98 {\n' + body + '\n}\n'
with open(os.path.join(target, 'Solution98.java'), 'w', encoding='utf-8') as f:
    f.write(sol)

# Test.java
test = f'''package org.example.BinaryTree.DFS.No98;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {{
    public static void main(String[] args) {{
        Solution98 solution = new Solution98();
        // root = [2,1,3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(solution.isValidBST(root));
    }}
}}
'''
with open(os.path.join(target, 'Test.java'), 'w', encoding='utf-8') as f:
    f.write(test)

# show.html
with open(os.path.join(target, 'show.html'), 'w', encoding='utf-8') as f:
    f.write('')

print("Re-created No98 at BinaryTree/DFS/No98")
print("Files: Solution98.java, Test.java, show.html")
