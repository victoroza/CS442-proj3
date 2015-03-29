package taskManager.observers;

import taskManager.observers.Observer;

public class ProcessesTab implements Observer {
	public void update(String value) {
		System.out.println("PROCESSESS CALLED");
		System.out.println(value);
	}
}