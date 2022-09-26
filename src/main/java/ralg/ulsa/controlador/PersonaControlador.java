package ralg.ulsa.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ralg.ulsa.dao.hibernate.PersonaDAO;
import ralg.ulsa.modelo.Persona;
import ralg.ulsa.util.HibernateUtil;

public class PersonaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO personaDAO;

	public void init() {
		personaDAO = new PersonaDAO();
	}

	public PersonaControlador() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
	}

	protected void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String action = request.getPathInfo();
			switch (action) {
			case "/crear":
				this.crear(request, response);
				break;

			case "/editar":
				this.editar(request, response);
				break;

			case "/actualizar":
				this.actualizar(request, response);
				break;

			case "/eliminar":
				this.eliminar(request, response);
				break;

			case "/listarPersonas":
				this.listarPersonas(request, response);
				break;

			case "/descargarExcel":
				this.descargarExcel(request, response);
				break;

			default:
				response.sendRedirect(request.getContextPath() + "/pages/persona/registrosPersona.jsp");
				break;
			}
		}
	}

	protected void crear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String parametroNombre = request.getParameter("nombre");
			String parametroPaterno = request.getParameter("paterno");
			String parametroMaterno = request.getParameter("materno");
			String parametroTelefono = request.getParameter("telefono");
			String parametroRFC = request.getParameter("rfc");
			String parametroNacimiento = request.getParameter("nacimiento");
			String parametroDomicilio = request.getParameter("domicilio");
			String parametroEdad = request.getParameter("edad");

			if (isEmptyOrNull(parametroNombre) || isEmptyOrNull(parametroPaterno) || isEmptyOrNull(parametroMaterno)
					|| isEmptyOrNull(parametroTelefono) || isEmptyOrNull(parametroRFC) || isEmptyOrNull(parametroEdad)
					|| isEmptyOrNull(parametroNacimiento) || isEmptyOrNull(parametroDomicilio)) {
				HibernateUtil.setAttributeInSession(request, response, "errorCrear", "/pages/persona/crearPersona.jsp",
						"No puedes dejar campos vacíos");

			} else {
				Persona persona = new Persona();
				persona.setNombre(parametroNombre);
				persona.setPaterno(parametroPaterno);
				persona.setMaterno(parametroMaterno);
				persona.setEdad(Integer.parseInt(parametroEdad));
				persona.setTelefono(parametroTelefono);
				persona.setRfc(parametroRFC);
				persona.setFechaNacimiento(parametroNacimiento);
				persona.setDomicilio(parametroDomicilio);

				personaDAO.createPersona(persona);
				listarPersonas(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String parametroNombre = request.getParameter("nombre");
			String parametroPaterno = request.getParameter("paterno");
			String parametroMaterno = request.getParameter("materno");
			String parametroTelefono = request.getParameter("telefono");
			String parametroRFC = request.getParameter("rfc");
			String parametroNacimiento = request.getParameter("nacimiento");
			String parametroDomicilio = request.getParameter("domicilio");
			String parametroEdad = request.getParameter("edad");

			if (isEmptyOrNull(parametroNombre) || isEmptyOrNull(parametroPaterno) || isEmptyOrNull(parametroMaterno)
					|| isEmptyOrNull(parametroTelefono) || isEmptyOrNull(parametroRFC) || isEmptyOrNull(parametroEdad)
					|| isEmptyOrNull(parametroNacimiento) || isEmptyOrNull(parametroDomicilio)) {
				HibernateUtil.setAttributeInSession(request, response, "errorUpdate",
						"/pages/persona/editarPersona.jsp", "No puedes dejar campos vacíos");

			} else {
				HttpSession session = request.getSession();
				Persona persona = (Persona) session.getAttribute("personToEdit");
				persona.setNombre(parametroNombre);
				persona.setPaterno(parametroPaterno);
				persona.setMaterno(parametroMaterno);
				persona.setEdad(Integer.parseInt(parametroEdad));
				persona.setTelefono(parametroTelefono);
				persona.setRfc(parametroRFC);
				persona.setFechaNacimiento(parametroNacimiento);
				persona.setDomicilio(parametroDomicilio);

				personaDAO.updatePersona(persona);
				listarPersonas(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Persona persona = personaDAO.getPersona(id);
			if (persona != null) {
				HibernateUtil.setAttributeInSession(request, response, "personToEdit",
						"/pages/persona/editarPersona.jsp", persona);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			personaDAO.deletePersona(id);
			listarPersonas(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	protected void listarPersonas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HibernateUtil.removeAttributeInSession(request, response, "errorCrear");
		HibernateUtil.removeAttributeInSession(request, response, "errorUpdate");
		HibernateUtil.setAttributeInSession(request, response, "listaPersonas", "/pages/persona/registrosPersona.jsp",
				personaDAO.getAllPersonas());
	}

	protected void descargarExcel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("hola");
			Double x = Double.parseDouble("a");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	private Boolean isEmptyOrNull(String param) {
		return param == null || param.isEmpty();
	}
}
