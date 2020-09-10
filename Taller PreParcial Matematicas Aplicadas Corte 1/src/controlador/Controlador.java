package controlador;

import modelo.Cifrado;
import modelo.CongruenciaLineal;
import modelo.Funcion;
import vista.Vista;

public class Controlador {

	private Vista vista;
	private CongruenciaLineal congruenciaLineal;
	private Funcion modelo_2;
	private Cifrado modelo_5;
	private String titulo;

	public Controlador() {
		congruenciaLineal = new CongruenciaLineal();
		titulo = "Taller Pre-Parcial";
		vista = new Vista();
		modelo_2 = new Funcion();
		modelo_5 = new Cifrado();
		pedirEjercicio();
	}

	private void pedirEjercicio() {
		vista.mostrarMensaje("Bienvenido al taller Pre-Parcial del primer corte.\nMatem�ticas aplicadas.", titulo);
		int opcion = 0;
		do {
			opcion = Integer.parseInt(vista.recibirValor("Seleccione el ejercicio a realizar:" + "\n1. M�todo de congruencia lineal." + "\n2. M�todo de Montecarlo." + "\n3. Criba de Erat�stenes." + "\n4. Aritm�tica modular 1." + "\n5. Aritm�tica modular 2." + "\n6. Salir.", titulo));
			switch (opcion) {
			case 1:
				titulo = "M�todo cingruencia lineal";
				ejercicio1();
				break;
			case 2:
				titulo = "M�todo de Montecarlo";
				ejercicio2();
				break;
			case 3:
				titulo = "Criba de Erat�stenes.";
				ejercicio3();
				break;
			case 4:
				titulo = "Arim�tica modular 1.";
				ejercicio4();
				break;
			case 5:
				titulo = "Arim�tica modular 2.";
				ejercicio5();
				break;
			case 6:
				vista.mostrarMensaje("Adios...", "Gracias..");
				break;

			default:
				break;
			}
		} while (opcion != 6);
	}

	// Ejercicio de n�mero aleatorio con congruencia lineal
	private void ejercicio1() {
		congruenciaLineal.setC(Integer.parseInt(vista.recibirValor("Por favor ingrese el valor para la constante C", titulo)));
		congruenciaLineal.setM(((int) Math.pow(2, Integer.parseInt(vista.recibirValor("Por favor ingrese un valor para b", titulo)))));
		if (congruenciaLineal.getC() != 0) {
			if (congruenciaLineal.mcd(congruenciaLineal.getC(), congruenciaLineal.getM()) == 1) {
				congruenciaLineal.setA(1 + 4 * Integer.parseInt(vista.recibirValor("Por favor ingrese el valor para la constante k", titulo)));
				congruenciaLineal.setX(Integer.parseInt(vista.recibirValor("Por favor ingrese el valor impar para X", titulo)));
				congruenciaLineal.setNumeroIteraciones((Integer.parseInt(vista.recibirValor("Por favor ingrese el numero de valores aleatoreos a generar", titulo))));

			} else {
				vista.mostrarMensaje("Por favor elija un valor valido para c, tal que el mcd entre 2^b y c = 1", titulo);
				pedirEjercicio();
			}
		} else {
			congruenciaLineal.setA(3 + 8 * Integer.parseInt(vista.recibirValor("Por favor ingrese el valor para la constante k", titulo)));
			congruenciaLineal.setX(Integer.parseInt(vista.recibirValor("Por favor ingrese el valor impar para X", titulo)));
			congruenciaLineal.setNumeroIteraciones((Integer.parseInt(vista.recibirValor("Por favor ingrese el numero de valores aleatoreos a generar", titulo))));
		}
		for (int i = 0; i < congruenciaLineal.getNumeroIteraciones(); i++) {
			int result = congruenciaLineal.formula();
			vista.mostrarMensaje("" + result, titulo);
		}

	}

	// Ejercicio de n�mero aleatorio con M�todo de Montecarlo
	private void ejercicio2() {
		int puntosTotales = Integer.parseInt(vista.recibirValor("Ingrese el n�mero de puntos que va a utilizar:", titulo));
		float x = 0.0f, aleatorio = 0.0f;
		int puntosDentro = 0, puntosFuera = 0;
		for (int i = 0; i < puntosTotales; i++) {
			x = (float) (Math.random() * 5); // N�mero aleatorio para x entre 0 y 5
			aleatorio = (float) (Math.random() * 5); // N�mero aleatorio hasta el 5
			modelo_2.setX(x);
			if (aleatorio <= modelo_2.getFx()) {
				puntosDentro++;
			} else {
				puntosFuera++;
			}
		}
		double areaBajoCurva = (double) puntosDentro / puntosTotales;
		String mensaje = "Cantidad de puntos aleatorios: " + puntosTotales + "." + "\nCantidad de puntos adentro del �rea: " + puntosDentro + "." + "\nCantidad de puntos fuera del �rea: " + puntosFuera + "." + "\n�rea estimada bajo la curva: " + areaBajoCurva + " unidades al cuadrado.";
		vista.mostrarMensaje(mensaje, titulo);
	}

	// Ejercicio de n�mero primo Criba de Erat�stenes
	private void ejercicio3() {

	}

	// Ejercicio �ritm�tica modular con fecha
	private void ejercicio4() {
		vista.mostrarMensaje("Estando el 11 de septiembre del a�o 1672, un sabio dijo �un acontecimiento sin\r\n" + 
				"precedentes ser� presenciado por algunos en exactamente 4176 meses�. �A qu� fecha se\r\n" + 
				"refer�a el sabio?", titulo);
		vista.mostrarMensaje("Si un a�o trae doce meses, entonces 4176 mod 12 es igual a : 0"
				+" Por lo tanto quedariamos en el primer mes del a�o", titulo);
		vista.mostrarMensaje("si dividimos 4176 entre 12 nos da 438 que seria el numero de a�os 8", titulo);
	}

	// Ejercicio aritm�tica modular cifrado cesar
	private void ejercicio5() {
		int opcion = Integer.parseInt(vista.recibirValor("Que opci�n desea realizar:" + "\n1. Encriptar." + "\n2. Desencriptar.", titulo));
		String frase = vista.recibirValor("Ingrese la palabra: ", titulo);
		if (opcion == 1) {
			int x = Integer.parseInt(vista.recibirValor("Ingrese el n�mero (entero) x: ", titulo));
			modelo_5.encriptarFrase(x, frase);
		} else if (opcion == 2) {
			int z = Integer.parseInt(vista.recibirValor("Ingrese el n�mero (entero) z: ", titulo));
			modelo_5.desencriptarFrase(z, frase);
		}
		vista.mostrarMensaje("La frase cifrada es: " + modelo_5.getFrase() + ".", titulo);
	}

}
