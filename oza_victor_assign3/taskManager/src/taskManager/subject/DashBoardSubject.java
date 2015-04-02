package taskManager.subject;

import java.util.*;

import taskManager.subject.Subject;
import taskManager.observers.Observer;
import taskManager.filter.DashboardFilter;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

public class DashBoardSubject implements Subject {
	private String notifStr = null;
	private Map<Observer, DashboardFilter> observerList;
	private FileProcessor reader;
	private FileProcessor writer;
	private MyLogger debug = MyLogger.getInstance();

	public DashBoardSubject(FileProcessor readerIn, FileProcessor writerIn) {
		debug.print(1, "DashBoardSubject constructor called");
		reader = readerIn;
		writer = writerIn;
		observerList = new HashMap<Observer, DashboardFilter>();
		

	}

	public void registerObserver(Observer o, DashboardFilter filter) {
		debug.print(1, "DashBoardSubject registerObserver called");
		observerList.put(o, filter);
	}

	public void removeObserver(Observer o) {
		debug.print(1, "DashBoardSubject removeObserver called");
		if(observerList.remove(o) == null){
			System.exit(1);
		}
	}

	public void notifyAllObservers(){
		debug.print(1, "DashBoardSubject notifyAllObservers called");
		for(Map.Entry<Observer, DashboardFilter> entry : observerList.entrySet()){
			DashboardFilter filterToCheck = entry.getValue();
			if(notifStr.contains("*")) {
				String[] taskSplit = notifStr.split("\\*");
				if(taskSplit.length > 0){
					for(int i = 0; i < taskSplit.length; i++) {
						if(filterToCheck.check(taskSplit[i])){
							Observer obsToUpdate = entry.getKey();
							obsToUpdate.update(taskSplit[i]);
						}
					}
				}
			}
		}
	}

	public void readFile() {
		debug.print(1, "DashBoardSubject readFile called");
		do {
			notifStr = reader.readLine();
			if(notifStr != null) {
				writer.writeLine("---TAB(s) BEGIN---");
				notifyAllObservers();
				writer.writeLine("---TAB(s) END---");
			}
		} while(notifStr != null);
	}

}