package findshop.DaeguHaeng_backend.Controller;

import findshop.DaeguHaeng_backend.DTO.ClientDTO;
import findshop.DaeguHaeng_backend.Service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private APIService flaskServer;

    @PostMapping("/recommend")
    public ResponseEntity<Object> getRecommendation(@RequestBody ClientDTO clientInfo) {
        // Python API 호출
        Object recommendations = flaskServer.callFlaskAPI(clientInfo);
        return ResponseEntity.ok(recommendations);
    }
}
