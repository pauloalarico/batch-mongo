package org.example.batchmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.batch.autoconfigure.BatchAutoConfiguration;

@SpringBootApplication
public class BatchMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchMongoApplication.class, args);
    }

}
