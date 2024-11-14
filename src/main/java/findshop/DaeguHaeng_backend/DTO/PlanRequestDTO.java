package findshop.DaeguHaeng_backend.DTO;
import findshop.DaeguHaeng_backend.domain.Sex;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@RequiredArgsConstructor
@Getter @Setter
public class PlanRequestDTO {
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Sex sex;
    private Integer age;
    private Integer budget;
}