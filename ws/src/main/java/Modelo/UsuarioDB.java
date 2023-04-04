package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Controlador.Conexion;

public class UsuarioDB {
	Conexion conexion = new Conexion(); // objeto de la clase Conexion que he creado
	Connection conection; // variable de tipo conection
	PreparedStatement prepareStatement; // variable de tipo prepareStatement
	ResultSet resultSet; // variable de tipo resultSet

	// metodo para validar el login de un usuariio comparando contra la BD
	public Usuario validarUsuario(String nombre, String password) {
		
		Usuario user = new Usuario();// creo el objeto usuario de la clase que he creado
		String consulta = "SELECT * FROM usuarios WHERE nombre=? AND password=?"; // consulta para localizar al usuario
																					// en la bd
		try {
			conection = conexion.conexion(); // establecer la conexion, la variable conetion va a ser igual a mi objeto
			prepareStatement = conection.prepareStatement(consulta); // prepare statement es igual a la conexion con
																		// paramentro la consulta
			// asigno los valores de los parametros de la consulta
			prepareStatement.setString(1, nombre);
			prepareStatement.setString(2, password);
			// resulSet
			resultSet = prepareStatement.executeQuery();
			//mientras que haya datos en el resultado de la consulta, recorrerla
			while (resultSet.next()){
				user.setIdusuario(resultSet.getInt("idusuario"));
				user.setNombre(resultSet.getString("nombre")); //nombre de la columna
				user.setPassword(resultSet.getString("password")); //nombre de la columna
			}

		} catch (Exception e) {
		}

		return user;
	}

}
