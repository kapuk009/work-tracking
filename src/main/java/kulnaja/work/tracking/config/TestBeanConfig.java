package kulnaja.work.tracking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Case Failed !!!!!!!!!!!! Do Not Load Bean because not have @Configulation

public class TestBeanConfig {

	@Bean
	public String testA() {
		String result = "AConfig.testA";
		System.out.println("#### @Bean : AConfig.testA");
		
		return result;
	}
}
