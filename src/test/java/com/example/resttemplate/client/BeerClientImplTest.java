package com.example.resttemplate.client;

import com.example.resttemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClientImpl beerClient;

    @Test
    void listBeers_all_params() {
        beerClient.listBeers("ALE", BeerStyle.ALE, true, 1, 5);
    }

    @Test
    void listBeers_all_params_all_null() {
        beerClient.listBeers(null, null, null, null, null);
    }

    @Test
    void listBeers_no_params() {
        beerClient.listBeers();
    }

    @Test
    void listBeers_beerName() {
        beerClient.listBeers("ALE", 1, 5);
    }

    @Test
    void listBeers_beerStyle() {
        beerClient.listBeers(BeerStyle.ALE, 1, 5);
    }
}