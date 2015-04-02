package taskManager.util;

/** MyLogger class that will print based upon given value
 *	Follows the singleton pattern
 *
 *	@author Victor Oza
 */
public class MyLogger {
	private static MyLogger instance = null;
	private static int debugValue;

	/** MyLogger class constructor
	 *
	 */
	private MyLogger(){ }

	/** Used to get the static instance of the MyLogger Singleton
	 *
	 * @return	Returns MyLogger static Singleton instance
	 */
	public static MyLogger getInstance(){
		if (instance == null) {
			instance = new MyLogger();
		}
		return instance;
	}


	/** Used to set debugValue at runtime 
     *
     *	@param indebugValue	Value that the debugValue will be set to,
     *						values from [0-3] are allowed.
     */
	public static void setDebugValue(int indebugValue) {
		debugValue = indebugValue;
		if(debugValue > 4 || debugValue < 0){
			System.err.println("Debug Value should be [0-4]");
			System.exit(1);
		}
	}

	/** Used to check if debug statement should be printed. 
     *
     *	@param level		Value of input debug statement that,
     *						needs to be checked.
     *	@param debugMessage	String to be printed.
     */
	public void print(int level, String debugMessage){
		if(level == debugValue){
			System.out.println(debugMessage);
		}
	}

	/** Used get string representation of class
	 *
	 *	@return		String of the MyLogger class
	 */
	public String toString() {
		return String.format("debugValue is %d", debugValue);
	}
}