package med.voll.api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
//É possível permitir o acesso de qualquer origem utilizando o símbolo
// *(asterisco): Access-Control-Allow-Origin: *O CORS é um mecanismo utilizado
// para adicionar cabeçalhos HTTP que informam aos navegadores para permitir que
// uma aplicação Web seja executada em uma origem e acesse recursos de outra origem diferente.
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
