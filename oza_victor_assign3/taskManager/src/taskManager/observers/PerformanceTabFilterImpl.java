package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

public class PerformanceTabFilterImpl implements DashboardFilter {
	private MyLogger debug = null;

	/** PerformanceTabFilterImpl class constructor
	 *
	 */
	public PerformanceTabFilterImpl() {
		debug = MyLogger.getInstance();
		debug.print(2, "PerformanceTabFilterImpl constructor called");
	}

	/** Check filter to see if necessary
	 *
	 *	@param	filter String to check
	 *	@return true if needed or false if not to update
	 */
    public boolean check(String filter) {
        boolean retVal = false;
        if(filter.contains("performance") || filter.contains("Performance")) {
            retVal = true;
        }
        return retVal;
    }

    /** toString method override
	 *
	 */
    public String toString() {
    	return "PerformanceTabFilterImpl";
    }
}