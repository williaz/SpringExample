package atm.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
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
	
	 @Bean
     public PlatformTransactionManager txManager() {
         return new DataSourceTransactionManager(dataSource());
     }
	
	 @Bean
	 public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
	   LocalSessionFactoryBean sfb=new LocalSessionFactoryBean();
	   sfb.setDataSource(dataSource);
	   sfb.setPackagesToScan(new String[] {"atm.bean"});
	   Properties props=new Properties();
	   //Dialect of oracle 11g is same as oracle10g (org.hibernate.dialect.Oracle10gDialect).
	   props.setProperty("dialect", "org.hibernate.dialect.Oracle10gDialect");
	   sfb.setHibernateProperties(props);
	   return sfb;
	 }

	@Bean
	public BeanPostProcessor persistenceTranslation() {
	  
	  return new PersistenceExceptionTranslationPostProcessor();
	}
	
	
	
	/*@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);

	}*/
	
	
	
	

}
