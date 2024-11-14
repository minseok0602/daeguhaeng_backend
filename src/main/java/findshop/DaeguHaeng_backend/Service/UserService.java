package findshop.DaeguHaeng_backend.Service;

import findshop.DaeguHaeng_backend.DTO.LoginRequestDTO;
import findshop.DaeguHaeng_backend.DTO.LoginResponseDTO;
import findshop.DaeguHaeng_backend.DTO.RegisterRequestDTO;
import findshop.DaeguHaeng_backend.Repository.UserRepository;
import findshop.DaeguHaeng_backend.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // DB에 트랜잭션하겟다 이말이지 그치~
// atomic한 수정작업 할거임 ㅇㅋ?
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    // 1. 로그인
    // 로그인 근데 뭐 리턴해야됨? 성공하면?
    public LoginResponseDTO logIn(LoginRequestDTO dto) {
        List<User> users = userRepository.findByLoginId(dto.getLoginId()); // user를 dto의 loginID 이걸로 뽑음

        if(users.isEmpty()){
            throw new IllegalStateException("해당 사용자 ID가 존재하지 않습니다.");
        }

        User user = users.get(0);
        if(!user.getUserPw().equals(dto.getPassword())){
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setLoginId(user.getLoginId());
        return loginResponseDTO;
    }

    // 2. 회원가입
    public LoginResponseDTO register(RegisterRequestDTO dto){
        validateDuplicateUser(dto.getUserLoginId());
        User newUser = User.createUser(dto.getUserName(), dto.getUserLoginId(), dto.getPassword());
        userRepository.save(newUser);
        LoginResponseDTO resDto = new LoginResponseDTO();
        resDto.setLoginId(newUser.getLoginId());
        return resDto;
    }


    private void validateDuplicateUser(String userLoginId){
        List<User> users = userRepository.findByLoginId(userLoginId);
        if(!users.isEmpty()){
            throw new IllegalStateException("이미 존재하는 LoginID");
        }
    }



    // 3. 계정 찾기


    // 4. 로그아웃 : frontend에서


    // 5. 내 정보 보기 by loginId






}
