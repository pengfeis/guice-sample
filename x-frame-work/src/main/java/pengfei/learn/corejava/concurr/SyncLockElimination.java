package pengfei.learn.corejava.concurr;

public class SyncLockElimination {

    private String name;

    StringBuffer sb = new StringBuffer(name);


    public void sayHello(String name) {
        sb.append("-");
        sb.append("say");
        sb.append(":");
        sb.append("Hello");
        System.out.println(sb.toString());
    }
}
