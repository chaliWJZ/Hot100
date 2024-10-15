package com.example.demo.demos.web;

public class MergeSort {


    private void mergeSort(int[] arr, int left, int right) {

        if (left <right) {

            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);

        }

    }

    private void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int p = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[p++] = arr[i++];
            else
                temp[p++] = arr[j++];
        }

        while (i <= mid) {
            temp[p++] = arr[i++];
        }

        while (j <= right) {
            temp[p++] = arr[j++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[left++] = temp[i];
        }
    }


    public static void main(String[] args) {


        MergeSort mergeSort = new MergeSort();

        int[] arr = {4, 3, 2, 10, 12, 1, 5, 6};

        mergeSort.mergeSort(arr,0,arr.length-1);



        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

}