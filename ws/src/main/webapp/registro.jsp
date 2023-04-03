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
				<h5 class="card-title text-center">Registro de nuevo usuario</h5>
				<p class="card-text">Regístrate con un nombre de usuario y
					password.</p>
				<form action="" method="post">
					<div class="mb-3">
						<label for="inputuser" class="form-label">Usuario</label> <input
							id="inputuser" name="user" type="text" class="form-control" />
					</div>
					<div class="mb-3">
						<label for="inputpass" class="form-label">Contraseña</label> <input
							id="inputpass" name="pass" type="password" class="form-control"
							aria-describedby="inputpass1" maxlength=6 />
						<div id="inputpass1" class="form-text">Teclea una clave de 6
							caracteres</div>
					</div>
					<div class="d-flex justify-content-center">
						<input type="submit" class="btn btn-primary me-2" value="Registro" />
					</div>

					<div class="border-top mt-3">
						<p class="card-text">Si ya estás registrado, accede haciendo Login.</p>
					</div>
					<div class="d-flex justify-content-center">
						<a class="text-center btn btn-primary mt-3" href="index.jsp">Login</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>