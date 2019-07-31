package kulnaja.work.tracking.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
//@PropertySource("classpath:db.properties")
public class OracleDBConfig {
//	
//	//@Bean
//	//** example parametercallmethod onload and ondestroy
//	//@Bean(initMethod = "init", destroyMethod = "destroy") 
//	
//	@Bean
//	public String testBean() {
//		String result = "";
//		System.out.println("#### @Bean : OracleDBConfig.testBean");
//		
//		return result;
//	}
//	
//	@Lazy
//	@Bean
//	@Primary	
//	public DataSource getJndiDataSource() throws IllegalArgumentException, NamingException {
//		System.out.println("#### @Bean : OracleDBConfig.getJndiDataSource");
//		
//		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
////		bean.setJndiName("java:comp/env/" + oracleReadJndiName);
//		bean.setJndiName("java:comp/env/jdbc/insureds");
//		bean.setProxyInterface(DataSource.class);
//		bean.setLookupOnStartup(false);
//		bean.afterPropertiesSet();
//		return (DataSource)bean.getObject();
//		
////		return null;
//	}
//	
//	@Bean
//	@Primary
//	public JdbcTemplate jdbcTemplate () throws IllegalArgumentException, NamingException {
//		System.out.println("#### @Bean : OracleDBConfig.jdbcTemplate");
//		return new JdbcTemplate(getJndiDataSource());
//	}
//	
//	@Bean
//	@Primary
//	public NamedParameterJdbcTemplate namedParameterJdbcTemplate () throws IllegalArgumentException, NamingException {
//		System.out.println("#### @Bean : OracleDBConfig.NamedParameterJdbcTemplate");
//		return new NamedParameterJdbcTemplate(getJndiDataSource());
//	}
}
