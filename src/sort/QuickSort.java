package sort;

import java.util.Arrays;

public class QuickSort {
    static int[] sort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        return quickSort(arr, 0, arr.length - 1);
    }

    static int[] quickSort(int[] arr, int left, int right) {
        if (left <= right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
        return arr;
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int i = left + 1;
        for (int j = i; j <= right; j++) {
            if (arr[j] < arr[pivot]) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, pivot, i - 1);
        return i - 1;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 1};

        Arrays.stream(sort(arr)).forEach(x -> System.out.print(x + ","));
    }
}
