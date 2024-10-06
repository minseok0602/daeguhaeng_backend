package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class PlanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_detail_id")
    private Long Id;

    @OneToOne(mappedBy = "planDetail")
    private Plan plan;


    // 예산
    private Integer budget;


    @Enumerated(EnumType.STRING)
    private Sex sex;

    private Integer age;
    private LocalDate startDate;
    private LocalDate endDate;



}
