
public class Controlador {

//	El tamaño x de población inicial
//	• Los individuos de la población inicial con sus respectivas funciones de
//	adaptación
//	• El número de hijos que se obtendrán
//	• El método de selección	
	Vista vista;

	public Controlador() {
		vista = new Vista();
	}
	
	public void inicio(){
		int tamañoPoblacional = Integer.parseInt(vista.pedirDato("Ingrese el tamaño poblacional inicial"));
		int x = Integer.parseInt(vista.pedirDato("Ingrese el tamaño poblacional inicial"));
		int y = Integer.parseInt(vista.pedirDato("Ingrese el tamaño poblacional inicial"));
		int numeroHijos = Integer.parseInt(vista.pedirDato("Ingrese el numero de hijos que se obtendran"));
		String metodoSeleccion = vista.pedirDato("Ingrese el numero de hijos que se obtendran");
		
	}

}
