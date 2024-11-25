package findshop.DaeguHaeng_backend.domain;

import findshop.DaeguHaeng_backend.DTO.PlaceDTO;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("H")
@Getter @Setter
public class Hotel extends Place {
    private PlaceDTO placeDTO;
    public Hotel(PlaceDTO placeDTO) {
        this.placeDTO = placeDTO;
    }

    public Hotel() {

    }
}
