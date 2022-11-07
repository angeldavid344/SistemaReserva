package presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Datos.DReservas;
import Datos.Dventas;
import logica.Lventas;
public class FrmVentas extends JInternalFrame {
	
	private JTextField txtId;
	private static JTextField txtIdReserva;
	private static JTextField txtNombre;
	private JTextField txtBuscar;
	private JDateChooser dcFecha;
	private JLabel lblId,lblIdReserva,lblNombre,lblFecha,lblHora,lblImagen;
	private JButton btnNuevo, btnEditar, btnGuardar,btnCancelar, btnBuscar,btnEliminar,btnBuscarR;
	private JTable tblVentas;
	private JScrollPane scrpVentas;
	private DefaultTableModel dtVentas;
	
	String hora,minutos,segundos,dia,mes,year;
	Calendar calendario;
	Thread h1;
	Font f1 = new Font("segoe UI", Font.BOLD, 14);
	
	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			java.util.Date hora = new java.util.Date();
			String patron = "hh:mm:ss";
			SimpleDateFormat formato = new SimpleDateFormat(patron);
			lblHora.setText(formato.format(hora));
		}
	};
	
	public FrmVentas() {
		setSize(800, 560);
		setTitle("Ventas");
		setClosable(true);
		setIconifiable(true);
		setLayout(null);
		setVisible(true);

		
		
		ImageIcon imVentas= new ImageIcon(getClass().getResource("/imagenes/imEspacios.png"));
		ImageIcon imNuevo= new ImageIcon(getClass().getResource("/imagenes/nuevo.png"));
		ImageIcon imEditar= new ImageIcon(getClass().getResource("/imagenes/editar.png"));
		ImageIcon imGuardar= new ImageIcon(getClass().getResource("/imagenes/guardar.png"));
		ImageIcon imCancelar= new ImageIcon(getClass().getResource("/imagenes/cancelar.png"));
		ImageIcon imEliminar= new ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
		ImageIcon imBuscar= new ImageIcon(getClass().getResource("/imagenes/buscar.png"));
		
		lblId = new JLabel("Id:");
		txtId = new JTextField();
		
		lblIdReserva = new JLabel("Id R:");
		txtIdReserva = new JTextField();
		
		lblNombre = new JLabel("Nombre:");
		txtNombre = new JTextField();
		
		
		
		lblFecha = new JLabel("Fecha:");
		dcFecha = new JDateChooser();
		
		lblHora = new JLabel("Hora:");
		
		lblHora.setFont(f1);
		lblHora.setText("00:00:00");
		Timer t = new Timer(1000, al);
		t.start();
		
		lblImagen=new JLabel();
		lblImagen.setIcon(imVentas);
		
		String titulos[]= {"IdVenta","IdReserva","Nombre","Hora"};
		dtVentas = new DefaultTableModel(null,titulos);
		tblVentas = new JTable(dtVentas);
		scrpVentas = new JScrollPane(tblVentas);

		btnNuevo = new JButton("Nuevo");
		btnEditar = new JButton("Editar");
		btnGuardar = new JButton("Guardar");
		btnCancelar = new JButton("Cancelar");
		btnEliminar = new JButton("Eliminar");
		txtBuscar = new JTextField();
		btnBuscar = new JButton("Buscar");
		
		btnNuevo.setIcon(imNuevo);
		btnEditar.setIcon(imEditar);
		btnGuardar.setIcon(imGuardar);
		btnCancelar.setIcon(imCancelar);
		btnEliminar.setIcon(imEliminar);
		btnBuscar.setIcon(imBuscar);
		
		btnBuscarR = new JButton("...");
		
		add(lblImagen);
		add(lblId);
		add(txtId);
		add(lblIdReserva);
		add(txtIdReserva);
		add(lblNombre);
		add(txtNombre);
		add(lblFecha);
		add(dcFecha);
		add(lblHora);
		add(txtBuscar);
		add(btnNuevo);
		add(btnEditar);
		add(btnGuardar);
		add(btnCancelar);
		add(btnEliminar);
		add(btnBuscar);
		add(btnBuscarR);
		
		add(scrpVentas);
		
		lblImagen.setBounds(20, 40, 150, 150);
		
		lblId.setBounds(190, 50, 100, 25);
		txtId.setBounds(260, 50, 100, 25);
		
		lblIdReserva.setBounds(190, 20, 100, 25);
		txtIdReserva.setBounds(260, 20, 100, 25);
		
		lblNombre.setBounds(190, 80, 100, 25);
		txtNombre.setBounds(260, 80, 160, 25);
		btnBuscarR.setBounds(430,80,50,25);
		
		lblFecha.setBounds(190, 120, 100, 25);
		dcFecha.setBounds(260, 120, 160, 25);
		
		lblHora.setBounds(650, 30, 100, 25);
		
		btnBuscar.setBounds(190, 266, 120, 32);
		txtBuscar.setBounds(20, 270, 160, 25);
		btnNuevo.setBounds(50, 210, 120, 32);
		btnEditar.setBounds(190, 210, 120, 32);
		btnGuardar.setBounds(330, 210, 120, 32);
		btnCancelar.setBounds(470, 210, 120, 32);
		btnEliminar.setBounds(610, 210, 120, 32);
		
		scrpVentas.setBounds(20, 300, 660,200 );
		
		btnBuscarR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnBuscarRActionPerformed(evt);
			}
		});
		
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
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnBuscarActionPerformed(evt);
			
			}
		});
		tblVentas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				//System.out.println("fila");
				tblVentasMouseClicked(evt);
			}
		});
		txtId.setEnabled(false);
		txtIdReserva.setEnabled(false);
		habilitarheshabilitar(true);
		limpiar();
		mostrarDtos();
	}

	public void mostrarDtos() {
		Dventas miRes = new Dventas();
		dtVentas = miRes.mostrarVentas();
		tblVentas.setModel(dtVentas);
	}
	protected void btnBuscarRActionPerformed(ActionEvent evt) {
		FrmBuscarR mi = new FrmBuscarR();
		mi.setVisible(true);
		mi.setLocationRelativeTo(null);
		
	}


	public void habilitarheshabilitar(boolean b) {
		btnNuevo.setEnabled(b);
		btnEditar.setEnabled(b);
		btnGuardar.setEnabled(!b);
		btnCancelar.setEnabled(!b);
		btnEliminar.setEnabled(b);
		btnBuscarR.setEnabled(!b);
		
		txtNombre.setEditable(!b);
		dcFecha.setEnabled(!b);
	}

	public void limpiar() {
		txtId.setText("");
		txtIdReserva.setText("");
		txtNombre.setText("");
		dcFecha.setDate(null);
	}
	protected void tblVentasMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		
	}



	protected void btnBuscarActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}



	protected void btnEliminarActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		limpiar();
	}



	protected void btnGuardarActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if(txtId.getText().equals("")){
			Lventas dts = new Lventas();
			Dventas fn = new Dventas();
			
			dts.setIdR(Integer.parseInt(txtIdReserva.getText()));
			Calendar cal;
			int d, m, a;
			cal = dcFecha.getCalendar();
			d= cal.get(Calendar.DAY_OF_MONTH);
			m = cal.get(Calendar.MONTH);
			a = cal.get(Calendar.YEAR)-1900;
			dts.setFecha(new Date(a,m,d));
			dts.setHora(lblHora.getText());
			String msg = fn.insertarVenta(dts);
			JOptionPane.showMessageDialog(this, msg);
			
		}else {
			Lventas dts = new Lventas();
			Dventas fn = new Dventas();
			
			dts.setIdR(Integer.parseInt(txtIdReserva.getText()));
			Calendar cal;
			int d, m, a;
			cal = dcFecha.getCalendar();
			d= cal.get(Calendar.DAY_OF_MONTH);
			m = cal.get(Calendar.MONTH);
			a = cal.get(Calendar.YEAR)-1900;
			dts.setFecha(new Date(a,m,d));
			dts.setHora(lblHora.getText());
			dts.setId(Integer.parseInt(txtId.getText()));
			String msg = fn.insertarVenta(dts);
			JOptionPane.showMessageDialog(this, msg);
		}
		mostrarDtos();
		habilitarheshabilitar(true);
		limpiar();
		
	}



	protected void btnCancelarActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		habilitarheshabilitar(true);
		limpiar();
	}



	protected void btnEditarActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		habilitarheshabilitar(false);
	}



	protected void btnNuevoActionPerformed(ActionEvent evt) {
		habilitarheshabilitar(false);
		limpiar();
	}


	public static void setReserva(String Id, String string) {
		System.out.println(string);
		txtIdReserva.setText(Id);
		txtNombre.setText(string);
		
	}
}

