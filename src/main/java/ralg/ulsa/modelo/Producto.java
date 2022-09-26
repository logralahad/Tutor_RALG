package ralg.ulsa.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio")
	private Float precio;

	@Column(name = "imagenURL")
	private String imagenURL;

	@Column(name = "numExistencias")
	private Integer numExistencias;

	@Column(name = "codigoBarras")
	private String codigoBarras;

	@Column(name = "ivaPorcentaje")
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
		this.imagenURL = imagen;
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
		return imagenURL;
	}

	public void setImagen(String imagen) {
		this.imagenURL = imagen;
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
