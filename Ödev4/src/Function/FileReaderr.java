package Function;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderr {
	private String file;

	public FileReaderr(String file) {
		this.file = file;
	}

	public String words(char separator) {
		//String builder oluşturduk biri kelime için diğeri birleştiğimiz sonuc için
		StringBuilder word = new StringBuilder();
		StringBuilder result = new StringBuilder();
		try {
			// Okumak için fileReader oluşturduk
			FileReader reader = new FileReader(file);
			//Char value tipinde int oluşturduk bu döngü dönerken kaç adet karakter oldugunu bilmemiz için
			int charValue;
			while ((charValue = reader.read()) != -1) {
				//cast yaptık 
				char character = (char) charValue;
				//karakter seperatör ayırıcı ile eşitse sonucu ekledik ve stringe çevirdik
				if (character == separator) {
					result.append(word.toString()).append(" ");
					word.setLength(0);
				} else {
					word.append(character);
				}
			}
			if (word.length() > 0) {
				result.append(word.toString());
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public String satır(int lineNumber) {
		try {
			FileReader reader = new FileReader(file);
			StringBuilder satır = new StringBuilder();
			int current = 0;
			int charValue;
			while ((charValue = reader.read()) != -1) {
				char character = (char) charValue;
				satır.append(character);
				if (character == '\n') {
					current++;
					if (current == lineNumber) {
						reader.close();
						return satır.toString();
					}
					satır.setLength(0);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
