package findshop.DaeguHaeng_backend.domain;

import findshop.DaeguHaeng_backend.domain.Plan;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;
    @NotNull
    private String userName;
    @Column(unique = true, name = "user_login_id")
    @NotNull
    private String userLoginID;
    @NotNull
    private String userPw;


    @OneToMany(mappedBy = "user")
    private List<Plan> plans = new ArrayList<Plan>();


    static public User createUser(String userName, String userLoginID, String userPw) {
        User user = new User();
        user.setUserLoginID(userLoginID);
        user.setUserName(userName);
        user.setUserPw(userPw);
        return user;
    }

}
