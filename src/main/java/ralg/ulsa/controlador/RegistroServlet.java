package ralg.ulsa.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ralg.ulsa.util.LargaVidaCookie;

/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		boolean isMissingValue = false;
		String nombre = request.getParameter("nombre");
		if (isMissing(nombre)) {
			nombre = "Nombre";
			isMissingValue = true;
		}

		String apellido = request.getParameter("apellido");
		if (isMissing(nombre)) {
			apellido = "Apellido";
			isMissingValue = true;
		}

		String email = request.getParameter("email");
		if (isMissing(nombre)) {
			email = "email@abc.com";
			isMissingValue = true;
		}

		Cookie c1 = new LargaVidaCookie("nombre", nombre);
		response.addCookie(c1);

		Cookie c2 = new LargaVidaCookie("apellido", apellido);
		response.addCookie(c2);

		Cookie c3 = new LargaVidaCookie("email", email);
		response.addCookie(c3);

		String servletFormulario = request.getContextPath() + "/FormularioDeRegistroServlet";
		if (isMissingValue) {
			response.sendRedirect(servletFormulario);
		} else {
			PrintWriter out = response.getWriter();
			String docType = "<!DOCTYPE>\n";
			String title = "Registro completado";
			out.println(docType + "<html>\n" + "<head><title>" + title + "</title><head>\n"
					+ "<body bgColor=\"#ECF6CE\">\n" + "<center>\n" + "<h1>" + title + "</h1>\n"
					+ "<ul>\n<li><b>Nombre<b>: " + nombre + "\n" + "<li><b>Apellido<b>: " + apellido + "\n"
					+ "<li><b>Email<b>: " + email + "\n" + "</ul>\n" + "</center></body></html>");
		}
	}

	private boolean isMissing(String param) {
		return ((param == null) || (param.trim().equals("")));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
