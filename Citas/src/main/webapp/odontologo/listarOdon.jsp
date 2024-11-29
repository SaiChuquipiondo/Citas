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
	%>
	<div class="container my-5">
		<h2 class="fw-bold text-primary">Odontologo</h2>
		<a type="button" href="<%=url%>OdontologoController?op=nuevo"
			class="btn btn-sucess btn-lg">Agregar nuevo Odontologo</a>
	</div>
	<table border="1">
		<thead>
			<tr>
				<th scope="row">Codigo</th>
				<th scope="col">Nombres</th>
				<th scope="col">Apellidos</th>
				<th scope="col">Dni</th>
				<th scope="col">Direccion</th>
				<th scope="col">Fecha de Nacmiento</th>
				<th scope="col">Acciones</th>
			</tr>

		</thead>

		<tbody>

			<% List<Odontologo> lista = (List<Odontologo>) request.getAttribute("listaOdon");
		if(lista!=null){
			for(Odontologo odon : lista){
				%>
			<tr>
				<td><%= odon.getIdOdon() %></td>
				<td><%= odon.getNombres() %></td>
				<td><%= odon.getApellidos()%></td>
				<td><%= odon.getDni()%></td>
				<td><%= odon.getDireccion()%></td>
				<td><%= odon.getFechaNac() %></td>
				<td><a
					href="<%= url %>OdontologoController?op=obtener&id=<%= odon.getIdOdon() %>">Editar</a>
					<a
					href="<%= url %>OdontologoController?op=eliminar&id=<%= odon.getIdOdon() %>">Eliminar</a>
					<a href="<%= url %>CitasController?op=listar&idOdontologo=<%=odon.getIdOdon()%>">Citas</a>
				</td>
			</tr>
			<% 
			} 
			}else{
			%>
			<p>no se encontró ninguna lista</p>

			<% 
			}
			%>
		</tbody>
	</table>
</body>
</html>