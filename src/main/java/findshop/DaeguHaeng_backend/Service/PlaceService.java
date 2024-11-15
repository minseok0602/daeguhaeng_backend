package findshop.DaeguHaeng_backend.Service;


import findshop.DaeguHaeng_backend.DTO.PlaceDTO;
import findshop.DaeguHaeng_backend.Repository.PlaceRepository;
import findshop.DaeguHaeng_backend.domain.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceService {

    @Autowired
    private final PlaceRepository placeRepository;

    public PlaceDTO findPlace(Long placeId){
        Place place = placeRepository.findById(placeId);
        if(place == null) throw new IllegalStateException("존재하지 않는 Place");

        return place.placeDTO();
    }
}
