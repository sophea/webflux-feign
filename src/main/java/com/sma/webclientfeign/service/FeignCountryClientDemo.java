package com.sma.webclientfeign.service;

import com.sma.webclientfeign.config.CountryClient;
import com.sma.webclientfeign.json.JCountry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FeignCountryClientDemo implements CommandLineRunner {


    private final CountryClient countryClient;

    public FeignCountryClientDemo(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @Override
    public void run(String... args) throws Exception {
        Flux.concat(
                getAll(), // first get all countries
                post(),   // create a country
                get()    // get details
        ).subscribe();
    }

    // GET all countrys
    private Mono<Void> getAll(){
        return this.countryClient.getAllCountries()
                .doOnNext(System.out::println)
                .doFinally(s -> System.out.println("------------- GET All completed ------------------"))
                .then();
    }

    // POST a country
    private Mono<Void> post(){
        var dto = JCountry.builder().code("KHM").name("Cambodia").build();
        return this.countryClient.createCountry(dto)
                .doOnNext(System.out::println)
                .doFinally(s -> System.out.println("------------- POST Country completed ------------------"))
                .then();
    }

    // GET a specific country
    private Mono<Void> get(){
        return this.countryClient.getCountryDetails("KHM")
                .doOnNext(System.out::println)
                .doFinally(s -> System.out.println("------------- GET Country completed ------------------"))
                .then();
    }
}
