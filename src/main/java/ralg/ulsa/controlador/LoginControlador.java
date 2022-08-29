package ralg.ulsa.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginControlador
 */
public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginControlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void procesarRespuesta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String parametroCorreo = request.getParameter("correo");
		String parametroPwd = request.getParameter("contrasenia");

		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet IndexControlador</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Rutal del archivo Servlet: " + request.getContextPath() + "</h3>");
			out.println("<p>Contenido de respuesta del Servlet</p>");
			out.println("<p>Correo = " + parametroCorreo + "</p>");
			out.println("<p>Contraseña = " + parametroPwd + "</p>");
			out.println("</body>");
			out.println("</html>");
		}
		// response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesarRespuesta(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesarRespuesta(request, response);
	}

}
