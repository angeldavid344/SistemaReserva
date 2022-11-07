package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import logica.LReserva;

public class DReservas {
DConexion miconex = new DConexion();
	Connection con = miconex.conectarDB();
	
	public DefaultTableModel buscarReservacion(int id) {
		String titulos [] = {"Id" , "Nombre" ,"Fecha", "Hora" , "Telefono"};
		DefaultTableModel miModelo = new DefaultTableModel(null,titulos);
		String datos [] = new String[8];
		String sql = "SELECT * FROM tblReserva where IdReserva = "+id+"";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				datos[0] = rs.getString("IdReserva");
				datos[1] = rs.getString("Nombre");
				datos[2] = rs.getString("Fecha");
				datos[3] = rs.getString("Hora");
				datos[4] = rs.getString("Telefono");
				 
			
			miModelo.addRow(datos);
			}
			return miModelo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public DefaultTableModel mostrarReservacion() {
		String titulos [] = {"Id" , "Nombre" ,"Fecha", "Hora" , "Telefono"};
		DefaultTableModel miModelo = new DefaultTableModel(null,titulos);
		String datos [] = new String[5];
		String sql = "SELECT * FROM tblReserva";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				datos[0] = rs.getString("IdReserva");
				datos[1] = rs.getString("Nombre");
				datos[2] = rs.getString("Fecha");
				datos[3] = rs.getString("Hora");
				datos[4] = rs.getString("Telefono");

			
			miModelo.addRow(datos);
			}
			return miModelo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public String insertarReserva(LReserva miReservacion) {
		try {
			String sql = "insert into tblReserva (Nombre,Fecha,Hora,Telefono,Sala,Usuario) value(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,miReservacion.getNombre());
			pst.setDate(2,miReservacion.getFecha());
			pst.setString(3,miReservacion.getHora());
			pst.setString(4,miReservacion.getTelefono());
			pst.setString(5,miReservacion.getSala());
			pst.setString(6,miReservacion.getUsuario());
			pst.executeUpdate();
			return "Se inserto de forma correcta";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return "Ocurrio un problema al insertar";
		}
		
	}
	
	public String editarReserva(LReserva miReservacion) {
		try {
			String sql = "update tblReserva set Nombre=?,Fecha=?,Hora=?,Telefono=?,Sala=?,Usuario=? where IdReserva = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,miReservacion.getNombre());
			pst.setDate(2,miReservacion.getFecha());
			pst.setString(3,miReservacion.getHora());
			pst.setString(4,miReservacion.getTelefono());
			pst.setString(5,miReservacion.getSala());
			pst.setString(6,miReservacion.getUsuario());
			pst.setInt(7,miReservacion.getIdReserva());
			pst.executeUpdate();
			
			return "Se Modifico de forma correcta";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return "Ocurrio un problema al Modificar";
		}
		
	}
	public String CancelarReserva(LReserva miReservacion) {
		try {
			String sql = "update tblReserva set Estado='Cancelado' where IdReserva = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,miReservacion.getIdReserva());
			pst.executeUpdate();
			
			return "Se Cancelo de forma correcta";
		} catch (SQLException e) {
			e.printStackTrace();
		return "Ocurrio un problema al Cancelar";
		}	
	}
	public String EliminarReserva(LReserva miReservacion) {
		try {
			String sql = "delete from tblReserva where IdReserva = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,miReservacion.getIdReserva());
			pst.executeUpdate();
			
			return "Se Elimino de forma correcta";
		} catch (SQLException e) {
			e.printStackTrace();
		return "Ocurrio un problema al Eliminar";
		}	
	}
}

