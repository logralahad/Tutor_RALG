package ralg.ulsa.modelo;

public class Producto {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Float precio;
	private String imagen;
	private Integer numExistencias;
	private String codigoBarras;
	private Integer ivaPorcentaje;

	public Producto() {
	}

	public Producto(Integer id, String nombre, String descripcion, Float precio, String imagen, Integer numExistencias,
			String codigoBarras, Integer ivaPorcentaje) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.numExistencias = numExistencias;
		this.codigoBarras = codigoBarras;
		this.ivaPorcentaje = ivaPorcentaje;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getNumExistencias() {
		return numExistencias;
	}

	public void setNumExistencias(Integer numExistencias) {
		this.numExistencias = numExistencias;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getIvaPorcentaje() {
		return ivaPorcentaje;
	}

	public void setIvaPorcentaje(Integer ivaPorcentaje) {
		this.ivaPorcentaje = ivaPorcentaje;
	}
}
