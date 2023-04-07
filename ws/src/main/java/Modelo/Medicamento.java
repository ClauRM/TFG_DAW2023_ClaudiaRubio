package Modelo;

public class Medicamento {
	
	private int idmedicamento;
	private String medicamento;
	
	public Medicamento() {
		super();
	}

	public Medicamento(int idmedicamento, String medicamento) {
		super();
		this.idmedicamento = idmedicamento;
		this.medicamento = medicamento;
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
	
	
}
