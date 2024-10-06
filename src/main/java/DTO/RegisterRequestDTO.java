package DTO;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class RegisterRequestDTO {
    String username;
    String userLoginId;
    String password;
}
