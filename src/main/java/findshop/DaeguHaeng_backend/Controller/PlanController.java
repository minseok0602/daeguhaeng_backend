package findshop.DaeguHaeng_backend.Controller;

import findshop.DaeguHaeng_backend.Service.PlanService;
import findshop.DaeguHaeng_backend.Service.ScheduleService;
import findshop.DaeguHaeng_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plans")
public class PlanController {
    private final UserService userService;
    private final PlanService planService;
    private final ScheduleService scheduleService;
    @Autowired
    public PlanController(UserService userService, PlanService planService, ScheduleService scheduleService) {
        this.userService = userService;
        this.planService = planService;
        this.scheduleService = scheduleService;
    }
}
