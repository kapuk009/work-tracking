package kulnaja.work.tracking.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class DemoBean {
	
	public DemoBean() {
		System.out.println("#### @Component : DemoBean.Constructor");
	}
	
	@PreDestroy
    public void destroy() throws Exception {
        System.out.println("#### @Component : Test @Bean DemoBean.destroy");
    }

	@PostConstruct
    public void init() throws Exception {
    	System.out.println("#### @Component : Test @Bean DemoBean.init");
    }
}
