package controladorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Medicamento;

public class MedicamentoDB {
	
	GestorDB gestorDB = new GestorDB(); // objeto de la clase Conexion.java

	Connection conection; // objeto de la clase Connection
	PreparedStatement prepareStatement; // variable de tipo prepareStatement
	ResultSet resultSet; // variable de tipo resultSet
	

	// LISTAR MEDICAMENTOS
	public List<Medicamento> listar() {

		List<Medicamento> listadoMedicamentos = new ArrayList<>();// variable local para traer los datos de la BD
		Medicamento medicamento; // objeto de la clase Medicamento
		String consultaSql = "SELECT * FROM medicamentos"; // escribo consulta sql tipo select

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
			e.printStackTrace();
		}

		return listadoMedicamentos; // retorno listado ordenado de medicamentos
	}

}
