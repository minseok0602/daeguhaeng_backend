package findshop.DaeguHaeng_backend.domain;

import findshop.DaeguHaeng_backend.DTO.LoginRequestDTO;
import findshop.DaeguHaeng_backend.DTO.LoginResponseDTO;
import findshop.DaeguHaeng_backend.DTO.RegisterRequestDTO;
import findshop.DaeguHaeng_backend.DTO.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;
    @NotNull
    private String userName;

    @Column(unique = true, name = "user_login_id")
    @NotNull
    private String loginId;
    @NotNull
    private String userPw;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Plan> plans = new ArrayList<Plan>();


    static public User createUser(String userName, String userLoginID, String userPw) {
        User user = new User();
        user.setLoginId(userLoginID);
        user.setUserName(userName);
        user.setUserPw(userPw);
        return user;
    }

    public UserDTO userDTO() {
        return new UserDTO(userName, Id, loginId);
    }

    public LoginRequestDTO loginRequestDTO(){
        return new LoginRequestDTO(loginId, userPw);
    }

    public LoginResponseDTO loginResponseDTO(){
        return new LoginResponseDTO(loginId, Id);
    }

    public RegisterRequestDTO registerRequestDTO(){
        return new RegisterRequestDTO(userName, loginId, userPw);
    }


}
