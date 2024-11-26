package findshop.DaeguHaeng_backend.Repository;

import findshop.DaeguHaeng_backend.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
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
        String jpql = "SELECT u FROM User u WHERE u.loginId = :loginId";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("loginId", loginId);

        try {
            return query.getSingleResult(); // 결과 반환
        } catch (NoResultException e) {
            return null; // 결과가 없을 경우 null 반환
        }
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

}