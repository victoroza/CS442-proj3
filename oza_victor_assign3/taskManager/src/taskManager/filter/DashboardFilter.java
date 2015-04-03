package taskManager.filter;

public interface DashboardFilter {
	/** Check filter to see if necessary
	 *
	 *	@param	filter String to check
	 *	@return true if needed or false if not to update
	 */
    public boolean check(String filter);
}