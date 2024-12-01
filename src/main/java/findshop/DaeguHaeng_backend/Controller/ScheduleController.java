package findshop.DaeguHaeng_backend.Controller;

import findshop.DaeguHaeng_backend.DTO.*;
import findshop.DaeguHaeng_backend.Service.ScheduleService;
import findshop.DaeguHaeng_backend.domain.Plan;
import findshop.DaeguHaeng_backend.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/") // 클라이언트 Origin 허용
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/{userid}/create/{planId}")
    public ResponseEntity<?> createSchedule(@RequestBody ScheduleCreateDTO scheduleCreateDTO) {
        ScheduleResponseDTO scheduleResponseDTO;
        try{
            scheduleResponseDTO = scheduleService.createSchedule(scheduleCreateDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(scheduleResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/get/{planId}")
    public ResponseEntity<?> getSchedule(@PathVariable Long planId) {
        List<?> schedules = scheduleService.findByPlanId(planId);
        return new ResponseEntity<>(schedules,HttpStatus.OK);
    }

    @PutMapping("/{userId}/modify/{planId}/{scheduleId}")
    public ResponseEntity<?> modifySchedule(@PathVariable Long scheduleId, @RequestBody ScheduleRequestDTO scheduleRequestDTO) {
        ScheduleResponseDTO scheduleResponseDTO;
        try {
            scheduleResponseDTO = scheduleService.modifySchedule(scheduleId, scheduleRequestDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(scheduleResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/delete/{planId}/{scheduleId}")
    public ResponseEntity<?> deleteSchedule(@PathVariable Long scheduleId) {
        try{
            scheduleService.deleteSchedule(scheduleId);
        }catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}