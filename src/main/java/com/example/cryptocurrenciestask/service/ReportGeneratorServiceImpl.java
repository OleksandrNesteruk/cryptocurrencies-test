package com.example.cryptocurrenciestask.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private final CryptocurrencyService cryptocurrencyService;

    public ReportGeneratorServiceImpl(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @Override
    public String generateReport() {
        List<String> allCurrenciesMinAndMaxPrice = cryptocurrencyService.findAllMinAndMaxPrice();
        StringBuilder report = new StringBuilder("Currency Name,Min Price,Max Price")
                .append(System.lineSeparator());
        for (String currency : allCurrenciesMinAndMaxPrice) {
            report.append(currency)
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
