package modelo;

public class ArimeticaModular {

	private int[] arreglo = new int[230];
	private String resultado;
	private int modulo = 12; // Meses de un año
	private int meses;

	public int[] getArreglo() {
		return arreglo;
	}

	public void setArreglo(int[] arreglo) {
		this.arreglo = arreglo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getModulo() {
		return modulo;
	}

	public void setModulo(int modulo) {
		this.modulo = modulo;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public int[][] eliminarMultiplos(int matriz[][], int numero) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (((matriz[i][j] % numero) == 0) && (matriz[i][j] != numero)) {
					matriz[i][j] = 0;
				}
			}
		}
		return matriz;
	}

	public String imprimirMatriz(int matriz[][]) {
		resultado = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if ((matriz[i][j] != 0) && matriz[i][j] <= 200) {
					resultado += matriz[i][j] + "    ";
				}
			}
			resultado += "\n\n";
		}
		return resultado;
	}

	public String calcularFecha(int mesesSumados, int anioInicio, int diaInicio, int mesInicio) {
		this.meses = mesesSumados;
		return diaInicio + " / " + (mesInicio + calcularMeses()) + " / " + (anioInicio + calcularAnios());
	}

	public int calcularMeses() {
		return meses % modulo;
	}

	public int calcularAnios() {
		return (int) meses / modulo;
	}

}
