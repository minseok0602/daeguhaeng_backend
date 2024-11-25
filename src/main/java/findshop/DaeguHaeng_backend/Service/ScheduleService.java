package findshop.DaeguHaeng_backend.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import findshop.DaeguHaeng_backend.DTO.ScheduleRequestDTO;
import findshop.DaeguHaeng_backend.DTO.ScheduleResponseDTO;
import findshop.DaeguHaeng_backend.Repository.PlaceRepository;
import findshop.DaeguHaeng_backend.Repository.PlanRepository;
import findshop.DaeguHaeng_backend.Repository.ScheduleRepository;
import findshop.DaeguHaeng_backend.domain.Place;
import findshop.DaeguHaeng_backend.domain.Plan;
import findshop.DaeguHaeng_backend.domain.Schedule;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {
    @Autowired
    private final ScheduleRepository scheduleRepository;
    @Autowired
    private final PlanRepository planRepository;
    @Autowired
    private final PlaceRepository placeRepository;
    @Autowired
    private PlaceService placeService;

    @Transactional
    public ScheduleResponseDTO modifySchedule(Long scheduleId, ScheduleRequestDTO dto){
        Schedule schedule = scheduleRepository.findById(scheduleId);
        if(schedule == null) throw new IllegalStateException("존재하지 않는 schedule");

        schedule.setStartTime(dto.getStartTime());
        schedule.setEndTime(dto.getEndTime());
        schedule.setScheduleText(dto.getScheduleText());

        Place requestPlace = placeRepository.findById(dto.getPlaceId());
        schedule.setPlace(requestPlace);

        return schedule.scheduleResponseDTO();
    }

    public ScheduleResponseDTO createSchedule(String jsonScheduleRequestDTO) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonParser parser = objectMapper.createParser(jsonScheduleRequestDTO);
        JsonNode node = objectMapper.readTree(parser);
        Plan requestPlan = planRepository.findById(node.get("planId").asLong());
        if(requestPlan == null) throw new IllegalStateException("존재하지 않는 Plan");

        placeService.findPlace(jsonScheduleRequestDTO, node.get("placeId").asLong());
        Schedule schedule = objectMapper.treeToValue(node, Schedule.class);

        // 여기서 scheduleRepo.save 해줘야함!

        return schedule.scheduleResponseDTO();
    }

    @Transactional
    public void deleteSchedule(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId);
        if(schedule != null)
            scheduleRepository.delete(schedule);
    }

    public List<ScheduleResponseDTO> findByPlanId(Long planId){
        Plan plan = planRepository.findById(planId);
        if(plan == null) throw new IllegalStateException("존재하지 않는 Plan");
        List<Schedule> schedules = plan.getSchedules();
        List<ScheduleResponseDTO> responseDTOs = new ArrayList<>();

        for(Schedule schedule : schedules)
            responseDTOs.add(schedule.scheduleResponseDTO());

        return responseDTOs;
    }



}
