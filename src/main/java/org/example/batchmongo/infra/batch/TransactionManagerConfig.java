package org.example.batchmongo.infra.batch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class TransactionManagerConfig {
    @Bean
    public PlatformTransactionManager transactionManagerData(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
