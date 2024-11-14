package findshop.DaeguHaeng_backend.domain;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("A")
public class Attraction extends Place {
    public Attraction createAttraction(String address, Double rate, Double latitude, Double longitude) {
        Attraction place = new Attraction();
        place.setAddress(address);
        place.setLatitude(latitude);
        place.setLongitude(longitude);
        place.setRate(rate);
        return place;
    }
}
