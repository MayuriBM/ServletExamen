<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Datos</title>
</head>
<body>
	<form method="post" action="welcome">
		<span>País: </span>
		<input type="text" name="pais">
		</br>
		<span>Idioma</span>
		<select name="idioma"></select>
		</br>
		<input type="submit">
	</form>
	<form action="insert" method="post">
		<span>Idioma:</span>
		<input type="text" name="idioma"> <br/>
		<input type="submit" name="Insertar Idioma">
	</form>
	
</body>
</html>