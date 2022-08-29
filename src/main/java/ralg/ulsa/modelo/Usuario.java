package ralg.ulsa.modelo;

public class Usuario {

	private Integer id;
	private String correo;
	private String password;
	private Boolean status;
	private String fechaRegistro;
	private String fechaVigencia;

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
