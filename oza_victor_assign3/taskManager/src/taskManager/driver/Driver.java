package taskManager.driver;

import taskManager.util.FileProcessor;
import taskManager.subject.*;
import taskManager.observers.*;
import taskManager.filter.*;
import taskManager.util.MyLogger;

public class Driver {

    /** Driver main
     *
     */
    public static void main(String args[]) {
        if(args.length < 3){
            System.out.println("Need 3 args");
            System.exit(1);
        }
        MyLogger.setDebugValue(Integer.parseInt(args[2]));
        FileProcessor reader = new FileProcessor(args[0], "READ");
        FileProcessor writer = new FileProcessor(args[1], "WRITE");

        Subject sub = new DashBoardSubject(reader, writer);
        Observer perfObs = new PerformanceTab(writer);
        Observer userObs = new UsersTab(writer);
        Observer proObs = new ProcessesTab(writer);
        DashboardFilter perfFilter = new PerformanceTabFilterImpl();
        DashboardFilter userFilter = new UsersTabFilterImpl();
        DashboardFilter proFilter = new ProcessesTabFilterImpl();
        sub.registerObserver(perfObs, perfFilter);
        sub.registerObserver(userObs, userFilter);
        sub.registerObserver(proObs, proFilter);
        ((DashBoardSubject)sub).readFile();
        reader.closeFiles();
        writer.closeFiles();
        
    }
}