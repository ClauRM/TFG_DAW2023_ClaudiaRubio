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
	<!-- javascript -->
	<script src="script/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
	<!--favicon-->
	<link rel="icon" type="image/x-icon" href="img/favicon.ico">
</head>
<body class="h-100">
	<!-- MENU DE NAVEGACION -->
	<nav id="menu" class="navbar navbar-expand-lg navbar-light">
		<div class="container-fluid">
		<a href="ControladorAdmin?menu=home" target="iframe"><img src="img/cronomed.png" alt="" width="50" height="44"></a>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
				<!-- al pulsar sobre cada parte del menu el Controlador se encarga de redirigir y el target se encarga de mostrar la vista en el iframe -->
					<li class="nav-item"><a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="ControladorAdmin?menu=medicamentos" target="iframe">Medicamentos</a></li>
				</ul>
			</div>
			<!-- DESPLEGABLE DE USUARIO -->
			<div style="margin-rigth: 20px" class="dropdown">
				<button id="btn-perfil" class="dropdown-toggle text-uppercase" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">${sessionScope.usuario.getNombre()}</button>
				<ul class="dropdown-menu dropdown-menu-end text-center" aria-labelledby="dropdownMenuButton1">
					<li><a class="dropdown-item" href="#"><img alt="60" width="60" src="img/user.png"></a></li>
    				<li><a class="dropdown-item" href="#">${sessionScope.usuario.getEmail()}</a></li>
    				<li><hr class="dropdown-divider"></li>
    				<!-- FORMULARIO DE SALIDA -->
    				<form action="ValidarAcceso" method="post"> <!-- al pulsar Login se redirecciona al Servlet ValidarAcceso.java -->
    					<input type="submit" class="dropdown-item" name="accion" value="Salir" />
    				</form>
  				</ul>
			</div>
		</div>
	</nav>
	<!-- VENTANA DE ACCIONES -->
	<div style="height: 85%;">
		<div class="h-100">
			<iframe src="homeadmin.jsp"name="iframe" style="height: 100%; width: 100%"></iframe>	
		</div>
	</div>
	<!-- PIE DE PAGINA -->
	    <div>
        	<h6 id="pie" class="text-white pt-2 pb-2">&copy; 2023 Claudia Rubio. Todos los derechos reservados</h6>
    	</div>
</body>
</html>