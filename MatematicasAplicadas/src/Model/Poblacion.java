package Model;

import java.util.ArrayList;

public class Poblacion {

	private ArrayList<Individuos> poblacionInicial;

	public Poblacion(ArrayList<Individuos> poblacionInicial) {
		this.poblacionInicial = poblacionInicial;
	}

	public ArrayList<Individuos> getPoblacionInicial() {
		return poblacionInicial;
	}

	public void setPoblacionInicial(ArrayList<Individuos> poblacionInicial) {
		this.poblacionInicial = poblacionInicial;
	}

}
