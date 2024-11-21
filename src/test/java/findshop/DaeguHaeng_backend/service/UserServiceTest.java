//package findshop.DaeguHaeng_backend.service;
//
//
//import findshop.DaeguHaeng_backend.DTO.LoginRequestDTO;
//import findshop.DaeguHaeng_backend.DTO.LoginResponseDTO;
//import findshop.DaeguHaeng_backend.DTO.RegisterRequestDTO;
//import findshop.DaeguHaeng_backend.Repository.UserRepository;
//import findshop.DaeguHaeng_backend.Service.UserService;
//import findshop.DaeguHaeng_backend.domain.User;
//import jakarta.persistence.EntityManager;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@Transactional
//public class UserServiceTest {
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    UserService userService;
//    @Autowired
//    EntityManager em;
//
//
//    @Test
//    public void 로그인_성공() throws Exception{
//
//        //given : test_id, test_pw 유저가 들어간 상황
//        User user = User.createUser("test", "test_id", "test_pw");
//        em.persist(user);
//
//        //given : loginreqdto
//        LoginRequestDTO reqdto = new LoginRequestDTO();
//        reqdto.setLoginId("test_id");
//        reqdto.setPassword("test_pw");
//
//
//        //when : login
//        LoginResponseDTO resdto = userService.logIn(reqdto);
//
//        //then : dto 맞는지
//        assertNotNull(resdto, "response is null");
//        assertEquals(resdto.getLoginId(), "test_id");
//
//    }
//
//    @Test
//    public void 로그인_존재하지않는ID() throws Exception{
//        //given : loginreqdto
//        LoginRequestDTO reqdto = new LoginRequestDTO();
//        reqdto.setLoginId("unfound_id");
//        reqdto.setPassword("unfound_id");
//
//        //when&then : login
//        assertThrows(IllegalStateException.class, () -> userService.logIn(reqdto));
//
//    }
//
//    @Test
//    public void 로그인_실패() throws Exception{
//        //given : test_id, test_pw 유저가 들어간 상황
//        User user = User.createUser("test", "test_id", "test_pw");
//        em.persist(user);
//
//        //given : 틀린 pw
//        LoginRequestDTO reqdto = new LoginRequestDTO();
//        reqdto.setLoginId("test_id");
//        reqdto.setPassword("wrong_pw");
//
//        //when&then : login
//        assertThrows(IllegalStateException.class, () -> userService.logIn(reqdto));
//
//    }
//
//    @Test
//    public void 회원가입_성공() throws Exception{
//        //given : test_id, test_pw에 대한 회원가입
//        RegisterRequestDTO reqdto = new RegisterRequestDTO();
//        reqdto.setUsername("test");
//        reqdto.setUserLoginId("test_id");
//        reqdto.setPassword("test_pw");
//
//        //when
//        LoginResponseDTO resdto = userService.register(reqdto);
//
//        //then
//        assertNotNull(resdto, "response is null");
//        assertEquals(resdto.getLoginId(), "test_id");
//
//    }
//
//    @Test
//    public void 회원가입_이미존재하는ID() throws Exception{
//        //given : test_id, test_pw 유저가 들어간 상황
//        User user = User.createUser("test", "test_id", "test_pw");
//        em.persist(user);
//
//
//        RegisterRequestDTO reqdto = new RegisterRequestDTO();
//        reqdto.setUsername("test");
//        reqdto.setUserLoginId("test_id");
//        reqdto.setPassword("test_pw");
//
//        //when, then
//        assertThrows(IllegalStateException.class, () -> userService.register(reqdto));
//    }
//
//}
