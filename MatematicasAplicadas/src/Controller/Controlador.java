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
		individuos = new ArrayList<Individuos>();
		iniciarProceso();
	}

	private void iniciarProceso() {
		agregarIndividuos();
	}
	private void agregarIndividuos() {
		int i = 1;	
		boolean bandera = true;
		while(bandera) {
		int valorIndividuo = Integer.parseInt(vista.pedirDato("Ingrese el valor del indivuo " + i ));
		int funcionAdaptacion = Integer.parseInt(vista.pedirDato("Ingrese la funcion de adaptacion indivuo " + i ));
		Individuos individuo  = new Individuos(valorIndividuo,funcionAdaptacion);
		individuos.add(individuo);
		i ++;
		if (vista.confirmarAccion("Desea agregar mas elementos?") == 1) {
			bandera = false;
		}
		}
	}
	
}
