package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Datos.DReservas;
import logica.LReserva;
import logica.LUsuarios;

public class FrmReservacion extends JInternalFrame{

	private JLabel lblId, lblNombre,lblFecha,lblHora,lblTelefono,lblSala,lblUsuario,lblMUs;
	private JTextField txtId, txtNombre,txtHora,txtTelefono,txtSala,txtbuscar;
	//private JComboBox cmbEstado;
	private JButton btnNuevo, btnEditar, btnGuardar, btnCancelar, btnbuscar, btnEliminar,btnCancelarR;
	private JDateChooser txtFecha;
	private String[] titulos = {"Id" , "Nombre" ,"Fecha", "Hora" , "Telefono" , "Espacio Reservado","Estado","Usuario"};
	private JTable tblReserva;
	private JScrollPane scrReserva;
	private DefaultTableModel miModelo;
	
	public FrmReservacion() {
			setSize(900,600);
			setTitle("Reservaciones");
			setClosable(true);
			setIconifiable(true);
			setLayout(null);
	//creamos componentes
			
			ImageIcon imNuevo= new ImageIcon(getClass().getResource("/imagenes/nuevo.png"));
			ImageIcon imEditar= new ImageIcon(getClass().getResource("/imagenes/editar.png"));
			ImageIcon imGuardar= new ImageIcon(getClass().getResource("/imagenes/guardar.png"));
			ImageIcon imCancelar= new ImageIcon(getClass().getResource("/imagenes/cancelar.png"));
			ImageIcon imEliminar= new ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
			ImageIcon imBuscar= new ImageIcon(getClass().getResource("/imagenes/buscar.png"));
			ImageIcon imCancelarR= new ImageIcon(getClass().getResource("/imagenes/cancelarR.png"));

			
			 lblId = new JLabel("Id");
			 lblNombre = new JLabel("Nombre");
			 lblFecha = new JLabel("Fecha");
			 lblHora = new JLabel("Hora");
			 lblTelefono = new JLabel("Telefono");
			 lblSala = new JLabel("Sala");
			 lblUsuario = new JLabel("Usuario");
			 lblMUs =new JLabel("Usuarios");
			 
			txtId = new JTextField();
			txtNombre = new JTextField();
			txtFecha = new JDateChooser();
			txtHora = new JTextField();
			txtTelefono = new JTextField();
			txtSala = new JTextField();
			txtbuscar = new JTextField();
			
			btnNuevo = new JButton("Nuevo");
			btnEditar = new JButton("Editar");
			btnGuardar = new JButton("Guardar");
			btnCancelar = new JButton("Cancelar");
			btnEliminar = new JButton("Eliminar");
			btnbuscar = new JButton("Buscar");
			btnCancelarR = new JButton("Cancelar reserva");
			
			btnNuevo.setIcon(imNuevo);
			btnEditar.setIcon(imEditar);
			btnGuardar.setIcon(imGuardar);
			btnCancelar.setIcon(imCancelar);
			btnEliminar.setIcon(imEliminar);
			btnbuscar.setIcon(imBuscar);
			btnCancelarR.setIcon(imCancelarR);
			
			
			miModelo = new DefaultTableModel(null,titulos);
			tblReserva = new JTable(miModelo);
			scrReserva = new JScrollPane(tblReserva);
			
			//agregamos componentes
			
			add(lblId);
			add(lblNombre);
			add(lblFecha);
			add(lblHora);
			add(lblTelefono); 
			add(lblSala);
			add(lblUsuario); 
			add(lblMUs);
			
			add(txtId);
			add(txtNombre);
			add(txtFecha);
			add(txtHora);
			add(txtTelefono); 
			add(txtSala);
			add(txtbuscar);
			
			add(btnNuevo);
			add(btnEditar);
			add(btnGuardar);
			add(btnCancelar);
			add(btnEliminar);
			add(btnbuscar);
			add(btnCancelarR);
			
			add(scrReserva);
			
			//posiciones componentes
			
			lblId.setBounds(70, 40, 100, 25);
			 lblNombre.setBounds(70, 70, 100, 25);
			 lblFecha.setBounds(70, 100, 100, 25);
			 lblHora.setBounds(70, 130, 100, 25);
			 lblTelefono.setBounds(70, 160, 100, 25);
			 lblSala.setBounds(70, 190, 100, 25);
			 lblUsuario.setBounds(680, 15, 100, 25);
			 lblMUs.setBounds(745, 15, 100, 25);
			 
			txtId.setBounds(160, 40, 100, 25);
			txtNombre.setBounds(160, 70, 200, 25);
			txtFecha.setBounds(160, 100, 150, 25);
			txtHora.setBounds(160, 130, 100, 25);
			txtTelefono.setBounds(160, 160, 200, 25);
			txtSala.setBounds(160, 190, 150, 25);
			
			btnCancelarR.setBounds(565, 285 ,165, 32);
			btnEliminar.setBounds(735, 285, 120, 32);
			btnNuevo.setBounds(40, 285, 120, 32);
			btnEditar.setBounds(170, 285, 120, 32);
			btnGuardar.setBounds(305, 285, 120, 32);
			btnCancelar.setBounds(440, 285, 120, 32);
			txtbuscar.setBounds(40, 350, 190, 25);
			btnbuscar.setBounds(280, 350, 100, 25);
		
			scrReserva.setBounds(40, 380, 800, 180);
	
		deshabilitar();
	
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnNuevoActionPerformed(evt);
			
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnEditarActionPerformed(evt);
			
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnGuardarActionPerformed(evt);
			
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnEliminarActionPerformed(evt);
			
			}
		});
		btnCancelarR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCancelarRActionPerformed(evt);
			
			}

			
			
		});
		
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnbuscarActionPerformed(evt);
			
			}

			
			
		});
		
		tblReserva.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				//System.out.println("fila");
				tblReservaMouseClicked(evt);
			}
			
				private void tblReservaMouseClicked(MouseEvent evt) {
					int fila = tblReserva.rowAtPoint(evt.getPoint());
					btnEditar.setEnabled(true);
					btnNuevo.setEnabled(false);
					btnCancelar.setEnabled(true);
					txtId.setText(tblReserva.getValueAt(fila, 0).toString());
					txtNombre.setText(tblReserva.getValueAt(fila, 1).toString());
					txtFecha.setDate(Date.valueOf(tblReserva.getValueAt(fila, 2).toString()));
					txtHora.setText(tblReserva.getValueAt(fila, 3).toString());
					txtTelefono.setText(tblReserva.getValueAt(fila, 4).toString());
					txtSala.setText(tblReserva.getValueAt(fila, 5).toString());
					lblMUs.setText(tblReserva.getValueAt(fila, 6).toString());
				}
		
		});
		mostrarReserva();
		
		
	}
	public void mostrarReserva() {
		DReservas miRes = new DReservas();
		miModelo = miRes.mostrarReservacion();
		tblReserva.setModel(miModelo);
	}
	public void setUs(String usuario) {
		lblMUs.setText(usuario);
	}
	
	public void deshabilitar() {
	
		txtId.setEnabled(false);
		txtNombre.setEnabled(false);
		txtFecha.setEnabled(false);
		txtHora.setEnabled(false);
		txtTelefono.setEnabled(false);
		txtSala.setEnabled(false);
		txtbuscar.setEnabled(true);
		
		btnNuevo.setEnabled(true);
		btnEditar.setEnabled(true);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnEliminar.setEnabled(true);
		btnCancelarR.setEnabled(true);
		btnbuscar.setEnabled(true);
	}
	private void btnNuevoActionPerformed(ActionEvent evt) {
		
		txtId.setText("");
		txtNombre.setText("");
		txtFecha.setDate(null);
		txtHora.setText("");
		txtTelefono.setText("");
		txtSala.setText("");
		
		txtId.setEnabled(false);
		txtNombre.setEnabled(true);
		txtFecha.setEnabled(true);
		txtHora.setEnabled(true);
		txtTelefono.setEnabled(true);
		txtSala.setEnabled(true);
		txtbuscar.setEnabled(true);
		
		btnNuevo.setEnabled(false);
		btnEditar.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnEliminar.setEnabled(false);
		btnbuscar.setEnabled(false);
		btnCancelarR.setEnabled(false);
		
	}
private void btnEditarActionPerformed(ActionEvent evt) {
		
		txtId.setEnabled(false);
		txtNombre.setEnabled(true);
		txtFecha.setEnabled(true);
		txtHora.setEnabled(true);
		txtTelefono.setEnabled(true);
		txtSala.setEnabled(true);
		txtbuscar.setEnabled(true);
		
		btnNuevo.setEnabled(false);
		btnEditar.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnEliminar.setEnabled(false);
		btnbuscar.setEnabled(true);
		btnCancelarR.setEnabled(false);
		
	}
private void btnCancelarActionPerformed(ActionEvent evt) {
	
	txtId.setEnabled(false);
	txtNombre.setEnabled(false);
	txtFecha.setEnabled(false);
	txtHora.setEnabled(false);
	txtTelefono.setEnabled(false);
	txtSala.setEnabled(false);
	txtbuscar.setEnabled(false);
	
	btnNuevo.setEnabled(true);
	btnEditar.setEnabled(true);
	btnGuardar.setEnabled(false);
	btnCancelar.setEnabled(false);
	btnEliminar.setEnabled(true);
	btnCancelarR.setEnabled(true);
	btnbuscar.setEnabled(false);
	
	
}
private void btnGuardarActionPerformed(ActionEvent evt) {
	if(txtNombre.getText().equals("")) {
		JOptionPane.showMessageDialog(this, "falta ingresar el nombre","validacion",2);
		txtNombre.requestFocusInWindow();
		return;	
	}
	if(txtFecha.getDate()== null) {
		JOptionPane.showMessageDialog(this, "falta ingresar la fecha","validacion",2);
		txtFecha.requestFocusInWindow();
		return;	
	}
	if(txtHora.getText().equals("")) {
		JOptionPane.showMessageDialog(this, "falta ingresar la hora","validacion",2);
		txtHora.requestFocusInWindow();
		return;	
	}
	if(txtTelefono.getText().equals("")) {
		JOptionPane.showMessageDialog(this, "falta ingresar el telefono","validacion",2);
		txtTelefono.requestFocusInWindow();
		return;	
	}
	if(txtSala.getText().equals("")) {
		JOptionPane.showMessageDialog(this, "falta ingresar la Sala","validacion",2);
		txtSala.requestFocusInWindow();
		return;	
	}
	if(lblMUs.getText().equals("")) {
		JOptionPane.showMessageDialog(this, "falta ingresar el usuario","validacion",2);
		lblMUs.requestFocusInWindow();
		return;	
	}
	if(txtId.getText().equals("")) {
		DReservas fn = new DReservas();
		LReserva dts = new LReserva();
		
		dts.setNombre(txtNombre.getText());
		Calendar cal;
		cal = txtFecha.getCalendar();
		int d, m, a;
		d=cal.get(Calendar.DAY_OF_MONTH);
		m=cal.get(Calendar.MONTH);
		a = cal.get(Calendar.YEAR) - 1900;
		dts.setFecha(new Date(a,m,d));
		dts.setHora(txtHora.getText());
		dts.setTelefono(txtTelefono.getText());
		dts.setSala(txtSala.getText());
		dts.setUsuario(lblMUs.getText());
		String msg = fn.insertarReserva(dts);
		JOptionPane.showMessageDialog(rootPane, msg);
	}else {
		DReservas fn = new DReservas();
		LReserva dts = new LReserva();
		
		dts.setNombre(txtNombre.getText());
		Calendar cal;
		cal = txtFecha.getCalendar();
		int d, m, a;
		d=cal.get(Calendar.DAY_OF_MONTH);
		m=cal.get(Calendar.MONTH);
		a = cal.get(Calendar.YEAR) - 1900;
		dts.setFecha(new Date(a,m,d));
		dts.setHora(txtHora.getText());
		dts.setTelefono(txtTelefono.getText());
		dts.setSala(txtSala.getText());
		dts.setUsuario(lblMUs.getText());
		dts.setIdReserva(Integer.parseInt(txtId.getText()));
		String msg = fn.editarReserva(dts);
		JOptionPane.showMessageDialog(rootPane, msg);
	
}
	mostrarReserva();
	txtId.setEnabled(false);
	txtNombre.setEnabled(false);
	txtFecha.setEnabled(false);
	txtHora.setEnabled(false);
	txtTelefono.setEnabled(false);
	txtSala.setEnabled(false);
	txtbuscar.setEnabled(true);
	
	
	btnNuevo.setEnabled(true);
	btnEditar.setEnabled(true);
	btnGuardar.setEnabled(false);
	btnCancelar.setEnabled(false);
	btnEliminar.setEnabled(true);
	btnCancelarR.setEnabled(true);
	btnbuscar.setEnabled(true);
	
	
}
private void btnEliminarActionPerformed(ActionEvent evt) {
	
	if(!txtId.getText().equals("")) {
		int confirmar = JOptionPane.showConfirmDialog(this, "En realidad deseas eliminar el registro?","confirmar",2);
		if(confirmar==0) {
			LReserva dts=new LReserva();
			DReservas fun=new DReservas();
			dts.setIdReserva(Integer.parseInt(txtId.getText()));
			String mensaje = fun.EliminarReserva(dts);
			JOptionPane.showMessageDialog(this, mensaje);
			mostrarReserva();
		}
	}
	
	
	
}
protected void btnCancelarRActionPerformed(ActionEvent evt) {
	if (!txtId.getText().equals("")) {
		int confirmar = JOptionPane.showConfirmDialog(this, "En realidad deseas cancelar el registro?",
				"confirmar", 2);
		if (confirmar == 0) {
			DReservas fn = new DReservas();
			LReserva dts = new LReserva();
			dts.setIdReserva(Integer.parseInt(txtId.getText()));
			String msg = fn.CancelarReserva(dts);
			JOptionPane.showMessageDialog(rootPane, msg);
			mostrarReserva();
		}
	}
}

protected void btnbuscarActionPerformed(ActionEvent evt) {
	DReservas miRes = new DReservas();
	miModelo = miRes.buscarReservacion(Integer.parseInt(txtbuscar.getText()));
	tblReserva.setModel(miModelo);
}

}