package org.example.batchmongo.utils;

import org.example.batchmongo.application.RedisDto;
import org.example.batchmongo.domain.entitie.Bank;

public class RedisMapper {
    public static RedisDto toDto(Bank bank) {
        return new RedisDto(bank);
    }
}
