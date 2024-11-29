<%@page import="com.beans.Odontologo"%>
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
	
	<% Odontologo odon;
	if(request.getAttribute("Odon")==null){
		odon = new Odontologo();
	}else{
		odon = (Odontologo) request.getAttribute("Odon");
	}
	%>
	<div class="contrainer">
		<h2>
			<strong>Registro Odontologo</strong>
		</h2>
		<form role="form" action="<%=url%>OdontologoController" method="post">
		<input type="hidden" name="op" value="editar">
		<input type="hidden" name= "id" value="<%= odon.getIdOdon() %>">
		
			<div class="input-group">
			<label for="nombre">Nombres: </label>
				<input type="text" name="nombres" id="nombres"
					value=<%= odon.getNombres() %>>
			</div>

			<div class="input-group">
			<label for="apellidos">Apellidos: </label>
				<input type="text" name="apellidos" id="apellidos"
					value="<%= odon.getApellidos() %>">
			</div>

			<div class="input-group">
			<label for="dni">Dni: </label>
				<input type="text" name="dni" id="dni" value="<%= odon.getDni() %>">
			</div>

			<div class="input-group">
			<label for="direccion">Direccion: </label>
				<input type="text" name="direccion" id="direccion"
					value="<%= odon.getDireccion() %>">
			</div>
			
			<div class="input-group">
			<label for="fecha">Fecha de Nacimiento: </label>
				<input type="date" name="fechaNac" id="fechaNac"
					value="<%= odon.getFechaNac() %>">
			</div>


			<div>
			<a type="reset" class="btn btn-outline-secundary" href="<%= url %>OdontologoController?op=listar">Cancelar</a>
			<button type="submit" class="btn btn-primary" >Registar</button>
			</div>
		</form>
	</div>
</body>
</html>