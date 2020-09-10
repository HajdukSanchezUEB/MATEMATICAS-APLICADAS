package modelo;

public class NumerosPrimos {
	int[] arreglo = new int[230];
	String resultado;
	
	
	public int [][] eliminarMultiplos(int matriz[][], int numero) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz [i][j] % numero == 0 && matriz [i][j] != numero) {
					matriz [i][j] = 0;
				}
				System.out.println("["+matriz[i][j]+"]");
			}
		}
		return matriz;
	}
	
	public String imprimirMatriz(int matriz[][]) {
		resultado = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] > 0 && matriz[i][j] <= 200) {
					resultado += "["+matriz[i][j]+"]";
					resultado += "    ";					
					
				}

//				
//				if (matriz[i][j] <= 99 && matriz[i][j] >= 10) {
//					resultado += "["+matriz[i][j]+"]";
//					resultado += "   ";					
//				}
//				if (matriz[i][j] <= 200 && matriz[i][j] >= 100) {
//					resultado += "["+matriz[i][j]+"]";
//					resultado += "  ";					
//				}
						}
			resultado += "\n\n";
		}
		return resultado;
	}
}
