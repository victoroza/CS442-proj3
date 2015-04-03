package taskManager.observers;

public interface Observer {
	/** Used to update the observer and write to file
     *
     *	@param value	value to write to file
     */
	public void update(String values);
}