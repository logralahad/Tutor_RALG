package ralg.ulsa.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ralg.ulsa.dao.hibernate.ProductoDAO;
import ralg.ulsa.modelo.Producto;
import ralg.ulsa.util.HibernateUtil;

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

			case "/listarProductos":
				this.listarProductos(request, response);
				break;

			case "/descargarExcel":
				this.descargarExcel(request, response);
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
			String imagen = request.getParameter("imagen");
			String existencias = request.getParameter("existencias");
			String codigo = request.getParameter("codigo");
			String porcentaje = request.getParameter("porcentaje");

			if (isEmptyOrNull(nombre) || isEmptyOrNull(descripcion) || isEmptyOrNull(precio) || isEmptyOrNull(imagen)
					|| isEmptyOrNull(existencias) || isEmptyOrNull(codigo) || isEmptyOrNull(porcentaje)) {
				HibernateUtil.setAttributeInSession(request, response, "errorCrear",
						"/pages/producto/crearProducto.jsp", "No puedes dejar campos vacíos");

			} else {
				Producto producto = new Producto();
				producto.setNombre(nombre);
				producto.setDescripcion(descripcion);
				producto.setPrecio(Float.parseFloat(precio));
				producto.setImagen(imagen);
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
			String imagen = request.getParameter("imagen");
			String existencias = request.getParameter("existencias");
			String codigo = request.getParameter("codigo");
			String porcentaje = request.getParameter("porcentaje");

			if (isEmptyOrNull(nombre) || isEmptyOrNull(descripcion) || isEmptyOrNull(precio) || isEmptyOrNull(imagen)
					|| isEmptyOrNull(existencias) || isEmptyOrNull(codigo) || isEmptyOrNull(porcentaje)) {
				HibernateUtil.setAttributeInSession(request, response, "errorUpdate",
						"/pages/producto/editarProducto.jsp", "No puedes dejar campos vacíos");

			} else {
				HttpSession session = request.getSession();
				Producto producto = (Producto) session.getAttribute("productToEdit");
				producto.setNombre(nombre);
				producto.setDescripcion(descripcion);
				producto.setPrecio(Float.parseFloat(precio));
				producto.setImagen(imagen);
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