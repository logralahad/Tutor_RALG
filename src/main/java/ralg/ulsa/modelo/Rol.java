package ralg.ulsa.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "estado")
	private Boolean estado;

	public Rol() {
	}

	public Rol(Integer id, String nombre, String descripcion, Boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Rol(String nombre, String descripcion, Boolean estado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

}
