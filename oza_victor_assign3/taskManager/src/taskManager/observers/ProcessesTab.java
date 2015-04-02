package taskManager.observers;

import taskManager.observers.Observer;
import taskManager.util.FileProcessor;

public class ProcessesTab implements Observer {
	private FileProcessor writer;
	
	public ProcessesTab(FileProcessor writerIn) {
		writer = writerIn;
	}

	public void update(String value) {
		writer.writeLine("---PROCESSES---");
		value = value.substring(10, value.length());
		String[] taskSplit = value.split("-");
		writer.writeLine("  PID COMMAND         USER     %CPU %MEM");
		for(int i = 0; i < taskSplit.length; i++){
			String[] taskSplitInner = taskSplit[i].split(":");
			writer.writeLine(String.format("%5s %-15s %-8s %4s %4s", taskSplitInner[0], taskSplitInner[1], taskSplitInner[2], taskSplitInner[3], taskSplitInner[4]));
		}
		writer.writeLine("");
	}
}