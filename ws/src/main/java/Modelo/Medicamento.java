package Modelo;

public class Medicamento {
	
	private int idmedicamento;
	private String medicamento;
	private int composicion;
	private String unidad;
	
	public Medicamento() {
		super();
	}

	public Medicamento(int idmedicamento, String medicamento, int composicion, String unidad) {
		super();
		this.idmedicamento = idmedicamento;
		this.medicamento = medicamento;
		this.composicion = composicion;
		this.unidad = unidad;
	}

		
	public int getIdmedicamento() {
		return idmedicamento;
	}

	public void setIdmedicamento(int idmedicamento) {
		this.idmedicamento = idmedicamento;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public int getComposicion() {
		return composicion;
	}

	public void setComposicion(int composicion) {
		this.composicion = composicion;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
	
}
