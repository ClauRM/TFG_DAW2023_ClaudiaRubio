<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="ISO-8859-1">
<title>CronoMed</title>
<!-- ESTILOS -->
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">
<link rel="stylesheet" type="text/css" href="style/styles.css">
<!--favicon-->
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>

<body class="h-100">
	<div id="fondo" class="h-100 text-center">
		<h1>
			<br>CronoMed<br>
		</h1>
		<h3>ESTOY EN MENU ADMINISTRADOR</h3>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
			eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
			ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
			aliquip ex ea commodo consequat. Duis aute irure dolor in
			reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
			pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
			culpa qui officia deserunt mollit anim id est laborum</p> <br><br>
		<div class="row w-100 d-flex justify-content-center align-items-center">
		<!-- TARJETAS -->
			<div class="col-lg-3 col-md-4">
				<a href="ControladorAdmin?menu=medicamentos">
					<div id="tarjeta" class="card h-100 d-flex align-items-center" style="width: 18rem;">
						<div class="card-body">
							<img id="img-tarjeta" class="my-3" style="height: 20%;" src="img/capsule.svg" alt="capsule" >
							<h5 class="card-subtitle mb-2 text-muted">Medicamentos</h5>
							<p class="card-text">Añadir, modificar y eliminar medicamentos disponibles que serán visibles a los usuarios de la app</p>
						</div>
					</div>
				</a>
			</div>
					</div>
	</div>
</body>
</html>