package org.example.batchmongo.infra.batch;

import lombok.RequiredArgsConstructor;
import org.example.batchmongo.domain.entitie.Bank;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.batch.infrastructure.item.data.MongoItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@RequiredArgsConstructor
public class WriterConfig {

    @Value("${app.paths.collection}")
    private String collection;
    private final MongoTemplate mongoTemplate;

    @Bean
    public ItemWriter<Bank> writer() {
        MongoItemWriter<Bank> writer = new MongoItemWriter<>(mongoTemplate);
        writer.setCollection(collection);
        return writer;
    }
}
