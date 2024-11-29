<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String url = "http://localhost:8080/Citas/";
	%>
	<div class="contrainer">
		<h2>
			<strong>Registro Odontologo</strong>
		</h2>
		<form role="form" action="<%=url%>OdontologoController" method="post">
		<input type="hidden" name="op" value="insertar">
		
			<div class="input-group">
			<label for="nombre">Nombres: </label>
				<input type="text" name="nombres" id="nombres"
					placeholder="Ingresar el nombre">
			</div>

			<div class="input-group">
			<label for="apellidos">Apellidos: </label>
				<input type="text" name="apellidos" id="apellidos"
					placeholder="Ingresar los apellidos">
			</div>

			<div class="input-group">
			<label for="dni">Dni: </label>
				<input type="text" name="dni" id="dni" placeholder="Ingresar el dni">
			</div>

			<div class="input-group">
			<label for="direccion">Direccion: </label>
				<input type="text" name="direccion" id="direccion"
					placeholder="Ingresar la direccion">
			</div>
			
			<div class="input-group">
			<label for="fecha">Fecha de Nacimiento: </label>
				<input type="date" name="fechaNac" id="fechaNac"
					placeholder="Ingresar la fecha de nacimiento">
			</div>


			<div>
			<a type="reset" class="btn btn-outline-secundary" href="<%= url %>OdontologoController?op=listar">Cancelar</a>
			<button type="submit" class="btn btn-primary" >Registar</button>
			</div>
		</form>
	</div>
</body>
</html>