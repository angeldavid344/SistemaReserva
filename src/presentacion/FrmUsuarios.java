package presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Datos.DUsuarios;
import logica.LUsuarios;
public class FrmUsuarios<ModelEvent> extends JInternalFrame{

	//declarar componentes
	private JLabel lblId,lblNombre,lblApaterno,lblAmaterno,lblImagen;
	private JLabel lblUsuario, lblClave,lblConfirmaClave,lblPerfil,lblbuscar;
	private JTextField txtId, txtNombre,txtApaterno,txtAmaterno;
	private JTextField txtUsuario, txtbuscar;
	private JPasswordField txtClave, txtConfirmarClave;
	private JComboBox cmbPerfil;
	private JButton btnNuevo, btnEditar, btnGuardar, btnCancelar, btnbuscar, btnEliminar;
	private String[] perfil = {"Administrador" , "empleado"};
	private String[] titulos = {"Id" , "Nombre" ,"A/Paterno","A/Materno", "Usuario" , "Clave" , "perfil"};
	private JTable tblUsuarios;
	private JScrollPane scrUsuarios;
	private DefaultTableModel miModelo;
	
	
	
	
	
	
	public FrmUsuarios(){
		
		setSize(840,550);
		setTitle("Usuarios");
		setClosable(true);
		setIconifiable(true);
		setLayout(null);
		
		//crear imagen
		
		ImageIcon imagenLogin= new ImageIcon(getClass().getResource("/imagenes/imEspacios.png"));
		
		ImageIcon imagenbuscar= new ImageIcon(getClass().getResource("/imagenes/miusuarios.png"));

	
		//Crear componentes
		
		lblId = new JLabel ("ID: ");
		lblNombre = new JLabel ("Nombre: ");
		lblApaterno = new JLabel ("Apellido Paterno: ");
		lblAmaterno = new JLabel ("Apellido Materno: ");
		lblUsuario = new JLabel ("Usuario: ");
		lblClave = new JLabel ("Contraseña: ");
		lblConfirmaClave = new JLabel ("Confirma Contraseña: ");
		lblPerfil = new JLabel ("Perfil: ");
        lblImagen = new JLabel ();
        lblbuscar = new JLabel ();
		txtId = new JTextField();
		txtNombre = new JTextField();
		txtApaterno = new JTextField();
		txtAmaterno = new JTextField();
		txtUsuario = new JTextField();
		txtClave = new JPasswordField();
		txtConfirmarClave = new JPasswordField();
		txtbuscar = new JTextField();
		cmbPerfil =new JComboBox(perfil);
		btnbuscar = new JButton("Buscar");
		miModelo = new DefaultTableModel(null,titulos);
		tblUsuarios = new JTable(miModelo);
		scrUsuarios = new JScrollPane(tblUsuarios);
		btnNuevo = new JButton("Nuevo");
		btnEditar = new JButton("Editar");
		btnGuardar = new JButton("Guardar");
		btnCancelar = new JButton("Cancelar");
		btnEliminar = new JButton("Eliminar");
		
		
		//asignar icono
		lblImagen.setIcon(imagenLogin);
		lblbuscar.setIcon(imagenbuscar);

		//agregar componentes
		add(lblId);
		add(lblNombre);
		add(lblApaterno);
		add(lblAmaterno);
		add(lblUsuario);
		add(lblClave);
		add(lblPerfil);
		add(lblConfirmaClave);
		add(lblImagen);
		add(txtId);
		add(txtNombre);
		add(txtApaterno);
		add(txtAmaterno);
		add(txtUsuario);
		add(txtClave);
		add(txtConfirmarClave);
		add(cmbPerfil);
		add(lblbuscar);
		add(txtbuscar);
		add(btnbuscar);
		add(scrUsuarios);
		add(btnNuevo);
		add(btnEditar);
		add(btnGuardar);
		add(btnCancelar);
		add(btnEliminar);


		
		
		//asignar  posiciones
		
		lblImagen.setBounds(20, 40, 150, 150);
		
		lblId.setBounds(230, 20, 180, 25);
		txtId.setBounds(380, 20, 100, 25);
		
		lblNombre.setBounds(230, 50, 180, 25);
		txtNombre.setBounds(370, 50, 180, 25);
		
		lblApaterno.setBounds(230, 90, 180, 25);
		txtApaterno.setBounds(370, 90, 180, 25);
		
		lblAmaterno.setBounds(230, 130, 180, 25);
		txtAmaterno.setBounds(370, 130, 180, 25);
		
		lblUsuario.setBounds(230, 170, 180, 25);
		txtUsuario.setBounds(370, 170, 180, 25);
		
		lblClave.setBounds(230, 210, 180, 25);
		txtClave.setBounds(370, 210, 180, 25);
		
		lblConfirmaClave.setBounds(230 , 250, 180, 25);
		txtConfirmarClave.setBounds(370, 250, 180, 25);
		
		lblPerfil.setBounds(230, 290, 100, 25);
		cmbPerfil.setBounds(370, 290, 130, 25);
		
		lblbuscar.setBounds(50 , 350, 25, 25);
		txtbuscar.setBounds(80, 350, 150, 25);
		btnbuscar.setBounds(240, 350, 100, 25);
		
		btnNuevo.setBounds(700, 80, 100, 25);
		btnEditar.setBounds(700, 120, 100, 25);
		btnGuardar.setBounds(700, 170, 100, 25);
		btnCancelar.setBounds(700, 220, 100, 25);
		btnEliminar.setBounds(700, 270, 100, 25);
		
		
		scrUsuarios.setBounds(50, 390, 800, 150);
		
	cargarUsuarios();
	nomostrarComponentes();
	
	btnbuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			btnBuscarActionPerformed(evt);
		
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
	
	btnGuardar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			btnGuardarActionPerformed(evt);
		
		}
	});
	
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			btnCancelarActionPerformed(evt);
		
		}
	});
	
	btnEliminar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			btnEliminarActionPerformed(evt);
		
		}
	});
	
	tblUsuarios.addMouseListener(new MouseAdapter() {
		
		public void mouseClicked(MouseEvent evt) {
			System.out.println("fila");
			tblUsuariosMouseClicked(evt);
			
		}
		private void tblUsuariosMouseClicked(MouseEvent evt) {
			System.out.println("hola");
			
			int fila = tblUsuarios.rowAtPoint(evt.getPoint());
			txtId.setText(tblUsuarios.getValueAt(fila, 0).toString());
			txtNombre.setText(tblUsuarios.getValueAt(fila, 1).toString());
			txtApaterno.setText(tblUsuarios.getValueAt(fila, 2).toString());
			txtAmaterno.setText(tblUsuarios.getValueAt(fila, 3).toString());
			txtUsuario.setText(tblUsuarios.getValueAt(fila, 4).toString());
			txtClave.setText(tblUsuarios.getValueAt(fila, 5).toString());
			cmbPerfil.setSelectedItem(tblUsuarios.getValueAt(fila, 6).toString());	
		}
	});	
	
	}

	
	private void nomostrarComponentes() {
		
		txtId.setEnabled(false);
		txtNombre.setEnabled(false);
		txtApaterno.setEnabled(false);
		txtAmaterno.setEnabled(false);
		txtUsuario.setEnabled(false);
		txtClave.setEnabled(false);
		txtConfirmarClave.setEnabled(false);
		cmbPerfil.setEnabled(false);
		
		btnNuevo.setEnabled(true);
		btnEditar.setEnabled(true);
		btnEliminar.setEnabled(true);
		btnbuscar.setEnabled(true);
		
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
		
	}
	
	private void simostrarComponentes() {
		
		txtId.setEnabled(false);
		txtNombre.setEnabled(true);
		txtApaterno.setEnabled(true);
		txtAmaterno.setEnabled(true);
		txtUsuario.setEnabled(true);
		txtClave.setEnabled(true);
		txtConfirmarClave.setEnabled(true);
		cmbPerfil.setEnabled(true);
		
		btnNuevo.setEnabled(false);
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnbuscar.setEnabled(false);
		
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		
	}
	
	private void btnNuevoActionPerformed(ActionEvent evt) {
		
		simostrarComponentes();
		txtId.setText("");
		txtNombre.setText("");
		txtApaterno.setText("");
		txtAmaterno.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		txtConfirmarClave.setText("");
		cmbPerfil.setSelectedIndex(-1);	
        txtNombre.requestFocusInWindow();
		
		btnNuevo.setEnabled(false);
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnbuscar.setEnabled(false);
		
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
	}
	
	private void btnBuscarActionPerformed(ActionEvent evt) {
		buscarUsuarios(txtbuscar.getText());
	}
	private void btnCancelarActionPerformed(ActionEvent evt) {
		
		nomostrarComponentes();
		
		
	}
	
	
	private void btnEliminarActionPerformed(ActionEvent evt) {
		System.out.println("hola");
		if(!txtId.getText().equals("")) {
			System.out.println(evt);
			int confirmar = JOptionPane.showConfirmDialog(this, "En realidad deseas eliminar el registro?","Confirmar",2);
			if(confirmar==0) {
				LUsuarios dta = new LUsuarios();
				DUsuarios fun=new DUsuarios();
				dta.setIdUsuarios(Integer.parseInt(txtId.getText()));
				String mensaje=fun.eliminarUsuarios(dta);
				JOptionPane.showMessageDialog(this, mensaje);			
				cargarUsuarios();
			}
		}
		
	}
	
	private void btnEditarActionPerformed(ActionEvent evt) {
		
		simostrarComponentes();
		
	}
	
	private void btnGuardarActionPerformed(ActionEvent evt) {
		if(txtNombre.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"falta ingresar el nombre");
			txtNombre.requestFocusInWindow();
			return;
		}
		if(txtApaterno.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"falta ingresar el A/Paterno");
			txtApaterno.requestFocusInWindow();
			return;
		}
		if(txtAmaterno.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"falta ingresar el A/Materno");
			txtAmaterno.requestFocusInWindow();
			return;
		}
		if(txtUsuario.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"falta ingresar el Usuario");
			txtUsuario.requestFocusInWindow();
			return;
		}
		String Pass =new String (txtClave.getPassword());
		String ConfirmaPass = new String (txtConfirmarClave.getPassword());
		
		if(Pass.equals("")) {
			JOptionPane.showMessageDialog(this,"falta ingresar la Contraseña");
			txtClave.requestFocusInWindow();
			return;
		}
		if(ConfirmaPass.equals("")) {
			JOptionPane.showMessageDialog(this,"falta Confirmar la Contraseña");
			txtConfirmarClave.requestFocusInWindow();
			return;
		}
		if(!Pass.equals(ConfirmaPass)) {
			JOptionPane.showMessageDialog(this, "La contraseña y la confirmacion no son iguales");
			txtClave.setText("");
			txtConfirmarClave.setText("");
		}
		if(cmbPerfil.getSelectedIndex()==-1) {
			
			JOptionPane.showMessageDialog(this, "Falta seleccionar un perfil");
			cmbPerfil.requestFocusInWindow();
  		return;
		}
		//validar
		
		if(!txtId.getText().equals("")) {
			
			LUsuarios datos = new LUsuarios();
			DUsuarios funciones = new DUsuarios();
			
			datos.setNombre(txtNombre.getText());
			datos.setAPaterno(txtApaterno.getText());
			datos.setAmaterno(txtAmaterno.getText());
			datos.setUsuario(txtUsuario.getText());
			String Clave = new String (txtClave.getPassword());
			datos.setClave(Clave);
			int seleccion = cmbPerfil.getSelectedIndex();
			datos.setPerfil((String)cmbPerfil.getItemAt(seleccion));
			datos.setIdUsuarios(Integer.parseInt(txtId.getText()));
			String mensaje = funciones.editarUsuarios(datos);
			JOptionPane.showMessageDialog(this, mensaje);
			
		}else{
			
			LUsuarios datos = new LUsuarios();
			DUsuarios funciones = new DUsuarios();
			
			datos.setNombre(txtNombre.getText());
			datos.setAPaterno(txtApaterno.getText());
			datos.setAmaterno(txtAmaterno.getText());
			datos.setUsuario(txtUsuario.getText());
			String Clave = new String (txtClave.getPassword());
			datos.setClave(Clave);
			int seleccion = cmbPerfil.getSelectedIndex();
			datos.setPerfil((String)cmbPerfil.getItemAt(seleccion));
			
			String mensaje = funciones.agregarUsuarios(datos);
			JOptionPane.showMessageDialog(this, mensaje);
		}
		cargarUsuarios();
		nomostrarComponentes();
	}
	
	

	
	private void cargarUsuarios() {
		DefaultTableModel miModelo;
		DUsuarios miFun=new DUsuarios();
		miModelo=miFun.mostrarUsuarios();
	    //System.out.println(miModelo.toString());
	    tblUsuarios.setModel(miModelo);
		}
		
	private void buscarUsuarios(String datos) {
		DefaultTableModel miModelo;
		DUsuarios miFun=new DUsuarios();
		miModelo=miFun.buscarUsuarios(datos);
			
			tblUsuarios.setModel(miModelo);
		}
		
	}
	