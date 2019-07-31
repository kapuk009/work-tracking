package kulnaja.work.tracking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkTrackingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("#### @Bean : WorkTrackingApplication.commandLineRunner");
//			final EmpJDBCTemplate empJDBCTemplate = (EmpJDBCTemplate) ctx.getBean("EmpJDBCTemplate");
//			System.out.println("Listing employee records : ");
//			empJDBCTemplate.displayEmpList();
		};
	}
	
	@Bean
	public void startUp() {
		System.out.println("#### @Bean : WorkTrackingApplication.startUp");
	}
	
}
