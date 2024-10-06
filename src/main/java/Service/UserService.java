package Service;

import DTO.LoginRequestDTO;
import DTO.LoginResponseDTO;
import DTO.RegisterRequestDTO;
import Repository.UserRepository;
import domain.User;
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
        User user = userRepository.findByUserLoginId(dto.getUserId()); // user를 dto의 loginID 이걸로 뽑음
        // password 검증 한 다음에
        // 맞으면 response return
        if(user != null){
            if(user.getUserPw().equals(dto.getPassword())) {
                LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
                dto.setUserId(user.getUserLoginID());
                return loginResponseDTO;
            }
        }
        return null;
    }

    // 2. 회원가입
    public LoginResponseDTO register(RegisterRequestDTO dto){
        if(userRepository.findByUserLoginId(dto.getUserLoginId()) == null){
            // 새로 user 만듦
            // 그 유저 그대로 reponse dto도 만듦
            // user save 하고
            // resonse return
            User newUser = User.createUser(dto.getUsername(), dto.getUserLoginId(), dto.getPassword());
            userRepository.save(newUser);
            LoginResponseDTO resDto = new LoginResponseDTO();
            resDto.setLoginID(newUser.getUserLoginID());
            return resDto;
        }
        return null;
    }



    // 3. 계정 찾기


    // 4. 로그아웃


    // 5. 내 정보 보기










}
