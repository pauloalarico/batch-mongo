package org.example.batchmongo.infra.batch;

import lombok.extern.slf4j.Slf4j;
import org.example.batchmongo.domain.model.Bank;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ProcessorConfig {
    @Bean
    public ItemProcessor<Bank, Bank> processor() {
        return item -> {
       log.warn(">>> Processando: {}", item);
            return item;
        };
    }
}
