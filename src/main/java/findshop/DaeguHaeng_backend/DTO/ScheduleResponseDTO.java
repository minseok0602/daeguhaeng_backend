package findshop.DaeguHaeng_backend.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter @Setter
public class ScheduleResponseDTO {
    private Long scheduleId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String scheduleText;
    private Long placeId;
}
