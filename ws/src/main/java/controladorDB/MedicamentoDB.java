package controladorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Medicamento;
import modelo.Tratamiento;
import utilidades.Utilidades;

public class MedicamentoDB {
	
	GestorDB gestorDB = new GestorDB(); // objeto de la clase Conexion.java

	Connection conection; // objeto de la clase Connection
	PreparedStatement prepareStatement; // variable de tipo prepareStatement
	ResultSet resultSet; // variable de tipo resultSet
		
	int resultado = 0; //resultado de ejecutar una consulta: 1 ok - 2 nada

	// OPERACIONES CRUD
	
	//LISTAR MEDICAMENTOS
	public List<Medicamento> listarMedicamentos() {

		List<Medicamento> listadoMedicamentos = new ArrayList<>();// variable local para traer los datos de la BD
		Medicamento medicamento; // objeto de la clase Medicamento
		String consultaSql = "SELECT * FROM medicamentos ORDER BY medicamento"; // escribo consulta sql tipo select

		try {
			conection = gestorDB.abrirConexion(); // establezco la conexion
			prepareStatement = conection.prepareStatement(consultaSql); // preparo la consulta
			resultSet = prepareStatement.executeQuery(); // ejecuto la consulta y almaceno el resultado
						
			// mientras que haya datos en el resultado de la consulta, recorrerla
			while (resultSet.next()) {
				medicamento = new Medicamento(); // instancio un nuevo objeto medicamento por cada linea
				// seteo los datos del medicamento en resultSet con el nombre de la columna
				medicamento.setIdmedicamento(resultSet.getInt("idmedicamento")); // nombre de la columna
				medicamento.setMedicamento(resultSet.getString("medicamento"));
				// aniado el medicamento al listado
				listadoMedicamentos.add(medicamento);
			}
			
			gestorDB.cerrarConexion(); // cierro la conexion

		} catch (Exception e) {
			System.out.println("ERROR EN METODO listarMedicamentos(): " + e.getMessage()); // muestro error por consola
		}

		return listadoMedicamentos; // retorno listado ordenado de medicamentos
	}

	//ANIADIR MEDICAMENTO
	public int aniadirMedicamento(String medicamento) {
		
		//escribo consulta insert		
				String consulta = "INSERT INTO medicamentos(medicamento) VALUES (?);";

				try {			
					conection = gestorDB.abrirConexion(); //establecezco la conexion
					prepareStatement = conection.prepareStatement(consulta); //preparo consulta
					prepareStatement.setString(1, medicamento); //indico parametros de la consulta
					resultado = prepareStatement.executeUpdate(); //ejecuto query
					
					gestorDB.cerrarConexion();
					
				} catch (Exception e) {
					System.out.println("ERROR EN METODO aniadirMedicamento(): " + e.getMessage()); //muestro error por consola
				}

				return resultado;
	}

	//MODIFICAR MEDICAMENTO
	public int modificarMedicamento(Medicamento medicamento) {
		
		//escribo consulta update		
		String consulta = "UPDATE medicamentos SET medicamento=? WHERE idmedicamento=?";

		try {			
			conection = gestorDB.abrirConexion(); //establezo la conexion			
			prepareStatement = conection.prepareStatement(consulta); //preparo la consulta
			prepareStatement.setString(1, medicamento.getMedicamento()); //indico parametros
			prepareStatement.setInt(2,medicamento.getIdmedicamento());
			resultado = prepareStatement.executeUpdate(); //ejecuto query
			
			gestorDB.cerrarConexion();
			
		} catch (Exception e) {
			System.out.println("ERROR EN METODO modificarMedicamento(): " + e.getMessage()); // muestro error por consola
		}

		return resultado;

	}

	//ELIMINAR MEDICAMENTO
	public int eliminarMedicamento(int idmedicamento) {
		
		//escribo consulta delete
		String consulta = "DELETE FROM medicamentos WHERE idmedicamento=" + idmedicamento;
		
		try {			
			conection = gestorDB.abrirConexion(); // establecezco la conexion
			prepareStatement = conection.prepareStatement(consulta); //preparo la consulta
			resultado = prepareStatement.executeUpdate(); //ejecuto la consulta
			gestorDB.cerrarConexion(); //cierro la conexion
		} catch (Exception e) {
			System.out.println("ERROR EN METODO eliminarMedicamento(): " + e.getMessage()); // muestro error por consola
		}
		
		return resultado;
	}
	
	//BUSCAR UN MEDICAMENTO POR SU ID
		public Medicamento unMedicamento(int idmedicamento) {
			Medicamento medicamento = new Medicamento(); //instancia de clase
			ResultSet resultSet; //variable resultado de ejecutar una consulta
			
			//consulta para traer los datos de la bd
			String consulta = "SELECT * FROM medicamentos WHERE idmedicamento=" + idmedicamento;
			
			try {			
				// abro la conexion a la BD, ejecuto consulta, cierro conexion y almaceno en variable resultado
				resultSet = gestorDB.getResult(consulta);
				// mientras que la consulta haya devuelto datos..
				while(resultSet.next()){
					//seteo las propiedades del objeto (set), tomandolos (get) de la variable resultado
					medicamento.setIdmedicamento(resultSet.getInt("idmedicamento")); //nombre columna en el resultado
					medicamento.setMedicamento(resultSet.getString("medicamento"));
					}
				
			} catch (Exception e) {
				System.out.println("ERROR EN unMedicamento(): " + e.getMessage());
			}
			
			return medicamento;
		}
}