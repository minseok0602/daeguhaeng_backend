package findshop.DaeguHaeng_backend.Service;

import findshop.DaeguHaeng_backend.DTO.LoginRequestDTO;
import findshop.DaeguHaeng_backend.DTO.LoginResponseDTO;
import findshop.DaeguHaeng_backend.DTO.RegisterRequestDTO;
import findshop.DaeguHaeng_backend.DTO.UserDTO;
import findshop.DaeguHaeng_backend.Repository.UserRepository;
import findshop.DaeguHaeng_backend.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public LoginResponseDTO logIn(LoginRequestDTO dto) {
        User user = userRepository.findByLoginId(dto.getLoginId());

        if(user == null){
            throw new IllegalStateException("해당 사용자 ID가 존재하지 않습니다.");
        }

        if(!user.getUserPw().equals(dto.getPassword())){
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        return user.loginResponseDTO();
    }


    public LoginResponseDTO register(RegisterRequestDTO dto){
        validateDuplicateUser(dto.getUserLoginId());
        User newUser = User.createUser(dto.getUsername(), dto.getUserLoginId(), dto.getPassword());
        userRepository.save(newUser);

        return newUser.loginResponseDTO();
    }


    private void validateDuplicateUser(String userLoginId){
        User user = userRepository.findByLoginId(userLoginId);
        if(user != null){
            throw new IllegalStateException("이미 존재하는 LoginID");
        }
    }


    public UserDTO findOne(Long userId){
        User user = userRepository.findById(userId);
        if(user == null)
            throw new IllegalStateException("존재하지 않는 user");

        return user.userDTO();
    }

    public UserDTO modifyUserName(Long userId, String newUserName){
        User user = userRepository.findById(userId);

        if(user == null)
            throw new IllegalStateException("존재하지 않는 user");

        user.setUserName(newUserName);
        userRepository.save(user);

        return user.userDTO();
    }

    public UserDTO modifyPassword(Long userId, String currentPw, String newPw){
        if(!isValidPassword(newPw)){
            throw new IllegalStateException("올바르지 않은 비밀번호 형식");
        }
        User user = userRepository.findById(userId);

        if(user == null)
            throw new IllegalStateException("존재하지 않는 user");

        user.setUserPw(newPw);
        userRepository.save(user);

        return user.userDTO();
    }

    private boolean isValidPassword(String password){
        // password 형식 : 특수문자(!,@,#,$,, 영문, 숫자 반드시 포함하는 8자리 이상
        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$]).{8,}$";
        return password.matches(regex);
    }


}
