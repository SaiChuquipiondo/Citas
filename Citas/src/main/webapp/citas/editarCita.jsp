<%@page import="com.beans.Citas"%>
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
	if(request.getAttribute("odon")==null){
		odon = new Odontologo();
	}else{
		odon = (Odontologo) request.getAttribute("odon");
	}
	
	Citas cita;
	if(request.getAttribute("cita")==null){
		cita = new Citas();
	}else{
		cita = (Citas) request.getAttribute("cita");
}
	
	%>
	<div class="contrainer">
		<h2>
			<strong>Editar Cita</strong>
		</h2>
		<form role="form" action="<%=url%>CitasController" method="post">
		<input type="hidden" name="op" value="editar">
		<input type="hidden" name ="id" value="<%= cita.getIdCita()%>">
		<input type="hidden" name="idOdontologo" value="<%= odon.getIdOdon() %>">
		
			<div class="input-group">
			<label for="fechaCita">Fecha Cita: </label>
				<input type="Date" name="fechaCita" id="fechaCita" value="<%= cita.getFechaCita() %>">
			</div>


			<div class="input-group">
			<label for="paciente">Paciente: </label>
				<input type="text" name="paciente" id="paciente" value="<%= cita.getPaciente() %>">
			</div>

			<div class="input-group">
			<label for="costo">Costo de la cita $/. : </label>
				<input type="number" name="costo" id="costo" min="0" step="0.01"
					value="<%= cita.getCostoCita() %>">
			</div>
			
			<div class="input-group">
			<label for="fecha">Hora de la cita: </label>
				<input type="time" name="horaCita" id="horaCita" value="<%= cita.getHoraCita()%>">
			</div>


			<div>
			<a type="reset" class="btn btn-outline-secundary" href="<%= url %>CitasController?op=listar&idOdontologo=<%= odon.getIdOdon()%>">Cancelar</a>
			<button type="submit" class="btn btn-primary" >Registar</button>
			</div>
		</form>
	</div>
</body>
</html>