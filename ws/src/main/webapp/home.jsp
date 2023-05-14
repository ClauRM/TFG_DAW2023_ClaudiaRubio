<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>CronoMed</title>
<!-- ESTILOS -->
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">
<link rel="stylesheet" type="text/css" href="style/styles.css">
<!--favicon-->
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>

<body class="h-100">
	<div id="fondo" class="h-100 text-center">
		<img style="height: 20%;" src="img/CronoMed-removebg.png" alt="cronomed" >
		<p>CronoMed es una aplicaci&oacute;n web que te permitir&aacute; gestionar un tratamiento m&eacute;dico de forma <strong>sencilla.</strong>
		S&iacute;, mucho &eacute;nfasis en la palabra &#171;sencilla&#187;...<br>Solo te pediremos que introduzcas pocos datos para que tengas el control completo sobre tus tratamientos m&eacute;dicos.<br>
		Te daremos la mayor eficacia y la tranquilidad para que finalices tus tratamientos de forma segura.</p> <br><br>
		<!-- CONTENEDOR TARJETAS -->
		<div id="contenedortarjeta" class="row w-100 d-flex justify-content-center align-items-center">
		<!-- TARJETAS -->
			<div class="col-lg-3 col-md-4">
				<a href="Controlador?menu=medicamentos">
					<div id="tarjeta" class="card" style="width: 18rem;">
						<div class="card-body">
							<img id="img-tarjeta" class="my-3" style="height: 20%;" src="img/capsule.svg" alt="capsule" >
							<h5 class="card-subtitle mb-2 text-muted">Medicamentos</h5>
							<p class="card-text">Accede al listado completo de todos los medicamentos disponibles</p>
						</div>
					</div>
				</a>
			</div>
			<!-- TARJETAS -->
			<div class="col-lg-3 col-md-4">
				<a href="Controlador?menu=enCurso&accion=listar&id=${sessionScope.usuario.getIdusuario()}">
					<div id="tarjeta" class="card" style="width: 18rem;">
						<div class="card-body">
							<img id="img-tarjeta" class="my-3" style="height: 20%;" src="img/clipboard-gestion.svg" alt="capsule" >
							<h5 class="card-subtitle mb-2 text-muted">Registro</h5>
							<p class="card-text">Crea un nuevo tratamiento, modifica o elim&#237;nalo al finalizar</p>
						</div>
					</div>
				</a>
			</div>
			<!-- TARJETAS -->
			<div class="col-lg-3 col-md-4">
				<a href="Controlador?menu=recetas&id=${sessionScope.usuario.getIdusuario()}">
				<div id="tarjeta" class="card" style="width: 18rem;">
						<div class="card-body">
							<img id="img-tarjeta" class="my-3" style="height: 20%;" src="img/heard-curso.svg" alt="capsule" >
							<h5 class="card-subtitle mb-2 text-muted">En curso</h5>
							<p class="card-text">Realiza un seguimiento todos los tratamientos que tienes en curso</p>
						</div>
					</div>
				</a>
			</div>
			<!-- TARJETAS -->
			<div class="col-lg-3 col-md-4">
				<a href="Controlador?menu=finalizados&accion=listar&id=${sessionScope.usuario.getIdusuario()}">
				<div id="tarjeta" class="card" style="width: 18rem;">
						<div class="card-body">
							<img id="img-tarjeta" class="my-3" style="height: 20%;" src="img/clipboard-fin.svg" alt="capsule" >
							<h5 class="card-subtitle mb-2 text-muted">Finalizados</h5>
							<p class="card-text">Revisa todos los tratamientos que has finalizado para limpiar tu perfil</p>
						</div>
					</div>
				</a>
			</div>
		</div>
		<!-- LEMA -->
		<div class="mt-4"><p id="lema">Tu tratamiento m&eacute;dico bajo control</p></div>		
	</div>
</body>
</html>