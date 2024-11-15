package findshop.DaeguHaeng_backend.DTO;

import findshop.DaeguHaeng_backend.domain.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class PlaceDTO {
    private String name;
    private String placeType;
    private String address;
    private Double rate;
    private Double latitude;
    private Double longitude;
//    private List<Review> reviews;
}
