package br.com.stapassoli.consultDollarPrice.consultDollarPrice.service;

import br.com.stapassoli.consultDollarPrice.consultDollarPrice.domain.ConsultDollarPrice;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class ConsultDollarServiceTest {

    @InjectMocks
    private ConsultDollarService service;

    @Test
    void shouldGetDollarPriceSuccess() {
        //GIVEN
        BigDecimal convertedValue = new BigDecimal("5.20");
        BigDecimal dollarprice = new BigDecimal("5.20");

        //THEN
        ResponseEntity<ConsultDollarPrice> dollarPrice = service.getDollarPrice(convertedValue, false);
        HttpStatusCode statusCode = dollarPrice.getStatusCode();
        ConsultDollarPrice body = dollarPrice.getBody();

        //EXPECT
        Assertions.assertEquals(statusCode, HttpStatus.OK);
        Assertions.assertNotNull(body);
        Assertions.assertEquals(body.getDollarPrice(), dollarprice);
        Assertions.assertEquals(body.getRequiredValue(), convertedValue);
        Assertions.assertEquals(body.getConvertedValue(), convertedValue.multiply(dollarprice));
    }

    @Test
    void shouldGetDollarPriceError() {
        //GIVEN
        BigDecimal convertedValue = new BigDecimal("5.20");

        //THEN
        ResponseEntity<ConsultDollarPrice> dollarPrice = service.getDollarPrice(convertedValue, true);
        HttpStatusCode statusCode = dollarPrice.getStatusCode();
        ConsultDollarPrice body = dollarPrice.getBody();

        //EXPECT
        Assertions.assertEquals(statusCode, HttpStatus.BAD_REQUEST);
        Assertions.assertNull(body);
    }

}