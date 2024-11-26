package findshop.DaeguHaeng_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduleCreateDTO {
    private Long planId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String scheduleText;
    private Long placeId;
    private String type;
    private String name;
    private String address;
    private float rate;
    private String imageURL;
}
