package com.codo.modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.codo.modelo.pojos.Cuentas;

public class CuentasDAO {

	private final EntityManagerFactory EM_FACTORY;

	public CuentasDAO(EntityManagerFactory emFactory) {
		this.EM_FACTORY = emFactory;
	}

	public void crear(Cuentas cuenta) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(cuenta); // Llamada al ORM
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

	public void actualizar(Cuentas cuenta) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(cuenta);
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

	public void borrar(Cuentas cuenta) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(manager.merge(cuenta));
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

	public List<Cuentas> leerCuentas() {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		List<Cuentas> lst = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			String qry = "SELECT s FROM Cuentas s";
			lst = manager.createQuery(qry, Cuentas.class).getResultList();
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