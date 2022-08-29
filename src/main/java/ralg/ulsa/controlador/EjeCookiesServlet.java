package ralg.ulsa.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ralg.ulsa.util.CookieUtilerias;
import ralg.ulsa.util.LargaVidaCookie;

public class EjeCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EjeCookiesServlet() {
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

	private void repetirVisitador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean esNuevo = true;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if ((c.getName().equals("repetirVisitador")) && (c.getValue().equals("yes"))) {
					esNuevo = false;
					break;
				}
			}
		}
		String title;
		if (esNuevo) {
			Cookie regresaCookieVisitador = new Cookie("repetirVisitador", "yes");
			regresaCookieVisitador.setMaxAge(60 * 60 * 24 * 365);
			response.addCookie(regresaCookieVisitador);
			title = "Saludos Visitador";
		} else {
			title = "Saludos nuevamente";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title><head>\n" + "<body bgColor=\"#ECF6CE\">\n"
				+ "<h1 align=\"center\">" + title + "</h1>\n" + "</body></html>");
	}

	private void cookiesSessionVsCookiesPersistencia(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		for (int i = 0; i < 3; i++) {
			Cookie cookie = new Cookie("Session-Cookie-" + i, "Cookie-Value-S" + i);
			response.addCookie(cookie);
			cookie = new Cookie("Persistent-Cookie-" + i, "Cookie-Value-P" + i);
			cookie.setMaxAge(10);
			response.addCookie(cookie);
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE>\n";
		String title = "Cookies Activas";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title><head>\n" + "<body bgColor=\"#ECF6CE\">\n"
				+ "<h1 align=\"center\">" + title + "</h1>\n" + "<table border=1 align=\"center\">\n"
				+ "<tr bgColor=\"#00FF40\">\n" + "<th>Nombre Cookie\n" + "<th>Valor cookie");
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			out.println("<tr><th colSpan=2>No hay cookies");
		} else {
			for (Cookie cookie : cookies) {
				out.println("<tr>\n" + " <td>" + cookie.getName() + "\n" + " <td>" + cookie.getValue());
			}
		}
		out.println("</table></body></html>");
	}

	private void contadorAccesosCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String countString = CookieUtilerias.getCookieValor(request, "contadorDeAccesos", "1");
		int count = 1;
		try {
			count = Integer.parseInt(countString);
		} catch (NumberFormatException nfe) {
			System.out.println("Error");
		}
		LargaVidaCookie c = new LargaVidaCookie("contadorDeAccesos", String.valueOf(count + 1));
		response.addCookie(c);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE>\n";
		String title = "Servlet Contador de Accesos";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title><head>\n" + "<body bgColor=\"#ECF6CE\">\n"
				+ "<center>\n" + "<h1>" + title + "</h1>\n" + "<h2>Es la visita n&uacute;mero: #" + count
				+ " para &eacute;ste navegador.</h2>\n" + "</center></body></html>");
	}

	protected void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String action = request.getPathInfo();
			switch (action) {
			case "/":
				this.repetirVisitador(request, response);
				break;
			case "/tiposCookies":
				this.cookiesSessionVsCookiesPersistencia(request, response);
				break;
			case "/contadorCookies":
				this.contadorAccesosCliente(request, response);
				break;
			}
		}
	}

}
