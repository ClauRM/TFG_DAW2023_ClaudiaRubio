<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	//valores capturador del formulario
	String usuario = request.getParameter("newusuario");
	String pass = request.getParameter("newpass");
	
	//indicar en tiempo de ejecucion donde esta la libreria
	Class.forName("com.mysql.jdbc.Driver");
	
	//realizar la conexion a la bd
	java.sql.Connection conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/cronomedbd", "root", "");
		
	//crear la sentencia
	java.sql.Statement sentencia = conexion.createStatement();
	
	//escribir la consulta
	String consultaSql= "INSERT INTO usuarios (nombre, password) VALUES ('"+usuario+"','"+pass+"')";
	
	//ejecutar la consulta
	sentencia.executeUpdate(consultaSql);
	
	out.println("Usuario registrado");
	
	%>
</body>
</html>