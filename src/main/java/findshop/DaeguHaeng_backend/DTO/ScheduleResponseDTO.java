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
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String scheduleText;
//    private Long placeId;
    private String name;
    private String imageURL;
    private String address;
    private float rate;
}
