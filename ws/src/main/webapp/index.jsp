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
		<div class="card" style="width: 24rem;">
			<h4 class="card-title text-center mt-2">Bienvenido a CronoMed</h4>
			<img src="..." class="card-img-top" alt="CronoMed">
			<div class="card-body">
				<h5 class="card-title text-center">Login</h5>
				<p class="card-text">
					Si ya estás registrado, accede con tu usuario y password, haciendo
					click en Login.<br>Si eres nuevo usuario regístrate haciendo
					click en Registro.
				</p>
				<!-- FORMULARIO DE ACCESO -->
				<form action="ValidarAcceso" method="post"> <!-- al pulsar Login se redirecciona al Servlet ValidarAcceso.java -->
					<div class="mb-3">
						<label for="inputuser" class="form-label">Usuario</label> <input
							id="inputuser" name="usuario" type="text" class="form-control"/>
					</div>
					<div class="mb-3">
						<label for="inputpass" class="form-label">Contraseña</label> <input
							id="inputpass" name="pass" type="password" class="form-control" maxlength=6/>
					</div>
					<div class="text-center">
						<input type="submit" class="btn btn-primary me-2" name="accion" value="Login"/>
						<a class="btn btn-primary" href="registro.jsp">Registro</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>