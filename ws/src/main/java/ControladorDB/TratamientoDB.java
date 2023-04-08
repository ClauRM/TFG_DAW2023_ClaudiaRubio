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
	
	int resultado = 0; // resultado de ejecutar las consultas: 1 ok - 2 nada

	// OPERACIONES CRUD //

	// LISTAR TRATAMIENTOS
	public List<Tratamiento> listar() {

		List<Tratamiento> listadoTratamientos = new ArrayList<>();// variable local para traer los datos de la BD
		// escribo consulta sql tipo inner join
		String consultaSql = "SELECT * FROM tratamientos t INNER JOIN  medicamentos m ON t.fidmedicamento = m.idmedicamento INNER JOIN usuarios u ON t.fidusuario = u.idusuario";

		try {
			// abro la conexion a la BD, ejecuto consulta, cierro conexion y devuelvo
			// resultado en resultSet
			ResultSet resultSet2 = gestorDB.getResult(consultaSql);

			// mientras que haya datos en el resultado de la consulta, recorrerla
			while (resultSet2.next()) {
				Tratamiento tratamiento = new Tratamiento(); // instancio un nuevo tratamiento por cada linea

				// seteo todos los campos del medicamento con resultSet nombre de la columna en
				// la base de datos
				tratamiento.setIdtratamiento(resultSet2.getInt("idtratamiento"));// nombre de la columna en el resultado
																				// de la consulta
				tratamiento.setFidusuario(resultSet2.getInt("fidusuario"));
				tratamiento.setFidmedicamento(resultSet2.getInt("fidmedicamento"));
				tratamiento.setPaciente(resultSet2.getString("paciente"));
				tratamiento.setDosis(resultSet2.getInt("dosis"));
				tratamiento.setHoras(resultSet2.getInt("horas"));
				tratamiento.setTratamiento(resultSet2.getString("tratamiento"));
				tratamiento.setObservaciones(resultSet2.getString("observaciones"));
				tratamiento.setActivo(resultSet2.getInt("activo"));
				// para los datos del medicamento, creo un nuevo objeto
				tratamiento.setMedicamento(
						new Medicamento(resultSet2.getInt("idmedicamento"), resultSet2.getString("medicamento")));
				// para los datos del usuario, creo un nuevo objeto
				tratamiento.setUsuario(new Usuario(resultSet2.getInt("idusuario"), resultSet2.getString("nombre"),
						resultSet2.getString("email"), resultSet2.getString("password")));
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
		
		//escribo consulta insert
		//tratamiento.setUsuario(null);
		//tratamiento.setMedicamento(null);
		
		String consulta = "INSERT INTO tratamientos(fidusuario, fidmedicamento, paciente, dosis, horas, tratamiento, observaciones, activo) VALUES (?,?,?,?,?,?,?,?);";

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
			prepareStatement.setString(6, tratamiento.getTratamiento());
			prepareStatement.setString(7, tratamiento.getObservaciones());
			prepareStatement.setInt(8, tratamiento.getActivo());
			//ejecuto query
			resultado = prepareStatement.executeUpdate();
			
			gestorDB.cerrarConexion();
			
		} catch (Exception e) {
		}

		return resultado;
	}

	// MODIFICAR TRATAMIENTO
	public int modificar(Tratamiento tratamiento) {
		
		//escribo consulta insert
		//tratamiento.setUsuario(null);
		//tratamiento.setMedicamento(null);
		
		String consulta = "UPDATE tratamientos SET fidusuario=?, fidmedicamento=?, paciente=?, dosis=?, horas=?, tratamiento=?, observaciones=?, activo=? WHERE idtratamiento=?;";

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
			prepareStatement.setString(6, tratamiento.getTratamiento());
			prepareStatement.setString(7, tratamiento.getObservaciones());
			prepareStatement.setInt(8, tratamiento.getActivo());
			prepareStatement.setInt(9,tratamiento.getIdtratamiento());
			//ejecuto query
			resultado = prepareStatement.executeUpdate();
			
			gestorDB.cerrarConexion();
			
		} catch (Exception e) {
		}

		return resultado;
		
	}

	// ELIMINAR TRATAMIENTO
	public void eliminar(int idtratamiento) {
		//no elimino consulta sino que la desactivo
		String consulta = "UPDATE tratamientos SET activo=0 WHERE idtratamiento=" + idtratamiento;
		
		try {			
			// abro la conexion a la BD, ejecuto consulta, cierro conexion 
			gestorDB.getResult(consulta);
			
		} catch (Exception e) {
		}
	}
	
	// LISTAR UN OBJETO TRATAMIENTO
	public Tratamiento tratamiento(int idtratamiento) {
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
				tratamiento.setTratamiento(resultSet.getString("tratamiento"));
				tratamiento.setObservaciones(resultSet.getString("observaciones"));
				tratamiento.setActivo(resultSet.getInt("activo"));
				// para los datos del medicamento, creo un nuevo objeto
				/*
				tratamiento.setMedicamento(
				new Medicamento(resultSet.getInt("idmedicamento"), resultSet.getString("medicamento")));
				// para los datos del usuario, creo un nuevo objeto
				tratamiento.setUsuario(new Usuario(resultSet.getInt("idusuario"), resultSet.getString("nombre"),
				resultSet.getString("email"), resultSet.getString("password")));
				*/
			
			}
			
		} catch (Exception e) {
		}
		
		return tratamiento;
	}
	

}
