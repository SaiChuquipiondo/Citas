package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.beans.Odontologo;
import com.model.odontologoModel;

/**
 * Servlet implementation class OdontologoController
 */
public class OdontologoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	odontologoModel modeloO = new odontologoModel();
    public OdontologoController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getParameter("op")==null) {
    		listar(request, response);
    		return;
    	}
    	String operacion = request.getParameter("op");
    	switch (operacion) {
		case "listar":
			listar(request, response);
			
			break;
		case "nuevo":
			request.getRequestDispatcher("/odontologo/nuevoOdon.jsp").forward(request, response);
			break;
		case "insertar":
			insertar(request, response);
			break;
		case "obtener": 
			obtener(request, response);;
			break;
		case "editar":
			editar(request, response);;
			break;
		case "eliminar":
			eliminar(request, response);
			break;
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			List<Odontologo> lista = modeloO.listaOdon();
			request.setAttribute("listaOdon", lista);
			request.getRequestDispatcher("/odontologo/listarOdon.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Odontologo odon = new Odontologo();
			odon.setNombres(request.getParameter("nombres"));
			odon.setApellidos(request.getParameter("apellidos"));
			odon.setDni(request.getParameter("dni"));
			odon.setDireccion(request.getParameter("direccion"));
			odon.setFechaNac(request.getParameter("fechaNac"));
			if(modeloO.insertarOdon(odon)>0) {
				request.setAttribute("insertado exitoso", "Odontologo insertado");
			}else {
				request.setAttribute("insertado fracaso", "Odontologo no insertado");
			}
			response.sendRedirect(request.getContextPath()+"/OdontologoController?op=listar");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void obtener (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Odontologo odon = modeloO.obtenerOdon(Integer.parseInt(request.getParameter("id")));
			if(odon!=null) {
				request.setAttribute("Odon", odon);
				request.getRequestDispatcher("/odontologo/editarOdon.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void editar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Odontologo odon = new Odontologo();
			odon.setIdOdon(Integer.parseInt(request.getParameter("id")));
			odon.setNombres(request.getParameter("nombres"));
			odon.setApellidos(request.getParameter("apellidos"));
			odon.setDni(request.getParameter("dni"));
			odon.setDireccion(request.getParameter("direccion"));
			odon.setFechaNac(request.getParameter("fechaNac"));
			if(modeloO.modificarOdon(odon)>0) {
				request.setAttribute("modificado exitoso", "Odontologo modificado");
			}else {
				request.setAttribute("modificado fracaso", "Odontologo no modificado");
			}
			response.sendRedirect(request.getContextPath()+"/OdontologoController?op=listar");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		private void eliminar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				if(modeloO.eliminarOdon(id)>0) {
					request.setAttribute("eliminado exitoso", "Odontologo eliminado");
				}else {
					request.setAttribute("eliminado fracaso", "Odontologo no eliminado");
				}
				response.sendRedirect(request.getContextPath()+"/OdontologoController?op=listar");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
	

}
