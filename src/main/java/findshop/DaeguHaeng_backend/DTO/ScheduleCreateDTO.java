package findshop.DaeguHaeng_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduleCreateDTO {
    private Long planId;
    private String startTime;
    private String endTime;
    private String scheduleText;
    private Long placeId;
    private String type;
    private String name;
    private String address;
    private float rate;
    private String imageURL;

    @Override
    public String toString(){
        return "ScheduleCreateDTO [planId=" + planId + ", startTime=" + startTime + ", endTime="
                + endTime + ", scheduleText=" + scheduleText + ", placeId=" + placeId + ", type=" + type
                + ", name=" + name + ", address=" + address + ", rate=" + rate + ", imageURL=" + imageURL
                ;
    }
}
