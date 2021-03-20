package com.mrt.pro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UserManager {
	
	protected SessionFactory sessionFactory;
	
	public void setup() {
	
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	protected void exit() {
		sessionFactory.close();
	}
	
	protected void create() {
		
		Users users = new Users();
		users.setUname("Murat");
		users.setUsurname("Çelik");
		users.setUmail("m@gmail.com");
		users.setUpassword("1234");
		
		Session sesi = sessionFactory.openSession();
		sesi.beginTransaction();
		
		sesi.save(users);
		
		sesi.getTransaction().commit();
		sesi.close();
	}
	
	protected void read() {
		
		Session sesi = sessionFactory.openSession();
		
		int usersId = 5;
		Users users = sesi.get(Users.class, usersId);
		
		if(users != null) {
			System.out.println("Adý: " + users.getUname());
			System.out.println("Soyad: " + users.getUsurname());
			System.out.println("mail: " + users.getUmail());
		}
	}
	
	protected void update() {
		
		Users users = new Users();
		users.setUid(11);
		users.setUname("Murat");
		users.setUsurname("Çelik");
		users.setUmail("murat@gmail.com");
		users.setUpassword("1234");
		
		Session sesi = sessionFactory.openSession();
		sesi.beginTransaction();
		
		sesi.update(users);
		
		sesi.getTransaction().commit();
		sesi.close();
	}
	
	protected void delete() {
		
		Users users = new Users();
		users.setUid(12);
		
		Session sesi = sessionFactory.openSession();
		sesi.beginTransaction();
		
		sesi.delete(users);
		
		sesi.getTransaction().commit();
		sesi.close();
	}
	
	
	public static void main(String[] args) {
		UserManager userManager = new UserManager();
		
		userManager.setup();
		
		userManager.delete();
		
		userManager.exit();
	}

}
