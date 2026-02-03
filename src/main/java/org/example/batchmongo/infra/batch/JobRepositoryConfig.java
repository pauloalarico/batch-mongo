//*package org.example.batchmongo.infra.batch;
//
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.repository.support.JdbcJobRepositoryFactoryBean;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class JobRepositoryConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean
//    public JobRepository jobRepository(@Qualifier("dataSource") DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
//        JdbcJobRepositoryFactoryBean jobRepository = new JdbcJobRepositoryFactoryBean();
//        jobRepository.setDataSource(dataSource);
//        jobRepository.setTransactionManager(transactionManager);
//        jobRepository.afterPropertiesSet();
//        return jobRepository.getObject();
//    }
//}
