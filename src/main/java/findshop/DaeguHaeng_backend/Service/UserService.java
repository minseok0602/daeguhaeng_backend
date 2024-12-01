package findshop.DaeguHaeng_backend.Service;

import findshop.DaeguHaeng_backend.DTO.*;
import findshop.DaeguHaeng_backend.Repository.UserRepository;
import findshop.DaeguHaeng_backend.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional(readOnly = true)
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

    @Transactional
    public LoginResponseDTO register(RegisterRequestDTO dto){
        validatePassword(dto.getPassword());
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

    @Transactional
    public UserDTO modifyUserName(Long userId, String newUserName){

        User user = userRepository.findById(userId);

        if(user == null)
            throw new IllegalStateException("존재하지 않는 user");

        user.setUserName(newUserName);

        return user.userDTO();
    }

    @Transactional
    public UserDTO modifyPassword(Long userId, UpdatePasswordDTO dto){
        validatePassword(dto.getNewPassword());
        User user = userRepository.findById(userId);

        if(user == null)
            throw new IllegalStateException("존재하지 않는 user");
        else if(!user.getUserPw().equals(dto.getOldPassword())){
            throw new IllegalStateException("올바르지 않은 비밀번호");
        }
        user.setUserPw(dto.getNewPassword());

        return user.userDTO();
    }

    private void validatePassword(String password){
        // password 형식 : 특수문자(!,@,#,$,, 영문, 숫자 반드시 포함하는 8자리 이상
        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$]).{8,}$";
        if(!password.matches(regex))
            throw new IllegalStateException("비밀번호 형식은 특수문자(!,@,#,$), 영문, 숫자를 반드시 포함하는 8자리 이상");

    }


}
