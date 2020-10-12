package Controller;

import java.util.ArrayList;

import Model.Individuos;
import Model.Poblacion;
import view.Vista;

public class Controlador {

	private Poblacion poblacion;
	private ArrayList<Individuos> individuos;
	private Seleccion metodo;
	private Vista vista;
	public Controlador() {
		vista = new Vista();
		
		iniciarProceso();
	}

	private void iniciarProceso() {

	}

}
