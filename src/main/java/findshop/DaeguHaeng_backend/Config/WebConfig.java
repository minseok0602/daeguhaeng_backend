package findshop.DaeguHaeng_backend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // 허용할 출처
                .allowedMethods("*") // 모든 HTTP method 허용
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .maxAge(3600); // pre-flight 리퀘스트를 1시간 동안 캐시 (초 단위)
    }
}