package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Calculator {
	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		Class a = x.getClass();
		return a;
	}

	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		// throw new NotImplementedException();
		List<Integer> a = new ArrayList<Integer>();
//		int m = 0;
//		Boolean y = false;
//		Integer l = null;
//		l = m;
//		m = l;
		int cont = 1;
		a.add(cont);
		
		for (int i = 1; i < n; i++) {
			int anterior = a.get(i-1);
			a.add(cont);
			cont = anterior + cont;
		}
		return a;

	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int tamanyoArray = 0;
		int [] numeros;
		int i = 0;
		int auxnumber = number;

		while(auxnumber-step>0) {
			auxnumber -= step;
			tamanyoArray++;
		}
		numeros = new int[tamanyoArray];
		while(number-step>0) {
			numeros[i] = number - step;
			number -= step;
			i++;
		}
		return numeros;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int aux = 0;
		if (n == 0) {
			return null;
		}
		for (int i = 1; i <= n; i++)
			if (n % i == 0)
				aux++;
		int[] divisor = new int[aux];
		for (int i = n, j = 0; i > 0; i--)
			if (n % i == 0) {
				divisor[j] = i;
				j++;
			}
		return divisor;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null) {
			return false;
		} else {
			cadena = cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
					.replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "").replace("?", "")
					.replace("¿", "").replace(":", "").replace("·", "");
			String invertir = new StringBuilder(cadena).reverse().toString();
			return invertir.equals(cadena);
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		int resultado;
		int unidad, decenas;
		String resultadoLetras = "";
		resultado = n;
		unidad = resultado % 10;
		decenas = resultado / 10;
		switch (decenas) {
		case 0:
			resultadoLetras = "";
			break;
		case 1:
			resultadoLetras = "Diez";
			break;
		case 2:
			resultadoLetras = "Veinte";
			break;
		case 3:
			resultadoLetras = "Treinta";
			break;
		case 4:
			resultadoLetras = "Cuarenta";
			break;
		case 5:
			resultadoLetras = "Cincuenta";
			break;
		case 6:
			resultadoLetras = "Sesenta";
			break;
		case 7:
			resultadoLetras = "Setenta";
			break;
		case 8:
			resultadoLetras = "Ochenta";
			break;
		case 9:
			resultadoLetras = "Noventa";
			break;
		}
		if ((n > 10) && unidad > 0) {
			resultadoLetras = resultadoLetras + " y ";
		} else {
			resultadoLetras = resultadoLetras + "";
		}
		switch (unidad) {
		case 0:
			resultadoLetras = resultadoLetras + "";
			break;
		case 1:
			resultadoLetras = resultadoLetras + "uno";
			break;
		case 2:
			resultadoLetras = resultadoLetras + "dos";
			break;
		case 3:
			resultadoLetras = resultadoLetras + "tres";
			break;
		case 4:
			resultadoLetras = resultadoLetras + "cuatro";
			break;
		case 5:
			resultadoLetras = resultadoLetras + "cinco";
			break;
		case 6:
			resultadoLetras = resultadoLetras + "seis";
			break;
		case 7:
			resultadoLetras = resultadoLetras + "siete";
			break;
		case 8:
			resultadoLetras = resultadoLetras + "ocho";
			break;
		case 9:
			resultadoLetras = resultadoLetras + "nueve";
			break;

		}
		if (n == 0) {
			return "Cero";
		} else {
			return resultadoLetras;
		}
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha == "") {
			return false;
		}
		String year = fecha.substring(fecha.length() - 4);
		int anio = Integer.parseInt(year);
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)))
			return true;
		else
			return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
			formatoFecha.setLenient(false);
			formatoFecha.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
