package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class DConexion {

	public DConexion() {
		
		
	}
	public Connection conectarDB() {
		Connection miConex=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			miConex=DriverManager.getConnection("jdbc:mysql://:3306/DBReserva","root","angel344");
			//System.out.println("linea 22");
			//JOptionPane.showMessageDialog(null, "ya se conecto");
		
		}catch(ClassNotFoundException | SQLException ex) {
			JOptionPane.showMessageDialog(null,ex);
		
	}
	return miConex;
}
}