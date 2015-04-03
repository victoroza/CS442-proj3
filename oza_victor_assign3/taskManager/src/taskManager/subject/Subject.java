package taskManager.subject;

import taskManager.observers.Observer;
import taskManager.filter.DashboardFilter;

public interface Subject {
	/** Register an observer in the hashmap and list
	 *
	 *	@param	o	Observer to register
	 *	@param	filter	Filter to associate with observer
	 */
	public void registerObserver(Observer o, DashboardFilter filter);

	/** Register an observer in the hashmap and list
	 *
	 *	@param	o	Observer to remove
	 */
	public void removeObserver(Observer o);

	/** Call the update methods in the respective necessary observers
	 *
	 */
	public void notifyAllObservers();
}