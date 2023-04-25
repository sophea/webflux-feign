package com.sma.server.controller;

import com.sma.server.json.JCountry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * It is used for IntelliJ IDEA By Manulife Digital Cambodia team.
 *
 * @author Sophea Mak
 * @since April-2023
 */
@RestController
@RequestMapping("/api/countries")
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CountryController extends ICountryController {

    @Override
    protected Mono<JCountry> createCountry(JCountry body) {

        return Mono.just(body);
    }

    @Override
    protected Mono<JCountry> findCountryById(String id) {
        return Mono.just(JCountry.builder().code(id).name("CountryName").build());
    }

    @Override
    protected Flux<JCountry> getAll() {
        //@formatter:off
        return Flux.just(
            createMock("CODE_1", "COUNTRY_1"),
            createMock("CODE_2", "COUNTRY_2"),
            createMock("CODE_3", "COUNTRY_3"),
            createMock("CODE_4", "COUNTRY_4")
        );
        //@formatter:on
    }

    private JCountry createMock(String code, String name) {
        return new JCountry(code, name);
    }

}
