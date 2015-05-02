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

import com.embio.tht.beans.FinanceItem;
import com.embio.tht.beans.Survey;

/**
 * Home object for domain model class FinanceItem.
 * @see .FinanceItem
 * @author Hibernate Tools
 */
public class FinanceItemHome {

	private static final Log log = LogFactory.getLog(FinanceItemHome.class);

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

	public void persist(FinanceItem transientInstance) {
		log.debug("persisting FinanceItem instance");
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

	public void attachDirty(FinanceItem instance) {
		log.debug("attaching dirty FinanceItem instance");
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

	public void attachClean(FinanceItem instance) {
		log.debug("attaching clean FinanceItem instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FinanceItem persistentInstance) {
		log.debug("deleting FinanceItem instance");
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

	public FinanceItem merge(FinanceItem detachedInstance) {
		log.debug("merging FinanceItem instance");
		try {
			FinanceItem result = (FinanceItem) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FinanceItem findById(int id) {
		log.debug("getting FinanceItem instance with id: " + id);
		try {
//			FinanceItem instance = (FinanceItem) sessionFactory
//					.getCurrentSession().get("FinanceItem", id);
			Session session = sessionFactory.openSession();
			FinanceItem instance = (FinanceItem) session.get("com.embio.tht.beans.FinanceItem", id);
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

	public List findByExample(FinanceItem instance) {
		log.debug("finding FinanceItem instance by example");
		try {
			Session session = sessionFactory.openSession();
			List results = session.createCriteria("com.embio.tht.beans.FinanceItem")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public FinanceItem findFirstByExample(FinanceItem instance) {
		log.debug("finding first UserInfo instance by example");
		try {
			List<FinanceItem> items = findByExample(instance);
			log.debug("find one by example successful, result size: 1");
			return (items==null||items.size()==0)?null:items.get(0);
		} catch (RuntimeException re) {
			log.error("find one by example failed", re);
			throw re;
		}
	}
	public List getAll() {
		FinanceItem all = new FinanceItem();
		return findByExample(all);
	}
}
