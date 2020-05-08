import java.util.LinkedHashMap;
import java.util.Scanner;

public class prueba {

	private static LinkedHashMap<String, String[]> gramatica;
	private static String cadena;
	public static String tabla[][];

	public static String primerNivel(String x, String y) {
		String aBuscar = x + y;
		String ubic = "";
		for (String key : gramatica.keySet()) {

			for (int cad = 0; cad < gramatica.get(key).length; cad++) {
				if (gramatica.get(key)[cad].equals(aBuscar)) {
					ubic = ubic + key;
				}
			}
		}
		if (ubic.equals("")) {
			// System.out.println("NO ESTA");
			return "";
		} else {
			// System.out.println(ubic);
			return ubic;
		}
	}

	public static String buscarEnGramatica(String x, String y) {
		String aBuscar;
		String ubic = "";
		String auxUbic = "";
		for (int nx = 0; nx < x.length(); nx++) {
			String cx = String.valueOf(x.charAt(nx)).toUpperCase();
			for (int ny = 0; ny < y.length(); ny++) {
				String cy = String.valueOf(y.charAt(ny)).toUpperCase();
				aBuscar = cx + cy;
				for (String key : gramatica.keySet()) {
					for (int cad = 0; cad < gramatica.get(key).length; cad++) {
						if (gramatica.get(key)[cad].equals(aBuscar)) {
							// System.out.println("ESTA");
							if (!ubic.contains(key)) {
								ubic = ubic + key;
							}
						}
					}
				}
			}
		}

		if (ubic.equals("")) {
			// System.out.println("NO ESTA");
			return "";
		} else {
			// System.out.println(ubic);
			return ubic;
		}
	}

	public static void recorrerTabla(int v, int h) {
		int rep = 0;
		int vAux = 0;
		int hAux = h;
		int vSecondAux = v;
		String res = "";
		while (rep < (cadena.length() - tabla[v].length)) {
			if (res.equals("")) {
				res = buscarEnGramatica(tabla[vAux][h], tabla[vSecondAux - 1][hAux + 1]);
			} else {
				String auxRes = buscarEnGramatica(tabla[vAux][h], tabla[vSecondAux - 1][hAux + 1]);
				String auxRes2 = "";

				for (int x = 0; x < auxRes.length(); x++) {
					String c = String.valueOf(auxRes.charAt(x));
					if (!res.contains(c)) {
						auxRes2 = auxRes2 + c.toUpperCase();
					}
				}
				res = res + auxRes2;
			}
			hAux++;
			vAux++;
			vSecondAux--;
			rep++;

		}
		tabla[v][h] = res;
	}

	public static void backTracking(int v, int h, String generador) {
		int rep = 0;
		int vAux = 0;
		int hAux = h;
		int vSecondAux = v;
		String res = "";
		boolean flagEncontrado = true;

		if (v == 0) {

			for (int cad = 0; cad < gramatica.get(generador).length; cad++) {

				if ((gramatica.get(generador)[cad].length()) == 1) {
					System.out.println(generador + "->" + gramatica.get(generador)[cad]);
				}
			}

			return;
		}
		while (rep < (cadena.length() - tabla[v].length)) {

			String x = tabla[vAux][h];
			String y = tabla[vSecondAux - 1][hAux + 1];

			for (int nx = 0; nx < x.length() && flagEncontrado; nx++) {
				String cx = String.valueOf(x.charAt(nx)).toUpperCase();
				for (int ny = 0; ny < y.length() && flagEncontrado; ny++) {
					String cy = String.valueOf(y.charAt(ny)).toUpperCase();
					String aBuscar = cx + cy;
					for (String key : gramatica.keySet()) {
						for (int cad = 0; cad < gramatica.get(key).length && flagEncontrado; cad++) {
							if (gramatica.get(key)[cad].equals(aBuscar)) {
								// System.out.println("ESTA");
								System.out.println(generador + "->" + cx + "," + cy);
								backTracking(vAux, h, cx);
								backTracking(vSecondAux - 1, hAux + 1, cy);
								return;

							}
						}
					}
				}
			}
			hAux++;
			vAux++;
			vSecondAux--;
			rep++;

		}

	}

	public static void main(String[] args) {
		// TODO code application logic here
		gramatica = new LinkedHashMap<String, String[]>();
		gramatica.put("S", new String[] { "AB", "AC", "AD" });
		gramatica.put("C", new String[] { "SB", "SD" });
		gramatica.put("A", new String[] { "XA", "a" });
		gramatica.put("X", new String[] { "a" });
		gramatica.put("B", new String[] { "b" });
		gramatica.put("D", new String[] { "b" });

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la cadena\n");
		cadena = sc.nextLine().toLowerCase();
		System.out.println(cadena);

		tabla = new String[cadena.length()][];

		int largo = cadena.length();
		for (int x = 0; x < tabla.length; x++) {
			tabla[x] = new String[largo];

			for (int y = 0; y < tabla[x].length; y++) {
				tabla[x][y] = "";
			}
			largo--;
		}

		for (int n = 0; n < cadena.length(); n++) {
			String c = String.valueOf(cadena.charAt(n));
			tabla[0][n] = tabla[0][n] + primerNivel(c, "");
		}

		for (int v = 1; v < tabla.length; v++) {
			for (int h = 0; h < tabla[v].length; h++) {
				recorrerTabla(v, h);
			}
		}

		for (int x = tabla.length - 1; x >= 0; x--) {
			for (int y = 0; y < tabla[x].length; y++) {
				System.out.print(tabla[x][y] + "|");
			}
			System.out.println("");
		}

		if (tabla[tabla.length - 1][0].contains("S")) {
			System.out.println("PERTENECE");
			backTracking(tabla.length - 1, 0, "S");
			for (int n = 0; n < cadena.length(); n++) {
				String c = String.valueOf(cadena.charAt(n));
				tabla[0][n] = tabla[0][n] + primerNivel(c, "");
			}
		} else {
			System.out.println("NO PERTENECE");
		}

	}

}
