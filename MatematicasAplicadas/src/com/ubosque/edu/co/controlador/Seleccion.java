package com.ubosque.edu.co.controlador;

import java.util.ArrayList;
import java.util.Random;

import com.ubosque.edu.co.modelo.Individuo;
import com.ubosque.edu.co.modelo.Poblacion;

/**
 * Esta clase tiene los métodos de selección de individuos
 *
 */
public class Seleccion {

	/**
	 * Objeto del modelo
	 */
	private Poblacion poblacion;
	/**
	 * Objeto del modelo para almacenar los individuos seleccionados
	 */
	public Poblacion poblacionSeleccionada;

	/**
	 * Constructor que inicializa la población inicial
	 * 
	 * @param poblacion - población inicial
	 */
	public Seleccion(Poblacion poblacion) {
		this.poblacion = poblacion;
		poblacionSeleccionada = new Poblacion();
	}

	/**
	 * Este método realiza la selección por ruleta
	 */
	public void ruleta() {
		double listaRangos[] = new double[poblacion.getIndividuos().size()];
		double listaProbabilidades[] = new double[poblacion.getIndividuos().size()];
		int sumFuncion = 0;
		for (int i = 0; i < poblacion.getIndividuos().size(); i++) {
			Individuo inviduo = poblacion.getIndividuos().get(i);
			sumFuncion += inviduo.getAdaptacion();
		}
		for (int i = 0; i < poblacion.getIndividuos().size(); i++) {
			double operacion = (double) poblacion.getIndividuos().get(i).getAdaptacion() / sumFuncion;
			listaProbabilidades[i] = operacion;
		}
		for (int i = 0; i < poblacion.getIndividuos().size(); i++) {
			if (i == 0) {
				listaRangos[i] = listaProbabilidades[i];
			} else {
				listaRangos[i] = listaProbabilidades[i] + listaRangos[i - 1];
			}
		}
		for (int i = 0; i < poblacion.getNumeroHijos(); i++) {
			Random numAleatorio = new Random();
			double aleatorio = numAleatorio.nextDouble();
			// y
			for (int j = 0; j < poblacion.getIndividuos().size(); j++) {
				if (j == 0) {
					if (aleatorio > 0 && aleatorio < listaRangos[j]) {
						poblacionSeleccionada.getIndividuos().add(poblacion.getIndividuos().get(i));
						break;
					}
				} else if (j == poblacion.getIndividuos().size()) {
					if (aleatorio > listaRangos[j - 1] && aleatorio < 1) {
						poblacionSeleccionada.getIndividuos().add(poblacion.getIndividuos().get(i));
						break;
					}
				} else {
					if (aleatorio > listaRangos[j - 1] && aleatorio < listaRangos[j]) {
						poblacionSeleccionada.getIndividuos().add(poblacion.getIndividuos().get(i));
						break;
					}
				}
			}
		}
	}

	/**
	 * Este método realiza la selección por torneo determinista
	 */
	public void torneoDeterminista() {
		ArrayList<Individuo> listaIndividuos = new ArrayList<Individuo>();
		ArrayList<Individuo> listaMejoresIndividuos = new ArrayList<Individuo>();
		for (int i = 0; i < poblacion.getNumeroHijos(); i++) { // Lo hace los número de hijos que se quieran obtener
			for (int j = 0; j < 3; j++) { // Escoge grupos de 3 individuos aleatorios
				int aleatorio = (int) ((Math.random() * poblacion.getTamanoPoblacion())); // Número aleatorio entre 0 y el tamaño de la población
				listaIndividuos.add(poblacion.getIndividuos().get(aleatorio));
			}
			Individuo mejorIndividuo = mejorHijoDeterminista(listaIndividuos);
			listaMejoresIndividuos.add(mejorIndividuo);
		}
		poblacionSeleccionada.setIndividuos(listaMejoresIndividuos);
	}

	/**
	 * Este método selecciona el mejor individuo para el torneo determinista
	 * 
	 * @param individuos - lista con los tres individuos que se enfrentan
	 * @return - individuo ganador
	 */
	private Individuo mejorHijoDeterminista(ArrayList<Individuo> individuos) {
		Individuo mejor = null;
		for (int i = 0; i < individuos.size() - 1; i++) {
			if (individuos.get(i).getAdaptacion() < individuos.get(i + 1).getAdaptacion()) {
				mejor = individuos.get(i + 1);
			}
		}
		return mejor;
	}

	/**
	 * Este método realiza la selección por torneo probabilístico
	 */
	public void torneoProbabilistico() {
		ArrayList<Individuo> listaIndividuos = new ArrayList<Individuo>();
		ArrayList<Individuo> listaMejoresIndividuos = new ArrayList<Individuo>();
		for (int i = 0; i < poblacion.getNumeroHijos(); i++) { // Lo hace los número de hijos que se quieran obtener
			for (int j = 0; j < 2; j++) { // Escoge grupos de dos individuos aleatorios
				int aleatorio = (int) ((Math.random() * poblacion.getTamanoPoblacion())); // Número aleatorio entre 0 y el tamaño de la población
				listaIndividuos.add(poblacion.getIndividuos().get(aleatorio));
			}
			Individuo mejorIndividuo = mejorHijoProbabilistico(listaIndividuos);
			listaMejoresIndividuos.add(mejorIndividuo);
		}
		poblacionSeleccionada.setIndividuos(listaMejoresIndividuos);
	}

	/**
	 * Este método selecciona al mejor entre dos individuos, si un número aleatorio entre 0 y 1 supera un parámtero establecido
	 * 
	 * @param individuos - lista con los dos individuos que van a torneo
	 * @return - individuo ganador
	 */
	private Individuo mejorHijoProbabilistico(ArrayList<Individuo> individuos) {
		double parametro = 0.5;
		int aleatorio = (int) ((Math.random() * poblacion.getTamanoPoblacion())); // Número aleatorio entre 0 y 1
		Individuo ganador = individuos.get(0);
		if (aleatorio > parametro) { // Si es así gana el individuo de mayor valor
			if (individuos.get(1).getAdaptacion() > ganador.getAdaptacion()) {
				ganador = individuos.get(1);
			}
		} else {
			if (individuos.get(1).getAdaptacion() < ganador.getAdaptacion()) {
				ganador = individuos.get(1);
			}
		}
		return ganador;
	}

	/**
	 * Este método realiza la selección por restos
	 */
	public void restos() {
		int tam = poblacion.getIndividuos().size();
		int totalAdaptacion = 0;
		int k = 4; // Entero k para la multiplicación
		ArrayList<Individuo> indiSeleccionados = new ArrayList<Individuo>();
		float pi[] = new float[tam];
		for (int i = 0; i < tam; i++) {
			totalAdaptacion += poblacion.getIndividuos().get(i).getAdaptacion();
		}
		for (int i = 0; i < tam; i++) {
			float valorPi = (float) poblacion.getIndividuos().get(i).getAdaptacion() / totalAdaptacion; // Halla el valor de pi
			pi[i] = valorPi;
		}
		for (int i = 0; i < tam; i++) {
			float pik = pi[i] * k;
			if ((int) pik != 0) {
				indiSeleccionados.add(poblacion.getIndividuos().get(i));
			}
		}
		poblacionSeleccionada.setIndividuos(indiSeleccionados);
	}

}
