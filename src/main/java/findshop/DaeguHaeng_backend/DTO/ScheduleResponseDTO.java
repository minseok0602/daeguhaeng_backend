package findshop.DaeguHaeng_backend.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ScheduleResponseDTO {
    private Long scheduleId;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private String scheduleText;
    private Long placeId;
}