package com.codo.modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.codo.modelo.pojos.Etiquetas;

public class EtiquetasDAO {

	private final EntityManagerFactory EM_FACTORY;

	public EtiquetasDAO(EntityManagerFactory emFactory) {
		this.EM_FACTORY = emFactory;
	}

	public void crear(Etiquetas etiqueta) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(etiqueta); // Llamada al ORM
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

	public void actualizar(Etiquetas etiqueta) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(etiqueta);
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

	public void borrar(Etiquetas etiqueta) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(manager.merge(etiqueta));
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

	public List<Etiquetas> leerEtiquetas() {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		List<Etiquetas> lst = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			String qry = "SELECT s FROM Etiquetas s";
			lst = manager.createQuery(qry, Etiquetas.class).getResultList();
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

	public List<Etiquetas> leerEtiquetasFiltro(String sentenciaSQL) {
		EntityManager manager = EM_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		List<Etiquetas> lst = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			String qry = sentenciaSQL;
			lst = manager.createQuery(qry, Etiquetas.class).getResultList();
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