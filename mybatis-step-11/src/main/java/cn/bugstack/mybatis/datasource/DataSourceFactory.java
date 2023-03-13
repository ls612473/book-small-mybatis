package cn.bugstack.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author sonarone
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();

}
