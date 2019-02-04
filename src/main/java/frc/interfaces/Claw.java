package frc.interfaces;

// import statements
import frc.globals.*;

public class Claw
{
    // private variables

    /**
     * Constructor
     * Parameters: motor controllers and/or solenoids required for Claw
     */

    /**
     * Method: open
     * Parameters: N/A
     * Return: void
     * Operation: fully open the claw
     */
    public static void open()
    {
        System.out.println("Open claw.");
    }
    /**
     * Method: close
     * Parameters: N/A
     * Return: void
     * Operation: fully close the claw
     */
    public static void close()
    {
        System.out.println("Close claw");
    }

    /**
     * Method: gripCargo
     * Parameters: N/A
     * Return: void
     * Operation: partially close the claw to grip cargo
     */
    public static void gripCargo()
    {
        System.out.println("Grip cargo.");
    }
    /**
     * Method: holdHatch
     * Parameters: N/A
     * Return: void
     * Operation: partially open the claw to hold hatch panel
     */
    public static void holdHatch()
    {
        System.out.println("Hold hatch panel");
    }
    /**
     * Method: boop
     * Parameters: N/A
     * Return: void
     * Operation: activate pneumatic piston or equivalent to push game piece out of claw
     */
    public static void boop()
    {
        System.out.println("Boop!");
    }

} // end Claw