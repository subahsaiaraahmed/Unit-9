import java.util.TimerTask;

public class Furnace extends TimerTask
{
    /*
       This class controls the furnace (the heating system).
       The thermostat calls this class every 10 seconds.

       The furnace decides:
       - Should we turn ON the heat?
       - Should we turn OFF the heat?

       It bases the decision on:
       - The temperature of the room (from TempSensor)
       - The user's hold temperature (from UI)
       - The current state of the furnace (from UI)
    */

    boolean commandMode;   // This is what we tell the furnace to do ON / OFF
    UI myUI;               // Connection to the user interface
    TempSensor myTS;       // Connection to the temperature sensor

    public Furnace(TempSensor inTS, UI inUI)
    {
        // Assign the incoming objects to this class
        this.myUI = inUI;
        this.myTS = inTS;
    }

    @Override
    public void run()
    {
        /*
           Every 10 seconds this method runs automatically.
           The system checks the temperature and decides if it should heat.
        */

        // The temperature the user wants the house to stay at (ex: 68°F)
        int holdTemp = myUI.getHoldTemp();

        // The current temperature reading from our fake sensor
        int currTemp = myTS.takeTemp();

        // Whether the furnace is currently ON (true) or OFF (false)
        boolean runState = myUI.getRunState();

        /*
           HEATING LOGIC (FURNACE RULES):

           If the furnace is ON:
               - Turn it OFF when the house becomes more than 2 degree celcius too warm.
                 (Example: HoldTemp = 68 - Furnace turns OFF at 71 or above)

           If the furnace is OFF:
               - Turn it ON when the house becomes more than 2 degree celcisu too cold.
                 (Example: HoldTemp = 68 - Furnace turns ON at 65 or below)
        */

        // Furnace is currently running AND the house is too warm - turn off heat
        if (runState == true && currTemp > holdTemp + 2)
        {
            commandMode = false;  // turn furnace OFF
        }

        // Furnace is currently off AND the house is too cold → turn on heat
        else if (runState == false && currTemp < holdTemp - 2)
        {
            commandMode = true;   // turn furnace ON
        }

        // Otherwise, keep the furnace in its current state
        else
        {
            commandMode = runState;
        }

        /*
           Now we update the user interface to show what the system is doing.
           The UI will print something like:

           Hold Temp: 68 | Mode: Heat | Furnace State: On | Current Temp: 64 | Command Mode: On
        */
        myUI.printStatus(currTemp, commandMode);

        /*
           Finally, we update the UI’s stored value for runState.
           This ensures that the next time the furnace runs, it knows
           whether it was ON or OFF previously.
        */
        myUI.setRunState(commandMode);
    }
}
