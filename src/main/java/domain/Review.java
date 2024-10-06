package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long Id;


    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    private Integer score;
    private String reviewText;




}
