package uebung01;

public class Stoppuhr {

	private long start;
	
	private long end;

	public void start() {
		this.start = System.currentTimeMillis();
	}

	public void end() {
		this.end = System.currentTimeMillis();
	}
	
	public long getResult() {
		return this.end - this.start;
	}
	
}
