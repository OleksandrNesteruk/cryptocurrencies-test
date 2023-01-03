package com.example.cryptocurrenciestask.dto;

import com.example.cryptocurrenciestask.model.Cryptocurrency;
import java.time.LocalDateTime;

public class CryptocurrencyRequestDto {
    private String currencyName;
    private Double price;
    private Cryptocurrency.Currency exchangeCurrency;
    private LocalDateTime createdAt;

    public CryptocurrencyRequestDto(String currencyName,
                                    Double price,
                                    Cryptocurrency.Currency exchangeCurrency,
                                    LocalDateTime createdAt) {
        this.currencyName = currencyName;
        this.price = price;
        this.exchangeCurrency = exchangeCurrency;
        this.createdAt = createdAt;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Cryptocurrency.Currency getExchangeCurrency() {
        return exchangeCurrency;
    }

    public void setExchangeCurrency(Cryptocurrency.Currency exchangeCurrency) {
        this.exchangeCurrency = exchangeCurrency;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
