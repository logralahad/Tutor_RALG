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
			List<Persona> personas = personaDAO.getAllPersonas();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=ListaPersonas.xlsx");

			if (personas.size() > 0) {
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("Roles");

				String[] headers = new String[] { "Id", "Nombre", "Apellido paterno", "Apellido materno", "Edad",
						"Telefono", "RFC", "Fecha de nacimiento", "Domicilio" };
				Row headerRow = sheet.createRow(0);
				for (int i = 0; i < headers.length; i++) {
					Cell headerCell = headerRow.createCell(i);
					headerCell.setCellValue(headers[i]);
					sheet.autoSizeColumn(i);
				}

				int rowCount = 1;
				for (Persona item : personas) {
					Row row = sheet.createRow(rowCount++);
					int columnCount = 0;
					Cell cell = row.createCell(columnCount++);
					cell.setCellValue(item.getId());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getNombre());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getPaterno());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getMaterno());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getEdad());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getTelefono());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getRfc());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getFechaNacimiento());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getDomicilio());
				}

				workbook.write(response.getOutputStream());
				workbook.close();
				return;
			} else {
				listarPersonas(request, response);
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
