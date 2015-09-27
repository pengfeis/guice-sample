package pengfei.learn.guice;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pengfei.learn.guice.customer.MyApplication;
import pengfei.learn.guice.injector.MyInjector;
import pengfei.learn.hibernate.domain.Customer;
import pengfei.learn.hibernate.domain.RxUserEntity;
import pengfei.learn.hibernate.domain.UserAlbumEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertNotNull;

public class AppTest {

    @Test
    public void testSendMsg() {
        Injector injector = Guice.createInjector(new MyInjector());
        MyApplication app = injector.getInstance(MyApplication.class);

        app.sendMsg("Hello world", "supengfei007@gmail.com");
        assertNotNull("There some instance can not be NULL", injector.getAllBindings());
    }

}
