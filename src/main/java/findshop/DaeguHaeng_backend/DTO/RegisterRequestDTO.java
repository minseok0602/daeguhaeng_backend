package findshop.DaeguHaeng_backend.DTO;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class RegisterRequestDTO {
    String userName;
    String userLoginId;
    String password;
}
