package com.ubosque.edu.co.controlador;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.ubosque.edu.co.modelo.Individuo;
import com.ubosque.edu.co.modelo.Poblacion;
import com.ubosque.edu.co.vista.Ventanas;

/**
 * Este método conecta las operaciones de la vista con el modelo
 *
 */
public class Controlador {

	/**
	 * Objeto del modelo
	 */
	private Poblacion poblacion;
	/**
	 * Objeto del modelo
	 */
	private Individuo individuo;
	/**
	 * Arreglo de tipo individuo
	 */
	private ArrayList<Individuo> listaIndividuos;
	/**
	 * Objeto del controlador
	 */
	private Seleccion seleccion;
	/**
	 * Objeto de la vista
	 */
	private Ventanas ventana;
	/**
	 * Icono de las ventanas de la vista
	 */
	private Icon icono;

	public Controlador() {
		icono = new ImageIcon(getClass().getResource("/Imagenes/Icono_Emergentes.png")); // Icono para ventanas emergentes
		ventana = new Ventanas();
		iniciarProceso();
	}

	/**
	 * Este método inicia el proceso de selección de la aplicación
	 */
	private void iniciarProceso() {
		ventana.mostrarMensaje("Bienvenido al punto 4 del taller pre-parcial 2 de matemáticas aplicadas." + "\nA continuación ingrese los valores solicitados para realizar el proceso de algorítmos genéticos.", icono);
		int aux = 0;
		do {
			listaIndividuos = new ArrayList<Individuo>();
			int tamPoblacion = Integer.parseInt(ventana.recibirValor("Ingrese el tamaño de la población (mínimo 5 individuos): "));
			if (tamPoblacion < 5) {
				ventana.mostrarMensaje("Error..." + "\nEL número de individuos no puede ser menor a 5.", icono);
			} else {
				int adpatacion;
				for (int i = 0; i < tamPoblacion; i++) {
					adpatacion = Integer.parseInt(ventana.recibirValor("Ingrese la adaptación del individuo " + (i + 1) + " / " + tamPoblacion + ": "));
					individuo = new Individuo((i + 1), adpatacion);
					listaIndividuos.add(individuo);
				}
				int numeroHijos = Integer.parseInt(ventana.recibirValor("Ingrese el número de individuos que desea hallar: "));
				if (numeroHijos > tamPoblacion) {
					ventana.mostrarMensaje("El tamaño de los individuos que desea hallar no puede ser mayor a la población inicial\nIntente de nuevo...", icono);
				} else {
					poblacion = new Poblacion(listaIndividuos, tamPoblacion, numeroHijos);
					seleccion = new Seleccion(poblacion);
					metodoSeleccion();
					break; // Termina el programa
				}
			}
		} while (aux == 0);
	}

	/**
	 * Este método escoge el tipo de selección de los individuos
	 */
	private void metodoSeleccion() {
		int aux = 0;
		do {
			int metodo = Integer.parseInt(ventana.recibirValor("Ingrese el método de selección a utilizar: " + "\n 1. Selección por ruleta." + "\n 2. Selección por torneo determinista." + "\n 3. Selección por torneo probabilístico." + "\n 4. Selección por restos."));
			if (metodo < 1 || metodo > 4) {
				ventana.mostrarMensaje("Error...\nNo ingresó un método válido. Intente de nuevo.", icono);
			} else {
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
				int again = Integer.parseInt(ventana.recibirValor("¿ Desea realizar nuevamente el proceso de selección ? " + "\n 1. Si." + "\n 2. No "));
				if (again != 1) {
					aux = 1;
				} else {
					iniciarProceso();
				}
			}
		} while (aux == 0);
		ventana.mostrarMensaje("Integrantes del grupo: " + "\n Laura Virginia Peña Cabrera" + "\n Jozek Andrzej Hajduk Sánchez" + "\n Jorge Andres Rangel Zapata" + "\n Brian Gerald Riffo Tineo", icono);
	}

	/**
	 * Este método muestra el resultado del algorítmo genético
	 * 
	 * @param metodo - método de selección de los individuos
	 */
	private void mostrarIndividuosSeleccionado(String metodo) {
		int numHijos = poblacion.getNumeroHijos();
		ventana.mostrarMensaje("Los valores ingresados fueron:" + "\n Tamaño de la población: " + poblacion.getTamanoPoblacion() + "\n Número de hijos: " + numHijos + "\n Método de selección: " + metodo, icono);
		ventana.mostrarMensaje("Los individuos ingresados por el usuario fueron:\n" + poblacion.mostrarIndividuos(), icono);
		String mensaje = "Los individuos seleccionados por el método " + metodo + " fueron: \n";
		int tam = seleccion.poblacionSeleccionada.getIndividuos().size();
		if (tam == 0) {
			mensaje += "Ninguno de los individuos resulto apto para generar desendencia.";
		} else {
			if (tam != numHijos) {
				mensaje += seleccion.poblacionSeleccionada.mostrarIndividuos() + "\nLos demas individuos no fueron aptos, tendrá que hallarlos utilizando otro método de selección.";
			} else {
				mensaje += seleccion.poblacionSeleccionada.mostrarIndividuos();
			}
		}
		ventana.mostrarMensaje(mensaje, icono);
	}

}
