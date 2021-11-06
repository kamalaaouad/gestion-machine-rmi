package com.myCompany.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {
	private static EntityManagerFactory factory;
	
	public static EntityManager getEntityManager() {
		if(factory == null)
			 factory = Persistence.createEntityManagerFactory("PU");
		return factory.createEntityManager();
	}
	
	public static EntityManager  beginTransaction() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		return em;
	}
	
	public static void commitTransaction(EntityManager em) {
		em.getTransaction().commit();
	}
	public static void closeEntityManger() {
		getEntityManager().close();
	}
	
}
