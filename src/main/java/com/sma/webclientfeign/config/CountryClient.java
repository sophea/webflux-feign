package com.sma.webclientfeign.config;

import com.sma.webclientfeign.json.JCountry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "country-service", url = "${country.service.url}")
public interface CountryClient {

    @GetMapping("/api/countries/v1")
    Flux<JCountry> getAllCountries();

    @GetMapping("/api/countries/v1/{id}")
    Mono<JCountry> getCountryDetails(@PathVariable("id") String id);

    @PostMapping("/api/countries/v1/json")
    Mono<JCountry> createCountry(JCountry JCountry);

}
