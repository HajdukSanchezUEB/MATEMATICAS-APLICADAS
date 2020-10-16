package Model;

/**
 * Esta clase posee los atributos de los individuos
 *
 */
public class Individuo {

	/**
	 * Variable con el valor del individuo
	 */
	private int individuo;
	/**
	 * Variable con el valor de la adaptación del individuo
	 */
	private int adaptacion;

	/**
	 * Constructor que inicializa las variables
	 * 
	 * @param individuo  - valor de individuo
	 * @param adaptacion - valor de adaptación del individuo
	 */
	public Individuo(int individuo, int adaptacion) {
		this.individuo = individuo;
		this.adaptacion = adaptacion;
	}

	public int getIndividuo() {
		return individuo;
	}

	public void setIndividuo(int individuo) {
		this.individuo = individuo;
	}

	public int getAdaptacion() {
		return adaptacion;
	}

	public void setAdaptacion(int adaptacion) {
		this.adaptacion = adaptacion;
	}

}
