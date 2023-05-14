<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.*,java.lang.*" %>
<%@ page import="modelo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- ESTILOS -->
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">
<link rel="stylesheet" type="text/css" href="style/styles.css">
<!-- javascript -->
<script src="script/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<h3 id="titulo1" class="px-3"><img alt="capsule" src="img/capsule.svg"> Tratamientos Finalizados</h3>
	<p class="px-3">Estos son los tratamientos que has finalizado. Puedes eliminarlos pulsando en <strong>Eliminar</strong>, pero recuerda!!! Si eliminas alguno definitivamente, no podrás recuperarlo.</p>
	<!-- DIV PARA MENSAJES -->
	<div class="px-3" id="mensajesOk"><p>${mensaje}</p></div>
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
						<th>ELIMINAR</th>
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
								<a  href="Controlador?menu=finalizados&accion=finalizar&idTratamiento=${tratamiento.getIdtratamiento() }&id=${usuario.getIdusuario()}"><img alt="" src="img/delete.svg"> Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

</body>
</html>