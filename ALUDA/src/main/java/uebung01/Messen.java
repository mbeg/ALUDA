package uebung01;

public class Messen {

	private static Stoppuhr stoppuhr = new Stoppuhr();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int n = 1; n <= 6; n++) {
			System.out.println("#######################");
			System.out.println("Test für 10 hoch " + n);
			System.out.println("#######################");

			int[] zahlen = getZufallszahlen((int) Math.pow(10, n));
			System.out.println("Anzahl Elemente: " + zahlen.length);

			System.out.print("Zufallszahlen: ");
			stoppuhr.start();
			sort(zahlen);
			stoppuhr.end();
			System.out.println(" Dauer = " + stoppuhr.getResult() + " ms");

			System.out.print("Zahlen ASC: ");
			setZahlenAufsteigend(zahlen);
			stoppuhr.start();
			sort(zahlen);
			stoppuhr.end();
			System.out.println(" Dauer = " + stoppuhr.getResult() + " ms");

			System.out.print("Zahlen DESC: ");
			setZahlenAbsteigend(zahlen);
			stoppuhr.start();
			sort(zahlen);
			stoppuhr.end();
			System.out.println(" Dauer = " + stoppuhr.getResult() + " ms");

		}

	}

	/**
	 * @param anzahl
	 * @return
	 */
	public static int[] getZufallszahlen(int anzahl) {

		int[] zahlen = new int[anzahl];

		for (int i = 0; i < zahlen.length; i++) {
			zahlen[i] = (int) (Math.random() * 100);
		}

		return zahlen;
	}


	/**
	 * @param zahlen
	 */
	public static void setZahlenAufsteigend(int[] zahlen) {
		for (int j = 0; j < zahlen.length; j++) {
			zahlen[j] = j + 1;
		}
	}

	/**
	 * @param zahlen
	 */
	public static void setZahlenAbsteigend(int[] zahlen) {
		for (int j = 0; j < zahlen.length; j++) {
			zahlen[j] = zahlen.length - j;
		}
	}

	/**
	 * Algorithmus hat die Komplexitätsklasse O(n²)?
	 * 
	 * @param a
	 */
	public static void sort(int[] a) {

		long zaehler = 0;

		// O(n)
		for (int i = 1; i < a.length; i++) {

			// O(1)
			int j = i;

			// O(n)
			while (j > 0) {

				// O(1)
				if (a[j - 1] > a[j]) { // Elemente vertauschen
					int tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
					zaehler++;
				}
				j--;
			}

		}

		System.out.print("Vertauschungen = " + zaehler);

	}

}
