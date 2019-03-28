package com.codo.modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.codo.modelo.pojos.Tipos;

public class TiposDAO {

	private final EntityManagerFactory EM_FACTORY;

	public TiposDAO(EntityManagerFactory emFactory) {
		this.EM_FACTORY = emFactory;
	}

	public void crear(Tipos tipo) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(tipo); // Llamada al ORM
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

	public void actualizar(Tipos tipo) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(tipo);
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

	public void borrar(Tipos tipo) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(manager.merge(tipo));
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

	public List<Tipos> leerTipos() {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		List<Tipos> lst = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			String qry = "SELECT s FROM Tipos s";
			lst = manager.createQuery(qry, Tipos.class).getResultList();
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