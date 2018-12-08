package cloud.dalston.eureka.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderInitApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ProviderInitApplication.class).web(true).run(args);
	}
}
