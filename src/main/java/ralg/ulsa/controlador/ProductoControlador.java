package ralg.ulsa.controlador;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import ralg.ulsa.dao.hibernate.ProductoDAO;
import ralg.ulsa.modelo.Producto;
import ralg.ulsa.util.HibernateUtil;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024
		* 100)
public class ProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO;

	public void init() {
		productoDAO = new ProductoDAO();
	}

	public ProductoControlador() {
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

			case "/listarProductos":
				this.listarProductos(request, response);
				break;

			case "/descargarExcel":
				this.descargarExcel(request, response);
				break;

			case "/subirImagen":
				this.subirImagen(request, response);
				break;

			default:
				response.sendRedirect(request.getContextPath() + "/pages/producto/registrosProducto.jsp");
				break;
			}
		}
	}

	protected void crear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			String precio = request.getParameter("precio");
			String urlImagen = request.getParameter("imagenActual");
			String existencias = request.getParameter("existencias");
			String codigo = request.getParameter("codigo");
			String porcentaje = request.getParameter("porcentaje");

			if (isEmptyOrNull(nombre) || isEmptyOrNull(descripcion) || isEmptyOrNull(precio)
					|| isEmptyOrNull(existencias) || isEmptyOrNull(codigo) || isEmptyOrNull(porcentaje)) {
				HibernateUtil.setAttributeInSession(request, response, "errorCrear",
						"/pages/producto/crearProducto.jsp", "No puedes dejar campos vacíos");

			} else {
				Producto producto = new Producto();
				producto.setNombre(nombre);
				producto.setDescripcion(descripcion);
				producto.setPrecio(Float.parseFloat(precio));
				producto.setImagen(urlImagen);
				producto.setNumExistencias(Integer.parseInt(existencias));
				producto.setCodigoBarras(codigo);
				producto.setIvaPorcentaje(Integer.parseInt(porcentaje));

				productoDAO.createProducto(producto);
				listarProductos(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			String precio = request.getParameter("precio");
			String urlImagen = request.getParameter("imagenActual");
			String existencias = request.getParameter("existencias");
			String codigo = request.getParameter("codigo");
			String porcentaje = request.getParameter("porcentaje");

			if (isEmptyOrNull(nombre) || isEmptyOrNull(descripcion) || isEmptyOrNull(precio)
					|| isEmptyOrNull(existencias) || isEmptyOrNull(codigo) || isEmptyOrNull(porcentaje)) {
				HibernateUtil.setAttributeInSession(request, response, "errorUpdate",
						"/pages/producto/editarProducto.jsp", "No puedes dejar campos vacíos");

			} else {
				HttpSession session = request.getSession();
				Producto producto = (Producto) session.getAttribute("productToEdit");
				producto.setNombre(nombre);
				producto.setDescripcion(descripcion);
				producto.setPrecio(Float.parseFloat(precio));
				producto.setImagen(urlImagen);
				producto.setNumExistencias(Integer.parseInt(existencias));
				producto.setCodigoBarras(codigo);
				producto.setIvaPorcentaje(Integer.parseInt(porcentaje));

				productoDAO.updateProducto(producto);
				listarProductos(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Producto producto = productoDAO.getProducto(id);
			if (producto != null) {
				HibernateUtil.setAttributeInSession(request, response, "productToEdit",
						"/pages/producto/editarProducto.jsp", producto);
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
			productoDAO.deleteProducto(id);
			listarProductos(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/pages/error500.jsp");
		}
	}

	protected void listarProductos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HibernateUtil.removeAttributeInSession(request, response, "errorCrear");
		HibernateUtil.removeAttributeInSession(request, response, "errorUpdate");
		HibernateUtil.setAttributeInSession(request, response, "listaProductos",
				"/pages/producto/registrosProducto.jsp", productoDAO.getAllProductos());
	}

	protected void subirImagen(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		for (Part part : request.getParts()) {
			part.write("C:\\upload\\" + fileName);
		}
	}

	protected void descargarExcel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Producto> productos = productoDAO.getAllProductos();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=ListaProductos.xlsx");
			if (productos.size() > 0) {
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("Roles");

				String[] headers = new String[] { "Id", "Nombre", "Descripcion", "Precio", "URL de Imagen",
						"Núm. de existencias", "Código de barras", "% de IVA" };
				Row headerRow = sheet.createRow(0);
				for (int i = 0; i < headers.length; i++) {
					Cell headerCell = headerRow.createCell(i);
					headerCell.setCellValue(headers[i]);
					sheet.autoSizeColumn(i);
				}

				int rowCount = 1;
				DataFormat format = workbook.createDataFormat();
				CellStyle style = workbook.createCellStyle();
				style.setDataFormat(format.getFormat("#.##"));

				for (Producto item : productos) {
					Row row = sheet.createRow(rowCount++);
					int columnCount = 0;
					Cell cell = row.createCell(columnCount++);
					cell.setCellValue(item.getId());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getNombre());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getDescripcion());

					cell = row.createCell(columnCount++);
					cell.setCellStyle(style);
					cell.setCellValue(item.getPrecio());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getImagen());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getNumExistencias());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getCodigoBarras());

					cell = row.createCell(columnCount++);
					cell.setCellValue(item.getIvaPorcentaje());
				}

				for (int i = 0; i < headers.length; i++) {
					sheet.autoSizeColumn(i);
				}

				workbook.write(response.getOutputStream());
				workbook.close();
				return;
			} else {
				listarProductos(request, response);
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
