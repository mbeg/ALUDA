package uebung02;

import java.util.LinkedList;

public class Turm {

	private static int z = 0;

	private LinkedList<Integer> scheiben = new LinkedList<Integer>();

	private String name;

	public Turm(String name) {
		this.name = name;
	}

	public int remove() {
		return scheiben.removeLast();
	}

	public void add(int i) {
		z++;
		scheiben.add(i);
	}

	public void ausgabe() {
		System.out.println("Turm " + name);
		for (int i = scheiben.size() - 1; i >= 0; i--) {
			System.out.println(scheiben.get(i));
		}
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	public static void clearAnzahlVertauschungen() {
		z = 0;
	}

	public static int getSummeVertauschungen() {
		return z;
	}

}
