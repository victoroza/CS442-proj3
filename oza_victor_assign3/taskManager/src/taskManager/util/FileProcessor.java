package taskManager.util;

import java.io.*;
import taskManager.util.MyLogger;

public class FileProcessor {
	private String inFile;
	private String outFile;
	private BufferedReader reader = null;
	private BufferedWriter writer = null;
	private MyLogger debug = null;
	
	/** FileProcessor class constructor
	 *
	 *	@param file input file to read from/write to
	 *	@operation to write or to read
	 */
	public FileProcessor(String file, String operation) {
		debug = MyLogger.getInstance();
		debug.print(2, "FileProcessor constructor called");
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

	/** Read a line from the input file
	 *
	 *	@return	String value of line that was read
	 */
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

	/** Write input line to file given
	 *
	 *	@param line Line to write to file
	 */
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

	/** close files after done
	 *
	 */
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

	/** toString method override
	 *
	 */
    public String toString() {
    	return "FileProcessor";
    }
}