package taskManager.observers;

import taskManager.observers.Observer;
import taskManager.util.FileProcessor;
import taskManager.display.DisplayFile;
import taskManager.util.MyLogger;

import java.util.*;

public class ProcessesTab implements Observer, DisplayFile {
	private FileProcessor writer;
	private List<String> toWrite;
	private MyLogger debug = null;
	
	/** ProcessesTab class constructor
	 *
	 *	@param writerIn writer to use to write to file
	 */
	public ProcessesTab(FileProcessor writerIn) {
		debug = MyLogger.getInstance();
		debug.print(2, "ProcessesTab constructor called");
		writer = writerIn;
		toWrite = new ArrayList<String>();
	}

	/** Used to update the observer and write to file
     *
     *	@param value	value to write to file
     */
	public void update(String value) {
		debug.print(3, "ProcessesTab update called");
		toWrite.add("---PROCESSES---");
		value = value.substring(10, value.length());
		String[] taskSplit = value.split("-");
		toWrite.add("  PID COMMAND         USER     %CPU %MEM");
		for(int i = 0; i < taskSplit.length; i++){
			String[] taskSplitInner = taskSplit[i].split(":");
			toWrite.add(String.format("%5s %-15s %-8s %4s %4s", taskSplitInner[0], taskSplitInner[1], taskSplitInner[2], taskSplitInner[3], taskSplitInner[4]));
		}
		toWrite.add("");
		writeToFile();
		toWrite.clear();
	}

	/** Used to call the writers write line method
     *
     */
	public void writeToFile() {
		debug.print(4, "ProcessesTab writing to file");
		for(int i = 0; i < toWrite.size(); i++){
			writer.writeLine(toWrite.get(i));
		}
	}

	/** toString method override
	 *
	 */
    public String toString() {
    	return "ProcessesTab";
    }
}