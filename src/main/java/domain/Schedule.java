package domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    @NotNull
    private Plan plan;
    @OneToOne
    @JoinColumn(name = "place_id")
    @NotNull
    private Place place;
    @NotNull
    private LocalDate startdate;
    @NotNull
    private LocalDate enddate;

    private String scheduleText;
    static public Schedule createSchedule(Place place, String scheduleText){
        Schedule schedule = new Schedule();
        schedule.place = place;
        return schedule;
    }
    public void setPlan(Plan plan) {
        this.plan = plan;
    }
    public void setPlace(Place place) {
        this.place = place;
    }

}
