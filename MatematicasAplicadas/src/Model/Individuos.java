package Model;

public class Individuos {

	private int valorIndividuo;
	private int funcionAdaptacion;

	public Individuos(int valorIndividuo, int funcionAdaptacion) {
		this.valorIndividuo = valorIndividuo;
		this.funcionAdaptacion = funcionAdaptacion;
	}

	public int getValorIndividuo() {
		return valorIndividuo;
	}

	public void setValorIndividuo(int valorIndividuo) {
		this.valorIndividuo = valorIndividuo;
	}

	public int getFuncionAdaptacion() {
		return funcionAdaptacion;
	}

	public void setFuncionAdaptacion(int funcionAdaptacion) {
		this.funcionAdaptacion = funcionAdaptacion;
	}

}
