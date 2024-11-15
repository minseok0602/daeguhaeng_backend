package findshop.DaeguHaeng_backend.DTO;
import findshop.DaeguHaeng_backend.domain.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@RequiredArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PlanResponseDTO {
    private Long planId;
    private Sex sex;
    private Integer age;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer budget;
}