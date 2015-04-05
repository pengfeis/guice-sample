package pengfei.learn.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pengfei.learn.guice.customer.MyApplication;
import pengfei.learn.guice.injector.MyInjector;
import pengfei.learn.hibernate.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple Test.
 */
public class AppTest {

    private EntityManagerFactory factory = null;

    @Test
    public void testSendMsg() {
        Injector injector = Guice.createInjector(new MyInjector());
        MyApplication app = injector.getInstance(MyApplication.class);

        app.sendMsg("Hello world", "supengfei007@gmail.com");
        assertNotNull("There some instance can not be NULL", injector.getAllBindings());
    }

    @Test
    public void testJpaHibernate() {
        EntityManager entityManager = factory.createEntityManager();
        List<Customer> resultList = entityManager.createQuery("from Customer", Customer.class).getResultList();
        for (Customer cust : resultList) {
            System.out.println(cust.toString());
        }
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println(customer.getCustomerName());
    }

    @Before
    public void before() {
        factory = Persistence.createEntityManagerFactory("pengfei.learn.hibernate.domain");
    }
    @After
    public void after() {
        if (null != factory) {
            factory.close();
        }
    }
}
