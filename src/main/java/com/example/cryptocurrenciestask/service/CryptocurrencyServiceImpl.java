package com.example.cryptocurrenciestask.service;

import com.example.cryptocurrenciestask.model.Cryptocurrency;
import com.example.cryptocurrenciestask.repository.CryptocurrencyRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CryptocurrencyServiceImpl implements CryptocurrencyService{
    private final CryptocurrencyRepository cryptocurrencyRepository;

    public CryptocurrencyServiceImpl(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    @Override
    public Cryptocurrency save(Cryptocurrency cryptocurrency) {
        return cryptocurrencyRepository.save(cryptocurrency);
    }

    @Override
    public List<Cryptocurrency> findAllByName(String currency, PageRequest pageRequest) {
        return cryptocurrencyRepository.findCryptocurrenciesByCurrencyName(currency, pageRequest);
    }

    @Override
    public List<String> findAllMinAndMaxPrice() {
        return cryptocurrencyRepository.findAllMinAndMaxPrice();
    }

    @Override
    public List<Cryptocurrency> findAllByName(String currency) {
        return cryptocurrencyRepository.findCryptocurrenciesByCurrencyName(currency);
    }
}
