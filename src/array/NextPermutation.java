package array;

import java.util.Arrays;

public class NextPermutation {
    /**
     * my first solution
     */
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;

            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }

            if (i >= 0) {
                int j = binarySearch(nums, i + 1, nums.length, nums[i]);
                swap(nums, i, j);
            }

            reverse(nums, i + 1, nums.length - 1);
        }

        void reverse(int[] nums, int left, int right) {
            while (left < right) {
                swap(nums, left++, right--);
            }
        }

        //desc lower_bound
        int binarySearch(int[] nums, int left, int right, int target) {
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] > target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left - 1;
        }

        void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    /**
     * modify zhiguo's solution to right anwser
     */
    class Solution1 {
        public void nextPermutation(int[] numbers) {
            // 数字拆成数组
            //            String numberStr = String.valueOf(number);
            //            int[] numbers = new int[numberStr.length()];
            //            for (int i = 0; i < numberStr.length(); i++) {
            //                numbers[i] = Integer.parseInt(String.valueOf(numberStr.charAt(i)));
            //            }

            // 从最后一位开始，向前找到不是降序的第一个数
            // 将该位与降序中的大于该数的最小数交换
            // 将该位后的数字升序排序
            int indexOfNotSort;
            for (indexOfNotSort = numbers.length - 1;
                indexOfNotSort > 0 && numbers[indexOfNotSort] <= numbers[indexOfNotSort - 1];
                indexOfNotSort--) {}
            if (indexOfNotSort > 0) {
                int numberOfNotSort = numbers[indexOfNotSort - 1];

                int smallestIndex = numbers.length - 1;
                for (int i = numbers.length - 1; i >= indexOfNotSort; i--) {
                    smallestIndex = i;
                    if (numbers[i] > numberOfNotSort) {
                        break;
                    }
                }

                int temp = numbers[indexOfNotSort - 1];
                numbers[indexOfNotSort - 1] = numbers[smallestIndex];
                numbers[smallestIndex] = temp;
            }

            Arrays.sort(numbers, indexOfNotSort, numbers.length);
        }
    }

    /**
     * zhiguo's origin solution not right
     *
     * <p>边界情况 1.数组完全降序，indexOfNotSort取不到 2.numbers[indexOfNotSort] < numbers[indexOfNotSort - 1]这块要取<=,只取<有问题
     *
     * <p>nt temp = numbers[indexOfNotSort]; numbers[indexOfNotSort] = numbers[smallestIndex]; numbers[smallestIndex] =
     * temp; 换的时候这块应该取indexOfNotSort-1
     *
     * <p>可优化： 1.还有个可优化的点在于，找后面比它大的中的最小的时候，可以用二分 2.ArraySort是快排O(nlogn)，翻转的时候直接首位元素交换O(n/2)
     */
    static class Solution2 {
        public static int findNext(int number) {
            // 数字拆成数组
            String numberStr = String.valueOf(number);
            int[] numbers = new int[numberStr.length()];
            for (int i = 0; i < numberStr.length(); i++) {
                numbers[i] = Integer.parseInt(String.valueOf(numberStr.charAt(i)));
            }

            // 从最后一位开始，向前找到不是降序的第一个数
            // 将该位与降序中的大于该数的最小数交换
            // 将该位后的数字升序排序
            int indexOfNotSort;
            for (indexOfNotSort = numbers.length - 1;
                indexOfNotSort > 0 && numbers[indexOfNotSort] < numbers[indexOfNotSort - 1];
                indexOfNotSort--) {}
            indexOfNotSort = Math.max(indexOfNotSort - 1, 0);

            int numberOfNotSort = numbers[indexOfNotSort];

            int smallestIndex = numbers.length - 1;
            for (int i = numbers.length - 1; i >= indexOfNotSort; i--) {
                smallestIndex = i;
                if (numbers[i] > numberOfNotSort) {
                    break;
                }
            }

            int temp = numbers[indexOfNotSort];
            numbers[indexOfNotSort] = numbers[smallestIndex];
            numbers[smallestIndex] = temp;

            Arrays.sort(numbers, indexOfNotSort + 1, numbers.length);

            StringBuilder stringBuilder = new StringBuilder();
            for (int i : numbers) {
                stringBuilder.append(i);
            }

            return Integer.parseInt(stringBuilder.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution2.findNext(321));
    }
}
