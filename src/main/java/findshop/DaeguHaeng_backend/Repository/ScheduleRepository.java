package findshop.DaeguHaeng_backend.Repository;

import findshop.DaeguHaeng_backend.domain.Schedule;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ScheduleRepository {

    private final EntityManager em;


    public void save(Schedule schedule) {
        em.persist(schedule);
    }

    public void delete(Schedule schedule) {
        em.remove(schedule);
    }

    public Schedule findById(Long id) {
        return em.find(Schedule.class, id);
    }

    public List<Schedule> findByPlanId(Long planId) {

    }


}