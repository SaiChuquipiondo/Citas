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
	
	Odontologo odon;
	if(request.getAttribute("Odon")==null){
		odon = new Odontologo();
	}else{
		odon = (Odontologo) request.getAttribute("Odon");
	}
	%>
	<div class="contrainer">
		<h2>
			<strong>Registro Cita</strong>
		</h2>
		<form role="form" action="<%=url%>CitasController" method="post">
		<input type="hidden" name="op" value="insertar">
		<input type="hidden" name="idOdontologo" value="<%= odon.getIdOdon() %>">
		
			<div class="input-group">
			<label for="fechaCita">Fecha Cita: </label>
				<input type="Date" name="fechaCita" id="fechaCita">
			</div>


			<div class="input-group">
			<label for="paciente">Paciente: </label>
				<input type="text" name="paciente" id="paciente" placeholder="Ingresar el paciente">
			</div>

			<div class="input-group">
			<label for="costo">Costo de la cita $/. : </label>
				<input type="number" name="costo" id="costo" min="0" step="0.01"
					placeholder="Ingresar el costo">
			</div>
			
			<div class="input-group">
			<label for="fecha">Hora de la cita: </label>
				<input type="time" name="horaCita" id="horaCita"
					placeholder="Ingresar la hora de la cita">
			</div>


			<div>
			<a type="reset" class="btn btn-outline-secundary" href="<%= url %>CitasController?op=listar&idOdontologo=<%= odon.getIdOdon()%>">Cancelar</a>
			<button type="submit" class="btn btn-primary" >Registar</button>
			</div>
		</form>
	</div>
</body>
</html>