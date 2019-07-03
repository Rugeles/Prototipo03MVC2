	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista presentar circunscripcion</title>
</head>
<body>
<form action="/registro" method="post">
	<b>Vista presentar circunscripcion</b><br><br>
	Nombre: ${circunscripcion.nombre}<br>
	Potencial de sufragantes: ${circunscripcion.potencialSufragantes}<br>
	Total de sufragantes: ${circunscripcion.totalSufragantes}<br>
	Participación [%]: ${circunscripcion.participacion}<br><br>
	<input type="submit" name="accion" value="Cancelar">
</form>	 
</body>
</html>