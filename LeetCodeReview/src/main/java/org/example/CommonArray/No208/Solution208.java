package org.example.CommonArray.No208;

import java.util.*;
public class Solution208 {


    // --- 解法一 ---
// 本质就是 构建一个 26叉树。对应26个 英文字母
// 前缀树的每个结点 都有26个子节点，对应26个 字母。
// 一次建树，可以 多次查询。

class Trie {

    class TireNode {
        // 节点值并不是存放 对应的字母，而是表示 该结点是否是一个 字符串的结束末尾
        private boolean isEnd;
        // 用一个 数组，来定义它的26个孩子节点，比如 下标0 就是 'a'字母，以此类推
        TireNode[] next;

        public TireNode() {
            isEnd = false;
            next = new TireNode[26];
        }
    }

    private TireNode root;

    public Trie() {
        root = new TireNode();
    }

    // 构建26叉树 和 构建链表 很像。首先要定义一个 移动指针 node，从根结点的子结点root.next开始，依次遍历字符串的字符，如果对应字符所在的子节点为null，就要开辟新的结点，同时node 要下移。当插入完 word 的最后一个字符，同时还要将最后一个结点isEnd = true，表示它是一个单词的末尾。
 
    public void insert(String word) {

        TireNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TireNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;

    }


    // 查找某个字符串，必须要完全匹配。从根结点的子结点root.next开始，一直向下匹配。如果 遍历字符串的字符 过程中，结点为空null就返回 false，说明对应字符没找到。如果匹配到了最后一个word字符，那我们只需判断 node.isEnd的值 即可。为什么要判断它，而不是直接返回true？主要是因为可能 26叉树存储的已有字符串比 当前搜索的word还要长，所以 word只是它的一部分，并不是完全匹配，那么其实应该返回false。
    public boolean search(String word) {
        TireNode node = root;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }


    // 查找匹配 某个字符串的前缀prefix，只需要前面的几个字符 相同匹配就行。其实大致的思路和 search()方法差不多。。如果能够for循环 匹配到最后一个word字符，说明前面的字符都是相同的，只需要字符串的前半部分 匹配就行。那么 我们直接返回 true 。
    public boolean startsWith(String prefix) {
        TireNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
}