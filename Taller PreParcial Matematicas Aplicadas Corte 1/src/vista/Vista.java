package vista;

import javax.swing.JOptionPane;

public class Vista {

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Taller Pre-Parcial", JOptionPane.INFORMATION_MESSAGE);
	}

	public String recibirValor(String mensaje) {
		return JOptionPane.showInputDialog(null, mensaje, "Taller Pre-Parcial", JOptionPane.INFORMATION_MESSAGE);
	}

}
