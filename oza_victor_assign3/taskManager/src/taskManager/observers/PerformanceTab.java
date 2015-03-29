package taskManager.observers;

import taskManager.observers.Observer;

public class PerformanceTab implements Observer {
	public void update(String value) {
		System.out.println("PERFORMANCE CALLED");
		value = value.substring(12, value.length());
		System.out.println(value);
	}
}