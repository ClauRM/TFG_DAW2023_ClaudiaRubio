<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="h-100">

<head>
<meta charset="ISO-8859-1">
<title>CronoMed</title>
<!-- ESTILOS BOOTSTRAP -->
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">
</head>

<body class="h-100">
	<div
		class="container h-100 d-flex justify-content-center align-items-center">
		<div class="card" style="width: 20rem;">
			<div class="card-img-top d-flex justify-content-center">
				<img src="img/cronomed.png" alt="CronoMed" height="150" width="150">
			</div>
			<div class="card-body">
				<h4 class="card-title text-center">Iniciar Sesión</h4>
				<!-- FORMULARIO DE ACCESO -->
				<form action="ValidarAcceso" method="post"> <!-- al pulsar Login se redirecciona al Servlet ValidarAcceso.java -->
					<div class="mb-3">
						<label for="inputemail" class="form-label">Correo electrónico</label> 
						<input id="inputemail" name="email" type="email" class="form-control"/>
					</div>
					<div class="mb-3">
						<label for="inputpass" class="form-label">Contraseña</label> <input
							id="inputpass" name="pass" type="password" class="form-control" maxlength=6/>
					</div>
					<div class="text-center">
						<input type="submit" class="btn btn-primary me-2" name="accion" value="Login"/>
						</div>
					<div class="border-top text-center mt-3">
						<p>¿No estás registrado?</p>
						<a class="btn btn-secondary" href="registro.jsp">Registrarse</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>