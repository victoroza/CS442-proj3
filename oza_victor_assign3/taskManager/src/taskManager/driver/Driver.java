package taskManager.driver;

import taskManager.util.FileProcessor;
import taskManager.subject.*;
import taskManager.observers.*;
import taskManager.filter.*;

public class Driver {
    public static void main(String args[]) {
        FileProcessor.setFile(args[0]);
        Subject sub = new DashBoardSubject();
        Observer perfObs = new PerformanceTab();
        Observer userObs = new UsersTab();
        DashboardFilter perfFilter = new PerformanceTabFilterImpl();
        DashboardFilter userFilter = new UsersTabFilterImpl();
        ((DashBoardSubject)sub).readFile();
        
    }
}