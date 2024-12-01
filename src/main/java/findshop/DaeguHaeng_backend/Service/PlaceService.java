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
        Place place;
        try{
            place = placeRepository.findById(scheduleCreateDTO.getPlaceId());
        } catch (Exception e){
            place = null;
        }
        if(place == null) {
            PlaceDTO placeDTO = new PlaceDTO(scheduleCreateDTO.getPlaceId(),scheduleCreateDTO.getType(),scheduleCreateDTO.getName(),scheduleCreateDTO.getAddress(),scheduleCreateDTO.getRate(),scheduleCreateDTO.getImageURL());

            if(placeDTO.getType().equals("호텔") || placeDTO.getType().equals("모텔")) {
                place = new Hotel(placeDTO);
                placeRepository.save(place);
            }
            else if(placeDTO.getType().equals("명소")) {
                place = new Attraction(placeDTO);
                placeRepository.save(place);
            }
            else if(placeDTO.getType().equals("맛집") || placeDTO.getType().equals("카페")) {
                place = new Restaurant(placeDTO);
                placeRepository.save(place);
            }
            System.out.println("[NEW PLACE] : " + placeDTO);
        }
        return place;
    }
}
