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
		fp = new FileProcessor();
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
		for(Map.Entry<Observer, DashboardFilter> entry : observerList.entrySet()){
			DashboardFilter filterToCheck = entry.getValue();
			System.out.println("checking obs");
			if(notifStr.contains("*")) {
				String[] taskSplit = notifStr.split("\\*");
				for(int i = 0; i < taskSplit.length; i++) {
					if(filterToCheck.check(taskSplit[i])){
						Observer obsToUpdate = entry.getKey();
						obsToUpdate.update(taskSplit[i]);
					}
				}
			}
		}
	}

	public void readFile() {
		do {
			notifStr = fp.readLine();
			if(notifStr != null) {
				notifyAllObservers();
			}
		} while(notifStr != null);
	}

}