package org.example.batchmongo.infra.batch;

import org.example.batchmongo.domain.model.Bank;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ReaderConfig {
    @Value("${app.paths.resource}")
    private String pathFileDestiny;

    @Bean
    public FlatFileItemReader<Bank> reader() {
        return new FlatFileItemReaderBuilder<Bank>()
                .name("file-reader")
                .resource(new FileSystemResource(pathFileDestiny + "/dados_ficticios.csv"))
                .linesToSkip(1)
                .delimited()
                .delimiter("|")
                .names("name", "documentNumber", "branch", "account", "value", "referenceDate")
                .targetType(Bank.class)
                .build();
    }
}
