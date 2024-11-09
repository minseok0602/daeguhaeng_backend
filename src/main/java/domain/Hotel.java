package domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("H")
@Getter @Setter
public class Hotel extends Place{
    public Hotel createHotel(String address, Double rate, Double latitude, Double longitude) {
        Hotel place = new Hotel();
        place.setAddress(address);
        place.setLatitude(latitude);
        place.setLongitude(longitude);
        place.setRate(rate);
        return place;
    }
}
