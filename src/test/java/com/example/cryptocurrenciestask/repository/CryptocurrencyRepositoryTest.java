package com.example.cryptocurrenciestask.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CryptocurrencyRepositoryTest {

    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;

    @Test
    void shouldReturnAllCurrenciesMinAndMaxPrices() {
        List<String> expected = List.of(
                "BTC,16799.40,16800.40",
                "ETH,1218.54,1219.54",
                "XRP,0.35,0.35"
        );
        List<String> actual = cryptocurrencyRepository.findAllMinAndMaxPrice();
        Assertions.assertEquals(3, actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }
}
