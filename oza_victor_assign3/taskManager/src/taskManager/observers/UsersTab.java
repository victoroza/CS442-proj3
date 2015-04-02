package taskManager.observers;

import taskManager.observers.Observer;
import taskManager.util.FileProcessor;
import taskManager.display.DisplayFile;

import java.util.*;

public class UsersTab implements Observer, DisplayFile {
	private FileProcessor writer;
	private List<String> toWrite;
	
	public UsersTab(FileProcessor writerIn) {
		writer = writerIn;
		toWrite = new ArrayList<String>();
	}

	public void update(String value) {
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

	public void writeToFile() {
		for(int i = 0; i < toWrite.size(); i++){
			writer.writeLine(toWrite.get(i));
		}
	}
}