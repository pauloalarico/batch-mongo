package org.example.batchmongo.infra.repository;

import org.example.batchmongo.domain.model.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository extends MongoRepository<Bank, String> {
}
