package vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Vista {

	public void mostrarMensaje(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public String recibirValor(String mensaje, String titulo) {
		return JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostarJframe() {
		JFrame ventana = new JFrame("Criba de Eratóstenes");
		
		int posX= 0;
		int posY= 52;
		for (int i = 0; i < 15; i++) {
			JPanel panel = new JPanel();
			panel.setBounds(posX, 0, 50, 50);
			panel.setBackground(Color.blue);
			posX += 52;
			ventana.add(panel);
			if (i == 15) {
				for (int j = 0; j < 15; j++) {
					posX = 0;
					JPanel pane2 = new JPanel();
					panel.setBounds(posX, posY, 50, 50);
					panel.setBackground(Color.black);
					posX += 52;
					ventana.add(panel);
				}
			}
			
		}
		
		
	    ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setSize(800, 700);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true); 
		

	}

}
