<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fin</title>
</head>
<body>
	<h1>Tu pais es: ${nom}</h1>
	<br>
	<h1>Hablas: ${idioma}</h1>
	<br>
	<h1></h1>
	<br>
	<input type="button" onclick="window.location.href='datos.jsp'"  value="Volver">
	<br>
	<form method="post" action="Hola">
		<input type="hidden" value="${nom}" name="nombre">
		<br>
		<input type="hidden" value="${i}" name="idioma">
		<br>
		<input type="submit"  value="Borrar">
	</form>	
</body>
</html>