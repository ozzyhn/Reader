package Function;

public class Main {

	public static void main(String[] args) {
		FileReaderr fileReader = new FileReaderr("dosya.txt");
		String words = fileReader.words(' ');
		String satır = fileReader.satır(4);
		System.out.println("Kelimeler: " + words);


	}

}
