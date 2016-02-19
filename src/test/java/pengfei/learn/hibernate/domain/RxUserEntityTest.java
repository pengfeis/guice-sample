package pengfei.learn.hibernate.domain;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pengfei.learn.mybatis.mapper.RxUserMapper;
import pengfei.learn.mybatis.module.MySqlMyBatisModule;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.util.Collection;


public class RxUserEntityTest {

    private EntityManagerFactory factory = null;

    @Test
    public void testMybatisRXUser() {
        Injector injector = Guice.createInjector(new MySqlMyBatisModule());
        RxUserMapper rxUserMapper = injector.getInstance(RxUserMapper.class);
        Collection<RxUserEntity> rxUserEntities = rxUserMapper.selectAll();
        for (RxUserEntity rxUserEntity : rxUserEntities) {
            System.out.println(rxUserEntity);
        }

    }

    @Test
    public void testJpaHibernate() {
        EntityManager entityManager = factory.createEntityManager();

        String maxMobileNum = entityManager.createQuery("SELECT MAX(mobileNumber) FROM RxUserEntity", String.class).getSingleResult();
        Long mobileNumber = Long.valueOf(maxMobileNum);
        ++mobileNumber;

        RxUserEntity rxUserEntity = new RxUserEntity();
        rxUserEntity.setGender('F');
        rxUserEntity.setMobileNumber(String.valueOf(mobileNumber));
        rxUserEntity.setNickName("Gf");
        rxUserEntity.setPassword("789632145");
        rxUserEntity.setDateOfBirth(Timestamp.valueOf("2015-05-29 12:25:23.001"));
        rxUserEntity.setRegisterDt(new Timestamp(System.currentTimeMillis()));
        rxUserEntity.setLastLogin(new Timestamp(System.currentTimeMillis()));
        rxUserEntity.setUpdateDt(new Timestamp(System.currentTimeMillis()));

        UserAlbumEntity userAlbumEntity = new UserAlbumEntity();
        userAlbumEntity.setTitle("selfie");
        userAlbumEntity.setAlbumType("Normal");
        userAlbumEntity.setImage("N/A");
        userAlbumEntity.setRxUserEntity(rxUserEntity);

        rxUserEntity.getUserAlbumEntities().add(userAlbumEntity);

        EntityTransaction tx = entityManager.getTransaction();
        Session session = entityManager.unwrap(Session.class);
        tx.begin();
        session.save(rxUserEntity);
        tx.commit();
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