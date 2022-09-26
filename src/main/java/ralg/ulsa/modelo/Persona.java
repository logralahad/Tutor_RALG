package ralg.ulsa.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "paterno")
	private String paterno;

	@Column(name = "materno")
	private String materno;

	@Column(name = "edad")
	private Integer edad;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "rfc")
	private String rfc;

	@Column(name = "fechaNacimiento")
	private String fechaNacimiento;

	@Column(name = "domicilio")
	private String domicilio;

	public Persona() {
	};

	public Persona(Integer id, String nombre, String paterno, String materno, Integer edad, String telefono, String rfc,
			String fechaNacimiento, String domicilio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.edad = edad;
		this.telefono = telefono;
		this.rfc = rfc;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
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

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNombreCompleto() {
		return this.nombre + " " + this.paterno + " " + this.materno;
	}

}
