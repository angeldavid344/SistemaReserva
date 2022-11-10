package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



import Datos.DConexion;

public class FrmDetalleVenta extends JInternalFrame {

	
	DConexion cn = new DConexion();
	Connection con = cn.conectarDB();
	private JTextField txtIdVenta;
	private JTable tblDetalle;
	private JScrollPane scrpDetalle;
	private DefaultTableModel dtmDetalle;
	public JButton btnReporte,btnGuardar;
	String titulos [] = {"Codigo","Producto","Cantidad","P/Unitario"};
	
	private JLabel lblCodigoV, lblCodigoR, lblNombre, lblFecha, lblHora;
	public JTextField txtCodigoV,txtCodigoR,txtNombre,txtFecha,txtHora,txtBuscar;
	private JLabel lblTotal;
	private JTextField txtTotal;
	
	public FrmDetalleVenta() {
		setTitle("Detalle de venta");
		setSize(777,650);
		setClosable(true);
		setIconifiable(true);
		setLayout(null);
		setVisible(true);
		
		ImageIcon imReporte= new ImageIcon(getClass().getResource("/imagenes/nuevo.png"));
		ImageIcon imGuardar= new ImageIcon(getClass().getResource("/imagenes/guardar.png"));
		
		dtmDetalle = new DefaultTableModel(null, titulos);
		tblDetalle = new JTable(dtmDetalle);
		scrpDetalle = new JScrollPane(tblDetalle);
		txtIdVenta = new JTextField();
		
		txtCodigoV = new JTextField();
		lblCodigoV = new JLabel("Codigo de venta:");
		txtCodigoR = new JTextField();
		lblCodigoR = new JLabel("Codigo de reserva:");
		txtNombre = new JTextField();
		lblNombre = new JLabel("Nombre:");
		txtFecha = new JTextField();
		lblFecha = new JLabel("Fecha:");
		txtHora = new JTextField();
		lblHora = new JLabel("Hora:");
		
		
		btnReporte = new JButton("Generar Reporte");
		btnGuardar = new JButton("Guardar"); 
		txtBuscar = new JTextField();
		lblTotal = new JLabel("Total:");
		txtTotal = new JTextField();
		
		btnReporte.setIcon(imReporte);
		btnGuardar.setIcon(imGuardar);
			
		txtBuscar.setBorder(BorderFactory.createTitledBorder("Ingrese el codigo"));
		
		//add(txtIdVenta);
		add(scrpDetalle);
		
		add(lblHora);
		add(lblFecha);
		add(lblNombre);
		add(lblCodigoR);
		add(lblCodigoV);
		
		add(txtHora);
		add(txtFecha);
		add(txtNombre);
		add(txtCodigoR);	
		add(txtCodigoV);
		add(btnReporte);
		add(btnGuardar);
		add(txtBuscar);
		
		add(lblTotal);
		add(txtTotal);
		
		//txtIdVenta.setBounds(20, 40, 100, 25);
		scrpDetalle.setBounds(20, 300, 720, 250);
		
		lblCodigoV.setBounds(180, 50, 180, 25);
		txtCodigoV.setBounds(300, 50, 100, 25);
		
		lblCodigoR.setBounds(180, 80, 180, 25);
		txtCodigoR.setBounds(300, 80, 180, 25);
		
		lblNombre.setBounds(180, 110, 180, 25);
		txtNombre.setBounds(300, 110, 180, 25);
		
		lblFecha.setBounds(180, 140, 180, 25);
		txtFecha.setBounds(300, 140, 180, 25);
		
		lblHora.setBounds(180, 170, 180, 25);
		txtHora.setBounds(300, 170, 180, 25);
		
		txtBuscar.setBounds(20, 225, 250, 70);
		
		btnReporte.setBounds(340, 240, 180, 50);
		btnGuardar.setBounds(560, 240, 180, 50);
		
		lblTotal.setBounds(570, 560, 100, 30);
		txtTotal.setBounds(640, 560, 100, 30);
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnGuardarActionPerformed(evt);
			}
		});
		
		txtBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtBuscarActionPerformed(evt);
			}
		});
		
		personalizarJTable();
		bloquear();
		//txtBuscar.setText("0,00");
		txtTotal.setText("0.00");
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		
		addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
			public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
			}
			public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
			}
			public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
			}
			public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
			}
			public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
			}
			public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
			}
			public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
				formInternalFrameOpened(evt);
			}
		});
		
		
	}
	protected void formInternalFrameOpened(InternalFrameEvent evt) {

	personalizarJTable();
	DecimalFormat formateador = new DecimalFormat("######.00");
	DecimalFormatSymbols dfs = formateador.getDecimalFormatSymbols();
	dfs.setDecimalSeparator('.');
	formateador.setDecimalFormatSymbols(dfs);
			int fila = tblDetalle.getRowCount();
			double sumatorial = 0.0;
			for (int i = 0; fila > i; i++) {
			int cantidad = Integer.parseInt(tblDetalle.getValueAt(i, 2).toString()) ;
			double punitario = Double.parseDouble(tblDetalle.getValueAt(i, 3).toString());
			double resultado = cantidad * punitario;
			sumatorial += resultado;
			txtTotal.setText("$ "+formateador.format(sumatorial));
			}
			
		}
		
	private void btnGuardarActionPerformed(ActionEvent evt) {
		try {
			
		
			
			int fila , ventaid;
			double punitario;
			String sql = "insert into tblDetalleVenta(VentaId, Codigo, Descripcion, Cantidad, PUnitario) values(?,?,?,?,?)";
			for( fila = 0; fila < tblDetalle.getRowCount();fila++) {
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setInt(1, Integer.parseInt(txtCodigoV.getText()));
					pst.setInt(2, Integer.parseInt(tblDetalle.getValueAt(fila, 0).toString()));
					pst.setString(3, tblDetalle.getValueAt(fila, 1).toString());
					pst.setInt(4, Integer.parseInt(tblDetalle.getValueAt(fila, 2).toString()));
					pst.setDouble(5, Double.parseDouble(tblDetalle.getValueAt(fila, 3).toString()));
					pst.executeUpdate();
			}
			limpiartbl();
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
	}
	public void limpiartbl() {
		try {
			DefaultTableModel miModelo = (DefaultTableModel) tblDetalle.getModel();
			int fila = tblDetalle.getRowCount();
			for(int i = 0; fila > i; i++) {
				miModelo.removeRow(0);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
	}
	public void txtBuscarActionPerformed(ActionEvent evt) {
		String codigo = txtBuscar.getText();
		if(!productoenTbl(codigo)) {
			buscarDts(codigo);
		}
	}
	public boolean productoenTbl(String codigo) {
		boolean resultado = false;
		int fila, cantidad,totalproductos;
		double precio, total;
		
		DecimalFormat formateador = new DecimalFormat("######.00");
		DecimalFormatSymbols dfs = formateador.getDecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		formateador.setDecimalFormatSymbols(dfs);
		
		if(!codigo.equals("")) {
			for(fila = 0; fila < tblDetalle.getRowCount();fila++) {
				
				if(tblDetalle.getValueAt(fila, 0).toString().equals(codigo)) {
					cantidad = Integer.parseInt(tblDetalle.getValueAt(fila, 2).toString());
					precio = Double.parseDouble(tblDetalle.getValueAt(fila, 3).toString());
					totalproductos = cantidad + 1;
					tblDetalle.getModel().setValueAt(totalproductos, fila, 2);
					txtBuscar.getText();
					total = Double.parseDouble(txtTotal.getText()) + precio;
					txtTotal.setText(formateador.format(total));
					resultado = true;
				}
			}
		}
		return resultado;
	}
	public void buscarDts(String codigo) {
		DefaultTableModel miModelo = (DefaultTableModel) tblDetalle.getModel();
		Object [] registros = new Object[4];
		double preciou, total;
		//
		DecimalFormat formateador = new DecimalFormat("######.00");
		DecimalFormatSymbols dfs = formateador.getDecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		formateador.setDecimalFormatSymbols(dfs);
		//
		if(!codigo.equals("")) {
			try {
				String sql = "select * from tblPlatillos where IdPlatillos = "+codigo+"";
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					registros[0] = rs.getString(1);
					registros[1] = rs.getString(2);
					registros[2] = "1";
					registros[3] = rs.getString(3);
					miModelo.insertRow(0,registros);
					
					preciou = Double.parseDouble(rs.getString(3));
					total = Double.valueOf(txtTotal.getText()) + Double.valueOf(preciou);
					txtTotal.setText(formateador.format(total));
					
				}
				txtBuscar.setText("");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void bloquear() {
		txtCodigoV.setEnabled(false);
		txtCodigoR.setEnabled(false);
		txtNombre.setEnabled(false);
		txtFecha.setEnabled(false);
		txtHora.setEnabled(false);
		txtTotal.setEnabled(false);
	}
	
	public void personalizarJTable() {
		tblDetalle.getTableHeader().setReorderingAllowed(false);
		tblDetalle.getColumn("Codigo").setWidth(80);
		tblDetalle.getColumn("Codigo").setPreferredWidth(80);
		tblDetalle.getColumn("Producto").setWidth(285);
		tblDetalle.getColumn("Producto").setPreferredWidth(285);
		tblDetalle.setFont(new Font("Comic Sans MS",1,14));
		DefaultTableCellRenderer cellAlinear = new DefaultTableCellRenderer();
		cellAlinear.setHorizontalAlignment(SwingConstants.RIGHT);
		tblDetalle.getColumnModel().getColumn(2).setCellRenderer(cellAlinear);
		tblDetalle.getColumnModel().getColumn(3).setCellRenderer(cellAlinear);
		tblDetalle.getTableHeader().setBackground(Color.CYAN);
		tblDetalle.getTableHeader().setForeground(Color.BLUE);
		//tblDetalle.getTableHeader().setFont(new Font("Comic Sans MS",1,14));
		
	}
	
	
	public void setDatos(int idv, int idr, String nombre, String fecha, String hora ) {
		//txtIdVenta.setText(String.valueOf(id));
		txtHora.setText(String.valueOf(hora));
		txtFecha.setText(String.valueOf(fecha));
		txtNombre.setText(String.valueOf(nombre));
		txtCodigoR.setText(String.valueOf(idr));
		txtCodigoV.setText(String.valueOf(idv));
	}
	public void setModelo(DefaultTableModel modelo) {
		personalizarJTable();
		tblDetalle.setModel(modelo);
		
	}
}