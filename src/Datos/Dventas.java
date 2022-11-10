package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import logica.LPlatillos;
import logica.LReserva;
import logica.Lventas;
import presentacion.FrmVentas;

public class Dventas {

	DConexion con = new DConexion();
	Connection cn = con.conectarDB();
	int resultado = 0;
	public DefaultTableModel mostrarVentas() {
		try {
			DefaultTableModel miModelo;
			String titulos [] = {"IdVenta", "ReservacionId","Nombre","Fecha","Hora"};
			String dta[]=new String[5];
			miModelo=new DefaultTableModel(null,titulos);
			String sql="SELECT v.IdVenta,v.ReservacionId, r.Nombre,v.Fecha,v.Hora FROM tblVentas v, tblReserva r where r.IdReserva = v.ReservacionId";
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				dta[0]=rst.getString("IdVenta");
				dta[1]=rst.getString("ReservacionId");
				dta[2]=rst.getString("Nombre");
				dta[3]=rst.getString("Fecha");
				dta[4]=rst.getString("Hora");
				
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
			int n = pst.executeUpdate();
			
			if(n == 1) {
				String sql2 = "select @@identity AS id from tblVentas";
				PreparedStatement pst1 = cn.prepareStatement(sql2);
				ResultSet rs = pst1.executeQuery();
				if(rs.next()) {
					int idv = rs.getInt(1);
					
					String  sql3 = ("SELECT v.IdVenta,v.ReservacionId, r.Nombre,v.Fecha,v.Hora FROM tblVentas v join tblReserva r on r.IdReserva = v.ReservacionId where v.Idventa = "+idv+"");
					PreparedStatement pst2 = cn.prepareStatement(sql3);
					ResultSet rst = pst2.executeQuery();
					if(rst.next()) {
						int idvv = rst.getInt("IdVenta");
						int idr = rst.getInt("ReservacionId");
						String nombre = rst.getString("Nombre");
						String fecha = rst.getString("Fecha");
						String hora = rst.getString("Hora");
						FrmVentas.retornaId(idvv, idr,nombre,fecha,hora);
					}
				}
			}
			
			
			return "Se inserto de forma correcta";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return "Ocurrio un problema al insertar";
		}
		
	}
	
	public String editarVenta(Lventas miventa) {
		try {
			String sql = "update tblVentas set ReservacionId=?,Fecha=?,Hora=? where IdVenta = ?";
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
	public String EliminarVenta(Lventas miventa) {
		try {
			String sql = "delete from tblventas where Idventa = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1,miventa.getId());
			pst.executeUpdate();
			
			return "Se Elimino de forma correcta";
		} catch (SQLException e) {
			e.printStackTrace();
		return "Ocurrio un problema al Eliminar";
		}	
	}
	
	public DefaultTableModel BuscarVenta(int id) {
		try {
			DefaultTableModel miModelo;
			String titulos [] = {"IdVenta", "ReservacionId","Nombre","Fecha","Hora"};
			String dta[]=new String[5];
			miModelo=new DefaultTableModel(null,titulos);
			String  sql = ("SELECT v.IdVenta,v.ReservacionId, r.Nombre,v.Fecha,v.Hora FROM tblVentas v join tblReserva r on r.IdReserva = v.ReservacionId where v.ReservacionId = "+id+"");
					//System.out.println(sql);
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				dta[0]=rst.getString("IdVenta");
				dta[1]=rst.getString("ReservacionId");
				dta[2]=rst.getString("Nombre");
				dta[3]=rst.getString("Fecha");
				dta[4]=rst.getString("Hora");
				
				miModelo.addRow(dta);
			}
			return miModelo;
			
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			return null;
		}
	}	
	
}
