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
	private List<Observer> observerListKey;
	private FileProcessor reader;
	private FileProcessor writer;
	private MyLogger debug = null;

	/** DashBoardSubject class constructor
	 *
	 *	@param	readerIn	Reader that will be called to read a line from
	 *	@param	writerIn	Writer that will be called to write to
	 */
	public DashBoardSubject(FileProcessor readerIn, FileProcessor writerIn) {
		debug = MyLogger.getInstance();
		debug.print(1, "DashBoardSubject constructor called");
		debug.print(2, "DashBoardSubject constructor called");
		reader = readerIn;
		writer = writerIn;
		observerList = new HashMap<Observer, DashboardFilter>();
		observerListKey = new ArrayList<Observer>();
		

	}

	/** Register an observer in the hashmap and list
	 *
	 *	@param	o	Observer to register
	 *	@param	filter	Filter to associate with observer
	 */
	public void registerObserver(Observer o, DashboardFilter filter) {
		debug.print(1, "DashBoardSubject registerObserver called");
		observerList.put(o, filter);
		observerListKey.add(o);
	}

	/** Register an observer in the hashmap and list
	 *
	 *	@param	o	Observer to remove
	 */
	public void removeObserver(Observer o) {
		debug.print(1, "DashBoardSubject removeObserver called");
		if(observerList.remove(o) == null){
			System.exit(1);
		}
	}

	/** Call the update methods in the respective necessary observers
	 *
	 */
	public void notifyAllObservers(){
		debug.print(1, "DashBoardSubject notifyAllObservers called");
		debug.print(3, "DashBoardSubject notifyAllObservers called");
		for(int j = 0; j < observerListKey.size(); j++){
			DashboardFilter filterToCheck = observerList.get(observerListKey.get(j));
			if(notifStr.contains("*")) {
				String[] taskSplit = notifStr.split("\\*");
				if(taskSplit.length > 0){
					for(int i = 0; i < taskSplit.length; i++) {
						if(filterToCheck.check(taskSplit[i])){
							Observer obsToUpdate = observerListKey.get(j);
							obsToUpdate.update(taskSplit[i]);
						}
					}
				}
			}
		}
	}

	/** Call the readers read line method and parse
	 *
	 */
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

	/** toString method override
	 *
	 */
    public String toString() {
    	return "DashBoardSubject";
    }

}