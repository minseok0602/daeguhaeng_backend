package findshop.DaeguHaeng_backend.Repository;

import findshop.DaeguHaeng_backend.domain.Place;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PlaceRepository {

    private final EntityManager em;

    public Place findById(Long id){
        return em.find(Place.class, id);
    }


}
