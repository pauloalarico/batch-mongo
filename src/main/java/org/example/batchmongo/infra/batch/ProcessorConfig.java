package org.example.batchmongo.infra.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.batchmongo.domain.entitie.Bank;
import org.example.batchmongo.utils.RedisMapper;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class ProcessorConfig {
    private final RedisTemplate<String, Object> redisTemplate;

    @Bean
    public ItemProcessor<Bank, Bank> processor() {
        return item -> {
            log.warn(">>> Processando: {}", item);
            var dto = RedisMapper.toDto(item);
            String redisKey = dto.documentNumber();
            redisTemplate.opsForValue().set(redisKey, dto);
            return item;
        };
    }
}
