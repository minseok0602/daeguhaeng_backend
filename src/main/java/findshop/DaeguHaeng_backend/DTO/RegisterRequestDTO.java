package findshop.DaeguHaeng_backend.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
    String username;
    String userLoginId;
    String password;
}
