package findshop.DaeguHaeng_backend.Service;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import findshop.DaeguHaeng_backend.DTO.PlaceDTO;
import findshop.DaeguHaeng_backend.DTO.ScheduleCreateDTO;
import findshop.DaeguHaeng_backend.Repository.PlaceRepository;
import findshop.DaeguHaeng_backend.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PlaceService {

    @Autowired
    private final PlaceRepository placeRepository;
    public Place findPlace(ScheduleCreateDTO scheduleCreateDTO){
        Place place = placeRepository.findById(scheduleCreateDTO.getPlaceId());
        if(place == null) {
            PlaceDTO placeDTO = new PlaceDTO(scheduleCreateDTO.getPlaceId(),scheduleCreateDTO.getType(),scheduleCreateDTO.getName(),scheduleCreateDTO.getAddress(),scheduleCreateDTO.getRate(),scheduleCreateDTO.getImageURL());

            if(placeDTO.getType().equals("Hotel")) {
                place = new Hotel(placeDTO);
                placeRepository.save(place);
            }
            else if(placeDTO.getType().equals("Attraction")) {
                place = new Attraction(placeDTO);
                placeRepository.save(place);
            }
            else if(placeDTO.getType().equals("Restaurant")) {
                place = new Restaurant(placeDTO);
                placeRepository.save(place);
            }
        }
        return place;
    }
}
