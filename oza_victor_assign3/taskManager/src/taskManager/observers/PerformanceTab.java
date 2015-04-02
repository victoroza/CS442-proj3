package taskManager.observers;

import taskManager.observers.Observer;
import taskManager.util.FileProcessor;

public class PerformanceTab implements Observer {
	private FileProcessor writer;

	public PerformanceTab(FileProcessor writerIn) {
		writer = writerIn;
	}

	public void update(String value) {
		writer.writeLine("---PERFORMANCE---");
		value = value.substring(12, value.length());
		String[] taskSplit = value.split(":");
		writer.writeLine(String.format("Memory Total: %s  Memory Used: %s  Memory  Free: %s  Memory  Cached: %s", taskSplit[0], taskSplit[1], taskSplit[2], taskSplit[3]));
		writer.writeLine(String.format("CPU Idle: %s  CPU User Level: %s  CPU System Level: %s", taskSplit[4], taskSplit[5], taskSplit[6]));
		writer.writeLine("");
	}
}