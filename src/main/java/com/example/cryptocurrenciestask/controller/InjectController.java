package com.example.cryptocurrenciestask.controller;

import com.example.cryptocurrenciestask.dto.CryptocurrencyRequestDto;
import com.example.cryptocurrenciestask.dto.mapper.CryptocurrencyDtoMapper;
import com.example.cryptocurrenciestask.model.Cryptocurrency;
import com.example.cryptocurrenciestask.repository.CryptocurrencyRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController("cryptocurrencies/inject")
public class InjectController {
    private final CryptocurrencyRepository cryptocurrencyRepository;
    private final CryptocurrencyDtoMapper cryptocurrencyDtoMapper;

    public InjectController(CryptocurrencyRepository cryptocurrencyRepository,
                            CryptocurrencyDtoMapper cryptocurrencyDtoMapper) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
        this.cryptocurrencyDtoMapper = cryptocurrencyDtoMapper;
    }

    @PostMapping
    public void inject() {
        CryptocurrencyRequestDto btc = new CryptocurrencyRequestDto("BTC",
                16800.40, Cryptocurrency.Currency.USD, LocalDateTime.now());
        cryptocurrencyRepository.save(cryptocurrencyDtoMapper.mapToModel(btc));
        CryptocurrencyRequestDto btc1 = new CryptocurrencyRequestDto("BTC",
                16799.40, Cryptocurrency.Currency.USD, LocalDateTime.now());
        cryptocurrencyRepository.save(cryptocurrencyDtoMapper.mapToModel(btc1));
        CryptocurrencyRequestDto eth = new CryptocurrencyRequestDto("ETH",
                1219.54, Cryptocurrency.Currency.USD, LocalDateTime.now());
        cryptocurrencyRepository.save(cryptocurrencyDtoMapper.mapToModel(eth));
        CryptocurrencyRequestDto eth1 = new CryptocurrencyRequestDto("ETH",
                1218.54, Cryptocurrency.Currency.USD, LocalDateTime.now());
        cryptocurrencyRepository.save(cryptocurrencyDtoMapper.mapToModel(eth1));
        CryptocurrencyRequestDto xrp = new CryptocurrencyRequestDto("XRP",
                0.35, Cryptocurrency.Currency.USD, LocalDateTime.now());
        cryptocurrencyRepository.save(cryptocurrencyDtoMapper.mapToModel(xrp));
        CryptocurrencyRequestDto xrp1 = new CryptocurrencyRequestDto("XRP",
                0.35, Cryptocurrency.Currency.USD, LocalDateTime.now());
        cryptocurrencyRepository.save(cryptocurrencyDtoMapper.mapToModel(xrp1));
    }
}
