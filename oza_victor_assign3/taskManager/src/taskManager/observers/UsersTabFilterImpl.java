package taskManager.observers;

import taskManager.filter.DashboardFilter;

public class UsersTabFilterImpl implements DashboardFilter {
    public boolean check(String filter) {
        boolean retVal = false;
        if(filter == "user" || filter == "User") {
            retVal = true;
        }
        return retVal;
    }
}