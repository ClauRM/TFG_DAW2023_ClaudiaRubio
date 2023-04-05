package Controlador;

import java.sql.*;

public class Conexion {

	Connection conexion; // objeto de la clase Connection
	
	String RUTA = "jdbc:mysql://localhost:3306/cronomedbd";
	String USUARIO ="root";
	String PASSWORD = "";

	public Connection conexion() {
		try {
			// indicar de forma dinamica, donde esta la libreria
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establecer la conexion
			conexion = DriverManager.getConnection(RUTA,USUARIO,PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexion;

	}
}
