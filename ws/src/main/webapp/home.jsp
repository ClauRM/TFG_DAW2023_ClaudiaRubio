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
			<br>CronoMed
		</h1>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
			eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
			ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
			aliquip ex ea commodo consequat. Duis aute irure dolor in
			reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
			pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
			culpa qui officia deserunt mollit anim id est laborum</p>
		<div class="row w-100">
		<!-- TARJETAS -->
			<div id="tarjeta" class="col-lg-3 col-md-6">
				<a href="Controlador?menu=medicamentos">
					<div class="card h-100 d-flex align-items-center" style="width: 18rem;">
						<div class="card-body">
							<h5 class="card-title">Título de la tarjeta</h5>
							<h6 class="card-subtitle mb-2 text-muted">Medicamentos</h6>
							<p class="card-text">Accede al listado completo de medicamentos disponibles</p>
						</div>
					</div>
				</a>
			</div>
			<!-- TARJETAS -->
			<div id="tarjeta" class="col-lg-3 col-md-6">
				<a
					href="Controlador?menu=enCurso&accion=listar&id=${sessionScope.usuario.getIdusuario()}">gestion</a>
			</div>
			<!-- TARJETAS -->
			<div id="tarjeta" class="col-lg-3 col-md-6">
				<a
					href="Controlador?menu=recetas&accion=listar&id=${sessionScope.usuario.getIdusuario()}">en
					curso</a>
			</div>
			<!-- TARJETAS -->
			<div id="tarjeta" class="col-lg-3 col-md-6">
				<a
					href="Controlador?menu=finalizados&accion=listar&id=${sessionScope.usuario.getIdusuario()}">finalizados</a>
			</div>

		</div>
	</div>
</body>
</html>