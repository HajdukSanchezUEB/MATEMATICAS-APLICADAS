package com.ubosque.edu.co.modelo;

import java.util.ArrayList;

/**
 * Esta clase contiene los atributos de una población
 *
 */
public class Poblacion {

	/**
	 * Arreglo con los individuos de la población
	 */
	private ArrayList<Individuo> individuos;
	/**
	 * Varibale con el valor de la población
	 */
	private int tamanoPoblacion;
	/**
	 * Variable con el valor de número de individuos que se quiere obtener
	 */
	private int numeroIndividuos;

	/**
	 * Constructor que inicializa variables
	 * 
	 * @param individuos       - arreglo de tipo individuos
	 * @param tamnoPoblacion   - tamaño de la población
	 * @param numeroIndividuos - numero de individuos que se quieren obtener
	 */
	public Poblacion(ArrayList<Individuo> individuos, int tamnoPoblacion, int numeroIndividuos) {
		this.individuos = individuos;
		this.tamanoPoblacion = tamnoPoblacion;
		this.numeroIndividuos = numeroIndividuos;
	}

	public Poblacion() {
		individuos = new ArrayList<Individuo>();
	}

	public ArrayList<Individuo> getIndividuos() {
		return individuos;
	}

	public void setIndividuos(ArrayList<Individuo> individuos) {
		this.individuos = individuos;
	}

	public int getTamanoPoblacion() {
		return tamanoPoblacion;
	}

	public void setTamanoPoblacion(int tamanoPoblacion) {
		this.tamanoPoblacion = tamanoPoblacion;
	}

	public int getNumeroHijos() {
		return numeroIndividuos;
	}

	public void setNumeroHijos(int numeroHijos) {
		this.numeroIndividuos = numeroHijos;
	}

	/**
	 * Este método muestra los individuos seleccionados
	 * 
	 * @return - Cadena de texto con los hijos resultantes
	 */
	public String mostrarIndividuos() {
		StringBuilder resultado = new StringBuilder();
		for (int i = 0; i < individuos.size(); i++) {
			resultado.append("Individuo: " + individuos.get(i).getIndividuo() + "    " + "Adaptacion: " + individuos.get(i).getAdaptacion() + "\n");
		}
		return resultado.toString();
	}
}
