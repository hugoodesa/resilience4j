package br.com.stapassoli.learnResilience4j.service;

import br.com.stapassoli.learnResilience4j.domain.ConsultDollarPrice;
import br.com.stapassoli.learnResilience4j.domain.Product;
import br.com.stapassoli.learnResilience4j.domain.Sale;
import br.com.stapassoli.learnResilience4j.repository.ProductRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SaleProductService {

    private final ProductRepository repository;
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        this.restTemplate = new RestTemplate();
    }

    private Product getProduct(Integer id) {
        return repository.getProducts().get(id);
    }

    private ConsultDollarPrice getDollarPrice(Product product, boolean generateError) {
        BigDecimal valueToConvert = product.getPrice();
        String requestURL = String.format("http://localhost:8080/dollar?requiredValue=%s&isGenerateError=%b", valueToConvert.toString(),
            generateError);
        return restTemplate.getForEntity(requestURL, ConsultDollarPrice.class).getBody();
    }

    public Sale accomplishSale(Integer productId, boolean generateError) {
        Product product = getProduct(productId);
        BigDecimal dollarPrice = getDollarPrice(product, generateError).getDollarPrice();

        return Sale
            .builder()
            .product(product)
            .dollarPrice(dollarPrice)
            .build();
    }

}
