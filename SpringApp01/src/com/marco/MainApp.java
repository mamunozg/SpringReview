package com.marco;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.marco.dao.AdminDao;
import com.marco.pojo.Admin;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config.xml");

		AdminDao adminDao = (AdminDao) appContext.getBean("adminDao");
		
		Timestamp ts = new Timestamp(new Date().getTime());
		
		try {

			List<Admin> lAdmin = new ArrayList<Admin>();
//			lAdmin.add(new Admin("pedro", "jefe de ingenieria", ts));
//			lAdmin.add(new Admin("miguel", "comercial", ts));
//			lAdmin.add(new Admin("manolo", "chief", ts));
//			lAdmin.add(new Admin("gema", "garante", ts));
			lAdmin.add(new Admin(40, "pedro", "jefe de ingenieria", ts));
			lAdmin.add(new Admin(41, "miguel", "comercial", ts));
			lAdmin.add(new Admin(32, "manolo", "chief", ts));
			lAdmin.add(new Admin(43, "gema", "garante", ts));

			int[]  values = adminDao.saveAll(lAdmin);
			
			for(int i :  values) {
				System.out.println("Filas afectadas para esta operación: " + i); 
			}


		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		((ClassPathXmlApplicationContext) appContext).close();
	}

	public static void main3(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config.xml");

		AdminDao adminDao = (AdminDao) appContext.getBean("adminDao");

		try {

			// adminDao.save(admin);

			Admin admin = adminDao.findById(1);
			System.out.println("Admin 1: " + admin);

			admin.setName("Miguel");
			admin.setRole("Jefecillo");
			System.out.println("Admin 2: " + adminDao.update(admin));

			System.out.println("Delete: " + adminDao.delete(5));
			System.out.println("Delete: " + adminDao.findById(5));

		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		((ClassPathXmlApplicationContext) appContext).close();
	}

	public static void main2(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config.xml");

		AdminDao adminDao = (AdminDao) appContext.getBean("adminDao");

		Admin admin = new Admin();
		admin.setName("Juan");
		admin.setRole("Gerente");
		admin.setCreationDate(new Timestamp(new Date().getTime()));

		try {

			// adminDao.save(admin);

			System.out.println(adminDao.findById(1));
			System.out.println(adminDao.findById(7));
			System.out.println(adminDao.findById(9));
			System.out.println(adminDao.findByName("arco").toString());

			// List<Admin> listUsers = adminDao.findAll();

			List<Admin> listUsers = adminDao.findByName("arcos");

			for (Admin a : listUsers) {
				System.out.println(a);
			}

		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		((ClassPathXmlApplicationContext) appContext).close();

	}
}
