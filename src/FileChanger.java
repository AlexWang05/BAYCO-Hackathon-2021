import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Used to create a file called "data.txt" under the folder "Data" in the project directory,
 * read the file on startup (or create one if there isn't one present)
 * and write to it as changes occur on HomeGui/AddCourse
 * 
 * @author Alex Wang, Connor Chow, Kamran Hussain
 * @version 4/16/2021
 */
public class FileChanger {

	/**
	 * Used to the check if there is a 'data.txt' file under 'BAYCO-Hackathon-2021/Data'
	 * 
	 * @return whether a file is present or not (true if file, false if none)
	 */
	public static Boolean checkFile() {
		Boolean isFile;

		//tries to scan, if error, then returns false
		try { 
			File file = new File("Resources/Data/data.txt");
			@SuppressWarnings({ "unused", "resource" })
			Scanner fileReader = new Scanner(file);
			isFile = true;
		} catch (FileNotFoundException e) {
			isFile = false;
		}

		return isFile;
	}

	/**
	 * Creates new file 'data.txt'
	 * 
	 * @pre Only call if checkFile() returns false
	 */
	public static void createFile() {
		
		//tries to create file, error if not able to create one
		try {
			File file = new File("Resources/Data/data.txt");
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Error in createFile()");
			e.printStackTrace();
		}
	}

	/**
	 * Reads 'data.txt' and inputs data into program (ex: links, courses, etc)
	 * 
	 * @pre Data d object needs to have 8 terms; Only call if checkFile() returns true or createNewFile() returns true
	 * @post inputs data into Data object d
	 * @param d Data object required from HomeGui to store link info
	 */
	public static void readFile(Data d) {
		String data = ""; // initialize String
		int num = 0; //number for which line to start inputting into Data object d
		//tries to read 'data.txt' and then input it into Data object d
		try {
			File file = new File("Resources/Data/data.txt");
			Scanner fileReader = new Scanner(file);

			//keeps reading for every line in 'data.txt'
			while (fileReader.hasNextLine()) {
				data = fileReader.nextLine();
				d.replaceStrings(num, data);
				num++;
			}
			fileReader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File is not found, stacktrace: ");
			e.printStackTrace();
		}
	}

	/**
	 * Called to write to 'data.txt' file 
	 * 
	 * @pre 'data.txt' has to be created
	 * @param info ArrayList of strings being converted into 'data.txt' file
	 * @throws IOException error if FileWriter runs into an issue with writing to 'data.txt'
	 */
	public static void writeFile(ArrayList<String> info) throws IOException {
		FileWriter writer = new FileWriter("Resources/Data/data.txt");
		
		// loops through array
		for (String s : info) {
			// write each element to 'data.txt'
			writer.write(s + "\n");
		}

		writer.close();
	}
	
}
