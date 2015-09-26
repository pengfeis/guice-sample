package pengfei.learn.hibernate.domain;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;
import pengfei.learn.mybatis.mapper.RxUserMapper;
import pengfei.learn.mybatis.module.MySqlMyBatisModule;

import java.util.Collection;


public class RxUserEntityTest {
    @Test
    public void testMybatisRXUser() {
        Injector injector = Guice.createInjector(new MySqlMyBatisModule());
        RxUserMapper rxUserMapper = injector.getInstance(RxUserMapper.class);
        Collection<RxUserEntity> rxUserEntities = rxUserMapper.selectAll();
        for (RxUserEntity rxUserEntity : rxUserEntities) {
            System.out.println(rxUserEntity);
        }

    }
}