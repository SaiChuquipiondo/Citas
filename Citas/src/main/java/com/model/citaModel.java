package com.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.beans.Citas;
import com.beans.Odontologo;



public class citaModel extends conexion {
	CallableStatement cs;
	ResultSet rs;

	public List<Citas> listaCitas(int id) {

		List<Citas> lista = new ArrayList<>();
		try {
			String sql = "CALL sp_listarCita(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			while (rs.next()) {
				Citas cita = new Citas();
				Odontologo odon = new Odontologo();
				cita.setIdCita(rs.getInt(1));
				cita.setFechaCita(rs.getString(2));
				odon.setIdOdon(rs.getInt(3));
				odon.setNombres(rs.getString(4));
				cita.setOdon(odon);
				cita.setCostoCita(rs.getDouble(5));
				cita.setPaciente(rs.getString(6));
				cita.setHoraCita(rs.getString(7));

				lista.add(cita);
			}

			this.cerrarConexion();
			return lista;

		} catch (Exception e) {
			System.err.println("Error en listaCita: "+e.getMessage());
			this.cerrarConexion();
			return null;
		}
	}
	
	public int insertarCita(Citas cita) {
		try {
			String sql = "CALL sp_insertarCita(?,?,?,?,?)";
			this.abrirConexion();
			cs=conexion.prepareCall(sql);

			cs.setString(1, cita.getFechaCita());
			cs.setInt(2, cita.getOdon().getIdOdon());
			cs.setDouble(3, cita.getCostoCita());
			cs.setString(4, cita.getPaciente());
			cs.setString(5, cita.getHoraCita());
			int fila = cs.executeUpdate();
			
			this.cerrarConexion();
			return fila;
		} catch (Exception e) {
			System.err.println("Error en insertarCita: "+e.getMessage());
			this.cerrarConexion();
			return 0;
		}
	}
	
	public Citas obtenerCita(int idCita) {
		Citas cita = new Citas();
		try {
			String sql = "CALL sp_obtenerCita(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idCita);
			rs=cs.executeQuery();
			if(rs.next()) {
				Odontologo odon = new Odontologo();
				cita.setIdCita(rs.getInt(1));
				cita.setPaciente(rs.getString(5));
				cita.setFechaCita(rs.getString(2));
				cita.setHoraCita(rs.getString(6));
				cita.setCostoCita(rs.getDouble(4));
				odon.setIdOdon(rs.getInt(3));
				cita.setOdon(odon);
				this.cerrarConexion();
			}
			
		} catch (Exception e) {
			System.err.println("Error en obtenerCita: "+e.getMessage());
			this.cerrarConexion();
			return null;
		}
		return cita;
	}
	
	public int modificarCita(Citas cita) {
		try {
			String sql = "CALL sp_modificarCita(?,?,?,?,?,?)";
			this.abrirConexion();
			cs=conexion.prepareCall(sql);
			cs.setInt(1, cita.getIdCita());
			cs.setString(2, cita.getFechaCita());
			cs.setInt(3, cita.getOdon().getIdOdon());
			cs.setDouble(4, cita.getCostoCita());
			cs.setString(5, cita.getPaciente());
			cs.setString(6, cita.getHoraCita());
			
			
			int fila = cs.executeUpdate();
			
			this.cerrarConexion();
			return fila;
			
		} catch (Exception e) {
			System.err.println("Error en modificarCita: "+e.getMessage());
			this.cerrarConexion();
			return 0;
		}
		
	}
	
	public int eliminarCita(int id) {
		try {
			String sql = "CALL sp_eliminarCita(?)";
			this.abrirConexion();
			cs= conexion.prepareCall(sql);
			cs.setInt(1, id);
			
			int fila = cs.executeUpdate();
			
			this.cerrarConexion();
			return fila;
		} catch (Exception e) {
			System.err.println("Erro en eliminarCita: "+e.getMessage());
			return 0;		
			}
	
	}
}
