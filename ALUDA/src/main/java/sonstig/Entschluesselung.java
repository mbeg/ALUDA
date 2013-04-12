package sonstig;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Entschluesselung {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// File f = new File("./key");
		// int fileLength = (int) f.length();
		// FileReader fr = new FileReader(f);
		// char[] key = new char[fileLength];
		// fr.read(key);
		//
		// for (int i = 0; i < key.length; i++) {
		// System.out.print(key[i]);
		// }
		// System.out.println();
		//
		// File f2 = new File("./chiffre");
		// int fl2 = (int) f2.length();
		// FileReader fr2 = new FileReader(f2);
		// char[] codedText = new char[fl2];
		// fr2.read(codedText);
		// System.out.println(codedText);
		// System.out.println();

		/* Key mit 256 Bytes */
		char[] key = new char[256];
		// Key-Datei einlesen
		DataInputStream ds = new DataInputStream(new FileInputStream(new File(
				"./key")));
		// Key einlesen
		for (int i = 0; i < key.length; i++) {
			key[i] = ds.readChar();
		}
		ds.close();
		
		
		
		

		DataInputStream ds2 = new DataInputStream(new FileInputStream(new File(
				"./chiffre")));
		// Anzahl der Zeichen herausfinden und dann die Zeichen einlesen
		int anzahlChars = ds2.available() / 2; // unglückliche Lösung!
		char[] chiffre = new char[anzahlChars];
		for (int i = 0; i < chiffre.length; i++) {
			chiffre[i] = ds2.readChar();
		}
		ds2.close();

		System.out.println(chiffre);

		char[] c = Verschluesselung.entschluesseln(key, chiffre);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}

	}
}
