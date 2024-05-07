package br.com.stapassoli.learnResilience4j.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;

}
