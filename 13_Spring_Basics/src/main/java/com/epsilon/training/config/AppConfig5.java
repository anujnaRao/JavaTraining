package com.epsilon.training.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.epsilon.training.entity.Product;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
@ComponentScan(basePackages = { "com.epsilon.training.dao", "com.epsilon.training.aop" })
@EnableAspectJAutoProxy // loads Aspectj bean into spring container,
//creates a proxy based on advices
@EnableTransactionManagement //helps in creating proxy for transaction management
public class AppConfig5 {

	@Value("${jdbc.connection.username}")
	private String username;
	@Value(("${jdbc.connection.password}"))
	private String password;
	@Value(("${jdbc.connection.driverClassName}"))
	private String driverClassName;
	@Value(("${jdbc.connection.url}"))
	private String url;
	
	//create bean of appropriate TransactionManager
	@Bean
	public HibernateTransactionManager txMgr(SessionFactory sf) {
		return new HibernateTransactionManager(sf);
	}
	
	@Bean // this represents the object of sessionfactory
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {// dependency injection
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();

		lsfb.setDataSource(dataSource); // wiring via setter
		lsfb.setAnnotatedClasses(Product.class);

		return lsfb;
	}

	@Bean
	public HibernateTemplate template(SessionFactory sessionFactory) { // dependency injection
		return new HibernateTemplate(sessionFactory); // manual wiring
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driverClassName);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);

		bds.setMaxTotal(50);
		bds.setInitialSize(5);
		bds.setMaxWaitMillis(5);
		bds.setMaxIdle(3000);

		return bds;
	}
}
