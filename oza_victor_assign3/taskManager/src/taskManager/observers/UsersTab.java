package taskManager.observers;

import taskManager.observers.Observer;
import taskManager.util.FileProcessor;

public class UsersTab implements Observer {
	private FileProcessor writer;
	
	public UsersTab(FileProcessor writerIn) {
		writer = writerIn;
	}

	public void update(String value) {
		writer.writeLine("---USERS---");
		value = value.substring(6, value.length());
		String[] taskSplit = value.split("-");
		for(int i = 0; i < taskSplit.length; i++){
			String[] taskSplitInner = taskSplit[i].split(":");
			writer.writeLine(String.format("User: %s  Status: %s", taskSplitInner[0], taskSplitInner[1]));
		}
		writer.writeLine("");
	}
}