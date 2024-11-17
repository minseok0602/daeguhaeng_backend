package findshop.DaeguHaeng_backend.Controller;

import findshop.DaeguHaeng_backend.DTO.LoginRequestDTO;
import findshop.DaeguHaeng_backend.DTO.RegisterRequestDTO;
import findshop.DaeguHaeng_backend.DTO.UpdatePasswordDTO;
import findshop.DaeguHaeng_backend.DTO.UserDTO;
import findshop.DaeguHaeng_backend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        try {
            userService.register(registerRequestDTO);
            return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("User registration failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        try{
            userService.logIn(loginRequestDTO);
            return new ResponseEntity<>("User logged in successfully!", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("User login failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{userId}/name")
    public ResponseEntity<String> updateUserName(@PathVariable Long userId, @RequestBody String newName) {
        try{
            UserDTO isUpdated = userService.modifyUserName(userId,newName);
        }catch (Exception e) {
            return new ResponseEntity<>("User update failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("User name updated successfully!", HttpStatus.OK);
    }

    @PutMapping("/{userId}/settings")
    public ResponseEntity<String> updatePassword(@PathVariable Long userId, @RequestBody UpdatePasswordDTO updatePasswordDTO) {
        try{
            UserDTO isUpdated = userService.modifyPassword(userId, updatePasswordDTO);
        }catch (Exception e) {
            return new ResponseEntity<>("User update failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("User password updated successfully!", HttpStatus.OK);
    }
}
