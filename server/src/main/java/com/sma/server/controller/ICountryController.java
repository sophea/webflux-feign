package com.sma.server.controller;

import com.sma.server.json.JCountry;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * It is used for IntelliJ IDEA By Manulife Digital Cambodia team.
 *
 * @author Sophea Mak
 * @since April-2023
 */
@Slf4j
public abstract class ICountryController {

    /**
     * create node with json
     * @param body category object
     * @return category object back
     */
    @RequestMapping(value = "v1/json", method = RequestMethod.POST, produces = "application/json")
    @Operation(operationId = "create-country", summary = "create-country", description = "create-country entity")
    public Mono<JCountry> create(@Valid @RequestBody JCountry body) {
        log.info("============= create with json ========== {}", body.getName());
        return createCountry(body);
    }

    @RequestMapping(value = "v1", method = RequestMethod.GET, produces = "application/json")
    @Operation(operationId = "get-countries-list", summary = "get-countries-list", description = "get-countries-list")
    public Flux<JCountry> getCountriesList() {
        log.info("============= getCountriesList ==========");
        return getAll();
    }

    /**
     * find node by id
     * @param id as string
     * @return JCategory
     */
    @RequestMapping(value = "v1/{id}", method = RequestMethod.GET)
    @Operation(operationId = "get-details-country", summary = "get-details-country",
            description = "get-details-category by id")
    public Mono<JCountry> findById(@PathVariable String id) {
        log.info("============= findById ========== {}", id);
        return findCountryById(id);
    }

    protected abstract Mono<JCountry> findCountryById(String id);

    protected abstract Mono<JCountry> createCountry(JCountry body);

    protected abstract Flux<JCountry> getAll();

}
