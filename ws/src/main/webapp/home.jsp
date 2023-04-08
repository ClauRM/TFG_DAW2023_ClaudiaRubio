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
	<div class="container-fluid">
		<div class="d-flex justify-content-center align-items-center">
			<img src="img/cronomed.png" alt="CronoMed" height="80">
			<h1 class="text-center">Bienvenido a CronoMed</h1>
		</div>
		<div class="text-center">
			<h3>Hola ${sessionScope.usuario}</h3><!-- para acceder a la sesion del usuario -->
			<p>¿Qué acción deseas realizar?</p>
		</div>
    	<div class="d-flex flex-column border col-3 mx-auto">
        		<a class="btn btn-outline-primary m-1" for="btncheck1" href="medicamentos.jsp">LISTADO DE MEDICAMENTOS</a>
        		<a class="btn btn-outline-primary m-1" for="btncheck1" href="tratamientosencurso.jsp">GESTION DE TRATAMIENTOS</a>
        		<a class="btn btn-outline-primary m-1" for="btncheck1" href="tratamientosfinalizados.jsp">TRATAMIENTOS FINALIZADOS</a>
  		 </div>
    	<!--opcion salir de la pagina-->
    	<form action="ValidarAcceso" method="post"> <!-- al pulsar Login se redirecciona al Servlet ValidarAcceso.java -->
    		<div class="text-center my-3 border">
	       		<p>Si no deseas realizar ninguna acción, pulsa para cerrar la sesión</p>
	        	<input type="submit" class="btn btn-secondary my-3" name="accion" value="Salir" />
   		</div>
    	</form>
	</div>
</body>
</html>