package sonstig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Verschluesselung {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String key = "Pumuckl";
		String text = "Meister Eder ist der Beste.";
		char[] codedText = verschluesseln(key.toCharArray(), text.toCharArray());
		System.out.println(codedText);
		char[] formerText = entschluesseln(key.toCharArray(), codedText);
		System.out.println(formerText);

		// Key in Datei schreiben
		File f = new File("./key.txt");
		FileWriter fw = new FileWriter(f);
		fw.write(key);
		fw.flush();
		fw.close();

		// Text in Datei schreiben
		File f2 = new File("./codedtext.txt");
		FileWriter fw2 = new FileWriter(f2);
		fw2.write(codedText);
		fw2.flush();
		fw2.close();

	}

	/**
	 * @param key
	 * @param text
	 * @return
	 */
	public static char[] verschluesseln(char[] key, char[] text) {
		StringBuilder sb = new StringBuilder();
		int j = -1;
		for (int i = 0; i < text.length; i++) {
			if (j < key.length-1) {
				j++;
			} else {
				j = 0;
			}
			char c = (char) (text[i] ^ key[j]);
			sb.append(c);
		}
		return sb.toString().toCharArray();
	}

	/**
	 * @param key
	 * @param text
	 * @return
	 */
	public static char[] entschluesseln(char[] key, char[] text) {
		StringBuilder sb = new StringBuilder();
		int j = -1;
		for (int i = 0; i < text.length; i++) {
			if (j < key.length-1) {
				j++;
			} else {
				j = 0;
			}
			char c = (char) (text[i] ^ key[j]);
			sb.append(c);
		}
		return sb.toString().toCharArray();
	}

}
