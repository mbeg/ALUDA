package stack;

public interface IStack {

	boolean isEmpty();
	
	boolean isFull();
	
	public int size();
	
	public void push(int item);
	
	public int pop();
	
	public int top();
	
	
}
