package pengfei.learn.mybatis.module;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import pengfei.learn.mybatis.mapper.RxUserMapper;

import java.util.Properties;

import static com.google.inject.name.Names.bindProperties;

/**
 * Created by pengfei on 2015/9/26.
 */
public class MySqlMyBatisModule extends MyBatisModule{
    @Override
    protected void initialize() {
        install(JdbcHelper.MySQL);

        bindDataSourceProviderType(PooledDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        addMapperClass(RxUserMapper.class);

        bindProperties(binder(), createTestProperties());
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
