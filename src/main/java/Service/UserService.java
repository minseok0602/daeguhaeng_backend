package Service;

import DTO.LoginRequestDTO;
import DTO.LoginResponseDTO;
import Repository.UserRepository;
import domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true) // DB에 트랜잭션하겟다 이말이지 그치~
// atomic한 수정작업 할거임 ㅇㅋ?
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    // 1. 로그인
    // 로그인 근데 뭐 리턴해야됨? 성공하면?
    public LoginResponseDTO logIn(LoginRequestDTO loginRequestDTO) {
        User user; // user를 dto의 loginID 이걸로 뽑음

        // password 검증 한 다음에
        // 맞으면 response return
        // 틀리면 exception


    }

    // 2. 회원가입



    // 3. 계정 찾기


    // 4. 로그아웃


    // 5. 내 정보 보기










}
