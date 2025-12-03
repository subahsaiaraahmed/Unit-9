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
			
			//if runState=on and the current temperature is more than 2 degrees under the hold temperature
			if(runState == true && currTemp < holdTemp - 2){
				//set the command mode to off
			}
			//else if runState=off and the current temperature is more than 2 degrees over the hold temperature
			else if(runState == false && currTemp > holdTemp + 2)
			{
				//set the command mode to on
				commandMode = true;
			}
			
			
			/* TODO - call the UI's print status method, passing to it the current temperature and command mode */
			myUI.printStatus(currTemp, commandMode);
			/* TODO - call the UI's set run state method to pass the command mode to the UI */	
			myUI.setRunState(commandMode);
		}
	
	}