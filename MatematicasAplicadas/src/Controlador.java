
public class Controlador {

//	El tama�o x de poblaci�n inicial
//	� Los individuos de la poblaci�n inicial con sus respectivas funciones de
//	adaptaci�n
//	� El n�mero de hijos que se obtendr�n
//	� El m�todo de selecci�n	
	Vista vista;

	public Controlador() {
		vista = new Vista();
	}
	
	public void inicio(){
		int tama�oPoblacional = Integer.parseInt(vista.pedirDato("Ingrese el tama�o poblacional inicial"));
		int x = Integer.parseInt(vista.pedirDato("Ingrese el tama�o poblacional inicial"));
		int y = Integer.parseInt(vista.pedirDato("Ingrese el tama�o poblacional inicial"));
		int numeroHijos = Integer.parseInt(vista.pedirDato("Ingrese el numero de hijos que se obtendran"));
		String metodoSeleccion = vista.pedirDato("Ingrese el numero de hijos que se obtendran");
		
	}

}
