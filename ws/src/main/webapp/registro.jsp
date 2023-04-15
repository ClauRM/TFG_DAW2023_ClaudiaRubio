<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="h-100">

<head>
<meta charset="ISO-8859-1">
<title>CronoMed</title>
<!-- estilos bootstrap -->
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">
<link rel="stylesheet" type="text/css" href="style/styles.css">
</head>

<body class="h-100">
	<div
		class="container h-100 d-flex justify-content-center align-items-center">
		<!-- CARD DE NUEVO REGISTRO DE USUARIO -->
		<div id="card" class="card row d-flex justify-content-center align-items-center">
			<!-- COLUMNA IZQUIERDA -->
			<div class="col-md-8 col-lg-6">
       			 <img src="img/cronomed.png" class="img-fluid" alt="Sample image">
       			 <!-- LEMA -->
				<p id="lema">Tu tratamiento médico bajo control</p>
      		</div>
      		<!-- COLUMNA IZQUIERDA -->
			<div class="col-md-8 col-lg-6">		
				<div class="card-body">
				<h2 class="card-title text-center border-bottom mb-3 pb-3">Formulario de Registro</h2>
				<!-- DESARROLLAR NUEVO USUARIO CON SERVLET EN EL ACTION -->
				<form action="ValidarAcceso" method="post"> 
					<div class="mb-2">
						<label for="inputuser" class="form-label">Nombre de usuario</label> 
						<input id="inputuser" name="usuario" type="text" placeholder="Escribe un nombre de usuario para tu perfil" class="form-control" />
					</div>
					<div class="mb-2">
						<label for="inputemail" class="form-label">Email</label> 
						<input id="inputemail" name="email" type="text" placeholder="Escribe tu dirección de email" class="form-control" />
					</div>
					<div class="mb-2">
						<label for="inputpass" class="form-label">Contraseña</label> 
						<input id="inputpass" name="pass" type="password" placeholder="Escribe una password para tu acceso" class="form-control" aria-describedby="inputpass1" maxlength=6 />
						<div id="inputpass1" class="form-text">Escribe una clave de 6 caracteres</div>
					</div>
					<div class="d-flex justify-content-center">
						<input type="submit" class="boton" name="accion" value="Registro" />
					</div>
					<!-- LINK A LA VENTANA DE LOGIN PARA USUARIOS REGISTRADOS -->
					<div class="border-top mt-3 pt-3">
						<p>Si ya estás registrado, haz click en <a id="link" href="index.jsp">Login</a></p>
					</div>
				</form>
			</div>
			</div>
		</div>
	</div>
</body>

</html>