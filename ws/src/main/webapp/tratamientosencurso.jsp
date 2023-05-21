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
	<h3 id="titulo1" class="px-3"><img alt="capsule" src="img/capsule.svg"> Registro de Tratamientos</h3>
	<p class="px-3">&#187; Registra un nuevo tratamiento: completa el formulario y pulsa en <strong>Agregar</strong><br>&#187; Modifica un tratamiento existente: selecciónalo en la lista pulsando <strong>Modificar</strong>, modifica sus datos en el formulario y pulsa <strong>Actualizar</strong><br>&#187; Finaliza un tratamiento existente: pulsa a la izquierda del tratamiento, en el botón <strong>Finalizar</strong> </p>
	<div class="d-flex row">
		<!-- CONTENEDOR DEL FORMULARIO -->
		<div class="card col-lg-3 col-sm-12 px-3">
			<div class="card-body">
				<form action="Controlador" method="get"> <!-- se redirecciona al Servlet y actualiza la tabla -->
					<div class="form-group">
					<!-- DIV PARA MENSAJES -->
					<div id="mensajes"><p>${mensaje}</p></div>
					<div id="mensajesOk"><p>${mensajeOk}</p></div>
						<label>Selecciona un medicamento</label>
						<!-- SELECT QUE OBTIENE LOS DATOS DE LA BD -->
						<select name="idmedicamento" class="form-select text-uppercase">
							<c:forEach items="${medicamentos}" var="medicamento">
						  		<option value="${medicamento.getIdmedicamento()}" class="text-uppercase">${medicamento.getMedicamento()}</option>
						  	</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Nombre del paciente</label>
						<input type="text" name="paciente" value="${tratamiento.getPaciente()}" class="form-control" maxlength=30 placeholder="Escribe el nombre del paciente" required>	
					</div>
					<div class="form-group">
						<label>Dosis en unidades (máx. 30)</label>
						<input type="number" name="dosis" value="${tratamiento.getDosis()}" class="form-control" min=1 max=30 placeholder="¿Cuál es la dosis?" required>	
					</div>
					<div class="form-group">
						<label>Pauta en horas</label>
						<input type="number" name="horas" value="${tratamiento.getHoras()}" class="form-control" min=1 max=24 placeholder="¿Cada cuántas horas?" required>	
					</div>	
					<div class="form-group">
						<label>Duración en días (máx. 15)</label>
						<input type="number" name="duracion" value="${tratamiento.getDuracion()}" class="form-control" min=1 max=15 placeholder="¿Durante cuántos días?" required>	
					</div>	
					<div class="form-group">
						<label>Observaciones</label>
						<input type="text" name="observaciones" value="${tratamiento.getObservaciones()}" class="form-control" maxlength=50 placeholder="Añade alguna observación">	
					</div>	
					<div class="form-group">
						<input type="hidden" name="id" value="${sessionScope.usuario.getIdusuario()}">
						<input type="hidden" name="inicio" value="${tratamiento.getInicio()}">		
					</div>	
					<input type="hidden" name="menu" value="enCurso"><!-- opcion del menu en el servlet -->
					<!-- BOTONES DE ACCION -->
					<input type="submit" name="accion" value="agregar" class="boton mt-3">
					<input type="submit" name="accion" value="actualizar" class="botongris mt-3">
								
				</form>
			</div>
		</div>
		<!-- CONTENEDOR DE LA TABLA -->
		<div class="col-lg-9 col-sm-12 px-3">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>MEDICAMENTO</th>
						<th>PACIENTE</th>
						<th>DOSIS</th>
						<th>PAUTA</th>
						<th>DURACION</th>
						<th>OBSERVACIONES</th>
						<th>MODIFICAR</th>
						<th>FINALIZAR</th>
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
							<!-- BOTONES DE ACCION, ademas del menu y la accion del Controlador, le envio el id de tratamiento -->
							<td><a  href="Controlador?menu=enCurso&accion=modificar&idTratamiento=${tratamiento.getIdtratamiento() }&id=${sessionScope.usuario.getIdusuario()}"><img alt="" src="img/edit.svg"> Modificar</a></td>
							<td><a  href="Controlador?menu=enCurso&accion=finalizar&idTratamiento=${tratamiento.getIdtratamiento() }&id=${sessionScope.usuario.getIdusuario()}"><img alt="" src="img/archive.svg"> Finalizar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>