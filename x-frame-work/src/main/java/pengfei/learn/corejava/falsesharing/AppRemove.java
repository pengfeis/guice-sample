package pengfei.learn.corejava.falsesharing;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class AppRemove {
    public boolean justRm(List<Object> items) {

        items = items.stream().collect(Collectors.toList());

        Iterator<Object> it = items.iterator();

        while (it.hasNext()) {
            Object next = it.next();
            it.remove();
            System.out.println(next);
        }
        return true;
    }
}
