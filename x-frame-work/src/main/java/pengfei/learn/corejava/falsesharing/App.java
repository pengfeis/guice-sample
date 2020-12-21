package pengfei.learn.corejava.falsesharing;

import java.util.ArrayList;
import java.util.List;

public class App {

    static long[][] arr;

    public static void main(String[] args) {

        List<Object> items = new ArrayList<>();

        items.add(new Object());

        System.out.println("old" + items);
        AppRemove app = new AppRemove();
        boolean b = app.justRm(items);
        System.out.println("new" + items);

        System.out.println(b);
        System.out.println(items);
        System.out.println(items.size());

    }

}
