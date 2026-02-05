package org.example.batchmongo.infra.batch;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JdbcJobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class MetaDataConfig {
    @Bean
    public JobRepository jobRepository(DataSource dataSource,
                                       PlatformTransactionManager transactionManager) throws Exception {
        JdbcJobRepositoryFactoryBean factory = new JdbcJobRepositoryFactoryBean();
        factory.setTransactionManager(transactionManager);
        factory.setDataSource(dataSource);
        factory.setDatabaseType("POSTGRES");
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("jobRepository") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
