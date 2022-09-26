package ralg.ulsa.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ralg.ulsa.modelo.Usuario;
import ralg.ulsa.util.HibernateUtil;

public class UsuarioDAO {

	public void createUsuario(Usuario usuario) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(usuario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateUsuario(Usuario usuario) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(usuario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Usuario getUsuario(Integer id) {
		Transaction transaction = null;
		Usuario usuario = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			usuario = session.get(Usuario.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return usuario;
	}

	public List<Usuario> getAllUsuarios() {
		Transaction transaction = null;
		List<Usuario> lista = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			lista = session.createQuery("from Usuario").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return lista;
	}

	public Usuario login(String correo, String password) {
		Transaction transaction = null;
		Usuario usuario = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			usuario = (Usuario) session.createQuery("from Usuario where correo=:param_correo and password=:param_pass")
					.setParameter("param_correo", correo).setParameter("param_pass", password).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return usuario;
	}

	public Boolean isOcuppied(String correo) {
		Transaction transaction = null;
		Usuario usuario = null;
		Boolean flag = false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			usuario = (Usuario) session.createQuery("from Usuario where correo=:param_correo")
					.setParameter("param_correo", correo).uniqueResult();
			if (usuario != null) {
				flag = true;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return flag;
	}

	public void deleteUsuario(Integer id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, id);
			if (usuario != null) {
				session.delete(usuario);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
