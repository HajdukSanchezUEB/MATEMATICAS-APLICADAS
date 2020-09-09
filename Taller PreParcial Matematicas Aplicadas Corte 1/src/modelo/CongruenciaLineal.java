package modelo;

public class CongruenciaLineal {

	int k, b, c, x, a, m, numeroIteraciones;

	public int getNumeroIteraciones() {
		return numeroIteraciones;
	}

	public void setNumeroIteraciones(int numeroIteraciones) {
		this.numeroIteraciones = numeroIteraciones;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int mcd(int num1, int num2) {
		int resto;
		int numDiv1 = num1;
		int numDiv2 = num2;

		do {
			resto = numDiv1 % numDiv2;
			numDiv1 = numDiv2;
			if (resto != 0)
				numDiv2 = resto;
		} while (resto != 0);
		System.out.println(numDiv2);
		return numDiv2;
		
	}
	
	public int formula() {
		int result = a*(x+c)%m;
		x = result;
		return result;
	}
}
