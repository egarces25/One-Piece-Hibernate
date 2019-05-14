package service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import entities.Pirate;
import hibernateUtil.HibernateUtil;


public class PirateService {

			
		public Pirate getPirateById(int id) {

	        SessionFactory sf = HibernateUtil.getSessionFactory();
	        Pirate pirate = null;
	        try (Session session = sf.openSession()) {
	            pirate = session.get(Pirate.class, id);
	        }
	        return pirate;
	    }

	public Pirate updatePirate(Pirate pirate) {

	        SessionFactory sf = HibernateUtil.getSessionFactory();
	        try (Session session = sf.openSession()) {
	            Transaction tx = session.beginTransaction();
	            session.update(pirate);
	            tx.commit();
	        }
	        return pirate;
	    }

	public Pirate	 savePirate(Pirate pirate) {
	        SessionFactory sf = HibernateUtil.getSessionFactory();
	        try (Session session = sf.openSession()) {
	            Transaction tx = session.beginTransaction();
	            session.save(pirate);
	            tx.commit();
	        }

	        return pirate;
	    }
	}


