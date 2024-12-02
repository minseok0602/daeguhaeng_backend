package findshop.DaeguHaeng_backend.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import findshop.DaeguHaeng_backend.DTO.ScheduleCreateDTO;
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

        scheduleRepository.save(schedule);

        return getScheduleResponseDTO(schedule);
    }

    public ScheduleResponseDTO createSchedule(ScheduleCreateDTO scheduleCreateDTO){ // Plan에 Schedule 추가하는 로직도 함께
        Plan requestPlan = planRepository.findById(scheduleCreateDTO.getPlanId());
        if(requestPlan == null) throw new IllegalStateException("존재하지 않는 Plan");

        Place requestPlace = placeService.findPlace(scheduleCreateDTO);

        Schedule schedule = Schedule.createSchedule(requestPlace, scheduleCreateDTO.getScheduleText());
        schedule.setPlan(requestPlan);
        schedule.setStartTime(scheduleCreateDTO.getStartTime());
        schedule.setEndTime(scheduleCreateDTO.getEndTime());
        schedule.setScheduleText(scheduleCreateDTO.getScheduleText());
        schedule.setPlace(requestPlace);
        scheduleRepository.save(schedule);
        return getScheduleResponseDTO(schedule);
    }

    @Transactional
    public void deleteSchedule(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId);
        if(schedule != null)
            scheduleRepository.delete(schedule);
    }

    public List<ScheduleResponseDTO> findByPlanId(Long planId){ // plan 안의 schedule들 반환, 이 때 placeId는 place세부 정보로 변환해서
        Plan plan = planRepository.findById(planId);
        if(plan == null) throw new IllegalStateException("존재하지 않는 Plan");
        List<Schedule> schedules = plan.getSchedules();
        List<ScheduleResponseDTO> responseDTOs = new ArrayList<>();

        for(Schedule schedule : schedules) {
            ScheduleResponseDTO responseDTO = getScheduleResponseDTO(schedule);
            responseDTOs.add(responseDTO);
        }
        return responseDTOs;
    }

    private static ScheduleResponseDTO getScheduleResponseDTO(Schedule schedule) {
        ScheduleResponseDTO responseDTO = new ScheduleResponseDTO();
        Place place = schedule.getPlace();
        responseDTO.setScheduleId(schedule.getId());
        responseDTO.setStartTime(schedule.getStartTime().toString());
        responseDTO.setEndTime(schedule.getEndTime().toString());
        responseDTO.setScheduleText(schedule.getScheduleText());
        if(place != null) {
            responseDTO.setName(place.getName());
            responseDTO.setImageURL(place.getImageURL());
            responseDTO.setAddress(place.getAddress());
            responseDTO.setRate(place.getRate());
        }

        return responseDTO;
    }


}
