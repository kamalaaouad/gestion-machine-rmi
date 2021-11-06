package com.myCompany.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Date;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.myCompany.models.Machine;
import com.myCompany.service.IDao;
import com.myCompany.serviceImpl.MachineService;

public class Server {

	public static void main(String[] args) throws NamingException, RemoteException {
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Machine m = new Machine("Pc", "DELL", new Date(), 1500.5);
		em.persist(m);
		tx.commit();
		em.close();
		emf.close();*/
		IDao<Machine> objet=new MachineService();
        LocateRegistry.createRegistry(1099);
       // Naming.bind("rmi://localhost/obj",objet);
        Hashtable<Object,Object> config=new Hashtable<Object, Object>();
        config.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.rmi.registry.RegistryContextFactory");
        config.put(Context.PROVIDER_URL,"rmi://localhost:1099");
        InitialContext jndi = new InitialContext(config);
        jndi.bind("obj",objet);
        System.out.println("En attende des clients");
        System.out.println(objet.findById(1));
        objet.delete(objet.findById(2));
        
        System.out.println(objet.findAll());
        //System.out.println(objet.findById(1));
	}
	

}
