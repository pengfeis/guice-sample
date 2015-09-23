package pengfei.learn.hibernate.domain;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import pengfei.learn.mybatis.RxUserMapper;

import java.util.Collection;
import java.util.Properties;

import static com.google.inject.name.Names.bindProperties;


public class RxUserEntityTest {
    @Test
    public void testMybatisRXUser() {
        Injector injector = Guice.createInjector(new MyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);

                bindDataSourceProviderType(PooledDataSourceProvider.class);
                bindTransactionFactoryType(JdbcTransactionFactory.class);
                addMapperClass(RxUserMapper.class);

                bindProperties(binder(), createTestProperties());
            }
        });
        RxUserMapper rxUserMapper = injector.getInstance(RxUserMapper.class);
        Collection<RxUserEntity> rxUserEntities = rxUserMapper.selectAll();
        for (RxUserEntity rxUserEntity : rxUserEntities) {
            System.out.println(rxUserEntity);
        }

    }

    protected static Properties createTestProperties() {
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.host", "localhost");
        myBatisProperties.setProperty("JDBC.port", "3306");
        myBatisProperties.setProperty("JDBC.schema", "dev");
        myBatisProperties.setProperty("JDBC.username", "root");
        myBatisProperties.setProperty("JDBC.password", "789632145");
        myBatisProperties.setProperty("JDBC.autoCommit", "false");
        return myBatisProperties;
    }
}