package com.example.resttemplate.client;

import com.example.resttemplate.model.BeerDTO;
import com.example.resttemplate.model.BeerDTOPageImpl;
import com.example.resttemplate.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private static final String GET_BEER_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers() {
        return listBeers(null, null, null, null, null);
    }

    @Override
    public Page<BeerDTO> listBeers(String beerName, Integer pageNumber, Integer pageSize) {
        return listBeers(beerName, null, null, pageNumber, pageSize);
    }

    @Override
    public Page<BeerDTO> listBeers(BeerStyle beerStyle, Integer pageNumber, Integer pageSize) {
        return listBeers(null, beerStyle, null, pageNumber, pageSize);
    }

    @Override
    public Page<BeerDTO> listBeers(BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize) {
        return listBeers(null, beerStyle, showInventory, pageNumber, pageSize);
    }

    @Override
    public Page<BeerDTO> listBeers(String beerName, Boolean showInventory, Integer pageNumber, Integer pageSize) {
        return null;
    }

    @Override
    public Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        // Since GET_BEER_PATH begins with a / the base path is retrieved via the `RestTemplateBuilderConfig` class.
        // Query parameters are encoded by the `UriComponentBuilder`.
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

        if (beerName != null) {
            // Go find any beers having a beer name that contains beerName
            uriComponentsBuilder.queryParam("beerName", beerName);
        }

        if (beerStyle != null) {
            uriComponentsBuilder.queryParam("beerStyle", beerStyle);
        }

        if (showInventory != null) {
            uriComponentsBuilder.queryParam("showInventory", showInventory);
        }

        if (pageNumber != null) {
            uriComponentsBuilder.queryParam("pageNumber", pageNumber);
        }

        if (pageSize != null) {
            uriComponentsBuilder.queryParam("pageNumber", pageNumber);
        }

        // Since GET_BEER_PATH begins with a / the base path is retrieved via the `RestTemplateBuilderConfig` class.
        // Query parameters are encoded by the `UriComponentBuilder`.
        ResponseEntity<BeerDTOPageImpl> response =
                restTemplate.getForEntity(GET_BEER_PATH, BeerDTOPageImpl.class);

        return response.getBody();
    }
}
