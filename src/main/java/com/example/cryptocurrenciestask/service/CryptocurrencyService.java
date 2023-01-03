package com.example.cryptocurrenciestask.service;

import com.example.cryptocurrenciestask.model.Cryptocurrency;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CryptocurrencyService {
    Cryptocurrency save(Cryptocurrency cryptocurrency);

    List<Cryptocurrency> findAllByName(String currency, PageRequest pageRequest);

    List<String> findAllMinAndMaxPrice();

    List<Cryptocurrency> findAllByName(String currency);
}
