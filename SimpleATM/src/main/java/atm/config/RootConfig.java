package atm.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages= {"atm.bean","atm.dao"})
public class RootConfig {
	
	@Bean(name="dataSource")
	public BasicDataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@192.168.56.101:1521:xe");
		ds.setUsername("will");
		ds.setPassword("will123");
		ds.setInitialSize(5);
		//ds.setMaxIdle(10);
		return ds;
		
	}
	

	
	/*@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);

	}*/
	
	
	
	

}
