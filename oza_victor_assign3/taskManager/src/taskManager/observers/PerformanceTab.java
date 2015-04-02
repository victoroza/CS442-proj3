package taskManager.observers;

import taskManager.observers.Observer;
import taskManager.util.FileProcessor;
import taskManager.display.DisplayFile;

import java.util.*;

public class PerformanceTab implements Observer, DisplayFile {
	private FileProcessor writer;
	private List<String> toWrite;

	public PerformanceTab(FileProcessor writerIn) {
		writer = writerIn;
		toWrite = new ArrayList<String>();
	}

	public void update(String value) {
		toWrite.add("---PERFORMANCE---");
		value = value.substring(12, value.length());
		String[] taskSplit = value.split(":");
		toWrite.add(String.format("Memory Total: %s  Memory Used: %s  Memory  Free: %s  Memory  Cached: %s", taskSplit[0], taskSplit[1], taskSplit[2], taskSplit[3]));
		toWrite.add(String.format("CPU Idle: %s  CPU User Level: %s  CPU System Level: %s", taskSplit[4], taskSplit[5], taskSplit[6]));
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