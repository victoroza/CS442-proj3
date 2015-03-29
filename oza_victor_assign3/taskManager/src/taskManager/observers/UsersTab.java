package taskManager.observers;

import taskManager.observers.Observer;

public class UsersTab implements Observer {
	public void update(String value) {
		System.out.println("USERS CALLED");
		System.out.println(value);
	}
}