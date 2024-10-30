package findshop.DaeguHaeng_backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;

    protected User() {}


    private String userName;
    @Column(unique = true, nullable = false)
    private String loginId;
    private String userPw;


    @OneToMany(mappedBy = "user")
    private List<Plan> plans = new ArrayList<Plan>();


    static public User createUser(String userName, String userLoginID, String userPw) {
        User user = new User();
        user.setLoginId(userLoginID);
        user.setUserName(userName);
        user.setUserPw(userPw);
        return user;
    }

}
