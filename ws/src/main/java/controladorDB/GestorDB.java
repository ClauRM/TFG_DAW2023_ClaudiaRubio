package controladorDB;

import java.sql.*;

import modelo.Usuario;
import utilidades.Utilidades;

public class GestorDB {

	String RUTA = "jdbc:mysql://localhost:3306/cronomedbd";
	String USUARIO ="root";
	String PASSWORD = "";
	
	Connection conection; // objeto de la clase Connection
	PreparedStatement prepareStatement; // variable de tipo prepareStatement
	ResultSet resultSet; // variable de tipo resultSet

	public Connection abrirConexion() {
		try {
			// indicar de forma dinamica, donde esta la libreria
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establecer la conexion
			conection = DriverManager.getConnection(RUTA,USUARIO,PASSWORD);

		} catch (Exception e) {
			System.out.println("ERROR EN METODO abrirConexion(): " + e.getMessage()); // muestro error por consola
		}
		return conection;

	}
	
	// CERRAR CONEXION A LA BD
	public void cerrarConexion() {
		try {
			conection.close();
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO cerrarConexion(): " + e.getMessage()); // muestro error por consola
		}
	}

	// REALIZA UNA CONEXION A LA BD, EJECUTA UNA CONSULTA SIN PARAMETROS Y RETORNA EL RESULTADO
	public ResultSet getResult(String consultaSql) {
		
		conection = abrirConexion(); // establecer la conexion, la variable conetion va a ser igual a mi objeto
		
			try {
				prepareStatement = conection.prepareStatement(consultaSql);
				// prepare statement es igual a la conexion con parametro la consulta
				// resulSet ejecuto la consulta
				resultSet = prepareStatement.executeQuery();
			} catch (SQLException e) {
				System.out.println("ERROR EN METODO getResult(): " + e.getMessage()); // muestro error por consola
			}
			
		//cerrarConexion();
		
		return resultSet;
	}
	
	//INSERT NUEVO USUARIO
	public int insertarUsuarioDB(Usuario usuario) {
				
		String consulta = "INSERT INTO usuarios(nombre, email, password) VALUES (?,?,?)"; //consultaSql
		int resultado = 0; // resultado de ejecutar la consulta de insercion: 1 ok - 2 nada
		
		try {
			conection = abrirConexion(); // establecer la conexion, la variable conetion va a ser igual a mi objeto
			prepareStatement = conection.prepareStatement(consulta);
			//indico cuales son los parametos de la consulta
			prepareStatement.setString(1, usuario.getNombre());
			prepareStatement.setString(2, usuario.getEmail());
			try {
				prepareStatement.setString(3, Utilidades.encriptar(usuario.getPassword()));
			} catch (Exception e) {
				System.out.println("Error al encriptar password del método insertarUsuarioDB(): " + e.getMessage());
			}
			//ejecuto query
			resultado = prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO insertarUsuarioDB(): " + e.getMessage()); // muestro error por consola
		}
		
			
		cerrarConexion();

		return resultado;
	}
}
