package Modelo;

public class Usuario {
	int idusuario;
	String nombre;
	String password;
	
	
	public Usuario() {
		super();
	}

	public Usuario(int idusuario, String nombre, String password) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
