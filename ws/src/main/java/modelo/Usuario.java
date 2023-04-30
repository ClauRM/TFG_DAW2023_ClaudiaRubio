package modelo;

public class Usuario {

	private int idusuario;
	private String nombre;
	private String email;
	private String password;
	private int admin;

	public Usuario() {
		super();
	}

	
	public Usuario(int idusuario, String nombre, String email, String password, int admin) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public Usuario(int idusuario, String nombre, String email, String password) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}	

	public Usuario(String nombre, String email, String password) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

}
