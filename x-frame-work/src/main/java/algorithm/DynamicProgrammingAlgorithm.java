package algorithm;

public class DynamicProgrammingAlgorithm {

    public int climing(int n) {
        System.out.println("i am climing: " + n);
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        return climing(n - 1) + climing(n - 2);
    }


    public static void main(String[] args) {
        DynamicProgrammingAlgorithm dpa = new DynamicProgrammingAlgorithm();
        System.out.println(dpa.climing(10));
    }
}
