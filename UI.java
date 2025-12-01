public class UI
{
	private boolean runState;
	private int holdTemp;
	private String rMode;
	
	/* TODO add get and set methods for the runState */
	
	/* TODO add get method to return the holdTemp, hardcoded to 68 degrees */
	
	/* TODO add get method to return the rMode, initially hardcoded to "heat" for testing purposes */
	
	public void printStatus(int currTemp, boolean commandMode)
	{
		print("Hold Temp: " + getHoldTemp() + " | Mode: " + getRunMode() + " | Furnace State: " + convertBool(getRunState()) + "| Current Temp: " + currTemp + " | Command Mode: " + convertBool(commandMode));
	}
	
	private String convertBool(boolean isOn)
	{
		/* TODO add a string variable to hold the on/off state as a string, initialized to "Off"  */
		
		/* TODO add an if statement, testing to see if isOn is true, and if it is, setting the string variable to "On" */
		
		/* TODO add the return statement for the string */
	}
}