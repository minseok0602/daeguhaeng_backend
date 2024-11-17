package findshop.DaeguHaeng_backend.Controller;

import findshop.DaeguHaeng_backend.DTO.PlanRequestDTO;
import findshop.DaeguHaeng_backend.DTO.ScheduleRequestDTO;
import findshop.DaeguHaeng_backend.DTO.ScheduleResponseDTO;
import findshop.DaeguHaeng_backend.Service.ScheduleService;
import findshop.DaeguHaeng_backend.domain.Plan;
import findshop.DaeguHaeng_backend.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    @PostMapping("/api/recomands/{userId}/{planId}")
    public ResponseEntity<?> createSchedule(@RequestBody ScheduleRequestDTO scheduleRequestDto) {
        ScheduleResponseDTO scheduleResponseDTO;
        try{
            scheduleResponseDTO = scheduleService.createSchedule(scheduleRequestDto);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(scheduleResponseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/api/recomands/{userId}/{planId}")
    public ResponseEntity<?> getSchedule(@PathVariable long planId) {
        List<?> schedules = scheduleService.findByPlanId(planId);
        return new ResponseEntity<>(schedules,HttpStatus.OK);
    }
    @PutMapping("/api/recomands/{userId}/{planId}")
    public ResponseEntity<?> modifySchedule(@PathVariable Long userId, @RequestBody ScheduleRequestDTO scheduleRequestDTO) {
        ScheduleResponseDTO scheduleResponseDTO;
        try {
            scheduleResponseDTO = scheduleService.modifySchedule(userId, scheduleRequestDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(scheduleResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/api/recomands/{userId}/{planId}")//schedule은 http 경로에 id가 안 나올듯
    public ResponseEntity<?> deleteSchedule(@RequestBody ScheduleResponseDTO scheduleResponseDTO) {
        try{
            scheduleService.deleteSchedule(scheduleResponseDTO.getScheduleId());
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
