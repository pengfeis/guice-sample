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
//        List<Customer> resultList = entityManager.createQuery("from Customer", Customer.class).getResultList();
//        List<RxUserEntity> rxUsers = entityManager.createQuery("from RxUserEntity", RxUserEntity.class).getResultList();
//        for (Customer cust : resultList) {
//            System.out.println(cust.toString());
//        }
//
//        for (RxUserEntity user : rxUsers) {
//            System.out.println(user.toString());
//        }
//        Customer customer = entityManager.find(Customer.class, 1L);
//        RxUserEntity user = entityManager.find(RxUserEntity.class, "1000000000085");
//        System.out.println(customer.getCustomerName());
//        System.out.println(user.toString());

        RxUserEntity rxUserEntity = new RxUserEntity();
        rxUserEntity.setGender('F');
        rxUserEntity.setMobileNumber("15601658286");
        rxUserEntity.setNickName("Gf");
        rxUserEntity.setPassword("789632145");
        rxUserEntity.setDateOfBirth(Timestamp.valueOf("2015-05-27 12:25:23.001"));
        rxUserEntity.setRegisterDt(new Timestamp(System.currentTimeMillis()));
        rxUserEntity.setLastLogin(new Timestamp(System.currentTimeMillis()));
        rxUserEntity.setUpdateDt(new Timestamp(System.currentTimeMillis()));

        UserAlbumEntity userAlbumEntity = new UserAlbumEntity();
        userAlbumEntity.setTitle("selfie");
        userAlbumEntity.setAlbumType("Normal");
        userAlbumEntity.setImage("N/A");
        rxUserEntity.setUserAlbumEntities(Lists.newArrayList(userAlbumEntity));


        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(rxUserEntity);
        tx.commit();

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap();
        map = null;
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
