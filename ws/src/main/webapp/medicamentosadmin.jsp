<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.*,java.lang.*"%>
<%@ page import="modelo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
	<h3 id="titulo1" class="px-3"><img alt="capsule" src="img/capsule.svg"> Listado de Medicamentos</h3>
	<h4 class="px-3">Administrador</h4>
	<p class="px-3">Puedes agregar un nuevo medicamento indicando su nombre y composición, modificar o eliminar un medicamento existente, o filtrar por nombre de medicamento.</p>
	<!-- CONTENEDOR DE FORMULARIO -->
	<form action="ControladorAdmin" method="get"> <!-- se redirecciona al Servlet y actualiza la tabla -->
	<div class="card">
	<div class="row d-flex justify-content-center">
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group mt-3 px-2">
				<input type="text" name="medicamento" value="${medicamento.getMedicamento()}" class="form-control" maxlength=60 placeholder="Nombre y composición del medicamento">	
			</div>
			<!-- BOTONES DE ACCION -->
			<input type="submit" name="accion" value="agregar" class="boton mx-2 mt-2">
			<input type="submit" name="accion" value="actualizar" class="botongris mt-2">
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<!-- FILTRAR -->
			<div class="input-group mt-3 px-2">
	 			<input type="text" class="form-control" placeholder="Filtrar por nombre del medicamento" aria-describedby="button">
	  			<button class="boton" type="button" id="button">Buscar</button>
			</div>
		</div>
		<!-- DIV PARA MENSAJES -->
		<div id="mensajes"><p>${mensaje}</p></div>
	</div>
	</div>
	</form>
	<!-- CONTENEDOR DE TABLA -->
	<div class="col-sm-8 px-3">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>NOMBRE Y COMPOSICION DEL MEDICAMENTO</th>
					<th>MODIFICAR</th>
					<th>ELIMINAR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${medicamentos}" var="medicamento">
					<tr>
						<td class="text-uppercase">${medicamento.getMedicamento()}</td>
						<!-- BOTONES DE ACCION, ademas del menu y la accion del Controlador, le envio el id de tratamiento -->
						<td><a href="ControladorAdmin?accion=modificar&id=${medicamento.getIdmedicamento()}"><img alt="" src="img/edit.svg"> Modificar</a></td>
						<td><a href="ControladorAdmin?accion=eliminar&id=${medicamento.getIdmedicamento()}"><img alt="" src="img/delete.svg"> Eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>