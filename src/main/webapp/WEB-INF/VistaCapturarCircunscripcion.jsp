<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista capturar circunscripcion</title>
</head>
<body>
<form action="/registro" method="post">
	<b>Vista capturar circunscripción</b><br><br>
	Nombre: <input type="text" id="nombre" name="nombre"><br><br>
	Potencial de sufragantes: <input type="text" id="potencialSufragantes" name="potencialSufragantes"><br><br>
	Total de sufragantes: <input type="text" id="totalSufragantes" name="totalSufragantes"><br><br>
	<input type="submit" name="accion" value="Enviar">
	<input type="submit" name="accion" value="Cancelar">
</form>	 
</body>
</html>