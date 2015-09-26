package pengfei.learn.guice;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.name.Names.bindProperties;

import com.google.inject.Injector;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import pengfei.learn.mybatis.mapper.RxUserMapper;

import java.util.Properties;

public class MybatisModuleCore {

    private Injector injector;

    public MybatisModuleCore() {
        injector = createInjector(new MyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.HSQLDB_IN_MEMORY_NAMED);

                bindDataSourceProviderType(PooledDataSourceProvider.class);
                bindTransactionFactoryType(JdbcTransactionFactory.class);
                addMapperClass(RxUserMapper.class);

                bindProperties(binder(), createTestProperties());
            }
        });
    }


    protected static Properties createTestProperties() {
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.username", "root");
        myBatisProperties.setProperty("JDBC.password", "789632145");
        myBatisProperties.setProperty("JDBC.autoCommit", "false");
        return myBatisProperties;
    }

}
