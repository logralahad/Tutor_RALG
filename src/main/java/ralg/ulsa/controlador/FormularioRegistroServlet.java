package ralg.ulsa.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ralg.ulsa.util.CookieUtilerias;

/**
 * Servlet implementation class FormularioRegistroServlet
 */
public class FormularioRegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormularioRegistroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String actionURL = request.getContextPath() + "/RegistroServlet";
		String nombre = CookieUtilerias.getCookieValor(request, "nombre", "");
		String apellido = CookieUtilerias.getCookieValor(request, "apellido", "");
		String email = CookieUtilerias.getCookieValor(request, "email", "");
		String docType = "<!DOCTYPE>\n";
		String title = "Registro";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title><head>\n"
				+ "<body bgColor=\"#ECF6CE\">\n" + "<center>\n" + "<h1>" + title + "</h1>\n"
				+ "<ul>\n<li><b>Nombre<b>: " + nombre + "\n" + "<li><b>Apellido<b>: " + apellido + "\n"
				+ "<li><b>Email<b>: " + email + "\n" + "</ul>\n" + "</center></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
