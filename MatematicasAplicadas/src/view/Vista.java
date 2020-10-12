package view;
import javax.swing.JOptionPane;

public class Vista {

	public int metodoSeleccion () {

		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccion una opcion del menu \n"
				+ "1. Seleccion por ruleta \n" 
				+ "2. Seleccion por torneo determinista \n"
				+ "3. Seleccion por torneo probilistico \n"
				+ "4. Seleccion por muestreo por restos \n"
				));
		
		return opcion;
		
	}
	public String pedirDato(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}
	
	public void mostrarDato(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
	}
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE, mensaje, 0);
	}	
	public int confirmarAccion(String mensaje) {
		// TODO Auto-generated method stub
		return JOptionPane.showConfirmDialog(null, mensaje);
	}
	
}
