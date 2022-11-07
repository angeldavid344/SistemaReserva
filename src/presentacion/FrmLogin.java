package presentacion;
import javax.swing.*;

import Datos.DUsuarios;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Image.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FrmLogin extends JFrame{
	//Declaracion de componentes y variables
	private JLabel lblUsuario, lblClave, lblImagen;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JButton btnIngresar, btnCancelar;
	
	
	
public FrmLogin() {
	setTitle("Ingreso al sistema..."); //titulo
	setSize(500,250); // tamaño
	setDefaultCloseOperation(EXIT_ON_CLOSE); // pueda cerrarse
	setLayout(null); // establecer coordenadas
	setLocationRelativeTo(null); //centrar
	setResizable(false);
	

	//crear iconos
	
	Image icon= new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage();
	setIconImage(icon);
	
	ImageIcon imagenLogin= new ImageIcon(getClass().getResource("/imagenes/login.png"));
	
	//Crear Componentes
	lblUsuario=new JLabel ("Usuario: ");
	txtUsuario=new JTextField();
	lblClave=new JLabel("Contraseña: ");
	txtClave=new JPasswordField();
	btnIngresar=new JButton ("Ingresar");
	btnCancelar=new JButton ("Cancelar");
	lblImagen=new JLabel();
	
	
	//asignar iconos
	lblImagen.setIcon(imagenLogin);
	
	
	
	
	//agregar componentes a ventana
	
	add(lblUsuario);
	add(txtUsuario);
	add(lblClave);
	add(txtClave);
	add(btnIngresar);
	add(btnCancelar);
	add(lblImagen);
	//asignar posiciones
	
	lblImagen.setBounds(20, 20, 150, 150);
	
	lblUsuario.setBounds(220, 50, 100, 25);
	txtUsuario.setBounds(310, 50, 150, 25);
	
	lblClave.setBounds(220, 90, 100, 25);
	txtClave.setBounds(310, 90, 150, 25);
	
	btnIngresar.setBounds(200, 150, 100, 25);
	btnCancelar.setBounds(310, 150, 150, 25);

	btnIngresar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) { 
			btnIngresarActionPerformed(evt);
		
	}});
	
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) { 
			btnCancelarActionPerformed(evt);
	}});
	
	
	
}
private void btnIngresarActionPerformed(ActionEvent evt) {
     
	DUsuarios miUsuario=new DUsuarios();
	String Usuario = txtUsuario.getText();
	String Clave = new String(txtClave.getPassword());
    if(miUsuario.validadLogin(Usuario, Clave)==1) {
    	this.dispose();
    	MDIPrincipal miprincipal=new MDIPrincipal();
    	miprincipal.setLocationRelativeTo(null);
    	miprincipal.setUsuario(Usuario);
    	miprincipal.setExtendedState(Frame.NORMAL);
    	miprincipal.setVisible(true);
    }else {
    	JOptionPane.showMessageDialog(this, "Usuario y/o Clave incorrectos");
    	txtUsuario.setText("");
    	txtClave.setText("");
    	txtUsuario.requestFocusInWindow();
    }
	/*MDIPrincipal miprincipal=new MDIPrincipal();
	miprincipal.setLocationRelativeTo(null);
	miprincipal.setVisible(true);
	this.dispose();*/
	
}
private void btnCancelarActionPerformed(ActionEvent evt) {
	System.exit(0);
	
}
}
