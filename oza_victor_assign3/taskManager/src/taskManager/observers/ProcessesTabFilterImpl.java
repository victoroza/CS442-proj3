package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

public class ProcessesTabFilterImpl implements DashboardFilter {
	private MyLogger debug = null;

	/** ProcessesTabFilterImpl class constructor
	 *
	 */
	public ProcessesTabFilterImpl() {
		debug = MyLogger.getInstance();
		debug.print(2, "ProcessesTabFilterImpl constructor called");
	}

	/** Check filter to see if necessary
	 *
	 *	@param	filter String to check
	 *	@return true if needed or false if not to update
	 */
    public boolean check(String filter) {
        boolean retVal = false;
        if(filter.contains("process") || filter.contains("Process")) {
            retVal = true;
        }
        return retVal;
    }

    /** toString method override
	 *
	 */
    public String toString() {
    	return "ProcessesTabFilterImpl";
    }
}