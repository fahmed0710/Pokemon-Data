package proj2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class CsvReader {
	public HashSet<Character> characters;
	
	/*
	 * Returns true if the file was read okay, false if otherwise 
	 * and creates and stores characters based on the file data
	 * 
	 * @param fileName the name of the file with data
	 * @return whether the file was read okay
	 */
	public boolean readFile(String fileName) throws IOException {
		characters = new HashSet<Character>();
		
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((line = br.readLine()) != null) {
				String dataLine = line;
				if(!line.contains("name") || !line.contains("hp")
						|| !line.contains("is_legendary")) {
					Character c = new Character(dataLine);
					characters.add(c);
				}	
			}
			br.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * Retrieves the HashSet of Character objects that were created
	 * 
	 * @returns a HashSet of Character objects
	 */
	public HashSet<Character> getCharacterSet(){
		return characters;
	}

}
