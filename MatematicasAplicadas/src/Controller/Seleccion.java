package Controller;

import java.util.ArrayList;

import Model.Individuo;
import Model.Poblacion;

public class Seleccion {

	private Poblacion poblacion;
	public Poblacion poblacionSeleccionada;

	public Seleccion(Poblacion poblacion) {
		this.poblacion = poblacion;
		poblacionSeleccionada = new Poblacion();
	}

	/**
	 * M�todo de selecci�n por ruleta
	 */
	public void ruleta() {

	}

	/**
	 * M�todo de selecci�n por torneo determinista
	 */
	public void torneoDeterminista() {
		ArrayList<Individuo> listaIndividuos = new ArrayList<Individuo>();
		ArrayList<Individuo> listaMejoresIndividuos = new ArrayList<Individuo>();
		for (int i = 0; i < poblacion.getNumeroHijos(); i++) { // Lo hace los n�mero de hijos que se quieran obtener
			for (int j = 0; j < 3; j++) {
				int aleatorio = (int) ((Math.random() * poblacion.getTamanoPoblacion())); // N�mero aleatorio entre 0 y el tama�o de la poblaci�n
				listaIndividuos.add(poblacion.getIndividuos().get(aleatorio));
			}
			Individuo mejorIndividuo = selecionarMejorHijo(listaIndividuos);
			listaMejoresIndividuos.add(mejorIndividuo);
		}
		poblacionSeleccionada.setIndividuos(listaMejoresIndividuos);
	}

	/**
	 * Selecciona el mejor hijo para el torneo determinista
	 */
	private Individuo selecionarMejorHijo(ArrayList<Individuo> individuos) {
		Individuo mejor = null;
		for (int i = 0; i < individuos.size() - 1; i++) {
			if (individuos.get(i).getAdaptacion() < individuos.get(i + 1).getAdaptacion()) {
				mejor = individuos.get(i + 1);
			}
		}
		return mejor;
	}

	/**
	 * M�todo de selecci�n por torneo probabil�stico
	 */
	public void torneoProbabilistico() {

	}

	/**
	 * M�todo de selecci�n por restos
	 */
	public void restos() {

	}

}
