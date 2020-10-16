package com.ubosque.edu.co.controlador;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.ubosque.edu.co.modelo.Individuo;
import com.ubosque.edu.co.modelo.Poblacion;
import com.ubosque.edu.co.vista.Ventanas;

/**
 * Este m�todo conecta las operaciones de la vista con el modelo
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
	 * Este m�todo inicia el proceso de selecci�n de la aplicaci�n
	 */
	private void iniciarProceso() {
		ventana.mostrarMensaje("Bienvenido al punto 4 del taller pre-parcial 2 de matem�ticas aplicadas." + "\nA continuaci�n ingrese los valores solicitados para realizar el proceso de algor�tmos gen�ticos.", icono);
		int aux = 0;
		do {
			listaIndividuos = new ArrayList<Individuo>();
			int tamPoblacion = Integer.parseInt(ventana.recibirValor("Ingrese el tama�o de la poblaci�n (m�nimo 5 individuos): "));
			if (tamPoblacion < 5) {
				ventana.mostrarMensaje("Error..." + "\nEL n�mero de individuos no puede ser menor a 5.", icono);
			} else {
				int adpatacion;
				for (int i = 0; i < tamPoblacion; i++) {
					adpatacion = Integer.parseInt(ventana.recibirValor("Ingrese la adaptaci�n del individuo " + (i + 1) + " / " + tamPoblacion + ": "));
					individuo = new Individuo((i + 1), adpatacion);
					listaIndividuos.add(individuo);
				}
				int numeroHijos = Integer.parseInt(ventana.recibirValor("Ingrese el n�mero de individuos que desea hallar: "));
				if (numeroHijos > tamPoblacion) {
					ventana.mostrarMensaje("El tama�o de los individuos que desea hallar no puede ser mayor a la poblaci�n inicial\nIntente de nuevo...", icono);
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
	 * Este m�todo escoge el tipo de selecci�n de los individuos
	 */
	private void metodoSeleccion() {
		int aux = 0;
		do {
			int metodo = Integer.parseInt(ventana.recibirValor("Ingrese el m�todo de selecci�n a utilizar: " + "\n 1. Selecci�n por ruleta." + "\n 2. Selecci�n por torneo determinista." + "\n 3. Selecci�n por torneo probabil�stico." + "\n 4. Selecci�n por restos."));
			if (metodo < 1 || metodo > 4) {
				ventana.mostrarMensaje("Error...\nNo ingres� un m�todo v�lido. Intente de nuevo.", icono);
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
					tipo = "Torneo probabil�stico";
					break;
				case 4:
					seleccion.restos();
					tipo = "Restos";
					break;
				}
				mostrarIndividuosSeleccionado(tipo);
				int again = Integer.parseInt(ventana.recibirValor("� Desea realizar nuevamente el proceso de selecci�n ? " + "\n 1. Si." + "\n 2. No "));
				if (again != 1) {
					aux = 1;
				} else {
					iniciarProceso();
				}
			}
		} while (aux == 0);
		ventana.mostrarMensaje("Integrantes del grupo: " + "\n Laura Virginia Pe�a Cabrera" + "\n Jozek Andrzej Hajduk S�nchez" + "\n Jorge Andres Rangel Zapata" + "\n Brian Gerald Riffo Tineo", icono);
	}

	/**
	 * Este m�todo muestra el resultado del algor�tmo gen�tico
	 * 
	 * @param metodo - m�todo de selecci�n de los individuos
	 */
	private void mostrarIndividuosSeleccionado(String metodo) {
		int numHijos = poblacion.getNumeroHijos();
		ventana.mostrarMensaje("Los valores ingresados fueron:" + "\n Tama�o de la poblaci�n: " + poblacion.getTamanoPoblacion() + "\n N�mero de hijos: " + numHijos + "\n M�todo de selecci�n: " + metodo, icono);
		ventana.mostrarMensaje("Los individuos ingresados por el usuario fueron:\n" + poblacion.mostrarIndividuos(), icono);
		String mensaje = "Los individuos seleccionados por el m�todo " + metodo + " fueron: \n";
		int tam = seleccion.poblacionSeleccionada.getIndividuos().size();
		if (tam == 0) {
			mensaje += "Ninguno de los individuos resulto apto para generar desendencia.";
		} else {
			if (tam != numHijos) {
				mensaje += seleccion.poblacionSeleccionada.mostrarIndividuos() + "\nLos demas individuos no fueron aptos, tendr� que hallarlos utilizando otro m�todo de selecci�n.";
			} else {
				mensaje += seleccion.poblacionSeleccionada.mostrarIndividuos();
			}
		}
		ventana.mostrarMensaje(mensaje, icono);
	}

}
