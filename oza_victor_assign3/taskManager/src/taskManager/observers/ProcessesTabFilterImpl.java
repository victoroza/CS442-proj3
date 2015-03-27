package taskManager.observers;

import taskManager.filter.DashboardFilter;

public class ProcessTabFilter implements Filter {
    public boolean check(String filter) {
        private boolean retVal = false;
        if(filter == "process" || filter == "Process") {
            retVal = true;
        }
        return retVal;
    }
}