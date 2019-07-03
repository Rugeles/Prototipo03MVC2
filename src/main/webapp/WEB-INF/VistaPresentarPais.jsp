	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista presentar pais</title>
</head>
<meta http-equiv="refresh" content="5">
<body>
<form action="/pais" method="get">
	<b>Vista presentar país</b><br><br>
	Circunscripciones: ${pais.capacidad} ${pais.indiceInicio}<br>

    <c:forEach var="i" begin="1" end="${pais.capacidad}">
    	${pais.siguiente.nombre} - 
    	${pais.siguiente.potencialSufragantes} -
    	${pais.siguiente.totalSufragantes} -
    	${pais.siguiente.participacion} ${pais.indiceSiguiente} <br>
    </c:forEach>
	<br>

	Indicadores:<br>
	Potencial de sufragantes: ${pais.potencialSufragantes}<br>
	Total de sufragantes: ${pais.totalSufragantes}<br>
	Participación [%]: ${pais.participacion}<br><br>
	<input type="submit" name="accion" value="Cancelar">
</form>	 
</body>
</html>