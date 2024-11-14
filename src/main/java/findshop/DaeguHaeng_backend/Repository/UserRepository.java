package findshop.DaeguHaeng_backend.Repository;

import findshop.DaeguHaeng_backend.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }


    public User findByLoginId(String loginId) {
        return em.find(User.class, loginId);
     }

    public User findById(Long id) {
        return em.find(User.class, id);
    }


}
