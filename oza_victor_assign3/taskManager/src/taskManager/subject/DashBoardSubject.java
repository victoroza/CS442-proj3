package taskManager.subject;

import java.util.*;

import taskManager.subject.Subject;
import taskManager.observers.Observer;
import taskManager.filter.DashboardFilter;
import taskManager.util.FileProcessor;

public class DashBoardSubject implements Subject {
	private String notifStr = null;
	private Map<Observer, DashboardFilter> observerList;
	private FileProcessor fp;

	public DashBoardSubject() {
		observerList = new HashMap<Observer, DashboardFilter>();

	}

	public void registerObserver(Observer o, DashboardFilter filter) {
		observerList.put(o, filter);
	}

	public void removeObserver(Observer o) {
		if(observerList.remove(o) == null){
			System.exit(1);
		}
	}

	public void notifyAllObservers(){

	}

	public void readFile(String file) {
		do {

		}
	}

}