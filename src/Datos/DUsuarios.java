package Datos;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import logica.LUsuarios;

public class DUsuarios {
DConexion con = new DConexion();
Connection cn = con.conectarDB();
int resultado = 0;
public DefaultTableModel mostrarUsuarios() {
	try {
		DefaultTableModel miModelo;
		String titulos [] = {"Id", "Nombre","A/Pateno","A/Materno","Usuario","Clave","Perfil"};
		String dta[]=new String[7];
		miModelo=new DefaultTableModel(null,titulos);
		String sql="SELECT * FROM tblUsuarios";
		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rst = pst.executeQuery();
		while(rst.next()) {
			dta[0]=rst.getString("IdUsuarios");
			dta[1]=rst.getString("Nombre");
			dta[2]=rst.getString("Apaterno");
			dta[3]=rst.getString("AMaterno");
			dta[4]=rst.getString("Usuario");
			dta[5]=rst.getString("Clave");
			dta[6]=rst.getString("Perfil");
			miModelo.addRow(dta);
		}
		return miModelo;
		
		
	}catch (Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
		return null;
	}
}
	/* TODO ESTE METODO PERMITE QUE LO DE LA TABLA DE USUARIOS EN MYSQL 
	LO REFLEJE EN EL CLIENTE*/


public String agregarUsuarios(LUsuarios misUsuarios) {
	try {
		String sql="insert into tblUsuarios(Nombre, APaterno, AMaterno, Usuario, Clave, Perfil) values('"
	+misUsuarios.getNombre()+"','"+misUsuarios.getAPaterno()+"','"+misUsuarios.getAmaterno()+"','"
	+misUsuarios.getUsuario()+"','"+misUsuarios.getClave()+"','"+misUsuarios.getPerfil()+"')";
		Statement st = cn.createStatement();
		st.executeUpdate(sql);
		return "Se Registro de forma correcta";
}catch(SQLException ex){
	JOptionPane.showMessageDialog(null, ex);
	return "Ocurrio un problema al insertar datos";
}

}
public String editarUsuarios(LUsuarios misUsuarios) {
	try {
		String sql="update tblUsuarios set Nombre=?, APaterno=?, AMaterno=?, Usuario=?, Clave=?, Perfil=? where IdUsuarios=?";
		PreparedStatement pat = cn.prepareStatement(sql);
		pat.setString(1, misUsuarios.getNombre());
		pat.setString(2, misUsuarios.getAPaterno());
		pat.setString(3, misUsuarios.getAmaterno());
		pat.setString(4, misUsuarios.getUsuario());
		pat.setString(5, misUsuarios.getClave());
		pat.setString(6, misUsuarios.getPerfil());
		pat.setInt(7, misUsuarios.getIdUsuarios());
		pat.executeUpdate();
		return "Se Actualizo de forma correcta";
}catch(SQLException ex){
	JOptionPane.showMessageDialog(null, ex);
	return "Ocurrio un problema al editar datos";
}
	
}

public String eliminarUsuarios(LUsuarios misUsuarios) {
	try {
		String sql="delete from tblUsuarios where IdUsuarios=?";
		PreparedStatement pat = cn.prepareStatement(sql);
		pat.setInt(1, misUsuarios.getIdUsuarios());
		pat.executeUpdate();
		return "Se elimino de forma correcta";
}catch(SQLException ex){
	JOptionPane.showMessageDialog(null, ex);
	return "Ocurrio un problema al eliminar datos";
}
	
}
public DefaultTableModel buscarUsuarios(String Buscar) {
	try {
		DefaultTableModel miModelo;
		String titulos [] = {"Id", "Nombre","A/Pateno","A/Materno","Usuario","Clave","Perfil"};
		String datos[]=new String[7];
		miModelo=new DefaultTableModel(null,titulos);
		String sql="SELECT * FROM tblUsuarios WHERE IdUsuarios='"+Buscar+"'";
		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rst = pst.executeQuery();
		while(rst.next()) {
			datos[0]=rst.getString("IdUsuarios");
			datos[1]=rst.getString("Nombre");
			datos[2]=rst.getString("Apaterno");
			datos[3]=rst.getString("AMaterno");
			datos[4]=rst.getString("Usuario");
			datos[5]=rst.getString("Clave");
			datos[6]=rst.getString("Perfil");
			miModelo.addRow(datos);
		}
		return miModelo;
		
		
	}catch (Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
		return null;
	}
}
public int validadLogin(String Usuario,String Clave) {
	try {
		String sql="SELECT * FROM tblUsuarios WHERE Usuario='"+Usuario+"' and Clave='"+Clave+"'";
		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rst = pst.executeQuery();
		
		while(rst.next()) {
			resultado = 1;
		}	
		return resultado;
	}catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex);
		return resultado;
	}
	
}


}