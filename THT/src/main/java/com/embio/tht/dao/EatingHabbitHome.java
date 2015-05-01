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

import com.embio.tht.beans.EatingHabbit;

/**
 * Home object for domain model class EatingHabbit.
 * @see .EatingHabbit
 * @author Hibernate Tools
 */
public class EatingHabbitHome {

	private static final Log log = LogFactory.getLog(EatingHabbitHome.class);

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

	public void persist(EatingHabbit transientInstance) {
		log.debug("persisting EatingHabbit instance");
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

	public void attachDirty(EatingHabbit instance) {
		log.debug("attaching dirty EatingHabbit instance");
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

	public void attachClean(EatingHabbit instance) {
		log.debug("attaching clean EatingHabbit instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EatingHabbit persistentInstance) {
		log.debug("deleting EatingHabbit instance");
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

	public EatingHabbit merge(EatingHabbit detachedInstance) {
		log.debug("merging EatingHabbit instance");
		try {
			EatingHabbit result = (EatingHabbit) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EatingHabbit findById(int id) {
		log.debug("getting EatingHabbit instance with id: " + id);
		try {
//			EatingHabbit instance = (EatingHabbit) sessionFactory
//					.getCurrentSession().get("EatingHabbit", id);
			Session session = sessionFactory.openSession();
			EatingHabbit instance = (EatingHabbit) session.get("com.embio.tht.beans.EatingHabbit", id);
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

	public List findByExample(EatingHabbit instance) {
		log.debug("finding EatingHabbit instance by example");
		try {
			Session session = sessionFactory.openSession();
			List results = session.createCriteria("com.embio.tht.beans.EatingHabbit")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public EatingHabbit findFirstByExample(EatingHabbit instance) {
		log.debug("finding first UserInfo instance by example");
		try {
			List<EatingHabbit> items = findByExample(instance);
			log.debug("find one by example successful, result size: 1");
			return (items==null||items.size()==0)?null:items.get(0);
		} catch (RuntimeException re) {
			log.error("find one by example failed", re);
			throw re;
		}
	}
}
