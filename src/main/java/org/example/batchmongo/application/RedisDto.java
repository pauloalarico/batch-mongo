package org.example.batchmongo.application;

import org.example.batchmongo.domain.entitie.Bank;

public record RedisDto (
        String name,
        String documentNumber,
        String branch,
        String account
) {
    public RedisDto(Bank bank) {
        this(bank.getName(), bank.getDocumentNumber(), bank.getBranch(), bank.getAccount());
    }
}
