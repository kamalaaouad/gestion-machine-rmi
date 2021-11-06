package com.myCompany.serviceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.myCompany.models.Machine;
import com.myCompany.service.IDao;
import com.myCompany.utils.Util;

public class MachineService extends UnicastRemoteObject implements IDao<Machine> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public MachineService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean create(Machine o) throws RemoteException {
		//Util.beginTransaction();
		System.out.println(o.toString());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Machine m = new Machine(o.getLibelle(),o.getMarque(),o.getDateAchat(), o.getPrix());
		em.persist(m);
		tx.commit();
		em.close();
		emf.close();
		return true;
	}

	public boolean update(Machine o) throws RemoteException {
		System.out.println(o.toString());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(o);
		tx.commit();
		em.close();
		emf.close();
		return false;
	}

	public boolean delete(Machine o) throws RemoteException {
		System.out.println(o.toString());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.remove(em.contains(o) ? o : em.merge(o));
		tx.commit();
		em.close();
		return false;
	}

	public List<Machine> findAll() throws RemoteException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Machine> cq = cb.createQuery(Machine.class);
		Root<Machine> rootEntry = cq.from(Machine.class);
		CriteriaQuery<Machine> all = cq.select(rootEntry);
		TypedQuery<Machine> machines = em.createQuery(all);
		System.out.println(machines.getResultList());
		return machines.getResultList();
	}

	public Machine findById(long id) throws RemoteException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		Machine machine = entityManager.find(Machine.class,id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return machine;
	}

}
