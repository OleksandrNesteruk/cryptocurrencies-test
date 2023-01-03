package com.example.cryptocurrenciestask.dto.mapper;

import com.example.cryptocurrenciestask.dto.CryptocurrencyRequestDto;
import com.example.cryptocurrenciestask.dto.CryptocurrencyResponseDto;
import com.example.cryptocurrenciestask.model.Cryptocurrency;
import org.springframework.stereotype.Component;

@Component
public class CryptocurrencyDtoMapper {
    public CryptocurrencyResponseDto mapToDto(Cryptocurrency cryptocurrency) {
        CryptocurrencyResponseDto responseDto = new CryptocurrencyResponseDto();
        responseDto.setId(cryptocurrency.getId());
        responseDto.setCurrencyName(cryptocurrency.getCurrencyName());
        responseDto.setExchangeCurrency(cryptocurrency.getExchangeCurrency());
        responseDto.setCreatedAt(cryptocurrency.getCreatedAt());
        responseDto.setPrice(cryptocurrency.getPrice());
        return responseDto;
    }

    public Cryptocurrency mapToModel(CryptocurrencyRequestDto requestDto) {
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        cryptocurrency.setCurrencyName(requestDto.getCurrencyName());
        cryptocurrency.setExchangeCurrency(requestDto.getExchangeCurrency());
        cryptocurrency.setCreatedAt(requestDto.getCreatedAt());
        cryptocurrency.setPrice(requestDto.getPrice());
        return cryptocurrency;
    }
}
