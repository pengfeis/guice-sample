package algorithm;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public final class Sort {

    private static AtomicLong count = new AtomicLong(0);

    public static Integer[] bubleSort(Integer[] temp) {
        boolean isOrdered = true;
        while (isOrdered) {
            isOrdered = false;
            int length = temp.length;
            for (int j = 1; j < length; j++) {
                if (temp[j - 1] > temp[j]) {
                    int tempInt = temp[j - 1];
                    temp[j - 1] = temp[j];
                    temp[j] = tempInt;
                    isOrdered = true;
                }
                System.out.println(Arrays.toString(temp));
            }
            length--;
        }

        return temp;
    }


    public static Integer[] quickSort(Integer[] input, int low, int high) {
        if (low < high) {
            int partition = partition(input, low, high);
            // 递归pivot左侧数组
            quickSort(input, low, partition - 1);
            // 递归pivot右侧数组
            quickSort(input, partition + 1, high);
        }
        return input;
    }


    /**
     * 以第一个元素作为pivot，把大于pivot移到后面，否则移到前面。
     */
    private static int partition(Integer[] sorting, int low, int high) {
        // 选第一个元素作为曲轴
        int pivot = sorting[low];
        while (low < high) {
            /**
             *  从后往前，如果high对应的元素大于pivot，继续往前。
             */
            while (sorting[high] >= pivot && low < high) {
                count.getAndIncrement();
                --high;
            }
            // 当sorting[high]对应的元素小于pivot时，把sorting[high]移到左边。
            sorting[low] = sorting[high];

            /**
             * 从前往后，如果sorting[low]小于pivot，继续前进
             */
            while (sorting[low] <= pivot && low < high) {
                ++low;
            }
            // 当sorting[low]大于pivot时，把sorting[low]移到pivot的右边
            sorting[high] = sorting[low];
        }
        sorting[low] = pivot;
        return low;
    }


    public static void main(String[] args) {
        String var = "aquickbrownfoxjumpoverthelazydog";
        Integer[] nums = {1, 2, 3, 4, 5};
        Integer[] result = quickSort(nums, 0, nums.length - 1);
        for (Integer i : result) {
            System.out.println(i);
        }
        System.out.println(count.get());
    }

    public static void lackStatistics(char[] someChar) {

        // 97 = a

        int[] ints = new int[26];
        for (int i = 0; i < someChar.length; i++) {
            ints[someChar[i] - 97]++;
        }

        for (int j = 0; j < ints.length; j++) {
            if (ints[j] == 0) {
                System.out.println(((char) (j + 97) + " <---------Not "));
            } else {
                System.out.println((char) (j + 97) + " Exits " + ints[j]);
            }
        }


    }

}
