package taskManager.util;

import java.io.*;

public class FileProcessor {
	private String inFile;
	private String outFile;
	private BufferedReader reader = null;
	private BufferedWriter writer = null;
	
	
	public FileProcessor(String file, String operation) {
		if(operation.equals("read") || operation.equals("READ")){
			try {
				inFile = file;
				reader = new BufferedReader(new FileReader(inFile));
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
				closeFiles();
				System.exit(1);
			} finally {
				
			}
		}
		else if(operation.equals("write") || operation.equals("WRITE")){
			try {
				outFile = file;

				File fileOut = new File(outFile);
				FileOutputStream fileOutStream = new FileOutputStream(fileOut);

				writer = new BufferedWriter(new OutputStreamWriter(fileOutStream));
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
				closeFiles();
				System.exit(1);
			} finally {
				
			}
		}
		else {
			System.err.println("Second param must be read/write");
			closeFiles();
			System.exit(1);
		}
		
	}

	public String readLine(){
		String retVal = null;
		try {
			retVal = reader.readLine();
		} catch (IOException e){
			System.err.println(e.getMessage());
			closeFiles();
			System.exit(1);
		} finally {
			
		}
		return retVal;
	}

	public void writeLine(String line) {
		try {
			writer.write(line);
			writer.newLine();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			closeFiles();
			System.exit(1);
		} finally {
			
		}
	}

	public void closeFiles() {
		try {
			if(reader != null){
				reader.close();
			}
			if(writer != null){
				writer.close();
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		} finally {
			
		}
	}
}