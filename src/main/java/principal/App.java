package principal;

import java.util.List;

import model.entty.Simplex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.dao.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
		
		Simplex simplex = new Simplex();
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the usuario objects
			session.persist(simplex);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		/*try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Usuario> books = session.createQuery("from Usuario", Usuario.class).list();
			books.forEach(u -> {
				System.out.println("Print Usuario name : " + u.getNome());
			});
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}*/
	}
}
