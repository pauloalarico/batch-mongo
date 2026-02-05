package org.example.batchmongo.infra.batch;

import org.example.batchmongo.domain.model.Bank;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StepConfig {
    @Bean
    public Step initialStep(JobRepository jobRepository,
                            ItemReader<Bank> reader,
                            ItemWriter<Bank> writer,
                            ItemProcessor<Bank, Bank> processor,
                            @Qualifier("transactionManagerData") PlatformTransactionManager transactionManager) {
        return new StepBuilder("first-step", jobRepository)
                .<Bank, Bank>chunk(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .transactionManager(transactionManager)
                .build();
    }
}