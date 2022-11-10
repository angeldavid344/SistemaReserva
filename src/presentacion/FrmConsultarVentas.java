package presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Datos.DConexion;
import Datos.Dventas;
import logica.Lventas;

public class FrmConsultarVentas extends JInternalFrame{

	
	private JTable tblVentas;
	private JScrollPane scrpVentas;
	private DefaultTableModel dtVentas;
	
	
	public FrmConsultarVentas() {
		setSize(900, 550);
		setTitle("Ventas");
		setClosable(true);
		setIconifiable(true);
		setLayout(null);
		setVisible(true);

		
		String titulos[]= {"IdVenta","IdReserva","Nombre","Hora"};
		dtVentas = new DefaultTableModel(null,titulos);
		tblVentas = new JTable(dtVentas);
		scrpVentas = new JScrollPane(tblVentas);

		
		add(scrpVentas);
		
		
		scrpVentas.setBounds(20, 100, 845,400 );
		
		
		tblVentas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tblVentasMouseClicked(evt);
				//System.out.println("fila");	
			}
			private void tblVentasMouseClicked(MouseEvent evt) {
				//if(evt.getClickCount()==2) {
				try {
				DConexion cn = new DConexion();
				Connection con = cn.conectarDB();
				
				int fila = tblVentas.rowAtPoint(evt.getPoint());
				FrmDetalleVenta miDetalle = new FrmDetalleVenta();
				miDetalle.setDatos(Integer.parseInt(tblVentas.getValueAt(fila, 0).toString()),Integer.parseInt(tblVentas.getValueAt(fila, 1).toString()),tblVentas.getValueAt(fila, 2).toString(),tblVentas.getValueAt(fila, 3).toString(),tblVentas.getValueAt(fila, 4).toString());
				miDetalle.setVisible(true);
				
				//}
			String titulos[] = {"Codigo","Producto","Cantidad","P/Unitario"};
			String registros[] = new  String [4];
			DefaultTableModel modelo = new DefaultTableModel(null, titulos);
			String sql = "select * from tblDetalleVenta where VentaId = '"+tblVentas.getValueAt(fila, 0).toString()+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				registros[0] = rs.getString(3);
				registros[1] = rs.getString(4);
				registros[2] = rs.getString(5);
				registros[3] = rs.getString(6);
				modelo.addRow(registros);
			}
			miDetalle.setModelo(modelo);
			miDetalle.txtBuscar.setEnabled(false);
			miDetalle.btnGuardar.setEnabled(false);
			MDIPrincipal.jdpEscritorio.add(miDetalle);
			miDetalle.toFront();
			miDetalle.setVisible(true);
				}catch(Exception ex) {
				ex.printStackTrace();
			}
			}
		});
		mostrarDtos();
	}

	
	public void mostrarDtos() {
		Dventas miRes = new Dventas();
		dtVentas = miRes.mostrarVentas();
		tblVentas.setModel(dtVentas);
	}
	

	
}
	

