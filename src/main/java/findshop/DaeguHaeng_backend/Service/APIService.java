package findshop.DaeguHaeng_backend.Service;

import findshop.DaeguHaeng_backend.DTO.ClientDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIService {
    private final String FLASK_API_URL = "http://127.0.0.1:5000/api/recommend";

    public Object callFlaskAPI(ClientDTO clientInfo) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(FLASK_API_URL, clientInfo, Object.class);
    }
}
