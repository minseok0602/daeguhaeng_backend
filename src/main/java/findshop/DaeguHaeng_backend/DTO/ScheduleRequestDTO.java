package findshop.DaeguHaeng_backend.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ScheduleRequestDTO {
    private Long planId;
    private String startTime;
    private String endTime;
    private String scheduleText;
    private Long placeId;
}