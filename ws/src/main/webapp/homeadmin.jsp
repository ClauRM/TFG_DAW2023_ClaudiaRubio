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
 		<img style="height: 20%;" src="img/CronoMed-removebg.png" alt="cronomed" >
 		<h3>Hola Administrador, ${sessionScope.usuario.getNombre()}</h3>
		<!-- DESCRIPCION -->
		<p>Desde la opción de medicamentos podrás realizar el Mantenimiento de la tabla Medicamentos que estará disponible para los usuarios de la aplicación. 
		</p> <br><br>
		<!-- CONTENEDOR TARJETAS -->
		<div id="row-tarjetas" class="row w-100 m-0">
		<!-- TARJETAS -->
			<div id="container-tarjeta" class="col-lg-3 col-md-6 col-sm-12">
				<a href="ControladorAdmin?menu=medicamentos&accion=listar">
					<div id="tarjeta" class="card" style="width: 18rem;">
						<div class="card-body">
							<img id="img-tarjeta" class="my-3" style="height: 20%;" src="img/capsule.svg" alt="capsule" >
							<h5 class="card-subtitle mb-2 text-muted">Medicamentos</h5>
							<p class="card-text">Añadir, modificar y eliminar medicamentos para los usuarios de la app</p>
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