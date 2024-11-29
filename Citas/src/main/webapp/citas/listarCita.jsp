<%@page import="com.beans.Citas"%>
<%@page import="com.beans.Odontologo"%>
<%@page import="java.util.List"%>
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
	int id;
	if(request.getAttribute("id")==null){
		id = 0;
	}else{
		id = (int) request.getAttribute("id");
	}
	%>
	<div class="container my-5">
		<h2 class="fw-bold text-primary">Citas</h2>
		<a type="button" href="<%=url%>CitasController?op=nuevo&idOdontologo=<%= id %>"
			class="btn btn-sucess btn-lg">Agregar nueva Cita</a>
	</div>
	<table border="1">
		<thead>
			<tr>
				<th scope="row">Codigo</th>
				<th scope="col">Fecha Cita</th>
				<th scope="col">Odontologo</th>
				<th scope="col">Costo</th>
				<th scope="col">Paciente</th>
				<th scope="col">hora Cita</th>
				<th scope="col">Acciones</th>
			</tr>

		</thead>

		<tbody>

			<%
			List<Citas> lista = (List<Citas>) request.getAttribute("listaCita");
			if (lista != null) {
				for (Citas cita : lista) {
			%>
			<tr>
				<td><%=cita.getIdCita()%></td>
				<td><%=cita.getFechaCita()%></td>
				<td><%=cita.getOdon().getIdOdon()%></td>
				<td><%=cita.getCostoCita()%></td>
				<td><%=cita.getPaciente()%></td>
				<td><%=cita.getHoraCita()%></td>
				<td><a
					href="<%=url%>CitasController?op=obtener&idOdontologo=<%= id %>&id=<%=cita.getIdCita()%>">Editar</a>
					<a
					href="<%=url%>CitasController?op=eliminar&idOdontologo=<%= id %>&id=<%=cita.getIdCita()%>">Eliminar</a>
				</td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td>No hay citas</td>
			</tr>


			<%
			}
			%>
		</tbody>
	</table>
	<div class="container my-5">
		<a type="button" href="<%=url%>OdontologoController?op=listar"
			class="btn btn-sucess btn-lg">Regresar</a>
	</div>
</body>
</html>