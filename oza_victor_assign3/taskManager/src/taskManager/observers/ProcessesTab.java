package taskManager.observers;

import taskManager.observers.Observer;
import taskManager.util.FileProcessor;
import taskManager.display.DisplayFile;

import java.util.*;

public class ProcessesTab implements Observer, DisplayFile {
	private FileProcessor writer;
	private List<String> toWrite;
	
	public ProcessesTab(FileProcessor writerIn) {
		writer = writerIn;
		toWrite = new ArrayList<String>();
	}

	public void update(String value) {
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

	public void writeToFile() {
		for(int i = 0; i < toWrite.size(); i++){
			writer.writeLine(toWrite.get(i));
		}
	}
}