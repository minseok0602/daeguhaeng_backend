package findshop.DaeguHaeng_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor @AllArgsConstructor
@Getter @Setter
public class LoginRequestDTO {
    private String loginId;
    private String password;
}