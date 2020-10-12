package Controller;

import Model.Poblacion;

public class Seleccion {

	private Poblacion poblacion;

	public Seleccion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}

	public void ruleta() {
		for (int j = 0; j < poblacion.getPoblacionInicial().size(); j++) {
			poblacion.getPoblacionInicial().get(j).getValorIndividuo();						
		}
	}

	public void torneoDeterminista() {

	}

	public void torneoProbabilistico() {

	}

	public void restos() {

	}

}
