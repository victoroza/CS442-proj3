package taskManager.subject;

import taskManager.observers.Observer;
import taskManager.filter.DashboardFilter;

public interface Subject {
	public void registerObserver(Observer o, DashboardFilter filter);
	public void removeObserver(Observer o);
	public void notifyAllObservers();
}