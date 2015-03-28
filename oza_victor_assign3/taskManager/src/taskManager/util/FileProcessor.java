package taskManager.util;

import java.io.*;

public class FileProcessor {
	private BufferedReader reader;
	public FileProcessor(String file) {
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		} finally {
			
		}
	}

	public String readLine(){
		String retVal = null;
		try {
			retVal = reader.readLine();
		} catch (IOException e){
			System.err.println(e.getMessage());
			System.exit(1);
		} finally {

		}
		return retVal;
	}
}