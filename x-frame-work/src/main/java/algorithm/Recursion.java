package algorithm;

public class Recursion {

    public void decreasePrint(int n) {
        if (n == 0) {
            return;
        } else {
            System.out.println(n);
            decreasePrint(n - 1);
        }
    }

    public void increasePrint(int n) {
        if (n == 0) {
            return;
        } else {
            increasePrint(n - 1);
            System.out.println(n);
        }
    }
}
