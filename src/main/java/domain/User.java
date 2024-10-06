package domain;

import jakarta.persistence.*;
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

    private String userName;
    private String userLoginID;
    private String userPw;


    @OneToMany(mappedBy = "user")
    private List<Plan> plans = new ArrayList<Plan>();



}
