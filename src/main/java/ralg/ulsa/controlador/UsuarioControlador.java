package ralg.ulsa.controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ralg.ulsa.dao.hibernate.UsuarioDAO;
import ralg.ulsa.modelo.Usuario;
import ralg.ulsa.util.HibernateUtil;

/**
 * Servlet implementation class UsuarioControlador
 */
public class UsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;

	public void init() {
		usuarioDAO = new UsuarioDAO();
	}

	public UsuarioControlador() {
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
		response.setContentType("text/html;charset=UTF-8");
		try (ServletOutputStream out = response.getOutputStream()) {
			String action = request.getPathInfo();
			switch (action) {
			case "/login":
				this.login(request, response);
				break;

			case "/registrar":
				this.registrar(request, response);
				break;

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

			case "/listarUsuarios":
				this.listarUsuarios(request, response);
				break;

			case "/perfil":
				this.perfil(request, response);
				break;

			case "/descargarExcel":
				this.descargarExcel(request, response);
				break;

			default:
				response.sendRedirect(request.getContextPath() + "/pages/usuario/registrosUsuario.jsp");
				break;
			}
		}
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String parametroCorreo = request.getParameter("username");
			String parametroPwd = request.getParameter("password");
			if ((parametroCorreo == null || parametroCorreo.isEmpty())
					&& (parametroPwd == null || parametroPwd.isEmpty())) {
				HibernateUtil.setAttributeInSession(request, response, "errorLogin", "/pages/login.jsp",
						"No puede dejar campos vacios");
			} else {
				Usuario usuario = usuarioDAO.login(parametroCorreo, parametroPwd);
				if (usuario != null) {
					HibernateUtil.setAttributeInSession(request, response, "usuario", "/pages/perfil.jsp", usuario);
				} else {
					HibernateUtil.setAttributeInSession(request, response, "errorLogin", "/pages/login.jsp",
							"Datos de ingreso erróneos");
				}
			}
		} catch (Exception e) {
			HibernateUtil.setAttributeInSession(request, response, "errorLogin", "/pages/login.jsp",
					"Hubo un error al iniciar sesión");
		}
	}

	protected void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String parametroCorreo = request.getParameter("correo");
			String parametroPwd = request.getParameter("password");
			String parametroRePwd = request.getParameter("re_password");
			Boolean status = request.getParameter("agree-term").equals("on") ? true : false;
			Boolean isOcuppied = usuarioDAO.isOcuppied(parametroCorreo);

			System.out.println(status);
			if ((isEmptyOrNull(parametroCorreo) || isEmptyOrNull(parametroPwd)) || status == false) {
				HibernateUtil.setAttributeInSession(request, response, "errorRegister", "/pages/registrar.jsp",
						"No puedes dejar campos vacíos");

			} else if (!parametroPwd.equals(parametroRePwd)) {
				HibernateUtil.setAttributeInSession(request, response, "errorRegister", "/pages/registrar.jsp",
						"Las contraseñas deben coincidir");

			} else if (isOcuppied) {
				HibernateUtil.setAttributeInSession(request, response, "errorRegister", "/pages/registrar.jsp",
						"El correo ya ha sido utilizado");
			} else {
				Usuario usuario = new Usuario();
				usuario.setCorreo(parametroCorreo);
				usuario.setPassword(parametroPwd);
				usuario.setStatus(true);
				Calendar today = Calendar.getInstance();
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				String todayFormatted = format1.format(today.getTime());
				usuario.setFechaRegistro(todayFormatted);

				today.add(Calendar.YEAR, 1);
				String vigentFormatted = format1.format(today.getTime());
				usuario.setFechaVigencia(vigentFormatted);
				usuarioDAO.createUsuario(usuario);
				response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
			}
		} catch (Exception e) {
			HibernateUtil.setAttributeInSession(request, response, "errorRegister", "/pages/registrar.jsp",
					"Hubo un error al registrarse");
		}
	}

	protected void crear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Boolean parametroEstatus = request.getParameter("estatus") == null ? false : true;
			String parametroCorreo = request.getParameter("correo");
			String parametroPwd = request.getParameter("password");
			String parametroVigencia = request.getParameter("vigencia");

			if (isEmptyOrNull(parametroCorreo) || isEmptyOrNull(parametroPwd) || isEmptyOrNull(parametroVigencia)) {
				HibernateUtil.setAttributeInSession(request, response, "errorCrear", "/pages/usuario/crearUsuario.jsp",
						"No puedes dejar campos vacíos");

			} else {
				Usuario usuario = new Usuario();
				usuario.setCorreo(parametroCorreo);
				usuario.setPassword(parametroPwd);
				usuario.setStatus(parametroEstatus);
				usuario.setFechaVigencia(parametroVigencia);

				Calendar today = Calendar.getInstance();
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				String todayFormatted = format1.format(today.getTime());
				usuario.setFechaRegistro(todayFormatted);

				usuarioDAO.createUsuario(usuario);
				listarUsuarios(request, response);
			}
		} catch (Exception e) {
			System.out.println("Message: " + e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}

	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Boolean parametroEstatus = request.getParameter("estatus") == null ? false : true;
			String parametroCorreo = request.getParameter("correo");
			String parametroPwd = request.getParameter("password");
			String parametroVigencia = request.getParameter("vigencia");

			if (isEmptyOrNull(parametroCorreo) || isEmptyOrNull(parametroVigencia)) {
				HibernateUtil.setAttributeInSession(request, response, "errorUpdate",
						"/pages/usuario/editarUsuario.jsp", "No puedes dejar campos vacíos");

			} else {
				HttpSession session = request.getSession();
				Usuario usuarioEditado = (Usuario) session.getAttribute("userToEdit");
				Usuario actual = (Usuario) session.getAttribute("usuario");

				usuarioEditado.setCorreo(parametroCorreo);
				if (!isEmptyOrNull(parametroPwd)) {
					usuarioEditado.setPassword(parametroPwd);
				}
				usuarioEditado.setStatus(parametroEstatus);
				usuarioEditado.setFechaVigencia(parametroVigencia);
				usuarioDAO.updateUsuario(usuarioEditado);

				if (actual.getId() == usuarioEditado.getId()) {
					HibernateUtil.setAttributeInSession(request, response, "usuario", "", actual);
				}
				listarUsuarios(request, response);
			}
		} catch (Exception e) {
			System.out.println("Message: " + e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Usuario usuario = usuarioDAO.getUsuario(id);
			if (usuario != null) {
				HibernateUtil.setAttributeInSession(request, response, "userToEdit", "/pages/usuario/editarUsuario.jsp",
						usuario);
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
			usuarioDAO.deleteUsuario(id);
			listarUsuarios(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	protected void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HibernateUtil.removeAttributeInSession(request, response, "errorCrear");
		HibernateUtil.removeAttributeInSession(request, response, "errorUpdate");
		HibernateUtil.setAttributeInSession(request, response, "listaUsuarios", "/pages/usuario/registrosUsuario.jsp",
				usuarioDAO.getAllUsuarios());
	}

	protected void perfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario actual = (Usuario) session.getAttribute("usuario");

		response.sendRedirect(request.getContextPath() + "/pages/perfil.jsp");
	}

	protected void descargarExcel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Usuario> usuarios = usuarioDAO.getAllUsuarios();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=ListaUsuarios.xlsx");

			if (usuarios.size() > 0) {
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("Roles");

				String[] headers = new String[] { "Id", "Correo", "Contraseña", "Estatus", "Fecha de registro",
						"Fecha de vigencia" };
				Row headerRow = sheet.createRow(0);
				for (int i = 0; i < headers.length; i++) {
					Cell headerCell = headerRow.createCell(i);
					headerCell.setCellValue(headers[i]);
				}

				int rowCount = 1;
				for (Usuario item : usuarios) {
					Row row = sheet.createRow(rowCount++);
					int columnCount = 0;
					Cell cell = row.createCell(columnCount++);
					cell.setCellValue(item.getId());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getCorreo());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getPassword());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getStatus() ? "Activo" : "Inactivo");

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getFechaRegistro());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getFechaVigencia());
				}

				for (int i = 0; i < headers.length; i++) {
					sheet.autoSizeColumn(i);
				}

				workbook.write(response.getOutputStream());
				workbook.close();
				return;
			} else {
				listarUsuarios(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	private Boolean isEmptyOrNull(String param) {
		return param == null || param.isEmpty();
	}

}
