package findshop.DaeguHaeng_backend.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class LoginRequestDTO {
    private String loginId;
    private String password;
}