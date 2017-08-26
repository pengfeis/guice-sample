package pengfei.learn.corejava.exception;

public class FinallyReturn {
    public static void main(String[] args) {


        int i = 3;


        System.out.println(getInt(i));

    }

    public static int getInt(int i) {
        try {
            i = i+2;
            System.out.println("in try: i = " + i);
            return i;
        } catch (Exception e) {
            System.out.println("in catch: i = " + i--);
            return i;
        } finally {
            /**
             *  seems finally will execute b4 return;
             */
            i = i + 3;
            System.out.println("in finally: i = " + i);
        }
    }
}
