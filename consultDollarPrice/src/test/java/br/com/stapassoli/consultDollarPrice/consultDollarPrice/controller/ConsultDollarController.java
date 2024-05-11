package br.com.stapassoli.consultDollarPrice.consultDollarPrice.controller;


import br.com.stapassoli.consultDollarPrice.consultDollarPrice.domain.ConsultDollarPrice;
import br.com.stapassoli.consultDollarPrice.consultDollarPrice.service.ConsultDollarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@AutoConfigureMockMvc
@SpringBootTest
public class ConsultDollarController {

    @Autowired
    public MockMvc mockMvc;
    @Autowired
    public ObjectMapper mapper;

    final String URI_CONTROLLER = "/dollar";

    @Test
    public void shouldGetDollarPriceFromWeb() throws Exception {

        var jsonResponse = mockMvc
                .perform(MockMvcRequestBuilders.get(URI_CONTROLLER)
                        .param("requiredValue", String.valueOf(2))
                        .param("isGenerateError", String.valueOf(false))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType((MediaType.APPLICATION_JSON)))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn()
                .getResponse()
                .getContentAsString();

        ConsultDollarPrice consultDollarPrice = mapper.readValue(jsonResponse, ConsultDollarPrice.class);

        Assertions.assertThat(consultDollarPrice).isNotNull();
        Assertions.assertThat(consultDollarPrice.getConvertedValue()).isGreaterThan(BigDecimal.ZERO);
        Assertions.assertThat(consultDollarPrice.getRequiredValue()).isEqualTo(new BigDecimal("2"));

    }

}
