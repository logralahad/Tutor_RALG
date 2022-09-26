package ralg.ulsa.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ralg.ulsa.modelo.Persona;
import ralg.ulsa.modelo.Producto;
import ralg.ulsa.modelo.Rol;
import ralg.ulsa.modelo.Usuario;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/dbTutor?useSSl=false");
				settings.put(Environment.USER, "administrador");
				settings.put(Environment.PASS, "administrador");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Rol.class);
				configuration.addAnnotatedClass(Persona.class);
				configuration.addAnnotatedClass(Usuario.class);
				configuration.addAnnotatedClass(Producto.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry creado");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				createAdminUser();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	protected static void createAdminUser() {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			session.save(new Usuario(1, "admin@gmail.com", "123", true, dtf.format(now).toString(),
					dtf.format(now).toString()));
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public static void setAttributeInSession(HttpServletRequest request, HttpServletResponse response, String name,
			String url, Object object) throws IOException {
		HttpSession session = request.getSession();
		synchronized (session) {
			session.setAttribute(name, object);
			if (!url.isEmpty()) {
				response.sendRedirect(request.getContextPath() + url);
			}
		}
	}

	public static void removeAttributeInSession(HttpServletRequest request, HttpServletResponse response, String name)
			throws IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute(name) != null) {
			synchronized (session) {
				session.removeAttribute(name);
			}
		}
	}

}
