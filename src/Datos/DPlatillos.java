package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import logica.LPlatillos;

public class DPlatillos {
	DConexion miconex = new DConexion();
	Connection con = miconex.conectarDB();
	
	public DefaultTableModel buscarPlatillo(int id) {
		String titulos [] = {"IdPlatillos" , "Nombre" ,"Costo"};
		DefaultTableModel miModelo = new DefaultTableModel(null,titulos);
		String datos [] = new String[3];
		String sql = "SELECT * FROM tblPlatillos where IdPlatillos = "+id+"";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				datos[0] = rs.getString("IdPlatillos");
				datos[1] = rs.getString("Nombre");
				datos[2] = rs.getString("Costo");
			
			miModelo.addRow(datos);
			}
			return miModelo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public DefaultTableModel mostrarPlatillos() {
		String titulos[] = {"Id" , "Nombre" ,"Costo"};
		DefaultTableModel miModelo = new DefaultTableModel(null,titulos);
		String datos[] = new String[3];
		String sql = "SELECT * FROM tblPlatillos";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				datos[0] = rs.getString("IdPlatillos");
				datos[1] = rs.getString("Nombre");
				datos[2] = rs.getString("Costo");
				
			
			miModelo.addRow(datos);
			}
			return miModelo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public String insertarPlatillos(LPlatillos misPlatillos) {
		try {
			String sql = "insert into tblPlatillos (Nombre,Costo) value(?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,misPlatillos.getNombre());
			pst.setDouble(2,misPlatillos.getCosto());
			pst.executeUpdate();
			return "Se inserto de forma correcta";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return "Ocurrio un problema al insertar";
		}
		
	}
	
	public String editarPlatillos(LPlatillos misplatillos) {
		try {
			String sql = "update tblPlatillos set Nombre=?,Costo=? where IdPlatillos = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,misplatillos.getNombre());
			pst.setDouble(2,misplatillos.getCosto());
			pst.setInt(3,misplatillos.getIdPlatillos());
			pst.executeUpdate();
			
			return "Se Modifico de forma correcta";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return "Ocurrio un problema al Modificar";
		}
		
	}
	public String CancelarPlatillo(LPlatillos misplatillos) {
		try {
			String sql = "update tblPlatillos set Estado='Cancelado' where IdPlatillos = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,misplatillos.getIdPlatillos());
			pst.executeUpdate();
			
			return "Se Cancelo de forma correcta";
		} catch (SQLException e) {
			e.printStackTrace();
		return "Ocurrio un problema al Cancelar";
		}	
	}
	public String EliminarPlatillos(LPlatillos misplatillos) {
		try {
			String sql = "delete from tblPlatillos where IdPlatillos = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,misplatillos.getIdPlatillos());
			pst.executeUpdate();
			
			return "Se Elimino de forma correcta";
		} catch (SQLException e) {
			e.printStackTrace();
		return "Ocurrio un problema al Eliminar";
		}	
	}
}
