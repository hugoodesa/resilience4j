package br.com.stapassoli.consultDollarPrice.consultDollarPrice.controller;

import br.com.stapassoli.consultDollarPrice.consultDollarPrice.domain.ConsultDollarPrice;
import br.com.stapassoli.consultDollarPrice.consultDollarPrice.service.ConsultDollarService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dollar")
@RequiredArgsConstructor
public class ConsultDollarPriceController {

    private final ConsultDollarService service;

    @GetMapping
    public ResponseEntity<ConsultDollarPrice> getDollarPrice(@RequestParam BigDecimal requiredValue, @RequestParam boolean isGenerateError) {
        return service.getDollarPrice(requiredValue, isGenerateError);
    }

}
