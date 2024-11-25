package findshop.DaeguHaeng_backend.Controller;

import findshop.DaeguHaeng_backend.DTO.PlaceDetailDTO;
import findshop.DaeguHaeng_backend.DTO.ScheduleRequestDTO;
import findshop.DaeguHaeng_backend.DTO.ScheduleResponseDTO;
import findshop.DaeguHaeng_backend.Service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/place")
@RequiredArgsConstructor
public class PlaceController {
    final PlaceService placeService;
    @GetMapping("/{placeId}")
    public ResponseEntity<?> getPlaceDetails(@PathVariable Long placeId) {
        PlaceDetailDTO placeDetailDTO;
    }
}
