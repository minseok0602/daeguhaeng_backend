package findshop.DaeguHaeng_backend.domain;


import findshop.DaeguHaeng_backend.DTO.PlaceDTO;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("A")
public class Attraction extends Place {
    public Attraction(PlaceDTO placeDTO) {
        this.setId(placeDTO.getPlaceId());
        this.setName(placeDTO.getName());
        this.setAddress(placeDTO.getAddress());
        this.setRate(placeDTO.getRate());
        this.setImageURL(placeDTO.getImageURL());
    }

    public Attraction() {

    }
}
