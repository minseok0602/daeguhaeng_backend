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

@RestController("/api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
<<<<<<< HEAD
    @PostMapping("/api/recommends/{userId}/{planId}")
=======

    @PostMapping("/{userid}/create/{planId}")
>>>>>>> origin/master
    public ResponseEntity<?> createSchedule(@RequestBody ScheduleRequestDTO scheduleRequestDto) {
        ScheduleResponseDTO scheduleResponseDTO;
        try{
            scheduleResponseDTO = scheduleService.createSchedule(scheduleRequestDto);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(scheduleResponseDTO, HttpStatus.CREATED);
    }
<<<<<<< HEAD
    @GetMapping("/api/recommends/{userId}/{planId}/schedules")
    public ResponseEntity<?> getSchedule(@PathVariable long planId) {
        List<?> schedules = scheduleService.findByPlanId(planId);
        return new ResponseEntity<>(schedules,HttpStatus.OK);
    }
    @PutMapping("/api/recommends/{userId}/{planId}/modify/{scheduleId}")
=======

    @GetMapping("/{userId}/get/{planId}")
    public ResponseEntity<?> getSchedule(@PathVariable Long planId) {
        List<?> schedules = scheduleService.findByPlanId(planId);
        return new ResponseEntity<>(schedules,HttpStatus.OK);
    }

    @PutMapping("/{userId}/modify/{planId}/{scheduleId}")
>>>>>>> origin/master
    public ResponseEntity<?> modifySchedule(@PathVariable Long scheduleId, @RequestBody ScheduleRequestDTO scheduleRequestDTO) {
        ScheduleResponseDTO scheduleResponseDTO;
        try {
            scheduleResponseDTO = scheduleService.modifySchedule(scheduleId, scheduleRequestDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(scheduleResponseDTO, HttpStatus.OK);
    }

<<<<<<< HEAD
    @DeleteMapping("/api/recommends/{userId}/{planId}/delete/{scheduleId}")
=======
    @DeleteMapping("/{userId}/delete/{planId}/{scheduleId}")
>>>>>>> origin/master
    public ResponseEntity<?> deleteSchedule(@PathVariable Long scheduleId) {
        try{
            scheduleService.deleteSchedule(scheduleId);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
