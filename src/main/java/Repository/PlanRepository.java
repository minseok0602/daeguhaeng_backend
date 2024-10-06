package Repository;

import domain.Plan;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlanRepository {

    // findAll
    private final EntityManager em;


    // findOne
    public Plan findOne(Long id){
        return em.find(Plan.class, id);
    }

    // findAll
    public List<Plan> findAll(){
        return em.createQuery("select p from Plan p", Plan.class).getResultList();
    }











}
