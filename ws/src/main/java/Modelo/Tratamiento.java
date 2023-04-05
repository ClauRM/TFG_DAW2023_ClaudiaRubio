package Modelo;

public class Tratamiento {

	private int idtratamiento;
	private int fidusuario;
	private int fidmedicamento;
	private String paciente;
	private int dosis;
	private int horas;
	private String tratamiento;
	private String observaciones;
	private int activo; //activo = 1 | inactivo = 0
	
	//objetos relacionados con el tratamiento
	private Medicamento medicamento;
	private Usuario usuario;
	
	
	public Tratamiento() {
		super();
	}
	
	public Tratamiento(int idtratamiento, int fidusuario, int fidmedicamento, String paciente, int dosis, int horas,
			String tratamiento, String observaciones, int activo) {
		super();
		this.idtratamiento = idtratamiento;
		this.fidusuario = fidusuario;
		this.fidmedicamento = fidmedicamento;
		this.paciente = paciente;
		this.dosis = dosis;
		this.horas = horas;
		this.tratamiento = tratamiento;
		this.observaciones = observaciones;
		this.activo = activo;
	}


	public Tratamiento(int fidusuario, int fidmedicamento, String paciente, int dosis, int horas, String tratamiento,
			String observaciones, int activo) {
		super();
		this.fidusuario = fidusuario;
		this.fidmedicamento = fidmedicamento;
		this.paciente = paciente;
		this.dosis = dosis;
		this.horas = horas;
		this.tratamiento = tratamiento;
		this.observaciones = observaciones;
		this.activo = activo;
	}
	
	public Tratamiento(int fidusuario, int fidmedicamento, String paciente, int dosis, int horas, String tratamiento,
			String observaciones, int activo, Medicamento medicamento, Usuario usuario) {
		super();
		this.fidusuario = fidusuario;
		this.fidmedicamento = fidmedicamento;
		this.paciente = paciente;
		this.dosis = dosis;
		this.horas = horas;
		this.tratamiento = tratamiento;
		this.observaciones = observaciones;
		this.activo = activo;
		this.medicamento = medicamento;
		this.usuario = usuario;
	}
	
	public Tratamiento(int idtratamiento, int fidusuario, int fidmedicamento, String paciente, int dosis, int horas,
			String tratamiento, String observaciones,int activo, Medicamento medicamento, Usuario usuario) {
		super();
		this.idtratamiento = idtratamiento;
		this.fidusuario = fidusuario;
		this.fidmedicamento = fidmedicamento;
		this.paciente = paciente;
		this.dosis = dosis;
		this.horas = horas;
		this.tratamiento = tratamiento;
		this.observaciones = observaciones;
		this.activo = activo;
		this.medicamento = medicamento;
		this.usuario = usuario;
	}

	public int getIdtratamiento() {
		return idtratamiento;
	}

	public void setIdtratamiento(int idtratamiento) {
		this.idtratamiento = idtratamiento;
	}

	public int getFidusuario() {
		return fidusuario;
	}

	public void setFidusuario(int fidusuario) {
		this.fidusuario = fidusuario;
	}

	public int getFidmedicamento() {
		return fidmedicamento;
	}

	public void setFidmedicamento(int fidmedicamento) {
		this.fidmedicamento = fidmedicamento;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
		
}
