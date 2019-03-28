package com.codo.modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.codo.modelo.pojos.Movimientos;

public class MovimientosDAO {

	private final EntityManagerFactory EM_FACTORY;

	public MovimientosDAO(EntityManagerFactory emFactory) {
		this.EM_FACTORY = emFactory;
	}

	public void crear(Movimientos movimiento) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(movimiento); // Llamada al ORM
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

	public void actualizar(Movimientos movimiento) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(movimiento);
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

	public void borrar(Movimientos movimiento) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(manager.merge(movimiento));
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

	public List<Movimientos> leerMovimientos() {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		List<Movimientos> lst = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			String qry = "SELECT s FROM Movimientos s";
			lst = manager.createQuery(qry, Movimientos.class).getResultList();
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

	public List<Movimientos> leerMovimientosFiltro(String sentenciaSQL) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		List<Movimientos> lst = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			String qry = sentenciaSQL;
			lst = manager.createQuery(qry, Movimientos.class).getResultList();
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