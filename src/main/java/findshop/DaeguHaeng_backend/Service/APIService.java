package findshop.DaeguHaeng_backend.Service;

import findshop.DaeguHaeng_backend.DTO.ClientDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIService {
    private final String FLASK_API_URL = "http://127.0.0.1:5000/api/recommend";

    public Object callFlaskAPI(ClientDTO clientDTO) {
        RestTemplate restTemplate = new RestTemplate();

        // HTTP 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // 요청 본문(body) 생성
        HttpEntity<ClientDTO> request = new HttpEntity<>(clientDTO, headers);

        // Flask 서버로 POST 요청 보내기
        ResponseEntity<String> response = restTemplate.postForEntity(FLASK_API_URL, request, String.class);

        // 응답 반환
        return response.getBody();
    }
}
