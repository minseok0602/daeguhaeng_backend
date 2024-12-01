package findshop.DaeguHaeng_backend.Controller;

import findshop.DaeguHaeng_backend.DTO.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/recommendation")
@CrossOrigin(origins = "http://localhost:5173/") // 클라이언트 Origin 허용
public class APIController {

    private final String FLASK_API_URL = "http://127.0.0.1:5000/api/recommend";

    @PostMapping
    public ResponseEntity<?> getRecommendation(@RequestBody ClientDTO clientDTO) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("[REQUEST RECEIVED] " + clientDTO);
        try {
            // Flask 서버로 요청 보내기
            ResponseEntity<String> flaskResponse = restTemplate.postForEntity(FLASK_API_URL, clientDTO, String.class);

//            // Flask 응답 반환
//            System.out.println(flaskResponse.getBody());

            return ResponseEntity.ok(flaskResponse.getBody());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body("Error communicating with Flask server: " + e.getMessage());
        }
    }
}
