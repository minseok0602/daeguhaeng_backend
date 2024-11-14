package findshop.DaeguHaeng_backend.domain;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long Id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private Double rate;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="place_iamge_id")
    private PlaceImage placeImageId;

    @OneToMany(mappedBy = "place")
    private List<Review> reviews = new ArrayList<Review>();




}
