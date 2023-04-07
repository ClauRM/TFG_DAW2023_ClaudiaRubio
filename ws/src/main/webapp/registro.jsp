<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="h-100">

<head>
<meta charset="ISO-8859-1">
<title>CronoMed</title>
<!-- estilos bootstrap -->
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">
</head>

<body class="h-100">
	<div
		class="container h-100 d-flex justify-content-center align-items-center">
		<!-- CARD DE NUEVO REGISTRO DE USUARIO -->
		<div class="card" style="width: 20rem;">
			<div class="card-img-top d-flex justify-content-center">
				<img src="img/cronomed.png" alt="CronoMed" height="150" width="150">
			</div>
			<div class="card-body">
				<h4 class="card-title text-center">Registro de nuevo usuario</h4>
				<!-- DESARROLLAR NUEVO USUARIO CON SERVLET EN EL ACTION -->
				<form action="ValidarAcceso" method="post"> 
					<div class="mb-2">
						<label for="inputuser" class="form-label">Usuario</label> 
						<input id="inputuser" name="usuario" type="text" class="form-control" />
					</div>
					<div class="mb-2">
						<label for="inputemail" class="form-label">Email</label> 
						<input id="inputemail" name="email" type="text" class="form-control" />
					</div>
					<div class="mb-2">
						<label for="inputpass" class="form-label">Contraseña</label> 
						<input id="inputpass" name="pass" type="password" class="form-control" aria-describedby="inputpass1" maxlength=6 />
						<div id="inputpass1" class="form-text">Teclea una clave de 6 caracteres</div>
					</div>
					<div class="d-flex justify-content-center">
						<input type="submit" class="btn btn-primary me-2" name="accion" value="Registro" />
					</div>
					<!-- LINK A LA VENTANA DE LOGIN PARA USUARIOS REGISTRADOS -->
					<div class="border-top text-center mt-3">
						<p>Si ya estás registrado, haz Login</p>
						<a class="text-center btn btn-secondary" href="index.jsp">Login</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>