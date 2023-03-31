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
		<div class="card" style="width: 18rem;">
			<h4 class="card-title text-center mt-2">Bienvenido a CronoMed</h4>
			<img src="..." class="card-img-top" alt="CronoMed">
			<div class="card-body">
				<h5 class="card-title text-center">Login</h5>
				<p class="card-text">
					Si ya estás registrado, accede con tu usuario y password, haciendo
					click en Login.<br>Si eres nuevo usuario regístrate haciendo
					click en Registro.
				</p>
				<form>
					<div class="mb-3">
						<label for="inputuser" class="form-label">Usuario</label> <input
							id="inputuser" name="user" type="text" class="form-control">
					</div>
					<div class="mb-3">
						<label for="inputpass" class="form-label">Contraseña</label> <input
							id="inputpass" name="pass" type="password" class="form-control">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary me-2">Login</button>
						<button type="submit" class="btn btn-primary">Registro</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>