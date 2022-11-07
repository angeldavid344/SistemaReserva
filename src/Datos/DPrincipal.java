package Datos;

import presentacion.FrmLogin;
import presentacion.MDIPrincipal;
import java.util.Scanner;
import java.util.Timer;
import java.util.logging.*;

public class DPrincipal {

	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
            if ("Nimbus".equals(info.getName())) {		
 			
            	javax.swing.UIManager.setLookAndFeel(info.getClassName());
            	break;
            }
		  }
			
		}catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(DPrincipal.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
		}catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,ex);
		}catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,ex);
		}catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DPrincipal.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
		}
			
		//MDIPrincipal miPrincipal = new MDIPrincipal();
		FrmLogin milogin =new FrmLogin();
		milogin.setVisible(true);
	
		}
}
