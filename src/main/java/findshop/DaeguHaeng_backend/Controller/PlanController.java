package findshop.DaeguHaeng_backend.Controller;

import findshop.DaeguHaeng_backend.DTO.PlanRequestDTO;
import findshop.DaeguHaeng_backend.DTO.PlanResponseDTO;
import findshop.DaeguHaeng_backend.Service.PlanService;
import findshop.DaeguHaeng_backend.Service.ScheduleService;
import findshop.DaeguHaeng_backend.Service.UserService;
import findshop.DaeguHaeng_backend.domain.Plan;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @PostMapping("/api/recomands/{id}")
    public ResponseEntity<?> createPlan(@PathVariable Long id, @RequestBody PlanRequestDTO planRequestDTO) {
        PlanResponseDTO planResponseDTO;
        try {
            planResponseDTO = planService.initPlan(id, planRequestDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(planResponseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/api/{id}/plans")
    public ResponseEntity<?> getAllPlans(@PathVariable Long id) {
        List<PlanResponseDTO> plans = planService.findPlans(id);
        return new ResponseEntity<>(plans,HttpStatus.OK);
    }

    @PutMapping("/api/{id}/plans")
    public ResponseEntity<Plan> updatePlan(@PathVariable Long id, @RequestBody PlanRequestDTO planRequestDTO) {
        try{ planService.updatePlan(id,planRequestDTO);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/{id}/plans")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        try{
            planService.deletePlan(id);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
