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

import com.embio.tht.beans.Ticket;

/**
 * Home object for domain model class Ticket.
 * @see .Ticket
 * @author Hibernate Tools
 */
public class TicketHome {

	private static final Log log = LogFactory.getLog(TicketHome.class);

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

	public void persist(Ticket transientInstance) {
		log.debug("persisting Ticket instance");
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

	public void attachDirty(Ticket instance) {
		log.debug("attaching dirty Ticket instance");
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

	public void attachClean(Ticket instance) {
		log.debug("attaching clean Ticket instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ticket persistentInstance) {
		log.debug("deleting Ticket instance");
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

	public Ticket merge(Ticket detachedInstance) {
		log.debug("merging Ticket instance");
		try {
			Ticket result = (Ticket) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ticket findById(int id) {
		log.debug("getting Ticket instance with id: " + id);
		try {
//			Ticket instance = (Ticket) sessionFactory.getCurrentSession().get(
//					"Ticket", id);
			Session session = sessionFactory.openSession();
			Ticket instance = (Ticket) session.get("com.embio.tht.beans.Ticket", id);
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

	public List findByExample(Ticket instance) {
		log.debug("finding Ticket instance by example");
		try {
			Session session = sessionFactory.openSession();
			List results = session.createCriteria("com.embio.tht.beans.Ticket").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public Ticket findFirstByExample(Ticket instance) {
		log.debug("finding first UserInfo instance by example");
		try {
			List<Ticket> items = findByExample(instance);
			log.debug("find one by example successful, result size: 1");
			return (items==null||items.size()==0)?null:items.get(0);
		} catch (RuntimeException re) {
			log.error("find one by example failed", re);
			throw re;
		}
	}
}
