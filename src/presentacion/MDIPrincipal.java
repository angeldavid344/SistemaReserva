package presentacion;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class MDIPrincipal extends JFrame {

	
	
	//declaramos componentes
	private JMenuBar miBarraMenu;
	private JMenu jmiMenuRegistros, jmiMenuOpciones, jmiMenuConsultas;
	private JMenuItem jmItemReservas, jmItemVentas, jmItemPlatillos;
	private JMenuItem jmItemUsuarios, jmItemConsultasV;
	public static JDesktopPane jdpEscritorio;
	String Us;
	
	public MDIPrincipal() {
		setTitle("...:: Sistema para reservaciones :: ...");
		setSize(1100,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//creamos iconos
		Image icon= new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage();
		setIconImage(icon);
		
		/*ImageIcon immenuReg = new ImageIcon(getClass().getResource("/imagenes/mregistro.png"));
		ImageIcon immenuCon = new ImageIcon(getClass().getResource("/imagenes/mconsultas.png"));
		ImageIcon immenuOp = new ImageIcon(getClass().getResource("/imagenes/mopciones.png"));
		ImageIcon imitemplatillos = new ImageIcon(getClass().getResource("/imagenes/misplatillos.png"));
		ImageIcon imireservas = new ImageIcon(getClass().getResource("/imagenes/mireservas.png"));
		ImageIcon imiventas = new ImageIcon(getClass().getResource("/imagenes/miventas.png"));
		ImageIcon imiusuarios = new ImageIcon(getClass().getResource("/imagenes/miusuarios.png"));
		ImageIcon imiconven = new ImageIcon(getClass().getResource("/imagenes/miconven.png"));
		*/
		//asignar imagenes
		ImageIcon imNuevo= new ImageIcon(getClass().getResource("/imagenes/mregistro.png"));
		ImageIcon imEditar= new ImageIcon(getClass().getResource("/imagenes/mopciones.png"));
		ImageIcon imGuardar= new ImageIcon(getClass().getResource("/imagenes/mconsultas.png"));
		ImageIcon imCancelar= new ImageIcon(getClass().getResource("/imagenes/misplatillos.png"));
		ImageIcon imEliminar= new ImageIcon(getClass().getResource("/imagenes/misreservas.png"));
		ImageIcon imBuscar= new ImageIcon(getClass().getResource("/imagenes/miventas.png"));
		ImageIcon imCancelarR= new ImageIcon(getClass().getResource("/imagenes/miusuarios.png"));
		ImageIcon imCancelari= new ImageIcon(getClass().getResource("/imagenes/miconven.png"));
		
		
		//crear componentes
		miBarraMenu=new JMenuBar();
		jmiMenuRegistros = new JMenu("Registros");
		jmiMenuOpciones = new JMenu("Opciones");
		jmiMenuConsultas = new JMenu("Consultas");
		jmItemPlatillos = new JMenuItem("Platillos");
		jmItemReservas = new JMenuItem("Reservaciones");
		jmItemVentas = new JMenuItem("Ventas");
		jmItemUsuarios = new JMenuItem("Usuarios");
		jmItemConsultasV = new JMenuItem("Consultas de Ventas");
		
		jmiMenuRegistros.setIcon(imNuevo);
		jmiMenuOpciones.setIcon(imEditar);
		jmiMenuConsultas.setIcon(imGuardar);
		jmItemPlatillos.setIcon(imCancelar);
		jmItemReservas.setIcon(imEliminar);
		jmItemVentas.setIcon(imBuscar);
		jmItemUsuarios.setIcon(imCancelarR);
		jmItemConsultasV.setIcon(imCancelari);
		
		//agregar componentes a la barra de menu
		
		
		jmiMenuRegistros.add(jmItemPlatillos);
		jmiMenuRegistros.add(jmItemVentas);
		jmiMenuRegistros.add(jmItemReservas);
		jmiMenuConsultas.add(jmItemConsultasV);
		jmiMenuOpciones.add(jmItemUsuarios);
		
		miBarraMenu.add(jmiMenuRegistros);
		miBarraMenu.add(jmiMenuConsultas);
		miBarraMenu.add(jmiMenuOpciones);
		
		setJMenuBar(miBarraMenu);
		
		jdpEscritorio = new JDesktopPane();
		getContentPane().add(jdpEscritorio);
		
		jmItemUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) { 
				jmItemUsuariosActionPerformed(evt);
		}});	
		
		jmItemReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) { 
				jmItemReservasActionPerformed(evt);
		}});
		jmItemPlatillos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) { 
				jmItemPlatillosActionPerformed(evt);
		}
			
		});
		jmItemVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) { 
				jmItemVentasActionPerformed(evt);
		}});
		jmItemConsultasV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) { 
				jmItemConsultasVActionPerformed(evt);
		}});
	}
	protected void jmItemConsultasVActionPerformed(ActionEvent evt) {
		FrmConsultarVentas misVentas = new FrmConsultarVentas();
		jdpEscritorio.add(misVentas);
		misVentas.show();
		
	}
	protected void jmItemVentasActionPerformed(ActionEvent evt) {
		FrmVentas misVentas = new FrmVentas();
		jdpEscritorio.add(misVentas);
		misVentas.show();
		
	}
	private void jmItemPlatillosActionPerformed(ActionEvent evt) {
		FrmPlatillos misPlatillos = new FrmPlatillos();
		jdpEscritorio.add(misPlatillos);
		misPlatillos.show();
	}
		
	
	public void setUsuario(String usuario) {
		Us = usuario;
	}
	private void jmItemUsuariosActionPerformed(ActionEvent evt) {
		
		FrmUsuarios misUsuarios = new FrmUsuarios();
		jdpEscritorio.add(misUsuarios);
		misUsuarios.show();
	}
	
private void jmItemReservasActionPerformed(ActionEvent evt) {
		
		FrmReservacion misReservacion = new FrmReservacion();
		jdpEscritorio.add(misReservacion);
		misReservacion.setUs(Us);
		misReservacion.show();
	}
}
