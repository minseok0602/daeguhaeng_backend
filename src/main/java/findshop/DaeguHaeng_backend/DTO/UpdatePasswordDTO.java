package findshop.DaeguHaeng_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UpdatePasswordDTO {
    private String oldPassword;
    private String newPassword;
}
