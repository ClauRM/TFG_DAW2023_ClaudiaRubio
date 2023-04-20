<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.*,java.lang.*" %>
<%@ page import="modelo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 
 List<Tratamiento> lista = request.getAttribute("tratamientos");
 Iterator<Tratamiento> itTratamientos =lista.iterator();
-->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CronoMed</title>
<!-- ESTILOS -->
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">
<link rel="stylesheet" type="text/css" href="style/styles.css">
<!-- javascript -->
<script src="script/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h3 id="titulo1" class="px-3">Nuevo tratamiento</h3>
	<p class="px-3">Aquí podrás gestionar tus tratamientos médicos. Puedes registrar un nuevo tratamiento, modificar los existentes o eliminar alguno si ya lo has finalizado. <br>Rellena todos los campos del formulario para registrar un nuevo tratamiento y pulsa en Agregar</p>
	<div class="d-flex">
		<!-- CONTENEDOR DEL FORMULARIO -->
		<div class="card col-sm-4 px-3">
			<div class="card-body">
				<form action="Controlador" method="get"> <!-- se redirecciona al Servlet y actualiza la tabla -->
					<div class="form-group">
					<!-- DIV PARA MENSAJES -->
					<div id="mensajes"><p>${mensaje}</p></div>
						<label>Selecciona un medicamento</label>
						<!-- SELECT QUE OBTIENE LOS DATOS DE LA BD -->
						<select name="idmedicamento" class="form-select">
							<c:forEach items="${medicamentos}" var="medicamento">
						  		<option class="text-uppercase" value="${medicamento.getIdmedicamento()}">${medicamento.getMedicamento()}</option>
						  	</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Nombre del paciente</label>
						<input type="text" name="paciente" value="${tratamiento.getPaciente()}" class="form-control" maxlength=20 placeholder="Escribe el nombre del paciente">	
					</div>
					<div class="form-group">
						<label>Dosis en unidades</label>
						<input type="number" name="dosis" value="${tratamiento.getDosis()}" class="form-control" min=1 max=30 placeholder="Dosis del tratamiento en unidades">	
					</div>
					<div class="form-group">
						<label>Pauta en horas</label>
						<input type="number" name="horas" value="${tratamiento.getHoras()}" class="form-control" min=1 max=24 placeholder="¿Cada cuántas horas se debe tomar?">	
					</div>	
					<div class="form-group">
						<label>Duración en días</label>
						<input type="number" name="duracion" value="${tratamiento.getDuracion()}" class="form-control" min=1 max=15 placeholder="¿Cuántos días dura el tratamiento?">	
					</div>	
					<div class="form-group">
						<label>Observaciones</label>
						<input type="text" name="observaciones" value="${tratamiento.getObservaciones()}" class="form-control" maxlength=50 placeholder="Añade alguna observación">	
					</div>	
					<div class="form-group">
						<input type="hidden" name="id" value="${sessionScope.usuario.getIdusuario()}" class="form-control" maxlength=50>	
					</div>	
					<input type="hidden" name="menu" value="enCurso"><!-- opcion del menu en el servlet -->
					<!-- BOTONES DE ACCION -->
					<input type="submit" name="accion" value="agregar" class="boton mt-3">
					<input type="submit" name="accion" value="actualizar" class="botongris mt-3">
								
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
						<th>DURACION</th>
						<th>OBSERVACIONES</th>
						<th>ACCIONES</th>
					</tr>
				</thead>
				<tbody>
                	<c:forEach items="${tratamientos}" var="tratamiento">
						<tr>
							<td class="text-uppercase">${tratamiento.getMedicamento().getMedicamento()} </td>
							<td>${tratamiento.getPaciente()} </td>
							<td>${tratamiento.getDosis()} </td>
							<td>Cada ${tratamiento.getHoras()} hrs.</td>
							<td>${tratamiento.getDuracion()} días</td>
							<td>${tratamiento.getObservaciones()} </td>
							<td>
								<!-- en los botones, ademas del menu y la accion del Controlador, le envio el id de tratamiento -->
								<a  href="Controlador?menu=enCurso&accion=modificar&idTratamiento=${tratamiento.getIdtratamiento() }&id=${usuario.getIdusuario()}">Modificar</a>
								<a  href="Controlador?menu=enCurso&accion=finalizar&idTratamiento=${tratamiento.getIdtratamiento() }&id=${usuario.getIdusuario()}">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>