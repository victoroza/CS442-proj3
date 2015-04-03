package taskManager.observers;

import taskManager.observers.Observer;
import taskManager.util.FileProcessor;
import taskManager.display.DisplayFile;
import taskManager.util.MyLogger;

import java.util.*;

public class UsersTab implements Observer, DisplayFile {
	private FileProcessor writer;
	private List<String> toWrite;
	private MyLogger debug = null;
	
	/** UsersTab class constructor
	 *
	 *	@param writerIn writer to use to write to file
	 */
	public UsersTab(FileProcessor writerIn) {
		debug = MyLogger.getInstance();
		debug.print(2, "UsersTab constructor called");
		writer = writerIn;
		toWrite = new ArrayList<String>();
	}

	/** Used to update the observer and write to file
     *
     *	@param value	value to write to file
     */
	public void update(String value) {
		debug.print(3, "UsersTab update called");
		toWrite.add("---USERS---");
		value = value.substring(6, value.length());
		String[] taskSplit = value.split("-");
		for(int i = 0; i < taskSplit.length; i++){
			String[] taskSplitInner = taskSplit[i].split(":");
			toWrite.add(String.format("User: %s  Status: %s", taskSplitInner[0], taskSplitInner[1]));
		}
		toWrite.add("");
		writeToFile();
		toWrite.clear();
	}

	/** Used to call the writers write line method
     *
     */
	public void writeToFile() {
		debug.print(4, "UsersTab writing to file");
		for(int i = 0; i < toWrite.size(); i++){
			writer.writeLine(toWrite.get(i));
		}
	}

	/** toString method override
	 *
	 */
    public String toString() {
    	return "UsersTab";
    }
}