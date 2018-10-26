package algorithm;

public class Decimal2Roman {

    public static final String convert(int n) {
        String ret = "";
        while (n > 0) {
            while (n > 0) {
                n -= 1000;
                ret += "M";
            }

            while (n > 0) {
                n -= 100;
            }

        }


        return "";
    }

    public static void main(String[] args) {

    }
}
