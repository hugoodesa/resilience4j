package br.com.stapassoli.learnResilience4j.repository;

import br.com.stapassoli.learnResilience4j.domain.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository {

    public List<Product> getProducts () {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1L, "CPU", new BigDecimal("250.00")));
        productList.add(new Product(2L, "GPU", new BigDecimal("500.00")));
        productList.add(new Product(3L, "RAM", new BigDecimal("100.00")));
        productList.add(new Product(4L, "Motherboard", new BigDecimal("150.00")));
        productList.add(new Product(5L, "SSD", new BigDecimal("120.00")));
        productList.add(new Product(6L, "HDD", new BigDecimal("80.00")));
        productList.add(new Product(7L, "Power Supply", new BigDecimal("80.00")));
        productList.add(new Product(8L, "Case", new BigDecimal("70.00")));
        productList.add(new Product(9L, "Cooling Fan", new BigDecimal("30.00")));
        productList.add(new Product(10L, "Monitor", new BigDecimal("200.00")));

        return productList;
    }

}
