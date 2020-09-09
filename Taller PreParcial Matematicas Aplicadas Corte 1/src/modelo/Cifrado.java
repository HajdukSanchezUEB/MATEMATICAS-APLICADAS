package modelo;

public class Cifrado {

	private int x, z;
	private String frase;
	private char[] tablaCaracteres = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	public char[] getTablaCaracteres() {
		return tablaCaracteres;
	}

	public void setTablaCaracteres(char[] tablaCaracteres) {
		this.tablaCaracteres = tablaCaracteres;
	}

	public void encriptarFrase(int codigo, String frase) {
		StringBuilder cifrado = new StringBuilder();
		int aux = 0, posicion;
		int modulo = tablaCaracteres.length;
		for (int i = 0; i < frase.length(); i++) {
			for (int j = 0; j < tablaCaracteres.length; j++) {
				if (frase.charAt(i) == tablaCaracteres[j]) {
					aux = j;
					break;
				}
			}
			posicion = (aux + codigo) % modulo;
			cifrado.append(tablaCaracteres[posicion]);
		}
		setFrase(cifrado.toString());
	}

	public void desencriptarFrase(int z, String frase) {
		
	}

}
