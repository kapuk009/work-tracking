package kulnaja.work.tracking.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@PropertySource("classpath:db.properties")
public class TomcatEmbeddedApplication {
	
//	@Value("${allticket.config.memcached-url}")
//	String MEMCACHEDURL;
//	
	// Oracle Config
	@Value("${oracle.config.oracle.jndi-name}")
	private String oracleJndiName;
	
	@Value("${oracle.config.oracle.driver-class-name}")
	private String oracleDriverClassName;
	
	@Value("${oracle.config.oracle.url}")
	private String oracleUrl;
	
	@Value("${oracle.config.oracle.username}")
	private String oracleUsername;
	
	@Value("${oracle.config.oracle.password}")
	private String oraclePassword;
	
	@Value("${oracle.config.oracle.max-total}")
	private String oracleMaxTotal;
	
	@Value("${oracle.config.oracle.initial-size}")
	private String oracleInitialSize;
	
//	// Oracle Read Config
//	@Value("${allticket.config.oracle-read.jndi-name}")
//	private String oracleReadJndiName;
//	
//	@Value("${allticket.config.oracle-read.url}")
//	private String oracleReadUrl;
//	
//	@Value("${allticket.config.oracle-read.username}")
//	private String oracleReadUsername;
//	
//	@Value("${allticket.config.oracle-read.password}")
//	private String oracleReadPassword;
//	
//	@Value("${allticket.config.oracle-read.max-total}")
//	private String oracleReadMaxTotal;
//	
//	@Value("${allticket.config.oracle-read.initial-size}")
//	private String oracleReadInitialSize;
//	
//	// MySql Config
//	@Value("${allticket.config.mysql.jndi-name}")
//	private String mysqlJndiName;
//	
//	@Value("${allticket.config.mysql.driver-class-name}")
//	private String mysqlDriverClassName;
//	
//	@Value("${allticket.config.mysql.url}")
//	private String mysqlUrl;
//	
//	@Value("${allticket.config.mysql.username}")
//	private String mysqlUsername;
//	
//	@Value("${allticket.config.mysql.password}")
//	private String mysqlPassword;
//	
//	@Value("${allticket.config.mysql.max-total}")
//	private String mysqlMaxTotal;
//	
//	@Value("${allticket.config.mysql.initial-size}")
//	private String mysqlInitialSize;
	
	@Value("${db.config.max-wait-millis}")
	private String maxWaitMillis;
	
	@Value("${db.config.time-between-eviction-runs-millis}")
	private String timeBetweenEvictionRunsMillis;
	
	@Value("${db.config.min-evictable-idle-time-millis}")
	private String minEvictableIdleTimeMillis;
	
	@Value("${db.config.pool-prepared-statements}")
	private String poolPreparedStatements;
	
	@Value("${db.config.remove-abandoned-on-borrow}")
	private String removeAbandonedOnBorrow;
	
	@Value("${db.config.remove-abandoned-on-maintenance}")
	private String removeAbandonedOnMaintenance;
	
	@Value("${db.config.log-abandoned}")
	private String logAbandoned;
	
	
	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
		return new TomcatServletWebServerFactory() {
			@Override
			protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
				System.out.println("#### TomcatEmbeddedApplication : TomcatServletWebServerFactory.getTomcatWebServer  ");
				tomcat.enableNaming();
				return super.getTomcatWebServer(tomcat);
			}
			
			@Override
			protected void postProcessContext(Context context) {
				System.out.println("#### TomcatEmbeddedApplication : TomcatServletWebServerFactory.postProcessContext  ");
				
//				oracle.config.oracle.driver-class-name=oracle.jdbc.OracleDriver
//				oracle.config.oracle.jndi-name=jdbc/insureds
//				oracle.config.oracle.url=${DB_ORACLE_URL:jdbc:oracle:thin:@10.182.236.52:1521:insprd}
//				oracle.config.oracle.username=${DB_ORACLE_USER:insurance}
//				oracle.config.oracle.password=${DB_ORACLE_PASSWORD:insuresys2013}
//				oracle.config.oracle.max-total=${DB_ORACLE_MAXTOTAL:20}
//				oracle.config.oracle.initial-size=${DB_ORACLE_INITIALSIZE:5}
//		
//				ContextResource resourceOracle = new ContextResource();
//				resourceOracle.setName("jdbc/insureds");
//				resourceOracle.setType(DataSource.class.getName());
//				resourceOracle.setProperty("driverClassName", oracleDriverClassName);
//				resourceOracle.setProperty("url", oracleUrl);
//				resourceOracle.setProperty("username", oracleUsername);
//				resourceOracle.setProperty("password", oraclePassword);
//				resourceOracle.setProperty("maxTotal", oracleMaxTotal);
//				resourceOracle.setProperty("maxIdle", oracleMaxTotal);
//				resourceOracle.setProperty("minIdle", oracleInitialSize);
//				resourceOracle.setProperty("maxWaitMillis", maxWaitMillis);
//				resourceOracle.setProperty("poolPreparedStatements", poolPreparedStatements);
//				resourceOracle.setProperty("timeBetweenEvictionRunsMillis", timeBetweenEvictionRunsMillis);
//				resourceOracle.setProperty("removeAbandonedOnBorrow", removeAbandonedOnBorrow);
//				resourceOracle.setProperty("removeAbandonedOnMaintenance", removeAbandonedOnMaintenance);
//				resourceOracle.setProperty("logAbandoned", logAbandoned);
//				resourceOracle.setProperty("validationQuery", "SELECT 1 FROM DUAL ");
//				resourceOracle.setProperty("minEvictableIdleTimeMillis", minEvictableIdleTimeMillis);
//				resourceOracle.setProperty("initialSize", oracleInitialSize);
//				context.getNamingResources().addResource(resourceOracle);
						
				
				

				System.out.println("#### oracleJndiName : " + oracleJndiName);
				System.out.println("#### oracleDriverClassName : " + oracleDriverClassName);
				System.out.println("#### oracleUrl : " + oracleUrl);
				System.out.println("#### oracleUsername : " + oracleUsername);
				System.out.println("#### oraclePassword : " + oraclePassword);
				System.out.println("#### oracleMaxTotal : " + oracleMaxTotal);
				System.out.println("#### oracleInitialSize : " + oracleInitialSize);
				System.out.println("#### maxWaitMillis : " + maxWaitMillis);
				System.out.println("#### poolPreparedStatements : " + poolPreparedStatements);
				System.out.println("#### timeBetweenEvictionRunsMillis : " + timeBetweenEvictionRunsMillis);
				System.out.println("#### removeAbandonedOnBorrow : " + removeAbandonedOnBorrow);
				System.out.println("#### removeAbandonedOnMaintenance : " + removeAbandonedOnMaintenance);
				System.out.println("#### logAbandoned : " + logAbandoned);
				System.out.println("#### minEvictableIdleTimeMillis : " + minEvictableIdleTimeMillis);
				System.out.println("#### oracleInitialSize : " + oracleInitialSize);
				
				ContextResource resourceOracle = new ContextResource();
				resourceOracle.setName(oracleJndiName);
				resourceOracle.setType(DataSource.class.getName());
				resourceOracle.setProperty("driverClassName", oracleDriverClassName);
				resourceOracle.setProperty("url", oracleUrl);
				resourceOracle.setProperty("username", oracleUsername);
				resourceOracle.setProperty("password", oraclePassword);
				resourceOracle.setProperty("maxTotal", oracleMaxTotal);
				resourceOracle.setProperty("maxIdle", oracleMaxTotal);
				resourceOracle.setProperty("minIdle", oracleInitialSize);
				resourceOracle.setProperty("maxWaitMillis", maxWaitMillis);
				resourceOracle.setProperty("poolPreparedStatements", poolPreparedStatements);
				resourceOracle.setProperty("timeBetweenEvictionRunsMillis", timeBetweenEvictionRunsMillis);
				resourceOracle.setProperty("removeAbandonedOnBorrow", removeAbandonedOnBorrow);
				resourceOracle.setProperty("removeAbandonedOnMaintenance", removeAbandonedOnMaintenance);
				resourceOracle.setProperty("logAbandoned", logAbandoned);
				resourceOracle.setProperty("validationQuery", "SELECT 1 FROM DUAL ");
				resourceOracle.setProperty("minEvictableIdleTimeMillis", minEvictableIdleTimeMillis);
				resourceOracle.setProperty("initialSize", oracleInitialSize);
				context.getNamingResources().addResource(resourceOracle);
				
//				ContextResource resourceOracleRead = new ContextResource();
//				resourceOracleRead.setName(oracleReadJndiName);
//				resourceOracleRead.setType(DataSource.class.getName());
//				resourceOracleRead.setProperty("driverClassName", oracleDriverClassName);
//				resourceOracleRead.setProperty("url", oracleReadUrl);
//				resourceOracleRead.setProperty("username", oracleReadUsername);
//				resourceOracleRead.setProperty("password", oracleReadPassword);
//				resourceOracleRead.setProperty("maxTotal", oracleReadMaxTotal);
//				resourceOracleRead.setProperty("maxIdle", oracleReadMaxTotal);
//				resourceOracleRead.setProperty("minIdle", oracleReadInitialSize);
//				resourceOracleRead.setProperty("maxWaitMillis", maxWaitMillis);
//				resourceOracleRead.setProperty("poolPreparedStatements", poolPreparedStatements);
//				resourceOracleRead.setProperty("timeBetweenEvictionRunsMillis", timeBetweenEvictionRunsMillis);
//				resourceOracleRead.setProperty("removeAbandonedOnBorrow", removeAbandonedOnBorrow);
//				resourceOracleRead.setProperty("removeAbandonedOnMaintenance", removeAbandonedOnMaintenance);
//				resourceOracleRead.setProperty("logAbandoned", logAbandoned);
//				resourceOracleRead.setProperty("validationQuery", "SELECT 1 FROM DUAL ");
//				resourceOracleRead.setProperty("minEvictableIdleTimeMillis", minEvictableIdleTimeMillis);
//				resourceOracleRead.setProperty("initialSize", oracleReadInitialSize);
//				context.getNamingResources().addResource(resourceOracleRead);
//				
//				ContextResource resourceMySQL = new ContextResource();
//				resourceMySQL.setName(mysqlJndiName);
//				resourceMySQL.setType(DataSource.class.getName());
//				resourceMySQL.setProperty("driverClassName", mysqlDriverClassName);
//				resourceMySQL.setProperty("url", mysqlUrl);
//				resourceMySQL.setProperty("username", mysqlUsername);
//				resourceMySQL.setProperty("password", mysqlPassword);
//				resourceMySQL.setProperty("maxTotal", mysqlMaxTotal);
//				resourceMySQL.setProperty("maxIdle", mysqlMaxTotal);
//				resourceMySQL.setProperty("minIdle", mysqlInitialSize);
//				resourceMySQL.setProperty("maxWaitMillis", maxWaitMillis);
//				resourceMySQL.setProperty("poolPreparedStatements", poolPreparedStatements);
//				resourceMySQL.setProperty("timeBetweenEvictionRunsMillis", timeBetweenEvictionRunsMillis);
//				resourceMySQL.setProperty("removeAbandonedOnBorrow", removeAbandonedOnBorrow);
//				resourceMySQL.setProperty("removeAbandonedOnMaintenance", removeAbandonedOnMaintenance);
//				resourceMySQL.setProperty("logAbandoned", logAbandoned);
//				resourceMySQL.setProperty("validationQuery", "SELECT 1 ");
//				resourceMySQL.setProperty("minEvictableIdleTimeMillis", minEvictableIdleTimeMillis);
//				resourceMySQL.setProperty("initialSize", mysqlInitialSize);
//				context.getNamingResources().addResource(resourceMySQL);
				
				super.postProcessContext(context);
			}
		};
	}
	
//	@Lazy
//	@Primary
//	@Bean(destroyMethod="")
//	public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
//		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
//		bean.setJndiName("java:comp/env/" + oracleReadJndiName);
//		bean.setProxyInterface(DataSource.class);
//		bean.setLookupOnStartup(false);
//		bean.afterPropertiesSet();
//		return (DataSource)bean.getObject();
//	}
	
	@Lazy
	@Bean(destroyMethod="")
	public DataSource oracleWriteJndiDataSource() throws IllegalArgumentException, NamingException {
		System.out.println("#### TomcatEmbeddedApplication.oracleWriteJndiDataSource  ");
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName("java:comp/env/" + oracleJndiName);
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);
		bean.afterPropertiesSet();
		return (DataSource)bean.getObject();
	}
	
//	@Lazy
//	@Bean(destroyMethod="")
//	public DataSource mySqlWriteJndiDataSource() throws IllegalArgumentException, NamingException {
//		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
//		bean.setJndiName("java:comp/env/" + mysqlJndiName);
//		bean.setProxyInterface(DataSource.class);
//		bean.setLookupOnStartup(false);
//		bean.afterPropertiesSet();
//		return (DataSource)bean.getObject();
//	}
	
//	@Bean
//	@Primary
//	public JdbcTemplate jdbcTemplate () throws IllegalArgumentException, NamingException {
//		return new JdbcTemplate(jndiDataSource());
//	}
	
//	@Bean
//	@Primary
//	public NamedParameterJdbcTemplate namedParameterJdbcTemplate () throws IllegalArgumentException, NamingException {
//		return new NamedParameterJdbcTemplate(jndiDataSource());
//	}
	
	@Bean
	//@Qualifier("oracleWriteJdbcTemplate")
	public JdbcTemplate oracleWriteJdbcTemplate () throws IllegalArgumentException, NamingException {
		System.out.println("#### TomcatEmbeddedApplication.oracleWriteJdbcTemplate  ");
		return new JdbcTemplate(oracleWriteJndiDataSource());
	}
	
	@Bean
	//@Qualifier("oracleWriteNamedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate oracleWriteNamedParameterJdbcTemplate () throws IllegalArgumentException, NamingException {
		System.out.println("#### TomcatEmbeddedApplication.oracleWriteNamedParameterJdbcTemplate  ");
		return new NamedParameterJdbcTemplate(oracleWriteJndiDataSource());
	}
	
//	@Bean
//	@Qualifier("mySqlWriteJdbcTemplate")
//	public JdbcTemplate mySqlWriteJdbcTemplate () throws IllegalArgumentException, NamingException {
//		return new JdbcTemplate(mySqlWriteJndiDataSource());
//	}
//	
//	@Bean
//	@Qualifier("mySqlWriteNamedParameterJdbcTemplate")
//	public NamedParameterJdbcTemplate mySqlWriteNamedParameterJdbcTemplate () throws IllegalArgumentException, NamingException {
//		return new NamedParameterJdbcTemplate(mySqlWriteJndiDataSource());
//	}
	
}
