package com.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
	private String url = "jdbc:mysql://localhost/citas";
	private String user = "root";
	private String pass = "1234567";
	private String driver = "com.mysql.cj.jdbc.Driver";
	protected Connection conexion = null;
		
	public void abrirConexion() {
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, pass);
			if(conexion!=null) {
				System.out.println("Conexion exitosa");
			}else {
				System.out.println("Conexion fracasada");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void cerrarConexion() {
		try {
			if(conexion!=null && !conexion.isClosed()) {
				conexion.isClosed();
				System.out.println("Conexion cerrada");
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
