package Controller;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Model.Individuo;
import Model.Poblacion;
import View.Ventanas;

public class Controlador {

	private Poblacion poblacion;
	private Individuo individuo;
	private ArrayList<Individuo> listaIndividuos;
	private Seleccion seleccion;
	private Ventanas ventana;
	private Icon icono;

	public Controlador() {
		icono = new ImageIcon(getClass().getResource("/Imagenes/Icono_Emergentes.png")); // Icono para ventanas emergentes
		ventana = new Ventanas();
		listaIndividuos = new ArrayList<Individuo>();
		iniciarProceso();
	}

	/**
	 * INicia el proceso de selecci�n de la aplicaci�n
	 */
	private void iniciarProceso() {
		ventana.mostrarMensaje("Bienvenido al punto 4 del taller pre-parcial 2 de matem�ticas aplicadas." + "\nA continuaci�n ingrese los valores solicitados para realizar el proceso de algor�tmos gen�ticos.", icono);
		int tamPoblacion;
		do {
			tamPoblacion = Integer.parseInt(ventana.recibirValor("Ingrese el tama�o de la poblaci�n (m�nimo 5 individuos): "));
			if (tamPoblacion < 5) {
				ventana.mostrarMensaje("Error..." + "\nEL n�mero de individuso no puede ser menor a 5.", icono);
			} else {
				int adpatacion;
				for (int i = 0; i < tamPoblacion; i++) {
					adpatacion = Integer.parseInt(ventana.recibirValor("Ingrse la adaptaci�n del individuo " + (i + 1) + ": "));
					individuo = new Individuo((i + 1), adpatacion);
					listaIndividuos.add(individuo);
				}
				int numeroHijos = Integer.parseInt(ventana.recibirValor("Ingrese el n�mero de hijos que habr�: " ));
				poblacion = new Poblacion(listaIndividuos, tamPoblacion, numeroHijos);
				seleccion = new Seleccion(poblacion);
				metodoSeleccion();
			}
		} while (tamPoblacion < 5);
	}

	/**
	 * Selecciona el tipo de selecci�n de los individuos
	 */
	private void metodoSeleccion() {
		int aux = 0;
		do {
			int metodo = Integer.parseInt(ventana.recibirValor("Ingrese el m�todo de selecci�n a utilizar: " + "\n 1. Selecci�n por ruleta." + "\n 2. Selecci�n por torneo determinista." + "\n 3. Selecci�n por torneo probabil�stico." + "\n 4. Selecci�n por rstos."));
			if (metodo < 1 || metodo > 4) {
				ventana.mostrarMensaje("Error...\nNo ingres� un m�todo v�lido. Intente de nuevo.", icono);
			} else {
				aux = 1;
				String tipo = "";
				switch (metodo) {
				case 1:
					seleccion.ruleta();
					tipo = "Ruleta";
					break;
				case 2:
					seleccion.torneoDeterminista();
					tipo = "Torneo determinista";
					break;
				case 3:
					seleccion.torneoProbabilistico();
					tipo = "Torneo probabil�stico";
					break;
				case 4:
					seleccion.restos();
					tipo = "Restos";
					break;
				}
				mostrarIndividuosSeleccionado(tipo);
			}
		} while (aux == 0);
	}

	/**
	 * Muestra el resultado del algor�tmo gen�tico
	 * 
	 * @param metodo - m�todo de selecci�n de los individuos
	 */
	private void mostrarIndividuosSeleccionado(String metodo) {
		ventana.mostrarMensaje("Los valores ingresados fueron:" + "\n Tama�o de la poblaci�n: " + poblacion.getTamanoPoblacion() + "\n N�mero de hijos: " + poblacion.getNumeroHijos() + "\n M�todo de selecci�n: " + metodo, icono);
		ventana.mostrarMensaje("Los indivudos seleccionados fueron: " + "\n" + seleccion.poblacionSeleccionada.getIndividuos(), icono);
	}

}
