package findshop.DaeguHaeng_backend.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://localhost:*") // 클라이언트 Origin 허용
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

}
