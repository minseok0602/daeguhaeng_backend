package findshop.DaeguHaeng_backend.Service;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import findshop.DaeguHaeng_backend.DTO.PlaceDTO;
import findshop.DaeguHaeng_backend.Repository.PlaceRepository;
import findshop.DaeguHaeng_backend.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PlaceService {

    @Autowired
    private final PlaceRepository placeRepository;
    public Place findPlace(String placeJson,Long placeId) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonParser parser = objectMapper.createParser(placeJson);
        JsonNode node = objectMapper.readTree(parser);
        Place place = placeRepository.findById(placeId);
        if(place == null) {
            String dtype = node.get("dtype").asText();
            if(dtype.equals("Hotel")) {
                place = objectMapper.treeToValue(node, Hotel.class);
            }
            else if(dtype.equals("Attraction")) {
                place = objectMapper.treeToValue(node, Attraction.class);
            }
            else if(dtype.equals("Restaurant")) {
                place = objectMapper.treeToValue(node, Restaurant.class);
            }
        }
        return place;
    }
}
