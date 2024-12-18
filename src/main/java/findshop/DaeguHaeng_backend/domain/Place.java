package findshop.DaeguHaeng_backend.domain;


import findshop.DaeguHaeng_backend.DTO.PlaceDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "place_type") // 상속을 구분해줄 칼럼명
@Getter @Setter
@RequiredArgsConstructor
public abstract class Place {

    @Id
    @Column(name = "place_id")
    private Long id;
    @NotNull
    private String name;
    //    @NotNull
    private String address;
    @NotNull
    private float rate;
    @NotNull
    @Column(length = 512)
    private String imageURL;



    public Place(PlaceDTO placeDTO){
        this.setId(placeDTO.getPlaceId());
        this.setAddress(placeDTO.getAddress());
        this.setRate(placeDTO.getRate());
        this.setName(placeDTO.getName());
        this.setImageURL(placeDTO.getImageURL());
    }

}
