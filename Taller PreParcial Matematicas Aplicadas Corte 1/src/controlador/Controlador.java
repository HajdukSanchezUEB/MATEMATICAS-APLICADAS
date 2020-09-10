package controlador;

import modelo.ArimeticaModular;
import modelo.Cifrado;
import modelo.CongruenciaLineal;
import modelo.Funcion;
import vista.Vista;

public class Controlador {

	private Vista vista;
	private CongruenciaLineal modelo_1;
	private Funcion modelo_2;
	private ArimeticaModular modelo_3_4;
	private Cifrado modelo_5;
	private String titulo;

	public Controlador() {
		vista = new Vista();
		modelo_1 = new CongruenciaLineal();
		modelo_2 = new Funcion();
		modelo_3_4 = new ArimeticaModular();
		modelo_5 = new Cifrado();
		pedirEjercicio();
	}

	private void pedirEjercicio() {
		vista.mostrarMensaje("Bienvenido al taller Pre-Parcial del primer corte.\nMATEM�TICAS APLICADAS." + "\nIntegrantes del grupo:" + "\n\nJorge Andr�s Rangel Zapata." + "\nJozek Andrzej Hajduk S�nchez.\n\n", "Taller Pre-Parcial");
		int opcion = 0;
		do {
			titulo = "Taller Pre-Parcial";
			opcion = Integer.parseInt(vista.recibirValor("Seleccione el ejercicio a realizar:" + "\n1. M�todo de congruencia lineal." + "\n2. M�todo de Montecarlo." + "\n3. Criba de Erat�stenes." + "\n4. Aritm�tica modular 1." + "\n5. Aritm�tica modular 2." + "\n6. Salir.", titulo));
			switch (opcion) {
			case 1:
				titulo = "M�todo congruencia lineal";
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
				vista.mostrarMensaje("Adios...", titulo);
				break;

			default:
				break;
			}
		} while (opcion != 6);
	}

	// Ejercicio de n�mero aleatorio con congruencia lineal
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
			mensaje += "N�mero " + i + " de " + (repeticiones - 1) + " =  " + respuesta + "\n";
		}
		vista.mostrarMensaje("N�meros aleatorios generados:  \n" + mensaje, titulo);
	}

	// Ejercicio de n�mero aleatorio con M�todo de Montecarlo
	private void ejercicio2() {
		int puntosTotales = 0;
		do {
			puntosTotales = Integer.parseInt(vista.recibirValor("Ingrese el n�mero de puntos que va a utilizar para el c�lculo (M�nimo 2000):", titulo));
			if (puntosTotales < 2000) {
				vista.mostrarMensaje("No ingres� un n�mero valido de puntos.", titulo);
			}
		} while (puntosTotales < 2000);
		float x = 0.0f, aleatorio = 0.0f;
		int puntosDentro = 0, puntosFuera = 0;
		for (int i = 0; i < puntosTotales; i++) {
			x = (float) (Math.random() * 5); // N�mero aleatorio para x entre 0 y 5
			aleatorio = (float) (Math.random() * 5); // N�mero aleatorio entre 0 y 5
			modelo_2.setX(x);
			if (aleatorio <= modelo_2.getFx()) {
				puntosDentro++;
			} else {
				puntosFuera++;
			}
		}
		double areaBajoCurva = (double) puntosDentro / puntosTotales;
		String mensaje = "Cantidad de puntos aleatorios: " + puntosTotales + "." + "\nCantidad de puntos dentro del �rea: " + puntosDentro + "." + "\nCantidad de puntos fuera del �rea: " + puntosFuera + "." + "\n�rea estimada bajo la curva: " + areaBajoCurva + " unidades al cuadrado.";
		vista.mostrarMensaje(mensaje, titulo);
	}

	// Ejercicio de n�mero primo Criba de Erat�stenes
	private void ejercicio3() {
		int k = 2;
		int[] arreglo = new int[200];
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = k;
			k++;
		}
		int aux = 0;
		int matriz[][] = new int[10][20];
		for (int i = 0; i < matriz.length; i++) { // Filas
			for (int j = 0; j < matriz[0].length; j++) { // Columnas
				matriz[i][j] = arreglo[aux];
				aux++;
			}
		}
		vista.mostrarMensaje("Estos son los n�meros comprendidos entre el 2 y el 200:\n\n" + modelo_3_4.imprimirMatriz(matriz), titulo);
		matriz = modelo_3_4.eliminarMultiplos(matriz, 2);
		vista.mostrarMensaje("Se eliminaron los m�ltiplos del 2, como lo indica el m�todo: \n\n" + modelo_3_4.imprimirMatriz(matriz), titulo);
		matriz = modelo_3_4.eliminarMultiplos(matriz, 3);
		vista.mostrarMensaje("Se eliminaron los m�ltiplos del 3, como lo indica el m�todo: \n\n" + modelo_3_4.imprimirMatriz(matriz), titulo);
		matriz = modelo_3_4.eliminarMultiplos(matriz, 5);
		vista.mostrarMensaje("Se eliminaron los m�ltiplos del 5, como lo indica el m�todo: \n\n" + modelo_3_4.imprimirMatriz(matriz), titulo);
		matriz = modelo_3_4.eliminarMultiplos(matriz, 7);
		vista.mostrarMensaje("Se eliminaron los m�ltiplos del 7, como lo indica el m�todo: \n\n" + modelo_3_4.imprimirMatriz(matriz), titulo);
		matriz = modelo_3_4.eliminarMultiplos(matriz, 11);
		vista.mostrarMensaje("Se eliminaron los m�ltiplos del 11, como lo indica el m�todo: \n\n" + modelo_3_4.imprimirMatriz(matriz), titulo);
		matriz = modelo_3_4.eliminarMultiplos(matriz, 13);
		vista.mostrarMensaje("Se eliminaron los m�ltiplos del 13, como lo indica el m�todo: \nEstos son los n�meros primos resultantes:\n\n" + modelo_3_4.imprimirMatriz(matriz), titulo);
	}

	// Ejercicio �ritm�tica modular con fecha
	private void ejercicio4() {
		vista.mostrarMensaje("Datos iniciales: " + "\nModulo: 12" + "\nMeses: 4176" + "\nFecha inicial: 11 / 09 / 1672", titulo);
		int meses = 4176;
		String fecha = modelo_3_4.calcularFecha(meses, 1672, 11, 9);
		vista.mostrarMensaje("El sabio se refer�a a la fecha: \n" + fecha, titulo);
	}

	// Ejercicio aritm�tica modular cifrado cesar
	private void ejercicio5() {
		int opcion = 0;
		do {
			opcion = Integer.parseInt(vista.recibirValor("Que opci�n desea realizar:" + "\n1. Encriptar." + "\n2. Desencriptar.", titulo));
			if (opcion < 1 || opcion > 2) {
				vista.mostrarMensaje("No seleccion� una opci�n valida", titulo);
			} else {
				String frase = vista.recibirValor("Ingrese la palabra: ", titulo);
				if (opcion == 1) {
					int x = Integer.parseInt(vista.recibirValor("Ingrese el n�mero (entero) x: ", titulo));
					modelo_5.encriptarFrase(x, frase);
				} else if (opcion == 2) {
					int z = Integer.parseInt(vista.recibirValor("Ingrese el n�mero (entero) z: ", titulo));
					modelo_5.desencriptarFrase(z, frase);
				}
			}
		} while (opcion < 1 || opcion > 2);
		vista.mostrarMensaje("La frase cifrada es: " + modelo_5.getFrase() + ".", titulo);
	}

}
