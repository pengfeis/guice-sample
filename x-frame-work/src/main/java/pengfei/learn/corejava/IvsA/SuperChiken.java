package pengfei.learn.corejava.IvsA;

public class SuperChiken implements Fly, Run {
    @Override
    public String f(String input) {
        return null;
    }

    @Override
    public String run(String input) {
        return null;
    }


    public static void main(String[] args) {
        SuperChiken s = new SuperChiken();
        // compile error
//        System.out.println(SuperChiken.A);
    }
}
