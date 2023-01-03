package com.example.cryptocurrenciestask.repository;

import com.example.cryptocurrenciestask.model.Cryptocurrency;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, Long> {
    @Query(value = "SELECT currency, MIN(price), MAX(PRICE) FROM cryptocurrencies "
            + "GROUP BY currency", nativeQuery = true)
    List<String> findAllMinAndMaxPrice();

    List<Cryptocurrency> findCryptocurrenciesByCurrencyName(String currency);

    List<Cryptocurrency> findCryptocurrenciesByCurrencyName(String currency, PageRequest pageRequest);
}
