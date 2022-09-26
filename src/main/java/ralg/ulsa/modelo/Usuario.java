package ralg.ulsa.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "correo")
	private String correo;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "fechaRegistro")
	private String fechaRegistro;

	@Column(name = "fechaVigencia")
	private String fechaVigencia;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "persona_id") private Persona persona;
	 */

	public Usuario() {
	}

	public Usuario(Integer id, String correo, String password, Boolean status, String fechaRegistro,
			String fechaVigencia) {
		super();
		this.id = id;
		this.correo = correo;
		this.password = password;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.fechaVigencia = fechaVigencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(String fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	};

}
