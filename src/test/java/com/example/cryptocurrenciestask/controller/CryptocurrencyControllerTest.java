package com.example.cryptocurrenciestask.controller;

import com.example.cryptocurrenciestask.model.Cryptocurrency;
import com.example.cryptocurrenciestask.service.CryptocurrencyService;
import com.example.cryptocurrenciestask.service.FileWriterService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CryptocurrencyControllerTest {
    @MockBean
    private CryptocurrencyService cryptocurrencyService;
    @MockBean
    private FileWriterService fileWriterService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void shouldShowMinPriceByName() {
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        cryptocurrency.setCurrencyName("BTC");
        cryptocurrency.setPrice(16799.40);
        cryptocurrency.setExchangeCurrency(Cryptocurrency.Currency.USD);
        Mockito.when(cryptocurrencyService.findAllByName(cryptocurrency.getCurrencyName()))
                .thenReturn(List.of(cryptocurrency));
        RestAssuredMockMvc
                .given()
                .queryParam("name", cryptocurrency.getCurrencyName())
                .when()
                .get("/cryptocurrencies/minprice")
                .then()
                .statusCode(200)
                .body("currencyName", Matchers.equalTo("BTC"))
                .body("price", Matchers.equalTo(16799.40F))
                .body("exchangeCurrency", Matchers.equalTo("USD"));
    }

    @Test
    public void minPriceByInvalidName() {
        Mockito.when(cryptocurrencyService.findAllByName("Fes"))
                .thenReturn(List.of());

        RestAssuredMockMvc
                .given()
                .queryParam("name", "Fes")
                .when()
                .get("/cryptocurrencies/minprice")
                .then()
                .statusCode(500);
    }

    @Test
    public void shouldShowMaxPriceByName()  {
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        cryptocurrency.setCurrencyName("BTC");
        cryptocurrency.setPrice(16800.40);
        cryptocurrency.setExchangeCurrency(Cryptocurrency.Currency.USD);
        Mockito.when(cryptocurrencyService.findAllByName(cryptocurrency.getCurrencyName()))
                .thenReturn(List.of(cryptocurrency));

        RestAssuredMockMvc
                .given()
                .queryParam("name", cryptocurrency.getCurrencyName())
                .when()
                .get("/cryptocurrencies/minprice")
                .then()
                .statusCode(200)
                .body("currencyName", Matchers.equalTo("BTC"))
                .body("price", Matchers.equalTo(16800.40F))
                .body("exchangeCurrency", Matchers.equalTo("USD"));
    }

    @Test
    public void maxPriceByInvalidName() {
        Mockito.when(cryptocurrencyService.findAllByName("Fes"))
                .thenReturn(List.of());

        RestAssuredMockMvc
                .given()
                .queryParam("name", "Fes")
                .when()
                .get("/cryptocurrencies/minprice")
                .then()
                .statusCode(500);
    }

    @Test
    public void shouldFindAllByName() {
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        cryptocurrency.setCurrencyName("BTC");
        cryptocurrency.setPrice(16799.40);
        Cryptocurrency cryptocurrency1 = new Cryptocurrency();
        cryptocurrency1.setCurrencyName("BTC");
        cryptocurrency1.setPrice(16800.40);
        List<Cryptocurrency> cryptocurrenciesMocked = List.of(
                cryptocurrency,
                cryptocurrency1
        );
        Sort sort = Sort.by(Sort.Direction.ASC, "price");
        PageRequest pageRequest = PageRequest.of(0, 10, sort);
        Mockito.when(cryptocurrencyService.findAllByName("BTC", pageRequest))
                .thenReturn(cryptocurrenciesMocked);

        RestAssuredMockMvc
                .given()
                .queryParam("name", "BTC")
                .queryParam("page", 0)
                .queryParam("size", 10)
                .when()
                .get("/cryptocurrencies")
                .then()
                .statusCode(200)
                .body("[0].currencyName", Matchers.equalTo("BTC"))
                .body("[0].price", Matchers.equalTo(16799.40F))
                .body("[1].currencyName", Matchers.equalTo("BTC"))
                .body("[1].price", Matchers.equalTo(16800.40F));
    }

    @Test
    public void FindAllByInvalidName() {
        Sort sort = Sort.by(Sort.Direction.ASC, "price");
        PageRequest pageRequest = PageRequest.of(0, 10, sort);
        Mockito.when(cryptocurrencyService.findAllByName("Invalid", pageRequest))
                .thenReturn(List.of());

        RestAssuredMockMvc
                .given()
                .queryParam("name", "Invalid")
                .queryParam("page", 0)
                .queryParam("size", 10)
                .when()
                .get("/cryptocurrencies")
                .then()
                .statusCode(500);
    }

    @Test
    public void FindAllByInvalidPage() {
        Sort sort = Sort.by(Sort.Direction.ASC, "price");
        PageRequest pageRequest = PageRequest.of(0, 10, sort);
        Mockito.when(cryptocurrencyService.findAllByName("BTC", pageRequest))
                .thenReturn(List.of());

        RestAssuredMockMvc
                .given()
                .queryParam("name", "Invalid")
                .queryParam("page", 1)
                .queryParam("size", 10)
                .when()
                .get("/cryptocurrencies")
                .then()
                .statusCode(500);
    }
}
