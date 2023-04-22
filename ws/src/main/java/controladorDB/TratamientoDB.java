package controladorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Medicamento;
import modelo.Tratamiento;
import modelo.Usuario;

public class TratamientoDB {

	GestorDB gestorDB = new GestorDB(); // objeto de la clase Conexion.java

	Connection conection; // objeto de la clase Connection
	PreparedStatement prepareStatement; // variable de tipo prepareStatement
	ResultSet resultSet; // variable de tipo resultSet
	
	int resultado = 0; // resultado de ejecutar las consultas: 1 ok - 2 nada

	// OPERACIONES CRUD //

	// LISTAR TRATAMIENTOS
	public List<Tratamiento> listarTratamientos(int idusuario, boolean isFinalizados) {

		List<Tratamiento> listadoTratamientos = new ArrayList<>();// variable local para traer los datos de la BD
		// escribo consulta sql tipo inner join
		String consultaSql = "SELECT * FROM tratamientos t INNER JOIN  medicamentos m ON t.fidmedicamento = m.idmedicamento INNER JOIN usuarios u ON t.fidusuario = u.idusuario WHERE activo = ? AND fidusuario=?";

		try {
			conection = gestorDB.abrirConexion(); // abro la conexion a la BD
			prepareStatement = conection.prepareStatement(consultaSql); // preparo la sentencia
			// indico cuales son los parametos de la consulta
			if (isFinalizados) { // Activos = 1 (en curso) activos = 0 (finalizados)
				prepareStatement.setInt(1, 0);
			} else {
				prepareStatement.setInt(1, 1);
			}
			prepareStatement.setInt(2, idusuario); 
			resultSet = prepareStatement.executeQuery(); // ejecuto consulta

			// mientras que haya datos en el resultado de la consulta, recorrerla
			while (resultSet.next()) {
				Tratamiento tratamiento = new Tratamiento(); // instancio un nuevo tratamiento por cada linea

				// seteo todos los campos del medicamento con resultSet nombre de la columna en
				// la base de datos
				tratamiento.setIdtratamiento(resultSet.getInt("idtratamiento"));// nombre de la columna en el resultado
																				// de la consulta
				tratamiento.setFidusuario(resultSet.getInt("fidusuario"));
				tratamiento.setFidmedicamento(resultSet.getInt("fidmedicamento"));
				tratamiento.setPaciente(resultSet.getString("paciente"));
				tratamiento.setDosis(resultSet.getInt("dosis"));
				tratamiento.setHoras(resultSet.getInt("horas"));
				tratamiento.setDuracion(resultSet.getInt("duracion"));
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
			System.out.println("ERROR EN METODO listarTratamientos(): " + e.getMessage()); // muestro error por consola
		}

		return listadoTratamientos; // retorno listado de tratamientoa
	}
	
	// ANIADIR NUEVO TRATAMIENTO
	public int aniadir(Tratamiento tratamiento) {
		
		//escribo consulta insert
		//tratamiento.setUsuario(null);
		//tratamiento.setMedicamento(null);
		
		String consulta = "INSERT INTO tratamientos(fidusuario, fidmedicamento, paciente, dosis, horas, duracion, tratamiento, observaciones, activo) VALUES (?,?,?,?,?,?,?,?,?);";

		try {			
			conection = gestorDB.abrirConexion(); // establecer la conexion, la variable conetion va a ser igual a mi objeto
			
			prepareStatement = conection.prepareStatement(consulta);
			//indico cuales son los parametos de la consulta
			//seteando las propiedades del prepareStatement (set) y tomandolos (get) del objeto 
			prepareStatement.setInt(1, tratamiento.getFidusuario());
			prepareStatement.setInt(2, tratamiento.getFidmedicamento());
			prepareStatement.setString(3, tratamiento.getPaciente());
			prepareStatement.setInt(4, tratamiento.getDosis());
			prepareStatement.setInt(5, tratamiento.getHoras());
			prepareStatement.setInt(6, tratamiento.getDuracion());
			prepareStatement.setString(7, tratamiento.getTratamiento());
			prepareStatement.setString(8, tratamiento.getObservaciones());
			prepareStatement.setInt(9, tratamiento.getActivo());
			//ejecuto query
			resultado = prepareStatement.executeUpdate();
			
			gestorDB.cerrarConexion();
			
		} catch (Exception e) {
			System.out.println("ERROR EN METODO aniadir(): " + e.getMessage()); // muestro error por consola
		}

		return resultado;
	}

	// MODIFICAR TRATAMIENTO
	public int modificar(Tratamiento tratamiento) {
		
		//escribo consulta insert
		//tratamiento.setUsuario(null);
		//tratamiento.setMedicamento(null);
		
		String consulta = "UPDATE tratamientos SET fidusuario=?, fidmedicamento=?, paciente=?, dosis=?, horas=?, duracion=?, tratamiento=?, observaciones=?, activo=? WHERE idtratamiento=?;";

		try {			
			conection = gestorDB.abrirConexion(); // establecer la conexion, la variable conetion va a ser igual a mi objeto
			
			prepareStatement = conection.prepareStatement(consulta);
			//indico cuales son los parametos de la consulta
			//seteando las propiedades del prepareStatement (set) y tomandolos (get) del objeto 
			prepareStatement.setInt(1, tratamiento.getFidusuario());
			prepareStatement.setInt(2, tratamiento.getFidmedicamento());
			prepareStatement.setString(3, tratamiento.getPaciente());
			prepareStatement.setInt(4, tratamiento.getDosis());
			prepareStatement.setInt(5, tratamiento.getHoras());
			prepareStatement.setInt(6, tratamiento.getDuracion());
			prepareStatement.setString(7, tratamiento.getTratamiento());
			prepareStatement.setString(8, tratamiento.getObservaciones());
			prepareStatement.setInt(9, tratamiento.getActivo());
			prepareStatement.setInt(10,tratamiento.getIdtratamiento());
			//ejecuto query
			resultado = prepareStatement.executeUpdate();
			
			gestorDB.cerrarConexion();
			
		} catch (Exception e) {
			System.out.println("ERROR EN METODO modificar(): " + e.getMessage()); // muestro error por consola
		}

		return resultado;
		
	}

	// FINALIZAR TRATAMIENTO
	public int finalizar(int idtratamiento) {
		//no elimino consulta sino que la desactivo
		String consulta = "UPDATE tratamientos SET activo=0 WHERE idtratamiento=" + idtratamiento;
		
		try {			
			conection = gestorDB.abrirConexion(); // establecezco la conexion
			prepareStatement = conection.prepareStatement(consulta); // preparo la consulta
			resultado = prepareStatement.executeUpdate(); // ejecuto la consulta
			gestorDB.cerrarConexion(); // cierro la conexion
		} catch (Exception e) {
			System.out.println("ERROR EN METODO finalizar(): " + e.getMessage()); // muestro error por consola
		}
		
		return resultado;
	}
	
	// ELIMINAR TRATAMIENTO
	public int eliminar(int idtratamiento) {
		String consulta = "DELETE FROM tratamientos WHERE idtratamiento=" + idtratamiento;
		
		try {			
			conection = gestorDB.abrirConexion(); // establecezco la conexion
			prepareStatement = conection.prepareStatement(consulta); // preparo la consulta
			resultado = prepareStatement.executeUpdate(); // ejecuto la consulta
			gestorDB.cerrarConexion(); // cierro la conexion
		} catch (Exception e) {
			System.out.println("ERROR EN METODO eliminar(): " + e.getMessage()); // muestro error por consola
		}
		
		return resultado;
	}

	
	// LISTAR UN OBJETO TRATAMIENTO
	public Tratamiento unTratamiento(int idtratamiento) {
		Tratamiento tratamiento = new Tratamiento(); //instancia de clase
		ResultSet resultSet; //variable resultado de ejecutar una consulta
		
		//consulta para traer los datos de la bd
		String consulta = "SELECT * FROM tratamientos WHERE idtratamiento=" + idtratamiento;
		
		try {			
			// abro la conexion a la BD, ejecuto consulta, cierro conexion y almaceno en variable resultado
			resultSet = gestorDB.getResult(consulta);
			// mientras que la consulta haya devuelto datos..
			while(resultSet.next()){
				
				//seteo las propiedades del objeto (set), tomandolos (get) de la variable resultado
				tratamiento.setIdtratamiento(resultSet.getInt("idtratamiento"));// nombre de la columna en el resultado
				// de la consulta
				tratamiento.setFidusuario(resultSet.getInt("fidusuario"));
				tratamiento.setFidmedicamento(resultSet.getInt("fidmedicamento"));
				tratamiento.setPaciente(resultSet.getString("paciente"));
				tratamiento.setDosis(resultSet.getInt("dosis"));
				tratamiento.setHoras(resultSet.getInt("horas"));
				tratamiento.setDuracion(resultSet.getInt("duracion"));
				tratamiento.setTratamiento(resultSet.getString("tratamiento"));
				tratamiento.setObservaciones(resultSet.getString("observaciones"));
				tratamiento.setActivo(resultSet.getInt("activo"));
				
			}
			
		} catch (Exception e) {
			System.out.println("ERROR EN unTratamiento(): " + e.getMessage());
		}
		
		return tratamiento;
	}
	

}
