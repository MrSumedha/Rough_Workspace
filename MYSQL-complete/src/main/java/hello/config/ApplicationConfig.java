package hello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {
	
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
}
