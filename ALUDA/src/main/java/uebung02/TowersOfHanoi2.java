package uebung02;


public class TowersOfHanoi2 {
	
	private static int z = 0;
	
	public static void move(int s, Turm quellTurm, Turm zielTurm, Turm hilfsTurm) {

		if (s <= 2) {
			int a = quellTurm.remove();
			hilfsTurm.add(a);
			System.out.println("Scheibe " + a + " von " + quellTurm.getName() + " nach " + hilfsTurm.getName());
			int b = quellTurm.remove();
			zielTurm.add(b);
			System.out.println("Scheibe " + b + " von " + quellTurm.getName() + " nach " + zielTurm.getName());
			int c = hilfsTurm.remove();
			zielTurm.add(c);
			System.out.println("Scheibe " + c + " von " + hilfsTurm.getName() + " nach " + zielTurm.getName());
		} else {
			
			move(s-1, quellTurm, hilfsTurm, zielTurm);
			
			int a = quellTurm.remove();
			zielTurm.add(a);
			System.out.println("Scheibe " + a + " von " + quellTurm.getName() + " nach " + zielTurm.getName());
			
			move(s-1, hilfsTurm, zielTurm, quellTurm);
			
		}
		
	}

	public static void main(String[] args) {

		Turm t1 = new Turm("A");
		Turm t2 = new Turm("B");
		Turm t3 = new Turm("C");
	
		int anzahlScheiben = 20;
		
		for (int i = anzahlScheiben; i > 0; i--) {
			t1.add(i);
		}
		
		Turm.clearAnzahlVertauschungen();
		
		t1.ausgabe();
		
		move(anzahlScheiben, t1, t2, t3);
		
		t1.ausgabe();
		t2.ausgabe();
		t3.ausgabe();
		
		System.out.println("Anzahl Vertauschungen: " + Turm.getSummeVertauschungen());
		
	}

}
