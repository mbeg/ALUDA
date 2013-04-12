package stack;

public class MyStack implements IStack {

	private int[] arr;
	
	private int top;
	
	public MyStack(int size) {
		arr = new int[size];
		top = -1;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}

	public boolean isFull() {
		return top == arr.length-1;
	}

	public int size() {
		return top + 1;
	}

	public void push(int item) {
		if (isFull()) {
			throw new RuntimeException("Fehler: Stack ist voll.");
		} else {
			top++;
			arr[top] = item;
		}
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Fehler: Stack ist leer.");
		} else {
			int res = arr[top];
			top--;
			return res;
		}
	}

	public int top() {
		if (isEmpty()) {
			throw new RuntimeException("Fehler: Stack ist leer.");
		} else {
			int res = arr[top];
			return res;
		}
	}


}
