package taskManager.driver;

import taskManager.util.FileProcessor;
import taskManager.subject.*;
import taskManager.observers.*;
import taskManager.filter.*;

public class Driver {
    public static void main(String args[]) {
        FileProcessor reader = new FileProcessor(args[0], "READ");
        FileProcessor writer = new FileProcessor(args[1], "WRITE");

        Subject sub = new DashBoardSubject(reader, writer);
        Observer perfObs = new PerformanceTab(writer);
        Observer userObs = new UsersTab(writer);
        Observer proObs = new ProcessesTab(writer);
        DashboardFilter perfFilter = new PerformanceTabFilterImpl();
        DashboardFilter userFilter = new UsersTabFilterImpl();
        DashboardFilter proFilter = new ProcessesTabFilterImpl();
        sub.registerObserver(proObs, proFilter);
        sub.registerObserver(userObs, userFilter);
        sub.registerObserver(perfObs, perfFilter);
        ((DashBoardSubject)sub).readFile();
        reader.closeFiles();
        writer.closeFiles();
        
    }
}