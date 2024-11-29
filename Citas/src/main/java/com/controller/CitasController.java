package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.beans.Citas;
import com.beans.Odontologo;
import com.model.citaModel;

/**
 * Servlet implementation class CitasController
 */
public class CitasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	citaModel modeloC = new citaModel();
    public CitasController() {
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
			
			nuevo(request, response);
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			
			int id = Integer.parseInt(request.getParameter("idOdontologo"));
			List<Citas> lista = modeloC.listaCitas(id);
			request.setAttribute("listaCita", lista);
			request.setAttribute("id", id);
			request.getRequestDispatcher("/citas/listarCita.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Odontologo odon = new Odontologo();			
			odon.setIdOdon(Integer.parseInt(request.getParameter("idOdontologo")));
			
			if(odon!=null) {
				request.setAttribute("Odon", odon);
			}
			request.getRequestDispatcher("/citas/nuevoCita.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Citas cita = new Citas();
			Odontologo odon = new Odontologo();
			
			cita.setFechaCita(request.getParameter("fechaCita"));
			odon.setIdOdon(Integer.parseInt(request.getParameter("idOdontologo")));
			cita.setOdon(odon);
			cita.setCostoCita(Double.parseDouble(request.getParameter("costo")));
			cita.setPaciente(request.getParameter("paciente"));
			cita.setHoraCita(request.getParameter("horaCita"));
			
			
			if(modeloC.insertarCita(cita)>0) {
				request.setAttribute("insertado exitoso", "Cita insertado");
			}else {
				request.setAttribute("insertado fracaso", "Cita no insertado");
			}
			response.sendRedirect(request.getContextPath()+"/CitasController?op=listar&idOdontologo="+odon.getIdOdon()+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void obtener (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Odontologo odon = new Odontologo();
			odon.setIdOdon(Integer.parseInt(request.getParameter("idOdontologo")));
			Citas cita = modeloC.obtenerCita(Integer.parseInt(request.getParameter("id")));
			if(cita!=null) {
				request.setAttribute("odon", odon);
				request.setAttribute("cita", cita);
				request.getRequestDispatcher("/citas/editarCita.jsp").forward(request, response);
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
			Citas cita = new Citas();
			cita.setIdCita(Integer.parseInt(request.getParameter("id")));
			cita.setFechaCita(request.getParameter("fechaCita"));
			odon.setIdOdon(Integer.parseInt(request.getParameter("idOdontologo")));
			cita.setOdon(odon);
			cita.setCostoCita(Double.parseDouble(request.getParameter("costo")));
			cita.setPaciente(request.getParameter("paciente"));
			cita.setHoraCita(request.getParameter("horaCita"));
			
			if(modeloC.modificarCita(cita)>0) {
				request.setAttribute("modificado exitoso", "Cita modificado");
			}else {
				request.setAttribute("modificado fracaso", "Cita no modificado");
			}
			response.sendRedirect(request.getContextPath()+"/CitasController?op=listar&idOdontologo="+odon.getIdOdon()+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		private void eliminar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				Odontologo odon = new Odontologo();
				odon.setIdOdon(Integer.parseInt(request.getParameter("idOdontologo")));
				int id = Integer.parseInt(request.getParameter("id"));
				if(modeloC.eliminarCita(id)>0) {
					request.setAttribute("eliminado exitoso", "Cita eliminado");
				}else {
					request.setAttribute("eliminado fracaso", "Cita no eliminado");
				}
				response.sendRedirect(request.getContextPath()+"/CitasController?op=listar&idOdontologo="+odon.getIdOdon()+"");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

}
