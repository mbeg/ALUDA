package uebung01;


public class HarmonischeReihe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Stoppuhr s = new Stoppuhr();
		s.start();
		System.out.println("Harmonische Reihe");
		for (int n = 1; n <= 10000; n++) {
			System.out.println("ite(" + n + ") =" + iter(n));
			System.out.println("rek(" + n + ") =" + rek(n));
			
		}
		s.end();
		System.out.println(s.getResult());
	}

	private static double iter(int n) {
		double summe = 0;
		for (int i = 1; i <= n; i++) {
			summe = summe + 1.0/i;
		}
		return summe;
	}

	private static double rek(int n) {
		if (n==1) {
			return 1;
		}
		else {
			return 1.0/n + rek(n-1);
		}
	}
	
}
