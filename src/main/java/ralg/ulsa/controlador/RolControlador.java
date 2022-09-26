package ralg.ulsa.controlador;

import java.io.IOException;
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
import ralg.ulsa.dao.hibernate.RolDAO;
import ralg.ulsa.modelo.Rol;
import ralg.ulsa.util.HibernateUtil;

public class RolControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RolDAO rolDao;

	public void init() {
		rolDao = new RolDAO();
	}

	public RolControlador() {
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
		try (ServletOutputStream out = response.getOutputStream()) {
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

			case "/listarRoles":
				this.listarRoles(request, response);
				break;

			case "/descargarExcel":
				this.descargarExcel(request, response);
				break;

			default:
				response.sendRedirect(request.getContextPath() + "/pages/rol/registrosRol.jsp");
				break;
			}
		}
	}

	private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			if (isEmptyOrNull(nombre) || isEmptyOrNull(descripcion)) {
				HibernateUtil.setAttributeInSession(request, response, "errorCrear", "/pages/rol/crearRol.jsp",
						"No puede dejar campos vacios");

			} else {
				Rol rol = new Rol();
				rol.setNombre(nombre);
				rol.setDescripcion(descripcion);
				rolDao.createRol(rol);
				listarRoles(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			if (isEmptyOrNull(nombre) || isEmptyOrNull(descripcion)) {
				HibernateUtil.setAttributeInSession(request, response, "errorUpdate", "/pages/rol/editarRol.jsp",
						"No puede dejar campos vacios");

			} else {
				HttpSession session = request.getSession();
				Rol rol = (Rol) session.getAttribute("rolToEdit");
				rol.setNombre(nombre);
				rol.setDescripcion(descripcion);
				rolDao.updateRol(rol);
				listarRoles(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Rol rol = rolDao.getRol(id);
			if (rol != null) {
				HibernateUtil.setAttributeInSession(request, response, "rolToEdit", "/pages/rol/editarRol.jsp", rol);
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
			rolDao.deleteRol(id);
			listarRoles(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	private void listarRoles(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HibernateUtil.removeAttributeInSession(request, response, "errorCrear");
		HibernateUtil.removeAttributeInSession(request, response, "errorUpdate");
		HibernateUtil.setAttributeInSession(request, response, "listaRoles", "/pages/rol/registrosRol.jsp",
				rolDao.getAllRoles());
	}

	protected void descargarExcel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Rol> roles = rolDao.getAllRoles();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=ListaRoles.xlsx");

			if (roles.size() > 0) {
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("Roles");

				String[] headers = new String[] { "Id", "Nombre", "Descripcion" };
				Row headerRow = sheet.createRow(0);
				for (int i = 0; i < headers.length; i++) {
					Cell headerCell = headerRow.createCell(i);
					headerCell.setCellValue(headers[i]);
					sheet.autoSizeColumn(i);
				}

				int rowCount = 1;
				for (Rol item : roles) {
					Row row = sheet.createRow(rowCount++);
					int columnCount = 0;
					Cell cell = row.createCell(columnCount++);
					cell.setCellValue(item.getId());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getNombre());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getDescripcion());
				}

				workbook.write(response.getOutputStream());
				workbook.close();
				return;
			} else {
				listarRoles(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	private Boolean isEmptyOrNull(String param) {
		return param == null || param.isEmpty();
	}

}
