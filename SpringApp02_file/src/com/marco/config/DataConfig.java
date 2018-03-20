package com.marco.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class DataConfig {

	@Bean
	public DataSource dataSource() throws IllegalArgumentException, NamingException {

		JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
		jndiObjectFB.setJndiName("jdbc/spring");
		jndiObjectFB.setResourceRef(true);
		jndiObjectFB.setProxyInterface(DataSource.class);
		jndiObjectFB.afterPropertiesSet();
		return (DataSource) jndiObjectFB.getObject();

	}
	
	  @Bean
	  public JdbcOperations jdbcTemplate(DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	  }

}
