package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Datos.DPlatillos;
import Datos.DReservas;
import logica.LPlatillos;
import logica.LReserva;

public class FrmPlatillos extends JInternalFrame {
	private JLabel lblId,lblNombre,lblCosto,lblImagen;
	private JTextField txtId,txtNombre,txtCosto,txtBuscar;
	private JButton btnNuevo, btnEditar, btnGuardar,btnCancelar, btnBuscar,btnEliminar;
	//private JLabel lblImagen;
	private JTable tblPlatillos;
	private JScrollPane scrpPlatillos;
	private DefaultTableModel dtPlatillos;
	
	
	
	public FrmPlatillos() {
		setSize(700,530);
		setTitle("Platillos - Bebidas");
		setClosable(true);
		setIconifiable(true);
		setLayout(null);
		setVisible(true);
		ImageIcon imPlatillos= new ImageIcon(getClass().getResource("/imagenes/imEspacios.png"));
		lblId = new JLabel("Id:");
		lblNombre = new JLabel ("Nombre:");
		lblCosto = new JLabel ("Costo:");
		lblImagen=new JLabel();
		
		lblImagen.setIcon(imPlatillos);
		
		
		txtId = new JTextField();
		txtNombre = new JTextField();
		txtCosto = new JTextField();
		txtBuscar = new JTextField();
		
		btnNuevo = new JButton("Nuevo");
		btnEditar = new JButton("Editar");
		btnGuardar = new JButton("Guardar");
		btnCancelar = new JButton("Cancelar");
		btnEliminar = new JButton("Eliminar");
		btnBuscar = new JButton("Buscar");
		
		String titulos[]= {"Id","Nombre","Costos"};
		dtPlatillos = new DefaultTableModel(null,titulos);
		tblPlatillos = new JTable(dtPlatillos);
		scrpPlatillos = new JScrollPane(tblPlatillos);
		
		add(lblId);
		add(lblNombre);
		add(lblCosto);
		add(lblImagen);
		add(txtId);
		add(txtNombre);
		add(txtCosto);
		add(txtBuscar);
		add(btnNuevo);
		add(btnEditar);
		add(btnGuardar);
		add(btnCancelar);
		add(btnEliminar);
		add(btnBuscar);
		
		add(scrpPlatillos);
		
		lblImagen.setBounds(20, 40, 150, 150);
		
		ImageIcon imNuevo= new ImageIcon(getClass().getResource("/imagenes/nuevo.png"));
		ImageIcon imEditar= new ImageIcon(getClass().getResource("/imagenes/editar.png"));
		ImageIcon imGuardar= new ImageIcon(getClass().getResource("/imagenes/guardar.png"));
		ImageIcon imCancelar= new ImageIcon(getClass().getResource("/imagenes/cancelar.png"));
		ImageIcon imEliminar= new ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
		ImageIcon imBuscar= new ImageIcon(getClass().getResource("/imagenes/buscar.png"));
		
		lblId.setBounds(180, 50, 100, 25);
		lblNombre.setBounds(180, 80, 100, 25);
		lblCosto.setBounds(180, 110, 100, 25);
		
		txtId.setBounds(240, 50, 100, 25);
		txtNombre.setBounds(240, 80, 150, 25);
		txtCosto.setBounds(240, 110, 150, 25);
		txtBuscar.setBounds(20, 290, 160, 25);
		
		btnNuevo.setBounds(20, 230, 120, 32);
		btnEditar.setBounds(150, 230, 120, 32);
		btnGuardar.setBounds(280, 230, 120, 32);
		btnCancelar.setBounds(410, 230, 120, 32);
		btnEliminar.setBounds(540, 230, 120, 32);
		
		btnNuevo.setIcon(imNuevo);
		btnEditar.setIcon(imEditar);
		btnGuardar.setIcon(imGuardar);
		btnCancelar.setIcon(imCancelar);
		btnEliminar.setIcon(imEliminar);
		btnBuscar.setIcon(imBuscar);
		
		txtBuscar.setBounds(20, 280, 160, 32);
		btnBuscar.setBounds(190, 280, 120, 32);
		
		scrpPlatillos.setBounds(20, 310, 620, 180);
		
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
		tblPlatillos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				//System.out.println("fila");
				tblPlatillosMouseClicked(evt);
			}
		});
		mostrarPlatillos();
	deshabilitar();
	}
	

	public void mostrarPlatillos() {
		DPlatillos miRes = new DPlatillos();
		dtPlatillos = miRes.mostrarPlatillos();
	    tblPlatillos.setModel(dtPlatillos);
	}
public void deshabilitar() {
	
    txtId.setEnabled(false);
	txtNombre.setEnabled(false);
	txtCosto.setEnabled(false);
			
	btnNuevo.setEnabled(true);
	btnEditar.setEnabled(true);
	btnGuardar.setEnabled(false);
	btnCancelar.setEnabled(false);
	btnEliminar.setEnabled(true);
	btnBuscar.setEnabled(true);
}
protected void tblPlatillosMouseClicked(MouseEvent evt) {
	int fila = tblPlatillos.rowAtPoint(evt.getPoint());
	btnEditar.setEnabled(true);
	btnNuevo.setEnabled(false);
	btnCancelar.setEnabled(true);
	txtId.setText(tblPlatillos.getValueAt(fila, 0).toString());
	txtNombre.setText(tblPlatillos.getValueAt(fila, 1).toString());
	txtCosto.setText(tblPlatillos.getValueAt(fila, 2).toString());
}
	protected void btnNuevoActionPerformed(ActionEvent evt) {
		
		txtNombre.setEnabled(true);
		txtCosto.setEnabled(true);
		
		btnNuevo.setEnabled(false);
		btnEditar.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnEliminar.setEnabled(false);
		btnBuscar.setEnabled(false);
		
		txtId.setText("");
		txtNombre.setText("");
		txtCosto.setText("");
	}
    protected void btnEditarActionPerformed(ActionEvent evt) {
    	txtNombre.setEnabled(true);
		txtCosto.setEnabled(true);
		
		btnNuevo.setEnabled(false);
		btnEditar.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnEliminar.setEnabled(false);
		btnBuscar.setEnabled(false);
		
	}
    protected void btnCancelarActionPerformed(ActionEvent evt) {
    	deshabilitar();
	}
    protected void btnGuardarActionPerformed(ActionEvent evt) {
    	if(txtNombre.getText().equals("")) {
    		JOptionPane.showMessageDialog(this, "falta ingresar el nombre","validacion",2);
    		txtNombre.requestFocusInWindow();
    		return;	
    	}
    	if(txtCosto.getText().equals("")) {
    		JOptionPane.showMessageDialog(this, "falta ingresar el Costo","validacion",2);
    		txtCosto.requestFocusInWindow();
    		return;		
    	}
    	if(txtId.getText().equals("")){
    		DPlatillos fn = new DPlatillos();
    		LPlatillos dts = new LPlatillos();
    		
    		dts.setNombre(txtNombre.getText());
    		dts.setCosto(Double.parseDouble(txtCosto.getText()));
    		String msg = fn.insertarPlatillos(dts);
    		JOptionPane.showMessageDialog(this, msg);
    		
    	}else {
    		DPlatillos fn = new DPlatillos();
    		LPlatillos dts = new LPlatillos();
    		
    		dts.setNombre(txtNombre.getText());
    		System.out.println(txtId.getText());
    		dts.setIdPlatillos(Integer.parseInt(txtId.getText()));
    		dts.setCosto(Double.parseDouble(txtCosto.getText()));
    		String msg = fn.editarPlatillos(dts);
    		JOptionPane.showMessageDialog(this, msg);
    	}
    	deshabilitar();
    	mostrarPlatillos();
    }
    protected void btnEliminarActionPerformed(ActionEvent evt) {
    	if(!txtId.getText().equals("")) {
    		int confirmar = JOptionPane.showConfirmDialog(this, "En realidad deseas eliminar el registro?","confirmar",2);
    		if(confirmar==0) {
    			LPlatillos dts=new LPlatillos();
    			DPlatillos fun=new DPlatillos();
    			dts.setIdPlatillos(Integer.parseInt(txtId.getText()));
    			String mensaje = fun.EliminarPlatillos(dts);
    			JOptionPane.showMessageDialog(this, mensaje);
    			mostrarPlatillos();
    		}
    	}
    	
    	
    	
    
    	deshabilitar();
    }
    protected void btnBuscarActionPerformed(ActionEvent evt) {
    	DPlatillos miRes = new DPlatillos();
    	dtPlatillos = miRes.buscarPlatillo(Integer.parseInt(txtBuscar.getText()));
    	tblPlatillos.setModel(dtPlatillos);
	}
    

}
