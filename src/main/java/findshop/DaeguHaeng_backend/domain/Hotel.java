package findshop.DaeguHaeng_backend.domain;

import findshop.DaeguHaeng_backend.DTO.PlaceDTO;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("H")
@Getter @Setter
@RequiredArgsConstructor
public class Hotel extends Place {
    public Hotel(PlaceDTO placeDTO){
        super(placeDTO);
    }
}
