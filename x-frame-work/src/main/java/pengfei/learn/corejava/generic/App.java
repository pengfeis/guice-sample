package pengfei.learn.corejava.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class App<T extends List<String>> {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "hollis");
        map.put("age", "22");
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
    }


    public static <A extends Comparable<A>> A max(Collection<A> xs) {
        Iterator<A> xi = xs.iterator();
        A w = xi.next();
        while (xi.hasNext()) {
            A x = xi.next();
            if (w.compareTo(x) < 0)
                w = x;
        }
        return w;
    }

}
