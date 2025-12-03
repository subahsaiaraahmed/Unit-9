public class UI
{
	private boolean runState;
	private int holdTemp;
	private String rMode;
	
	/* TODO add get and set methods for the runState */
	public boolean getRunState()
	{
		return runState;
	}
	public void setRunState(boolean state)
	{
		runState = state;
	}
	/* TODO add get method to return the holdTemp, hardcoded to 68 degrees */
	public int getHoldTemp()
	{
		return 68;
	}
	/* TODO add get method to return the rMode, initially hardcoded to "heat" for testing purposes */
	public String getRunMode(boolean commandMode)
	{
		if(!commandMode){
			return "cool";
		}
		return "heat";
	}
	public void printStatus(int currTemp, boolean commandMode)
	{
		System.out.println("Hold Temp: " + getHoldTemp() + " | Mode: " + getRunMode(commandMode) + " | Furnace State: " + convertBool(getRunState()) + "| Current Temp: " + currTemp + " | Command Mode: " + convertBool(commandMode));
	}
	
	private String convertBool(boolean isOn)
	{
		/* TODO add a string variable to hold the on/off state as a string, initialized to "Off"  */
		String state = "Off";
		/* TODO add an if statement, testing to see if isOn is true, and if it is, setting the string variable to "On" */
		if (isOn)
		{
			state = "On";
		}
		/* TODO add the return statement for the string */
		return state;
	}
}