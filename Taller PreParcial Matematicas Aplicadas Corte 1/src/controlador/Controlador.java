package controlador;

import modelo.Funcion;
import vista.Vista;

public class Controlador {

	private Vista vista;
	private Funcion modelo1;

	public Controlador() {
		vista = new Vista();
		modelo1 = new Funcion();
		pedirEjercicio();
	}

	private void pedirEjercicio() {
		vista.mostrarMensaje("Bienvenido al taller Pre-Parcial del primer corte.\nMatemáticas aplicadas.");
		int opcion = 0;
		do {
			opcion = Integer.parseInt(vista.recibirValor("Seleccione el ejercicio a realizar:"
					+ "\n1. Método de congruencia lineal." + "\n2. Método de Montecarlo." + "\n3. Criba de Eratóstenes."
					+ "\n4. Aritmética modular 1." + "\n5. Aritmética modular 2." + "\n6. Salir."));
			switch (opcion) {
			case 1:
				ejercicio1();
				break;
			case 2:
				ejercicio2();
				break;
			case 3:
				ejercicio3();
				break;
			case 4:
				ejercicio4();
				break;
			case 5:
				ejercicio5();
				break;
			case 6:
				vista.mostrarMensaje("Adios...");
				break;

			default:
				break;
			}
		} while (opcion != 6);
	}

	private void ejercicio1() {

	}

	private void ejercicio2() {

	}

	private void ejercicio3() {

	}

	private void ejercicio4() {

	}

	private void ejercicio5() {

	}

}
