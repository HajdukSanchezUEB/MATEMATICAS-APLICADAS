package modelo;

public class CongruenciaLineal {

	private int m = 16;
	private int c = 85;
	private int a = 9;
	private int k = 2;
	private int x0, xN;

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getX0() {
		return x0;
	}

	public void setX0(int x0) {
		this.x0 = x0;
	}

	public int getxN() {
		return xN;
	}

	public void setxN(int xN) {
		this.xN = xN;
	}

	public int formula() {
		int xJ = (a * (xN + c)) % m;
		xN = xJ;
		return xJ;
	}
}
