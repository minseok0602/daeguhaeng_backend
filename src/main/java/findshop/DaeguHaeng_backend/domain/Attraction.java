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
    private PlaceDTO placeDTO;
    public Attraction(PlaceDTO placeDTO) {
        this.placeDTO = placeDTO;
    }

    public Attraction() {

    }
}
