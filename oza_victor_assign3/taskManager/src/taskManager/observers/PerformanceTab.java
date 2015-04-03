package taskManager.observers;

import taskManager.observers.Observer;
import taskManager.util.FileProcessor;
import taskManager.display.DisplayFile;
import taskManager.util.MyLogger;

import java.util.*;

public class PerformanceTab implements Observer, DisplayFile {
	private FileProcessor writer;
	private List<String> toWrite;
	private MyLogger debug = null;

	/** PerformanceTab class constructor
	 *
	 *	@param writerIn writer to use to write to file
	 */
	public PerformanceTab(FileProcessor writerIn) {
		debug = MyLogger.getInstance();
		debug.print(2, "PerformanceTab constructor called");
		debug = MyLogger.getInstance();
		writer = writerIn;
		toWrite = new ArrayList<String>();
	}

	/** Used to update the observer and write to file
     *
     *	@param value	value to write to file
     */
	public void update(String value) {
		debug.print(3, "PerformanceTab update called");
		toWrite.add("---PERFORMANCE---");
		value = value.substring(12, value.length());
		String[] taskSplit = value.split(":");
		toWrite.add(String.format("Memory Total: %s  Memory Used: %s  Memory  Free: %s  Memory  Cached: %s", taskSplit[0], taskSplit[1], taskSplit[2], taskSplit[3]));
		toWrite.add(String.format("CPU Idle: %s  CPU User Level: %s  CPU System Level: %s", taskSplit[4], taskSplit[5], taskSplit[6]));
		toWrite.add("");
		writeToFile();
		toWrite.clear();
	}

	/** Used to call the writers write line method
     *
     */
	public void writeToFile() {
		debug.print(3, "PerformanceTab writing to file");
		for(int i = 0; i < toWrite.size(); i++){
			writer.writeLine(toWrite.get(i));
		}
	}

	/** toString method override
	 *
	 */
    public String toString() {
    	return "PerformanceTab";
    }
}