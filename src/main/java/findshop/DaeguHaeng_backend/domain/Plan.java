package findshop.DaeguHaeng_backend.domain;

import findshop.DaeguHaeng_backend.DTO.PlanRequestDTO;
import findshop.DaeguHaeng_backend.DTO.PlanResponseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long Id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<Schedule> schedules = new ArrayList<Schedule>();
    @NotNull
    private int budget;
    @NotNull
    private Sex sex;
    @NotNull
    private int age;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotNull
    private String title;
    public void setUser(User user) {
        this.user = user;
        user.getPlans().add(this);
    }
    static public Plan createPlan(User user) {
        Plan plan = new Plan();
        plan.setUser(user);
        return plan;
    }
    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }
    public void setDetail(int budget, Sex sex, int age, LocalDate startDate, LocalDate endDate) {
        this.budget = budget;
        this.sex = sex;
        this.age = age;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PlanResponseDTO planResponseDTO(){
        return new PlanResponseDTO(Id, sex, age, startDate, endDate, budget,title);
    }

    public PlanRequestDTO planRequestDTO(){
        return new PlanRequestDTO(user.getId(), startDate, endDate, sex, age, budget,title);
    }


}
