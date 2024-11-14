package findshop.DaeguHaeng_backend.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("R")
public class Restaurant extends Place{
    public Restaurant createRestaurant(String address, Double rate, Double latitude, Double longitude) {
        Restaurant place = new Restaurant();
        place.setAddress(address);
        place.setLatitude(latitude);
        place.setLongitude(longitude);
        place.setRate(rate);
        return place;
    }

}
