package taskManager.observers;

import taskManager.filter.DashboardFilter;

public class ProcessesTabFilterImpl implements DashboardFilter {
    public boolean check(String filter) {
        boolean retVal = false;
        if(filter.contains("process") || filter.contains("Process")) {
            retVal = true;
        }
        return retVal;
    }
}