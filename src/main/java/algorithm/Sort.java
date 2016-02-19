package algorithm;

import java.util.Arrays;

public class Sort {
    public static Integer[] bubleSort(Integer[] temp) {
        boolean isOrdered = true;
        while (isOrdered) {
            isOrdered = false;
            int length = temp.length;
            for (int j = 1; j < length; j++) {
                if (temp[j-1] > temp[j]) {
                    int tempInt = temp[j-1];
                    temp[j-1] = temp[j];
                    temp[j] = tempInt;
                    isOrdered = true;
                }
                System.out.println(Arrays.toString(temp));
            }
            length--;
        }

        return temp;
    }


    public static Integer[] quickSort(Integer[] sorting) {
        int low = 0; int high = sorting.length-1;
        int pivot = sorting[low];
        while(low < high) {
            while (sorting[low] <= pivot && low < high) {
                ++low;
            }
        }


        return null;
    }



    public static void main(String[] args) {
        String var = "aquickbrownfoxjumpoverthelazydog";
        lackStatistics(var.toCharArray());
    }

    public static void lackStatistics(char[] someChar) {

        // 97 = a

        int[] ints = new int[26];
        for (int i = 0; i < someChar.length; i++) {
            ints[someChar[i] - 97 ]++;
        }

        for (int j = 0; j < ints.length; j ++) {
            if (ints[j] == 0) {
                System.out.println(((char)(j + 97) + " <---------Not "));
            } else {
                System.out.println((char)(j + 97) + " Exits " + ints[j]);
            }
        }


    }

}
