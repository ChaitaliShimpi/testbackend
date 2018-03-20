package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.niit.model.*;
import com.niit.DAO.*;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {
	@Bean(name="dataSource")

	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/FaceportDB");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		System.out.println("---Data Source Created---");
		return dataSource;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {

		Properties hibernateProp = new Properties();

		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		LocalSessionFactoryBuilder factoryBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(Product.class);
		factoryBuilder.addAnnotatedClass(Supplier.class);
		factoryBuilder.addAnnotatedClass(User.class);
		factoryBuilder.addAnnotatedClass(Cart.class);
		factoryBuilder.addAnnotatedClass(Order.class);


		factoryBuilder.addProperties(hibernateProp);

		System.out.println("Creating SessionFactory Bean");
		return factoryBuilder.buildSessionFactory();
	}

	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDAO() {
		System.out.println("----categoryDAO Implementation---");
		return new CategoryDAOImpl();
	}

	@Bean(name = "productDAO")
	public ProductDAO getProductDAO() {
		System.out.println("----productDAO Implementation---");
		return new ProductDAOImpl();
	}

	@Bean(name = "supplierDAO")
	public SupplierDAO getsupplierDAO() {
		System.out.println("----supplierDAO Implementation---");
		return new SupplierDAOImpl();
	}

	@Bean(name = "userDAO")
	public UserDAO getuserDAO() {
		System.out.println("---userDAO impl---");
		return new UserDAOImpl();
	}

	@Bean(name = "cartDAO")
	public CartDAO getcartDAO() {
		System.out.println("---cartDAO impl---");
		return new CartDAOImpl();
	}

	@Bean(name = "orderDAO")
	public OrderDAO getorderDAO() {
		System.out.println("---orderDAO impl---");
		return new OrderDAOImpl();
	}
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("---Transaction Manager----");
		return new HibernateTransactionManager(sessionFactory);
	}

}
