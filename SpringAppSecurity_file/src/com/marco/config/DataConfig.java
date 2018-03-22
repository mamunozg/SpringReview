package com.marco.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
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

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws IllegalArgumentException, NamingException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.marco.pojo");
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = -7367636538342475651L;

			{
				setProperty("hibernate.show_sql", "true");
				setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
				setProperty("javax.persistence.validation.group.pre-persist", "com.marco.pojo.valid.PersistenceGroup");
				setProperty("javax.persistence.validation.group.pre-update", "com.marco.pojo.valid.PersistenceGroup");
				setProperty("javax.persistence.validation.group.pre-remove", "com.marco.pojo.valid.PersistenceGroup");
			}
		};
	}

	@Autowired
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslator() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
