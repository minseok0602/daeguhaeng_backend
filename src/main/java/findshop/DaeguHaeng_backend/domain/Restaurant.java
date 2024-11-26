package findshop.DaeguHaeng_backend.domain;

import findshop.DaeguHaeng_backend.DTO.PlaceDTO;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("R")
@RequiredArgsConstructor
public class Restaurant extends Place {
    public Restaurant(PlaceDTO placeDTO){
        super(placeDTO);
    }
}
