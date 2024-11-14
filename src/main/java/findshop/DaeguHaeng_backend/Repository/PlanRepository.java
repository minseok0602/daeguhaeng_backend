package findshop.DaeguHaeng_backend.Repository;

import findshop.DaeguHaeng_backend.domain.Plan;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlanRepository {

    // findAll
    private final EntityManager em;


    public void save(Plan plan) {
        em.persist(plan);
    }

    public Plan findById(Long id) {
        return em.find(Plan.class, id);
    }

    public List<Plan> findByUserId(Long userId) {

    }

    public void delete(Plan plan) {
        em.remove(plan);
    }









}