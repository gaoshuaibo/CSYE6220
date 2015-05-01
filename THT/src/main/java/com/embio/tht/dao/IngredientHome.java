package com.embio.tht.dao;
// Generated Apr 6, 2015 10:54:41 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import com.embio.tht.beans.Ingredient;

/**
 * Home object for domain model class Ingredient.
 * @see .Ingredient
 * @author Hibernate Tools
 */
public class IngredientHome {

	private static final Log log = LogFactory.getLog(IngredientHome.class);

	private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Ingredient transientInstance) {
		log.debug("persisting Ingredient instance");
		try {
						Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(transientInstance);
			tx.commit();
			session.close();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ingredient instance) {
		log.debug("attaching dirty Ingredient instance");
		try {
						Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(instance);
			tx.commit();
			session.close();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ingredient instance) {
		log.debug("attaching clean Ingredient instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ingredient persistentInstance) {
		log.debug("deleting Ingredient instance");
		try {
							Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(persistentInstance);
				tx.commit();
				session.close();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ingredient merge(Ingredient detachedInstance) {
		log.debug("merging Ingredient instance");
		try {
			Ingredient result = (Ingredient) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ingredient findById(int id) {
		log.debug("getting Ingredient instance with id: " + id);
		try {
//			Ingredient instance = (Ingredient) sessionFactory
//					.getCurrentSession().get("Ingredient", id);
			Session session = sessionFactory.openSession();
			Ingredient instance = (Ingredient) session.get("com.embio.tht.beans.Ingredient", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Ingredient instance) {
		log.debug("finding Ingredient instance by example");
		try {
			Session session = sessionFactory.openSession();
			List results = session.createCriteria("com.embio.tht.beans.Ingredient").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public Ingredient findFirstByExample(Ingredient instance) {
		log.debug("finding first UserInfo instance by example");
		try {
			List<Ingredient> items = findByExample(instance);
			log.debug("find one by example successful, result size: 1");
			return (items==null||items.size()==0)?null:items.get(0);
		} catch (RuntimeException re) {
			log.error("find one by example failed", re);
			throw re;
		}
	}
	
	public List<Ingredient> getAll() {
		log.debug("finding first UserInfo instance by example");
		try {
			List<Ingredient> items = findByExample(new Ingredient());
			log.debug("find one by example successful, result size: 1");
			return items;
		} catch (RuntimeException re) {
			log.error("find one by example failed", re);
			throw re;
		}
	}
}
