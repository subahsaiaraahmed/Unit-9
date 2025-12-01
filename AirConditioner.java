import java.util.TimerTask;

public class AirConditioner extends TimerTask
	{
		boolean commandMode;
		UI myUI;
		TempSensor myTS;
		
		public AirConditioner(TempSensor inTS, UI inUI) 
		{
         	this.myUI = inUI;
         	this.myTS = inTS;
     	}
		
		@Override
		public void run()
		{
			int holdTemp = myUI.getHoldTemp();
			int currTemp = myTS.takeTemp();
			boolean runState = myUI.getRunState();
			
			/* TODO - translate the pseudocode logic below into working java code */
			
			if runState=on and the current temperature is more than 2 degrees under the hold temperature
			{
				set the command mode to off
			}
			else if runState=off and the current temperature is more than 2 degrees over the hold temperature
			{
				set the command mode to on
			}
			
			
			/* TODO - call the UI's print status method, passing to it the current temperature and command mode */
			
			/* TODO - call the UI's set run state method to pass the command mode to the UI */	
		}
	
	}