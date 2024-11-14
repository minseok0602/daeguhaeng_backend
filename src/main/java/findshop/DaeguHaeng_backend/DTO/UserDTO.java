package findshop.DaeguHaeng_backend.DTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@RequiredArgsConstructor
@Getter@Setter
public class UserDTO {
    private String userName;
    private Long userId;
    private String loginId;
}