package domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;

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

    private String name;
    private String address;
    private Double rate;
    private Double latitude;
    private Double longitude;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="place_id")
    private PlaceImage placeImageId;

    @OneToMany(mappedBy = "place")
    private List<Review> reviews = new ArrayList<Review>();




}
