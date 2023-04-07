package ControladorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Modelo.Medicamento;
import Modelo.Tratamiento;
import Modelo.Usuario;

public class TratamientoDB {

	GestorDB gestorDB = new GestorDB(); // objeto de la clase Conexion.java

	Connection conection; // objeto de la clase Connection
	PreparedStatement prepareStatement; // variable de tipo prepareStatement
	ResultSet resultSet; // variable de tipo resultSet

	// OPERACIONES CRUD //

	// LISTAR TRATAMIENTOS
	public List<Tratamiento> listar() {

		List<Tratamiento> listadoTratamientos = new ArrayList<>();// variable local para traer los datos de la BD
		// escribo consulta sql tipo inner join
		String consultaSql = "SELECT * FROM tratamientos t INNER JOIN  medicamentos m ON t.fidmedicamento = m.idmedicamento INNER JOIN usuarios u ON t.fidusuario = u.idusuario";

		try {
			// abro la conexion a la BD, ejecuto consulta, cierro conexion y devuelvo
			// resultado en resultSet
			ResultSet resultSet = gestorDB.getResult(consultaSql);

			// mientras que haya datos en el resultado de la consulta, recorrerla
			while (resultSet.next()) {
				Tratamiento tratamiento = new Tratamiento(); // instancio un nuevo tratamiento por cada linea

				// seteo todos los campos del medicamento con resultSet nombre de la columna en
				// la base de datos
				tratamiento.setIdtratamiento(resultSet.getInt("idtratamiento"));// nombre de la columna en el resultado
																				// de la consulta
				tratamiento.setFidusuario(resultSet.getInt("fidusuario"));
				tratamiento.setFidmedicamento(resultSet.getInt("fimedicamento"));
				tratamiento.setPaciente(resultSet.getString("paciente"));
				tratamiento.setDosis(resultSet.getInt("dosis"));
				tratamiento.setHoras(resultSet.getInt("horas"));
				tratamiento.setTratamiento(resultSet.getString("tratamiento"));
				tratamiento.setObservaciones(resultSet.getString("observaciones"));
				tratamiento.setActivo(resultSet.getInt("activo"));
				// para los datos del medicamento, creo un nuevo objeto
				tratamiento.setMedicamento(
						new Medicamento(resultSet.getInt("idmedicamento"), resultSet.getString("medicamento")));
				// para los datos del usuario, creo un nuevo objeto
				tratamiento.setUsuario(new Usuario(resultSet.getInt("idusuario"), resultSet.getString("nombre"),
						resultSet.getString("email"), resultSet.getString("password")));
				// aniado el tratamiento al listado
				listadoTratamientos.add(tratamiento);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listadoTratamientos; // retorno listado de tratamientoa
	}

	// ANIADIR NUEVO TRATAMIENTO
	public int aniadir(Tratamiento tratamiento) {
		int resultado = 0; // resultado de ejecutar la consulta de insercion: 1 ok - 2 nada
		
		//escribo consulta insert
		tratamiento.setUsuario(null);
		tratamiento.setMedicamento(null);
		
		String consulta = "INSERT INTO tratamientos(fidusuario, fidmedicamento, paciente, dosis, horas, tratamiento, observaciones, activo) VALUES (?,?,?,?,?,?,?,?);";

		try {			
			conection = gestorDB.abrirConexion(); // establecer la conexion, la variable conetion va a ser igual a mi objeto
			prepareStatement = conection.prepareStatement(consulta);
			//indico cuales son los parametos de la consulta
			//prepareStatement.setString(1, tratamiento.getNombre());
			//prepareStatement.setString(2, tratamiento.getEmail());
			//prepareStatement.setString(3, tratamiento.getPassword());
			//ejecuto query
			resultado = prepareStatement.executeUpdate();
			
			gestorDB.cerrarConexion();
			
		} catch (Exception e) {
		}

		return 0;
	}

	// MODIFICAR TRATAMIENTO
	public int modificar(Tratamiento tratamiento) {
		return 0;
	}

	// ELIMINAR TRATAMIENTO
	public int eliminar(int id) {
		return id;
	}

}
