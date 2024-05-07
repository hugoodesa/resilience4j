package br.com.stapassoli.consultDollarPrice.consultDollarPrice.service;

import br.com.stapassoli.consultDollarPrice.consultDollarPrice.domain.ConsultDollarPrice;
import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConsultDollarService {

    private ResponseEntity<ConsultDollarPrice> dollarPriceResponse(ConsultDollarPrice response, boolean isGenerateError) {

        if (isGenerateError) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ConsultDollarPrice> getDollarPrice(BigDecimal requiredValue, boolean isGenerateError) {
        BigDecimal dollarPrice = new BigDecimal("5.20");
        BigDecimal convertedValue = dollarPrice.multiply(requiredValue);

        ConsultDollarPrice consultDollarPrice = ConsultDollarPrice
            .builder()
            .dollarPrice(dollarPrice)
            .requiredValue(requiredValue)
            .convertedValue(convertedValue)
            .build();

        return dollarPriceResponse(consultDollarPrice, isGenerateError);
    }

}
