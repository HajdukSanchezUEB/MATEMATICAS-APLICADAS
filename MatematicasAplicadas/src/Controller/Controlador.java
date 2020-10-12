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
	 * INicia el proceso de selección de la aplicación
	 */
	private void iniciarProceso() {
		ventana.mostrarMensaje("Bienvenido al punto 4 del taller pre-parcial 2 de matemáticas aplicadas." + "\nA continuación ingrese los valores solicitados para realizar el proceso de algorítmos genéticos.", icono);
		int tamPoblacion;
		do {
			tamPoblacion = Integer.parseInt(ventana.recibirValor("Ingrese el tamaño de la población (mínimo 5 individuos): "));
			if (tamPoblacion < 5) {
				ventana.mostrarMensaje("Error..." + "\nEL número de individuso no puede ser menor a 5.", icono);
			} else {
				int adpatacion;
				for (int i = 0; i < tamPoblacion; i++) {
					adpatacion = Integer.parseInt(ventana.recibirValor("Ingrse la adaptación del individuo " + (i + 1) + ": "));
					individuo = new Individuo((i + 1), adpatacion);
					listaIndividuos.add(individuo);
				}
				int numeroHijos = Integer.parseInt(ventana.recibirValor("Ingrese el número de hijos que habrá: " ));
				poblacion = new Poblacion(listaIndividuos, tamPoblacion, numeroHijos);
				seleccion = new Seleccion(poblacion);
				metodoSeleccion();
			}
		} while (tamPoblacion < 5);
	}

	/**
	 * Selecciona el tipo de selección de los individuos
	 */
	private void metodoSeleccion() {
		int aux = 0;
		do {
			int metodo = Integer.parseInt(ventana.recibirValor("Ingrese el método de selección a utilizar: " + "\n 1. Selección por ruleta." + "\n 2. Selección por torneo determinista." + "\n 3. Selección por torneo probabilístico." + "\n 4. Selección por rstos."));
			if (metodo < 1 || metodo > 4) {
				ventana.mostrarMensaje("Error...\nNo ingresó un método válido. Intente de nuevo.", icono);
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
					tipo = "Torneo probabilístico";
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
	 * Muestra el resultado del algorítmo genético
	 * 
	 * @param metodo - método de selección de los individuos
	 */
	private void mostrarIndividuosSeleccionado(String metodo) {
		ventana.mostrarMensaje("Los valores ingresados fueron:" + "\n Tamaño de la población: " + poblacion.getTamanoPoblacion() + "\n Número de hijos: " + poblacion.getNumeroHijos() + "\n Método de selección: " + metodo, icono);
		ventana.mostrarMensaje("Los indivudos seleccionados fueron: " + "\n" + seleccion.poblacionSeleccionada.getIndividuos(), icono);
	}

}
