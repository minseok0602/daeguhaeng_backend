package findshop.DaeguHaeng_backend.DTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
@RequiredArgsConstructor
@Getter @Setter
public class ScheduleRequestDTO {
    private Long planId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String scheduleText;
    private Long placeId;
}