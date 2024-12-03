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
@RequestMapping("/api/plan")
// class level url
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @PostMapping("/{userId}/new") // localhost:8080/api/plan/userid/new
    public ResponseEntity<?> createPlan(@PathVariable Long userId, @RequestBody PlanRequestDTO planRequestDTO) {
        PlanResponseDTO planResponseDTO;
        try {
            planResponseDTO = planService.initPlan(userId, planRequestDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(planResponseDTO, HttpStatus.CREATED);
    }


    @GetMapping("/{userId}/get")
    public ResponseEntity<?> getAllPlans(@PathVariable Long userId) {
        List<PlanResponseDTO> plans = planService.findPlans(userId);
        return new ResponseEntity<>(plans,HttpStatus.OK);
    }

    @PutMapping("/{userId}/update/{planId}")
    public ResponseEntity<?> updatePlan(@PathVariable Long planId, @RequestBody PlanRequestDTO planRequestDTO) {
        PlanResponseDTO planResponseDTO;
        try{
            planResponseDTO = planService.updatePlan(planId,planRequestDTO);
        }catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(planResponseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/delete/{planId}")
    public ResponseEntity<?> deletePlan(@PathVariable Long planId) {
        try{
            planService.deletePlan(planId);
        }catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
