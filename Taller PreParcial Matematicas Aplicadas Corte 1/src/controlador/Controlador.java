package controlador;

import modelo.Modelo;
import vista.Vista;

public class Controlador {

	private Vista vista;
	private Modelo modelo;

	public Controlador() {
		vista = new Vista();
		modelo = new Modelo();
	}

}
