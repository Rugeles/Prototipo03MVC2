<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista capturar nombre búsqueda</title>
</head>
<body>
<form action="/registro" method="post">
	<b>Vista capturar nombre búsqueda</b><br><br>
	Nombre para búsqueda de circunscripción: <input type="text" id="nombre" name="nombre"><br><br>
	<input type="submit" name="accion" value="Consultar">
	<input type="submit" name="accion" value="Cancelar">
</form>	 
</body>
</html>