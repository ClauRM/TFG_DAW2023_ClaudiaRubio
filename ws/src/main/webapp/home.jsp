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
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
			eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
			ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
			aliquip ex ea commodo consequat. Duis aute irure dolor in
			reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
			pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
			culpa qui officia deserunt mollit anim id est laborum</p> <br><br>
		<div class="row w-100 d flex align-items-center">
		<!-- TARJETAS -->
			<div class="col-lg-3 col-md-6">
				<a href="Controlador?menu=medicamentos">
					<div id="tarjeta" class="card h-100 d-flex align-items-center" style="width: 18rem;">
						<div class="card-body">
							<img id="img-tarjeta" class="my-3" style="height: 20%;" src="img/capsule.svg" alt="capsule" >
							<h5 class="card-subtitle mb-2 text-muted">Medicamentos</h5>
							<p class="card-text">Accede al listado completo de todos los medicamentos disponibles</p>
						</div>
					</div>
				</a>
			</div>
			<!-- TARJETAS -->
			<div class="col-lg-3 col-md-6">
				<a href="Controlador?menu=enCurso&accion=listar&id=${sessionScope.usuario.getIdusuario()}">
					<div id="tarjeta" class="card h-100 d-flex align-items-center" style="width: 18rem;">
						<div class="card-body">
							<img id="img-tarjeta" class="my-3" style="height: 20%;" src="img/clipboard-gestion.svg" alt="capsule" >
							<h5 class="card-subtitle mb-2 text-muted">Nuevo tratamiento</h5>
							<p class="card-text">Crea un nuevo tratamiento, modifica o elimínalo al finalizar</p>
						</div>
					</div>
				</a>
			</div>
			<!-- TARJETAS -->
			<div class="col-lg-3 col-md-6">
				<a href="Controlador?menu=recetas&accion=listar&id=${sessionScope.usuario.getIdusuario()}">
				<div id="tarjeta" class="card h-100 d-flex align-items-center" style="width: 18rem;">
						<div class="card-body">
							<img id="img-tarjeta" class="my-3" style="height: 20%;" src="img/heard-curso.svg" alt="capsule" >
							<h5 class="card-subtitle mb-2 text-muted">En curso</h5>
							<p class="card-text">Realiza un seguimiento todos los tratamientos que tienes en curso</p>
						</div>
					</div>
				</a>
			</div>
			<!-- TARJETAS -->
			<div class="col-lg-3 col-md-6">
				<a href="Controlador?menu=finalizados&accion=listar&id=${sessionScope.usuario.getIdusuario()}">
				<div id="tarjeta" class="card h-100 d-flex align-items-center" style="width: 18rem;">
						<div class="card-body">
							<img id="img-tarjeta" class="my-3" style="height: 20%;" src="img/clipboard-fin.svg" alt="capsule" >
							<h5 class="card-subtitle mb-2 text-muted">Finalizados</h5>
							<p class="card-text">Revisa todos los tratamientos que has finalizado para limpiar tu perfil</p>
						</div>
					</div>
				</a>
			</div>

		</div>
	</div>
</body>
</html>