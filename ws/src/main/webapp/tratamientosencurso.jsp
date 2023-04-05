<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CronoMed</title>
<!-- estilos bootstrap -->
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">
<!-- javascript -->
<script src="script/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h3 class="px-3">Nuevo tratamiento</h3>
	<p class="px-3">Para iniciar un nuevo tratamiento, cumplimente los campos del formulario y pulse en Añadir</p>
	<div class="d-flex">
		<!-- CONTENEDOR DEL FORMULARIO -->
		<div class="card col-sm-4 px-3">
			<div class="card-body">
				<form action="">
					<div class="form-group">
						<label>Medicamento</label>
						<input type="text" name="medicamento" class="form-control">		
						<input type="hidden" name="idMedicamento" class="form-control">	
					</div>
					<div class="form-group">
						<label>Paciente</label>
						<input type="text" name="paciente" class="form-control">	
					</div>
					<div class="form-group">
						<label>Dosis</label>
						<input type="number" name="dosis" class="form-control">	
					</div>
					<div class="form-group">
						<label>Pauta horaria</label>
						<input type="number" name="horas" class="form-control">	
					</div>	
					<div class="form-group">
						<label>Observaciones</label>
						<input type="text" name="observaciones" class="form-control">	
					</div>	
					<input type="submit" name="accion" value="Añadir" class="btn btn-primary mt-3">			
				</form>
			</div>
		</div>
		<!-- CONTENEDOR DE LA TABLA -->
		<div class="col-sm-8 px-3">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>MEDICAMENTO</th>
						<th>PACIENTE</th>
						<th>DOSIS</th>
						<th>PAUTA</th>
						<th>OBSERVACIONES</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>