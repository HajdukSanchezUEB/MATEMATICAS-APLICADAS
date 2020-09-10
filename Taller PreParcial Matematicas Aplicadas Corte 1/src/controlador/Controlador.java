package controlador;

import modelo.Cifrado;
import modelo.CongruenciaLineal;
import modelo.Funcion;
import vista.Vista;

public class Controlador {

	private Vista vista;
	private CongruenciaLineal modelo_1;
	private Funcion modelo_2;
	private Cifrado modelo_5;
	private String titulo;

	public Controlador() {
		vista = new Vista();
		modelo_1 = new CongruenciaLineal();
		modelo_2 = new Funcion();
		modelo_5 = new Cifrado();
		pedirEjercicio();
	}

	private void pedirEjercicio() {
		vista.mostrarMensaje("Bienvenido al taller Pre-Parcial del primer corte.\nMatemáticas aplicadas.", "Taller Pre-Parcial");
		int opcion = 0;
		do {
			titulo = "Taller Pre-Parcial";
			opcion = Integer.parseInt(vista.recibirValor("Seleccione el ejercicio a realizar:" + "\n1. Método de congruencia lineal." + "\n2. Método de Montecarlo." + "\n3. Criba de Eratóstenes." + "\n4. Aritmética modular 1." + "\n5. Aritmética modular 2." + "\n6. Salir.", titulo));
			switch (opcion) {
			case 1:
				titulo = "Método cingruencia lineal";
				ejercicio1();
				break;
			case 2:
				titulo = "Método de Montecarlo";
				ejercicio2();
				break;
			case 3:
				titulo = "Criba de Eratóstenes.";
				ejercicio3();
				break;
			case 4:
				titulo = "Arimética modular 1.";
				ejercicio4();
				break;
			case 5:
				titulo = "Arimética modular 2.";
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

	// Ejercicio de número aleatorio con congruencia lineal
	private void ejercicio1() {
		vista.mostrarMensaje("Se van a utilizar los siguientes valores iniciales:" + "\nm: 16" + "\nc : 85" + "\na: 9", titulo);
		int x0 = Integer.parseInt(vista.recibirValor("Ingrese el valor de Xo: ", titulo));
		int repeticiones = modelo_1.getM();
		String mensaje = "";
		int xJ = 0, respuesta = 0;
		for (int i = 0; i < repeticiones; i++) {
			if (i == 0) {
				respuesta = x0;
			} else {
				xJ = respuesta;
				respuesta = modelo_1.formula(xJ);
			}
			mensaje += "Número " + i + " de " + (repeticiones - 1) + " =  " + respuesta + "\n";
		}
		vista.mostrarMensaje("Números aleatorios generados:  \n" + mensaje, titulo);
	}

	// Ejercicio de número aleatorio con Método de Montecarlo
	private void ejercicio2() {
		int puntosTotales = 0;
		do {
			puntosTotales = Integer.parseInt(vista.recibirValor("Ingrese el número de puntos que va a utilizar para el cálculo (Mínimo 2000):", titulo));
			if (puntosTotales < 2000) {
				vista.mostrarMensaje("No ingresó un número valido de puntos.", titulo);
			}
		} while (puntosTotales < 2000);
		float x = 0.0f, aleatorio = 0.0f;
		int puntosDentro = 0, puntosFuera = 0;
		for (int i = 0; i < puntosTotales; i++) {
			x = (float) (Math.random() * 5); // Número aleatorio para x entre 0 y 5
			aleatorio = (float) (Math.random() * 5); // Número aleatorio hasta el 5
			modelo_2.setX(x);
			if (aleatorio <= modelo_2.getFx()) {
				puntosDentro++;
			} else {
				puntosFuera++;
			}
		}
		double areaBajoCurva = (double) puntosDentro / puntosTotales;
		String mensaje = "Cantidad de puntos aleatorios: " + puntosTotales + "." + "\nCantidad de puntos dentro del área: " + puntosDentro + "." + "\nCantidad de puntos fuera del área: " + puntosFuera + "." + "\nÁrea estimada bajo la curva: " + areaBajoCurva + " unidades al cuadrado.";
		vista.mostrarMensaje(mensaje, titulo);
	}

	// Ejercicio de número primo Criba de Eratóstenes
	private void ejercicio3() {

	}

	// Ejercicio áritmética modular con fecha
	private void ejercicio4() {

	}

	// Ejercicio aritmética modular cifrado cesar
	private void ejercicio5() {
		int opcion = 0;
		do {
			opcion = Integer.parseInt(vista.recibirValor("Que opción desea realizar:" + "\n1. Encriptar." + "\n2. Desencriptar.", titulo));
			if (opcion < 1 || opcion > 2) {
				vista.mostrarMensaje("No seleccionó una opción valida", titulo);
			} else {
				String frase = vista.recibirValor("Ingrese la palabra: ", titulo);
				if (opcion == 1) {
					int x = Integer.parseInt(vista.recibirValor("Ingrese el número (entero) x: ", titulo));
					modelo_5.encriptarFrase(x, frase);
				} else if (opcion == 2) {
					int z = Integer.parseInt(vista.recibirValor("Ingrese el número (entero) z: ", titulo));
					modelo_5.desencriptarFrase(z, frase);
				}
			}
		} while (opcion < 1 || opcion > 2);
		vista.mostrarMensaje("La frase cifrada es: " + modelo_5.getFrase() + ".", titulo);
	}

}
