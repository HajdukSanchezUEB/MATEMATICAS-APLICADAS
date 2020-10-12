package View;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Ventanas {

	/**
	 * Muestra mensaje por pantalla
	 * 
	 * @param mensaje - mensaje que se va a mostrar
	 * @param icono   - icono de la ventana emergente
	 */
	public void mostrarMensaje(String mensaje, Icon icono) {
		JOptionPane.showMessageDialog(null, mensaje, "Taller Pre - Parcial 2", JOptionPane.DEFAULT_OPTION, icono);
	}

	/**
	 * Recibe valor ingresado por el usuario
	 * 
	 * @param mensaje - mensaje que se va a mostar
	 * @return - valor que ingreso el usuario
	 */
	public String recibirValor(String mensaje) {
		return JOptionPane.showInputDialog(null, mensaje, "Taller Pre - Parcial 2", JOptionPane.DEFAULT_OPTION);
	}

}
