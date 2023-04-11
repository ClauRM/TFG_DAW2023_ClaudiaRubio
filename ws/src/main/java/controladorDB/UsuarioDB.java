package controladorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Usuario;

public class UsuarioDB {

	GestorDB gestorDB = new GestorDB(); // objeto de la clase GestorDB.java

	// metodo para validar el login de un usuariio comparando contra la BD
	public Usuario validarUsuario(String email, String password) {
		
		Connection conection; // objeto de la clase Connection
		PreparedStatement prepareStatement; // variable de tipo prepareStatement
		ResultSet resultSet; // variable de tipo resultSet
		
		Usuario user = new Usuario();// creo el objeto usuario de la clase que he creado
		String consulta = "SELECT * FROM usuarios WHERE email=? AND password=?"; // consulta para localizar al usuario
																					// en la bd
		
		try {
			conection = gestorDB.abrirConexion(); // establecer la conexion
			prepareStatement = conection.prepareStatement(consulta);
			//indico cuales son los parametos de la consulta
			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);
			//ejecuto query
			resultSet = prepareStatement.executeQuery();
			
			// mientras que haya datos en el resultado de la consulta, recorrerla
			while (resultSet.next()) {
				user.setIdusuario(resultSet.getInt("idusuario"));// nombre de la columna en la base de datos
				user.setNombre(resultSet.getString("nombre"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
			}

		} catch (Exception e) {
			System.out.println("ERROR EN METODO validarUsuario(): " + e.getMessage()); // muestro error por consola
		}

		return user;
	}

	// NUEVO USUARIO

	public void insertarUsuario(Usuario usuario) {

		int resultado = 0; // resultado de ejecutar la consulta de insercion: 1 ok | 2 nada

		// VALIDAR nombre, email , password

		resultado = gestorDB.insertarUsuarioDB(usuario);

		if (resultado == 1) {
			// ANALIZAR SI res ES EL OK DE LA TRABSACCION
			// si E ok CONTINUA7
		} else {
			// sI ES ko VULVE PANTALLA
			// sino se queda en la misma pagina
		}

	}
}
