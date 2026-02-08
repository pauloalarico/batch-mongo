package org.example.batchmongo.domain.entitie;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "teste-paulo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class Bank {
    @Id
    private String id;
    private String name;
    private String documentNumber;
    private String branch;
    private String account;
    private BigDecimal value;
    private String referenceDate;
}
