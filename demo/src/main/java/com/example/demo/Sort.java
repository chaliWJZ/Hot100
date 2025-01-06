package com.example.demo;

public class Sort {
    // 堆排序的主函数
    public static void heapSort(int[] arr) {

        // a.初始化，构建1次大顶堆
        buildMaxHeap(arr);
        int len = arr.length;

        // b.不断调整堆
        for (int i = len - 1; i > 0; i--) {

            // 先把堆顶元素（最大的元素arr[0]）和当前未排序部分的最后一个元素arr[I] 交换位置
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 然后调整 剩下的元素，让它们 重新构成大顶堆
            adjustHeap(arr, 0, i);
        }
    }

    //初次 构建大顶堆
    public static void buildMaxHeap(int[] arr) {
        int len = arr.length;
        // 从最后一个非叶子节点开始调整堆，这样可以保证整个堆构建好
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
    }

    //最核心的函数 adjustHeap！！！主要用于每次更新之后的 调整堆(大顶堆)
    public static void adjustHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        // 左孩子节点的索引
        int k = 2 * i + 1;
        while (k < len) {
            // 如果右孩子存在且比左孩子大，就选右孩子
            if (k + 1 < len && arr[k + 1] > arr[k]) {
                k = k + 1;
            }
            // 如果父节点已经比最大的孩子节点大了，那就不用调整了
            if (temp >= arr[k]) {
                break;
            }
            // 把较大的孩子节点的值赋给父节点
            arr[i] = arr[k];
            // 现在当前节点变成刚才那个较大的孩子节点了，继续往下调整
            i = k;
            k = 2 * i + 1;
        }
        // 把一开始保存的temp（原来的父节点的值）放到合适的位置
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 1, 2};
        heapSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}

