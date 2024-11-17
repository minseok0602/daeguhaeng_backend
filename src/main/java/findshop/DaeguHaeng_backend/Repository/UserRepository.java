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


    public List<User> findByLoginId(String loginId) {
        String jpql = "SELECT u FROM User u WHERE u.loginId = :loginId";
        return em.createQuery(jpql, User.class).setParameter("loginId", loginId).getResultList();
    }




}
