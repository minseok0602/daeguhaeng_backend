package findshop.DaeguHaeng_backend.Service;

import findshop.DaeguHaeng_backend.DTO.PlanRequestDTO;
import findshop.DaeguHaeng_backend.DTO.PlanResponseDTO;
import findshop.DaeguHaeng_backend.Repository.PlanRepository;
import findshop.DaeguHaeng_backend.Repository.UserRepository;
import findshop.DaeguHaeng_backend.domain.Plan;
import findshop.DaeguHaeng_backend.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // DB에 트랜잭션하겟다 이말이지 그치~
// atomic한 수정작업 할거임 ㅇㅋ?
@RequiredArgsConstructor
public class PlanService {

    @Autowired
    private final PlanRepository planRepository;
    @Autowired
    private final UserRepository userRepository;

    public PlanResponseDTO initPlan(Long userId, PlanRequestDTO request){
        User user = userRepository.findById(userId);
        if(user == null) throw new IllegalStateException("존재하지 않는 User");
        Plan newPlan = Plan.createPlan(user);
        newPlan.setDetail(request.getBudget(), request.getSex(), request.getAge(), request.getStartDate(), request.getEndDate());

        PlanResponseDTO response = new PlanResponseDTO();


    }

    public List<PlanResponseDTO> findPlans(Long userId){

    }

    public PlanResponseDTO updatePlan(Long planId, PlanRequestDTO request){

    }

    public void deletePlan(Long planId){
        Plan plan = planRepository.findById(planId);
        if(plan != null)
            planRepository.delete(plan);
    }



}
