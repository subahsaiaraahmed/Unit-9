import java.util.Timer;
import java.util.TimerTask;

public class SmartThermostat 
{
	
	public static void main (String[] args)
	{
		Timer timer = new Timer();
		UI myUI = new UI();
		TempSensor myTS = new TempSensor();
		
		String runMode = myUI.getRunMode();
		
		if(runMode == "heat")
		{
			timer.schedule(new Furnace(myTS, myUI),
            	0,        //startup delay
            	10000);  //milliseconds between cycles
		}
		else if (runMode == "cool")
		{
			timer.schedule(new AirConditioner(myTS, myUI),
                0,        //startup delay
                10000);  //milliseconds between cycles
		}				 			
	}
}
