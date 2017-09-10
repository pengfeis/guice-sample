package algorithm.sort;

import java.util.Arrays;

public class Sort {

    public int[] doSort(int[] in, int l, int r) {

        int tmp = in[l]; // pivot
        int i = l; // first element index of array in
        int j = r; // last element index of array in

        while (i < j) {

            while (i < j && tmp < in[j]) {
                j--;
            }


            if (i < j) {
                in[i] = in[j];
                i++;
            }

            while (i < j && tmp > in[i]) {
                i++;
            }

            if (i < j) {
                in[j] = in[i];
                j--;
            }

            in[i] = tmp;

            doSort(in, l, i - 1);
            doSort(in, i + 1, r);
        }

        return in;

    }


    public static void main(String[] args) {
        Sort s = new Sort();
        int[] input = {8, 10, 3, 1, 7, 2, 4};
        s.doSort(input, 0, input.length - 1);

        System.out.println(Arrays.toString(input));
    }
}
