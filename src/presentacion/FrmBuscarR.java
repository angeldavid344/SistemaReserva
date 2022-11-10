package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Datos.DReservas;


public class FrmBuscarR extends JFrame {

	private JTextField txtBuscar,txtNombre;
	private JButton btnBuscar,btnGuardar,btnCancelar,btnNuevo;
	private JTable tblBuscar;
	private JScrollPane scrpBuscar;
	private DefaultTableModel dtmBuscar;
	private JLabel lblNombre;
	
	public FrmBuscarR() {
		setTitle("Seleccione una reservacion");
		setLayout(null);
		setSize(535,520);
		setVisible(true);
		
		ImageIcon imNuevo= new ImageIcon(getClass().getResource("/imagenes/nuevo.png"));
		ImageIcon imGuardar= new ImageIcon(getClass().getResource("/imagenes/guardar.png"));
		ImageIcon imCancelar= new ImageIcon(getClass().getResource("/imagenes/cancelar.png"));
		
		txtBuscar = new JTextField();
		btnBuscar = new JButton("Buscar");
		txtNombre = new JTextField();
		lblNombre = new JLabel("Nombre:");
		
		String titulos[]= {"Id" , "Nombre" ,"Fecha", "Hora" , "Telefono" };
		dtmBuscar = new DefaultTableModel(null,titulos);
		tblBuscar = new JTable(dtmBuscar);
		scrpBuscar = new JScrollPane(tblBuscar);
		
		btnCancelar = new JButton("Cancelar");
		btnGuardar = new JButton("Guardar");
		btnNuevo = new JButton("Nuevo");
		
		btnNuevo.setIcon(imNuevo);
		btnCancelar.setIcon(imGuardar);
		btnGuardar.setIcon(imCancelar);
		
		
		
		add(txtBuscar);
		add(btnBuscar);
		add(scrpBuscar);
		
		txtBuscar.setBounds(20, 40, 160, 25);
		btnBuscar.setBounds(190, 37, 120, 32);
		scrpBuscar.setBounds(20, 75, 480, 200);
		mostrarReserva();
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.out.println("fila");
				btnBuscarActionPerformed(evt);
			}
		});
		
		
		
		
		
		
		
		
		tblBuscar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tblBuscarMouseClicked(evt);
				//System.out.println("fila");	
			}
			private void tblBuscarMouseClicked(MouseEvent evt) {
				//if(evt.getClickCount()==2) {
					String id = tblBuscar.getValueAt(tblBuscar.getSelectedRow(),0).toString();
					String nombre = tblBuscar.getValueAt(tblBuscar.getSelectedRow(),1).toString();
					FrmVentas.setReserva(id, nombre);
				//}
			}
		});
	}
				
	
	
	
	
		protected void btnBuscarActionPerformed(ActionEvent evt) {
			DReservas miRes = new DReservas();
			dtmBuscar = miRes.buscarReservacion(Integer.parseInt(txtBuscar.getText()));
			tblBuscar.setModel(dtmBuscar);
			
		}
		public void mostrarReserva() {
			DReservas miRes = new DReservas();
			dtmBuscar = miRes.mostrarReservacion();
			tblBuscar.setModel(dtmBuscar);
		}
}
