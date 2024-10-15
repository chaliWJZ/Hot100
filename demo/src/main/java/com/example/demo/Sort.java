package com.example.demo;

public class Sort {

    private static void mergeSort(int[] arr, int left, int right) {

        // 如果区间还有多个元素（非单个元素），就一直向下递归排序和合并 。如果只剩一个 元素，那么就是有序的
        if (left < right) {

            // 计算中间索引 mid
            int mid = left + (right - left) / 2;

            // 对 左半区间 进行递归，归并排序
            mergeSort(arr, left, mid);
            // 对 右半区间 进行递归排序，归并排序
            mergeSort(arr, mid + 1, right);

            //递归的处理逻辑，每次都是要调用下面的merge()方法，合并 已排序的左半区间和右半区间
            merge(arr, left, mid, right);

        }
    }

    // 这个merge()方法，主要作用其实就是 合并两个有序数组
    private static void merge(int[] arr, int left, int mid, int right) {

        // 创建临时数组temp 来存储合并后的结果，长度要指定的
        int[] temp = new int[right - left + 1];
        int p = 0;  // 临时数组temp 的指针p，不断后移 添加元素

        int i = left;  // 左子数组 的指针i
        int j = mid + 1;  // 右子数组 的指针j


        // 比较 左子数组 和 右子数组的元素，将较小的元素 放入 临时数组temp
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[p++] = arr[i++];
            else
                temp[p++] = arr[j++];
        }

        // 如果 左子数组 还有剩余元素，将其 放入 临时数组temp
        while (i <= mid) {
            temp[p++] = arr[i++];
        }

        // 如果 右子数组 还有剩余元素，将其放入临时数组
        while (j <= right) {
            temp[p++] = arr[j++];
        }

        // 切记！！每次都还要将 temp临时数组中的元素 复制回 原始数组。。注意是 往原始数组的 left下标++
        for (i = 0; i < temp.length; i++) {
            arr[left++] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        mergeSort(arr,0,arr.length-1);
        System.out.println("排序后的数组：");
        for (int num : arr){
            System.out.print(num + " ");
        }
    }

}

