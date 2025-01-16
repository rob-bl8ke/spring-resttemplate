package com.example.resttemplate.client;

import com.example.resttemplate.model.BeerDTO;
import com.example.resttemplate.model.BeerStyle;
import org.springframework.data.domain.Page;

public interface BeerClient {
    Page<BeerDTO> listBeers();
    Page<BeerDTO> listBeers(String beerName, Integer pageNumber, Integer pageSize);
    Page<BeerDTO> listBeers(String beerName, Boolean showInventory, Integer pageNumber, Integer pageSize);
    Page<BeerDTO> listBeers(BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);
    Page<BeerDTO> listBeers(BeerStyle beerStyle, Integer pageNumber, Integer pageSize);
    Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);
}
