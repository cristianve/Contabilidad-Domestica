package com.codo.modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.codo.modelo.pojos.Monedas;

public class MonedasDAO {

	private final EntityManagerFactory EM_FACTORY;

	public MonedasDAO(EntityManagerFactory emFactory) {
		this.EM_FACTORY = emFactory;
	}

	public void crear(Monedas moneda) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(moneda); // Llamada al ORM
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
	}

	public void actualizar(Monedas moneda) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(moneda);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
	}

	public void borrar(Monedas moneda) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(manager.merge(moneda));
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
	}

	public List<Monedas> leerMonedas() {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		List<Monedas> lst = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			String qry = "SELECT s FROM Monedas s";
			lst = manager.createQuery(qry, Monedas.class).getResultList();
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		return lst;
	}
}