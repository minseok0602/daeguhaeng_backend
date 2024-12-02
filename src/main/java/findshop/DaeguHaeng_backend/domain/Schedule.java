package findshop.DaeguHaeng_backend.domain;

import findshop.DaeguHaeng_backend.DTO.ScheduleRequestDTO;
import findshop.DaeguHaeng_backend.DTO.ScheduleResponseDTO;
import findshop.DaeguHaeng_backend.Service.PlaceService;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Getter @Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    @NotNull
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "place_id")
    @NotNull
    private Place place;

    @NotNull
    private LocalDateTime startTime;
    @NotNull
    private LocalDateTime endTime;

    private String scheduleText;
    static public Schedule createSchedule(Place place, String scheduleText){
        Schedule schedule = new Schedule();
        schedule.place = place;
        schedule.scheduleText = scheduleText;
        return schedule;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
        plan.addSchedule(this);
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public ScheduleRequestDTO scheduleRequestDTO(){
        return new ScheduleRequestDTO(plan.getId(), startTime.toString(), endTime.toString(), scheduleText, place.getId());
    }


//    public ScheduleResponseDTO scheduleResponseDTO(){
//        return new ScheduleResponseDTO(Id, startTime, endTime, scheduleText, place.getId());
//    }

}
