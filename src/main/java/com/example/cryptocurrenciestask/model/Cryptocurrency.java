package com.example.cryptocurrenciestask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "cryptocurrencies")
public class Cryptocurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "currency")
    private String currencyName;
    private Double price;
    @Column(name = "exchange_currency")
    @Enumerated(value = EnumType.STRING)
    private Currency exchangeCurrency;
    private LocalDateTime createdAt;

    public enum Currency {
        USD, EUR, GBR
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Currency getExchangeCurrency() {
        return exchangeCurrency;
    }

    public void setExchangeCurrency(Currency exchangeCurrency) {
        this.exchangeCurrency = exchangeCurrency;
    }
}
