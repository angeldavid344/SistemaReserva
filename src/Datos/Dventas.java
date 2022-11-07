package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import logica.LPlatillos;
import logica.Lventas;

public class Dventas {

	DConexion con = new DConexion();
	Connection cn = con.conectarDB();
	int resultado = 0;
	public DefaultTableModel mostrarVentas() {
		try {
			DefaultTableModel miModelo;
			String titulos [] = {"Id", "IdReserva","Nombre","Fecha","Hora"};
			String dta[]=new String[5];
			miModelo=new DefaultTableModel(null,titulos);
			String sql="SELECT v.IdVenta,v.ReservacionId, r.Nombre,v.Fecha,v.Hora FROM tblVentas v, tblReserva r where r.IdReserva = v.ReservacionId";
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				dta[0]=rst.getString("v.IdVenta");
				dta[1]=rst.getString("v.ReservacionId");
				dta[2]=rst.getString("r.Nombre");
				dta[3]=rst.getString("v.Fecha");
				dta[4]=rst.getString("v.Hora");
				
				miModelo.addRow(dta);
			}
			return miModelo;
			
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			return null;
		}
	}
	public String insertarVenta(Lventas miventa) {
		try {
			String sql = "insert into tblVentas (ReservacionId,Fecha,Hora) value(?,?,?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1,miventa.getIdR());
			pst.setDate(2,miventa.getFecha());
			pst.setString(3,miventa.getHora());
			pst.executeUpdate();
			return "Se inserto de forma correcta";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return "Ocurrio un problema al insertar";
		}
		
	}
	
	public String editarVenta(Lventas miventa) {
		try {
			String sql = "update tblVentas set ReservacionId=?,Fecha=?,Hora=? where IdVentas = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(2,miventa.getIdR());
			pst.setDate(3,miventa.getFecha());
			pst.setString(4,miventa.getHora());
			
			pst.setInt(1,miventa.getId());
			pst.executeUpdate();
			
			return "Se Modifico de forma correcta";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return "Ocurrio un problema al Modificar";
		}
		
	}
}
