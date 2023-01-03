package com.example.cryptocurrenciestask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ReportGeneratorServiceImplTest {
    @InjectMocks
    private ReportGeneratorServiceImpl reportGeneratorService;
    @Mock
    private CryptocurrencyService cryptocurrencyService;

    @Test
    void shouldReturnValidReport() {
        String expected = "Currency Name,Min Price,Max Price" + System.lineSeparator() +
                "BTC,16799.40,16800.40" + System.lineSeparator() +
                "ETH,1218.54,1219.54" + System.lineSeparator() +
                "XRP,0.35,0.35" + System.lineSeparator();
        Mockito.when(cryptocurrencyService.findAllMinAndMaxPrice())
                .thenReturn(List.of("BTC,16799.40,16800.40","ETH,1218.54,1219.54","XRP,0.35,0.35"));
        String actual = reportGeneratorService.generateReport();
        Assertions.assertEquals(expected, actual);
    }
}
