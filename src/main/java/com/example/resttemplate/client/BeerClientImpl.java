package com.example.resttemplate.client;

import com.example.resttemplate.model.BeerDTO;
import com.example.resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private static final String GET_BEER_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers() {

        RestTemplate restTemplate = restTemplateBuilder.build();

//        // Simply return response as a JSON string
//        ResponseEntity<String> stringResponse = restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, String.class);
//        System.out.println((stringResponse.getBody()));

//        // Use a map to get data back in a semi-structured form. Good approach if not sure what is being returned by the API
//        // and would simply want to interrogate the information coming back.
//        ResponseEntity<Map> mapResponse = restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, Map.class);

//        // Parse content using Jackson to fetch the content that you need.
//        ResponseEntity<JsonNode> jsonResponse = restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, JsonNode.class);
//        jsonResponse.getBody().findPath("content").elements().forEachRemaining(node -> {
//            System.out.println(node.get("beerName").asText());
//        });

        ResponseEntity<BeerDTOPageImpl> response =
                restTemplate.getForEntity(GET_BEER_PATH, BeerDTOPageImpl.class);

        return response.getBody();
    }
}
