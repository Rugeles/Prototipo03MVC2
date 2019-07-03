<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista main</title>
</head>
<body>
<form action="/main" method="get">
	<h1>Participación electoral</h1><br><br>
    <div class="areaPais"><iframe src="/pais" width='100%' height='50%' ></iframe></div>
    <div class="areaRegistro"><iframe src="/registro" width='100%' height='50%' ></iframe></div>
</form>	 
</body>
</html>