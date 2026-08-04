package org.example.ListNode.DummyHead.No146;

import java.util.*;
public class Solution146 {


    // --- 解法一 ---
//  


/**
	
	这道题 要用 双向链表 + 哈希表map  来实现 LRU 最近最少使用算法:
	1、要 快速判断 某个关键字 是否存在，所以要用到 哈希表map
	2、在get()访问，或者 put()插入关键字 时，将其标记为 最近使用的，就需要插入到 双向链表的表头
	3、同时在 put()插入 关键字的时候，缓存 长度满了， 移除最久未使用的关键字，也就是 链表的 尾节点
	

**/

class LRUCache {
    
    
   //自定义 一个 双向链表，作为内部类。链表的 表头节点，就代表着 最近被访问过的 关键字key
    		// 每次 get()访问过某个关键字，就会被插入到 表头。
    		//  put() 插入 关键字key，也会被插入 表头。
    		// 链表的 尾节点 就是 最久未被访问的节点，如果长度满了，就要被移除。
    private class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
		
    // 声明 LRU类的三个final属性 
    private final int capacity; // LRU能保存的 容量，关键字个，也就是能保存多少个 链表节点
    private final Node dummy = new Node(0, 0); // 双向链表的 "虚拟"头节点，为了 方便操作，为了让 头节点和 尾节点的 pre和next指针 都不为空 
    private final Map<Integer, Node> keyToNode = new HashMap<>(); // map哈希表，快速 知道某个关键字 key，也就是 是否存在  对应的 链表节点node

    		// LRU缓存的 构造方法
    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        	// 这里的 "虚拟"头节点，初始化的时候prev和 next都指向自己。
        this.dummy.prev = dummy;
        this.dummy.next = dummy;
    }
    
    
    
    
    // 先定义最基础的3个方法:  getNode(key) 、remove(node) 、pushFront(node)
    
    //1.getNode(key) ：从 双向链表中查询，是否存在 关键字key的节点
    private Node getNode(int key) {
        
        if (!keyToNode.containsKey(key)) { // 其实就是去map哈希表查询，没有这个关键字key，就返回null
            return null;
        }
        		// 如果map哈希表中，查询的到 这个链表节点
        Node node = keyToNode.get(key); 
        
        remove(node); // 把这个节点先从 原来的位置删除
        pushFront(node); // 因为最近被访问了，就要把它放在最前面，链表表头
        return node;  // 最后返回该节点 
    }

    
    // 2. remove(node) 方法：从链表中，删除一个节点，前面后面断链就行，这里就2行就可以
    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    // 3. pushFront(node) 方法： 在链表表头，添加一个节点
    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }

    
    	// 核心方法 get(key) :需要调用 上面定义的 基础方法 
    public int get(int key) {
        
        Node node = getNode(key);
        return node != null ? node.value : -1;
        
    }

    // 核心方法 put(key,value):也需要调用 上面定义的 基础方法 
    public void put(int key, int value) {
        
        Node node = getNode(key);
        if (node != null) {    // 有这个关键字key的节点
            node.value = value; // 更新对应的 value值
            return;
        }
        	
        // 如果 这个关键字key 不存在，那么它就是 要插入的 新节点
        node = new Node(key, value); 
        //记得要插入 map， key关键字 以及对应 node 节点。。便于 后面去判断它 是否存在
        keyToNode.put(key, node);
        pushFront(node); // 因为是 最近访问的，也要记得 放到链表的表头，，也就是 链表的表头
        			
// 通过map哈希表就能知道，key关键字数量，如果超过 初始容量capacity，就要 删除链表 最后的尾节点 
        if (keyToNode.size() > capacity) {
            
            
       // 先通过 虚拟头节点的 prev，就能获取链表尾节点。。因为是 双向链表，这样可以直接获取到
            Node backNode = dummy.prev; 
            keyToNode.remove(backNode.key);  // 哈希表map也要删除它！！！
            remove(backNode); // 同时，也要删除 双向链表的最后一个尾节点 ！！
            
        }
    }
}
}