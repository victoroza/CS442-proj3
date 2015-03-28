package taskManager.observers;

import taskManager.filter.DashboardFilter;

public class PerformanceTabFilterImpl implements DashboardFilter {
    public boolean check(String filter) {
        boolean retVal = false;
        if(filter == "performance" || filter == "Performance") {
            retVal = true;
        }
        return retVal;
    }
}