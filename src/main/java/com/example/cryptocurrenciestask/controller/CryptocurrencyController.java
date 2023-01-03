package com.example.cryptocurrenciestask.controller;

import com.example.cryptocurrenciestask.dto.CryptocurrencyResponseDto;
import com.example.cryptocurrenciestask.dto.mapper.CryptocurrencyDtoMapper;
import com.example.cryptocurrenciestask.model.Cryptocurrency;
import com.example.cryptocurrenciestask.service.FileWriterService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.cryptocurrenciestask.service.CryptocurrencyService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cryptocurrencies")
public class CryptocurrencyController {
    private final CryptocurrencyDtoMapper cryptocurrencyDtoMapper;
    private final CryptocurrencyService cryptocurrencyService;
    private final FileWriterService fileWriterService;

    public CryptocurrencyController(CryptocurrencyDtoMapper cryptocurrencyDtoMapper,
                                    CryptocurrencyService cryptocurrencyService,
                                    FileWriterService fileWriterService) {
        this.cryptocurrencyDtoMapper = cryptocurrencyDtoMapper;
        this.cryptocurrencyService = cryptocurrencyService;
        this.fileWriterService = fileWriterService;
    }

    @GetMapping("/minprice")
    public CryptocurrencyResponseDto minPrice(@RequestParam String name) {
        Cryptocurrency cryptocurrency = cryptocurrencyService.findAllByName(name)
                .stream()
                .min(Comparator.comparing(Cryptocurrency::getPrice))
                .orElseThrow(()-> new RuntimeException("There is no currency with name "
                        + name));
        return cryptocurrencyDtoMapper.mapToDto(cryptocurrency);
    }

    @GetMapping("/maxprice")
    public CryptocurrencyResponseDto maxPrice(@RequestParam String name) {
        Cryptocurrency cryptocurrency = cryptocurrencyService.findAllByName(name)
                .stream()
                .max(Comparator.comparing(Cryptocurrency::getPrice))
                .orElseThrow(()-> new RuntimeException("There is no currency with name "
                        + name));
        return cryptocurrencyDtoMapper.mapToDto(cryptocurrency);
    }

    @GetMapping
    public List<CryptocurrencyResponseDto> findAll(@RequestParam String name,
                                        @RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "price");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        List<CryptocurrencyResponseDto> cryptocurrencies = cryptocurrencyService
                .findAllByName(name, pageRequest).stream()
                .map(cryptocurrencyDtoMapper::mapToDto)
                .collect(Collectors.toList());
        if (cryptocurrencies.isEmpty()) {
            throw new RuntimeException("There is no currency with name " + name);
        }
        return cryptocurrencies;
    }

    @GetMapping("/csv")
    public String generateCsvReport() {
        return fileWriterService.writeToCsv();
    }
}
