package pengfei.learn.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import pengfei.learn.guice.customer.MyApplication;
import pengfei.learn.guice.injector.MyInjector;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        Injector injector = Guice.createInjector(new MyInjector());

        MyApplication app = injector.getInstance(MyApplication.class);

        injector.getAllBindings();

        app.sendMsg("Hello world", "supengfei007@gmail.com");
    }
}
