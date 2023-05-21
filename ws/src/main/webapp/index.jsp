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

<body id="fondo" class="h-100">
	<div class="container h-100 d-flex justify-content-center align-items-center">
		<div id="card" class="card row d-flex justify-content-center align-items-center">
		<!-- COLUMNA IZQUIERDA -->
			<div class="col-md-8 col-lg-6">
       			 <img src="img/cronomed.png" class="img-fluid" alt="CronoMed">
       			 <!-- LEMA -->
				<p id="lema">Tu tratamiento médico bajo control</p>
      		</div>
		<!-- COLUMNA DERECHA -->
			<div class="col-md-8 col-lg-6">
			<div class="card-body">
				<h1 class="card-title text-center border-bottom mb-3 pb-3">Bienvenido</h1>
				<!-- FORMULARIO DE ACCESO -->
				<form action="ValidarAcceso" method="post"> <!-- al pulsar Login se redirecciona al Servlet ValidarAcceso.java -->
					<div class="mb-3">
						<label for="inputemail" class="form-label">Correo electrónico</label> 
						<input id="inputemail" name="email" type="email" class="form-control" maxlength=50 placeholder="Escribe tu dirección de email" required/>
					</div>
					<div class="mb-3">
						<label for="inputpass" class="form-label">Contraseña</label> <input
							id="inputpass" name="pass" type="password" class="form-control" maxlength=6 placeholder="Escribe tu password" required/>
					</div>
					
					<!-- DIV PARA MENSAJES -->
					<div id="mensajes"><p>${mensaje}</p></div>
					<div id="mensajesOk"><p>${mensajeOk}</p></div>
					<!-- BOTON DE LOGIN -->
					<div class="text-center">
						<input type="submit" class="boton" name="accion" value="Login"/>
					</div>
					<!-- LINK A LA VENTANA DE REGISTRO PARA NUEVOS USUARIOS -->
					<div class="border-top mt-3 pt-3">
						<p>¿No estás registrado?  <a id="link" href="registro.jsp">Nuevo Registro</a></p>
					</div>
				</form>
			</div>
			</div>
		</div>
	</div>
	
	
	
</body>

</html>