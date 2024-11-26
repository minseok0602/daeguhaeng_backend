package findshop.DaeguHaeng_backend.domain;


import findshop.DaeguHaeng_backend.DTO.PlaceDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "place_type") // 상속을 구분해줄 칼럼명
@Getter @Setter
public abstract class Place {

    @Id
    @Column(name = "place_id")
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private float rate;
    @NotNull
    private String imageURL;
    public Place();

}
