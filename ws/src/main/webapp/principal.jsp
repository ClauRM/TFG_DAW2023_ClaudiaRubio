<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="ISO-8859-1">
<title>CronoMed</title>
<!-- estilos bootstrap -->
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">
<!-- javascript -->
<script src="script/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="h-100">
	<!-- MENU DE NAVEGACION -->
	<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<div class="container-fluid">
			<img src="" alt="" width="30" height="24">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#">CronoMed</a></li>
					<li class="nav-item"><a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#">Medicamentos</a></li>
					<li class="nav-item"><a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#">Nuevo tratamiento</a></li>
					<li class="nav-item"><a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#">Tratamientos en curso</a></li>
				</ul>
			</div>
			<!-- DESPLEGABLE DE USUARIO -->
			<div style="margin-rigth: 20px" class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">${usuario.getNombre()}</button>
				<ul class="dropdown-menu dropdown-menu-end text-center" aria-labelledby="dropdownMenuButton1">
					<li><a class="dropdown-item" href="#"><img alt="60" width="60" src="img/user.png"></a></li>
    				<li><a class="dropdown-item" href="#">usuario</a></li>
    				<li><hr class="dropdown-divider"></li>
    				<li><a class="dropdown-item" href="#">Salir</a></li>
  				</ul>
			</div>
		</div>
	</nav>
</body>
</html>