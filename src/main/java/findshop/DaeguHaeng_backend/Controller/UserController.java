package findshop.DaeguHaeng_backend.Controller;

import findshop.DaeguHaeng_backend.DTO.*;
import findshop.DaeguHaeng_backend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        LoginResponseDTO loginResponseDTO;
        try {
            loginResponseDTO = userService.register(registerRequestDTO);
        } catch (Exception e) {
            return new ResponseEntity<>("User registration failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(loginResponseDTO, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDTO;
        try{
            loginResponseDTO =  userService.logIn(loginRequestDTO);
        }catch (Exception e) {
            return new ResponseEntity<>("User login failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(loginResponseDTO, HttpStatus.OK);
    }


    @PutMapping("/{id}/updateName")
    public ResponseEntity<?> updateUserName(@PathVariable Long id, @RequestBody String newName) {
        UserDTO userDTO;
        try{
            userDTO = userService.modifyUserName(id,newName);
        }catch (Exception e) {
            return new ResponseEntity<>("User update failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/{userId}/settings")
    public ResponseEntity<?> updatePassword(@PathVariable Long userId, @RequestBody UpdatePasswordDTO updatePasswordDTO) {
        UserDTO userDTO;
        try{
            userDTO =  userService.modifyPassword(userId, updatePasswordDTO);
        }catch (Exception e) {
            return new ResponseEntity<>("User update failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}
