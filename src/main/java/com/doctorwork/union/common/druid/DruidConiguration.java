package com.doctorwork.union.common.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.doctorwork.union.common.config.DruidProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by barry on 2017/9/29.
 */
@Slf4j
@Configuration
@ConditionalOnClass(DruidDataSource.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidConiguration {

    //增加这个注解 不会检查configuration不允许注入bean
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DruidProperties properties;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUser());
        dataSource.setPassword(properties.getPassword());
        if (properties.getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getInitialSize());
        }
        if (properties.getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getMinIdle());
        }
        if (properties.getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getMaxActive());
        }
        if(properties.getMaxWait()>0){
            dataSource.setMaxWait(properties.getMaxWait());
        }
        log.info("数据库"+properties.toString());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;

    }
}
