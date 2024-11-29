package com.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.beans.Odontologo;

public class odontologoModel extends conexion {

	CallableStatement cs;
	ResultSet rs;

	public List<Odontologo> listaOdon() {

		List<Odontologo> lista = new ArrayList<>();
		try {
			String sql = "CALL sp_listarOdon()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Odontologo odon = new Odontologo();
				odon.setIdOdon(rs.getInt(1));
				odon.setNombres(rs.getString(2));
				odon.setApellidos(rs.getString(3));
				odon.setDni(rs.getString(4));
				odon.setDireccion(rs.getString(5));
				odon.setFechaNac(rs.getString(6));
				lista.add(odon);
			}

			this.cerrarConexion();
			return lista;

		} catch (Exception e) {
			System.err.println("Error en listaOdon: "+e.getMessage());
			this.cerrarConexion();
			return null;
		}
	}
	
	public int insertarOdon(Odontologo odon) {
		try {
			String sql = "CALL sp_insertarOdon(?,?,?,?,?)";
			this.abrirConexion();
			cs=conexion.prepareCall(sql);
			cs.setString(1, odon.getNombres());
			cs.setString(2, odon.getApellidos());
			cs.setString(3, odon.getDni());
			cs.setString(4, odon.getDireccion());
			cs.setString(5, odon.getFechaNac());
			int fila = cs.executeUpdate();
			
			this.cerrarConexion();
			return fila;
		} catch (Exception e) {
			System.err.println("Error en insertarOdon: "+e.getMessage());
			this.cerrarConexion();
			return 0;
		}
	}
	
	public Odontologo obtenerOdon(int idOdon) {
		Odontologo odon = new Odontologo();
		try {
			String sql = "CALL sp_obtenerOdon(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idOdon);
			rs=cs.executeQuery();
			if(rs.next()) {
				odon.setIdOdon(rs.getInt(1));
				odon.setNombres(rs.getString(2));
				odon.setApellidos(rs.getString(3));
				odon.setDni(rs.getString(4));
				odon.setDireccion(rs.getString(5));
				odon.setFechaNac(rs.getString(6));
				this.cerrarConexion();
			}
			
		} catch (Exception e) {
			System.err.println("Error en obtenerOdon: "+e.getMessage());
			this.cerrarConexion();
			return null;
		}
		return odon;
	}
	
	public int modificarOdon(Odontologo odon) {
		try {
			String sql = "CALL sp_modificarOdon(?,?,?,?,?,?)";
			this.abrirConexion();
			cs=conexion.prepareCall(sql);
			cs.setInt(1, odon.getIdOdon());
			cs.setString(2, odon.getNombres());
			cs.setString(3, odon.getApellidos());
			cs.setString(4, odon.getDni());
			cs.setString(5, odon.getDireccion());
			cs.setString(6, odon.getFechaNac());
			int fila = cs.executeUpdate();
			
			this.cerrarConexion();
			return fila;
			
		} catch (Exception e) {
			System.err.println("Error en modificarOdon: "+e.getMessage());
			this.cerrarConexion();
			return 0;
		}
		
	}
	
	public int eliminarOdon(int id) {
		try {
			String sql = "CALL sp_eliminarOdon(?)";
			this.abrirConexion();
			cs= conexion.prepareCall(sql);
			cs.setInt(1, id);
			
			int fila = cs.executeUpdate();
			
			this.cerrarConexion();
			return fila;
		} catch (Exception e) {
			System.err.println("Erro en eliminarOdon: "+e.getMessage());
			return 0;		
			}
	
	}
}
