package modelo;

public class Funcion {

	private float x;
	private float fx;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
		this.setFx(x);
	}

	public float getFx() {
		return fx;
	}

	public void setFx(Float x) {
		fx = (float) (Math.sqrt(9 - ((9 * Math.pow(x, 2)) / 25)));
	}

}
