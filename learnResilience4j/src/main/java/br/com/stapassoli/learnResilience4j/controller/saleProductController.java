package br.com.stapassoli.learnResilience4j.controller;

import br.com.stapassoli.learnResilience4j.domain.Sale;
import br.com.stapassoli.learnResilience4j.service.SaleProductService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class saleProductController {

    private final SaleProductService service;

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestParam Integer productId, @RequestParam boolean isGenerateError) {
        return ResponseEntity.ok(service.accomplishSale(productId, isGenerateError));
    }

}
