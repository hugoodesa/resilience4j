package br.com.stapassoli.consultDollarPrice.consultDollarPrice.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConsultDollarPrice {

    private BigDecimal dollarPrice;

    private BigDecimal requiredValue;

    private BigDecimal convertedValue;

}
