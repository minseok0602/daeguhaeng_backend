package findshop.DaeguHaeng_backend.domain;

import findshop.DaeguHaeng_backend.DTO.PlaceDTO;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("R")
public class Restaurant extends Place {
    private PlaceDTO placeDTO;
    public Restaurant(PlaceDTO placeDTO) {
        this.placeDTO = placeDTO;
    }

    public Restaurant() {

    }
}
