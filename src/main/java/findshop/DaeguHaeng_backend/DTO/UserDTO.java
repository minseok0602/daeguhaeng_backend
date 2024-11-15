package findshop.DaeguHaeng_backend.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class UserDTO {
    private String userName;
    private Long userId;
    private String loginId;

}