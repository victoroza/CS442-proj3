package taskManager.driver;

import taskManager.util.FileProcessor;
import taskManager.subject.*;

public class Driver {
    public static void main(String args[]) {
        FileProcessor.setFile(args[0]);
        Subject sub = new DashBoardSubject();
        ((DashBoardSubject)sub).readFile();
        
    }
}