package stack;

public class InfixPostfixUmwandlung {

	static char[] zielArray = null;
	static int zaehler = 0;

	private static void addToZielArray(char c) {
		zielArray[zaehler] = c;
		zaehler++;
	}

	public static MyStack umwandlung(String infix) {

		zielArray = new char[infix.length()];

		char[] zeichen = infix.toCharArray();

		MyStack stack = new MyStack(zeichen.length);
		for (int i = 0; i < zeichen.length; i++) {

			char c = zeichen[i];

			// Offene Klammer (
			if (c == 40) {
				stack.push(c);
			}
			// Zahlen 0 bis 9
			if (48 <= c && c <= 57) {
				addToZielArray(c);
			}
			// Operatoren + - * /
			if (c == 42 || c == 43 || c == 45 || c == 47) {
				boolean b = true;
				while (b) {
					if (c == 43 || c == 45) {
						// Was liegt auf dem Stack?
						int fromStack;
						try {
							fromStack = stack.top();
						} catch (Exception e) {
							fromStack = -1;
						}
						// Ist es ein Operator mit gleicher oder höherer
						// Priorität
						if (fromStack == 43 || fromStack == 45
								|| fromStack == 42 || fromStack == 47) {
							addToZielArray((char) stack.pop());
						} else {
							b = false;
						}
					}
					// c ist entweder * oder /
					else {
						// Was liegt auf dem Stack?
						int fromStack;
						try {
							fromStack = stack.top();
						} catch (Exception e) {
							fromStack = -1;
						}
						// Ist es ein Operator mit gleicher Priorität?
						if (fromStack == 42 || fromStack == 47) {
							addToZielArray((char)stack.pop());
						} else {
							b = false;
						}
					}
				}
				stack.push(c);
			}
			// geschlossen Klammer
			if (c == 41) {
				boolean b2 = true;
				while (b2) {
					// Liegt ein ) auf dem Stack
					if (stack.size()>0) {
						if (stack.top() != 40) {
							addToZielArray((char)stack.pop());
						} else {
							b2 = false;
						}	
					} else {
						b2 = false;
					}
				}
			}
		}
		return stack;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyStack stack = umwandlung("(3+5)*(7-2)");
	
		for (int i = 0; i < zielArray.length; i++) {
			if (zielArray[i]!=0) {
				System.out.print(zielArray[i]);	
			}
		}
		
		for (int i = 0; i < stack.size(); i++) {
			if (stack.top()!=0) {
				System.out.print((char)stack.pop());
			}
		}

//		System.out.println("+ = " + (int) '+');
//		System.out.println("- = " + (int) '-');
//		System.out.println("* = " + (int) '*');
//		System.out.println("/ = " + (int) '/');
//
//		System.out.println(") = " + (int) ')');

	}

}
