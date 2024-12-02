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

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlanService {

    @Autowired
    private final PlanRepository planRepository;
    @Autowired
    private final UserRepository userRepository;

    @Transactional
    public PlanResponseDTO initPlan(Long userId, PlanRequestDTO request){
        User user = userRepository.findById(userId);
        if(user == null) throw new IllegalStateException("존재하지 않는 User");

        Plan newPlan = Plan.createPlan(user);


        newPlan.setDetail(request.getBudget(), request.getSex(), request.getAge(), request.getStartDate(), request.getEndDate(), request.getTitle());

        planRepository.save(newPlan);

        return newPlan.planResponseDTO();
    }

    public List<PlanResponseDTO> findPlans(Long userId){
        User user = userRepository.findById(userId);
        if(user == null) throw new IllegalStateException("존재하지 않는 User");
        List<Plan> plans = user.getPlans();

        List<PlanResponseDTO> planDTOs = new ArrayList<>();

        for(Plan plan : plans)
            planDTOs.add(plan.planResponseDTO());

        return planDTOs;
    }

    @Transactional
    public PlanResponseDTO updatePlan(Long planId, PlanRequestDTO request){
        Plan plan = planRepository.findById(planId);
        plan.setStartDate(request.getStartDate());
        plan.setEndDate(request.getEndDate());
        plan.setSex(request.getSex());
        plan.setAge(request.getAge());
        plan.setBudget(request.getBudget());
        plan.setTitle(request.getTitle());
        return plan.planResponseDTO();
    }

    @Transactional
    public void deletePlan(Long planId){
        Plan plan = planRepository.findById(planId);
        if(plan != null)
            planRepository.delete(plan);
    }

}
