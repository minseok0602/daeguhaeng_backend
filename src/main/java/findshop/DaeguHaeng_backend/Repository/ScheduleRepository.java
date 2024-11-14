package findshop.DaeguHaeng_backend.Repository;

import findshop.DaeguHaeng_backend.domain.Schedule;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ScheduleRepository {

    private final EntityManager em;

    //

    public void save(Schedule schedule) {
        em.persist(schedule);
    }

    // 시간 수정해야됨

}
