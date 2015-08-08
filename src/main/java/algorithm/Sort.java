package algorithm.sort;

import java.util.Arrays;

/**
 * Created by pengfei on 2015/8/5.
 */
public class sort {
    public static Integer[] sort(Integer[] temp) {
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

    public static void main(String[] args) {
        Integer sorting[] = {11, 8, 2, 5, 3, 6, 9, 7, 4};
        sort(sorting);
        System.out.println(Arrays.toString(sorting));
    }
}
