package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

public class UsersTabFilterImpl implements DashboardFilter {
	private MyLogger debug = null;

	/** UsersTabFilterImpl class constructor
	 *
	 */
	public UsersTabFilterImpl() {
		debug = MyLogger.getInstance();
		debug.print(2, "UsersTabFilterImpl constructor called");
	}

	/** Check filter to see if necessary
	 *
	 *	@param	filter String to check
	 *	@return true if needed or false if not to update
	 */
    public boolean check(String filter) {
        boolean retVal = false;
        if(filter.contains("user") || filter.contains("User")) {
            retVal = true;
        }
        return retVal;
    }

    /** toString method override
	 *
	 */
    public String toString() {
    	return "UsersTabFilterImpl";
    }
}