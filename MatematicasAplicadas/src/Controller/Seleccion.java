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
	 * Método de selección por ruleta
	 */
	public void ruleta() {

	}

	/**
	 * Método de selección por torneo determinista
	 */
	public void torneoDeterminista() {
		ArrayList<Individuo> listaIndividuos = new ArrayList<Individuo>();
		ArrayList<Individuo> listaMejoresIndividuos = new ArrayList<Individuo>();
		for (int i = 0; i < poblacion.getNumeroHijos(); i++) { // Lo hace los número de hijos que se quieran obtener
			for (int j = 0; j < 3; j++) {
				int aleatorio = (int) ((Math.random() * poblacion.getTamanoPoblacion())); // Número aleatorio entre 0 y el tamaño de la población
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
	 * Método de selección por torneo probabilístico
	 */
	public void torneoProbabilistico() {

	}

	/**
	 * Método de selección por restos
	 */
	public void restos() {

	}

}
