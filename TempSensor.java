import java.util.Random;

public class TempSensor
{
    /* 
       This class pretends to be a real temperature sensor.
       In real life, a thermostat reads the temperature from hardware.
       But for this assignment, we simulate that by randomly picking
       a temperature from a list of possible values. 
    */

    // A list of temperatures the "sensor" might read
    int[] tempArray = new int[] {45, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 85};

    // This will store the random index chosen from the array above
    int randIndex;

    // This stores the actual temperature from the array
    int tempValue;

    // Random object used to generate the random index
    Random rand = new Random();

    /*
       This method imitates taking a temperature reading in a room.
       Every time the SmartThermostat calls this method, we randomly pick
       one temperature from the array to act like a real reading.
    */
    public int takeTemp()
    {
        // pick a random index between 0 and (array length - 1)
        randIndex = rand.nextInt(tempArray.length);

        // select the temperature at that index
        tempValue = tempArray[randIndex];

        // return the chosen temperature so the furnace or AC can use it
        return tempValue;
    }
}
