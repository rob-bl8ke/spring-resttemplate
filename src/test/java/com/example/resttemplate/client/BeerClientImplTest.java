package com.example.resttemplate.client;

import com.example.resttemplate.model.BeerDTO;
import com.example.resttemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClientImpl beerClient;

    @Test
    void createBeer() {
        BeerDTO newDto = BeerDTO.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("12345")
                .build();

        BeerDTO savedDto = beerClient.createBeer(newDto);

        assertNotNull(savedDto);
    }

    @Test
    void updateBeer() {
        BeerDTO newDto = BeerDTO.builder()
                .price(new BigDecimal("12.99"))
                .beerName("Mango Bobs 2")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("12345")
                .build();

        BeerDTO beerDTO = beerClient.createBeer(newDto);

        final String newName = "Mango Bobs 3";
        beerDTO.setBeerName(newName);
        BeerDTO updatedBeer = beerClient.updateBeer(beerDTO);

        assertEquals(newName, updatedBeer.getBeerName());
    }

    @Test
    void deleteBeer() {
        BeerDTO newDto = BeerDTO.builder()
                .price(new BigDecimal("12.99"))
                .beerName("Mango Bobs 4")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("12345")
                .build();

        BeerDTO beerDTO = beerClient.createBeer(newDto);

        beerClient.deleteBeer(beerDTO.getId());

        assertThrows(HttpClientErrorException.class, () -> {
           beerClient.getBeerById(beerDTO.getId());
        });
    }

    @Test
    void getBeerById() {
        Page<BeerDTO> beerDTOs = beerClient.listBeers();
        BeerDTO dto = beerDTOs.getContent().get(0);
        BeerDTO byId = beerClient.getBeerById(dto.getId());

        assertNotNull(byId);
    }

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