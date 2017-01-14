
import java.io.*;
import java.util.ArrayList;

/**
 * This class is largely based off of:
 * https://www.caveofprogramming.com/java/java-file-reading-and-writing-
 * files-in-java.html
 * 
 * Reads in files.
 */
public class LoadText {
	// Reads in all the words in the dictionary to this arraylist
	private ArrayList<String> words = new ArrayList<String>();

	public LoadText(String fileName) {
		String line;

		try {
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				words.add(line);
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	public ArrayList getWords()
	{
		return words;
	}
}