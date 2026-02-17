package org.example.batchmongo.application;

public record RedisDto (
        String name,
        String documentNumber,
        String branch,
        String account
) {
}
