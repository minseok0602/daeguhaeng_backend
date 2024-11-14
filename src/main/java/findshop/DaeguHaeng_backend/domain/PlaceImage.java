package domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter @Setter
public class PlaceImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_image_id")
    private Long placeImageId;
    @NotNull
    private String imageUrl;
    public PlaceImage createlaceImage(String imageUrl) {
        PlaceImage placeImage = new PlaceImage();
        placeImage.setPlaceImageId(placeImageId);
        return placeImage;
    }
}
