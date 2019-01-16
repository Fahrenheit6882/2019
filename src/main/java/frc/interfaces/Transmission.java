package frc.interfaces;

// Import statements here
import frc.globals.*;
import edu.wpi.first.wpilibj.Victor;

public class Transmission
{
    //Transmission varables
    private static Victor rightFront;
    private static Victor leftFront;
    private static Victor rightRear;
    private static Victor leftRear;

    /**
     * Constructor
     * Parameters: 4 motor controllers, 1 per motor
     */
    public Transmission (Victor rf, Victor lf, Victor rr, Victor lr)
    {
        // Initialize motor controllers
        rightFront = rf;
        leftFront = lf;
        rightRear = rr;
        leftRear = lr;
        

        // TODO: Invert one side of motor controllers so that + input moves forward

    }

    /**
     * Method: stop
     * Parameters: N/A
     * Return: void
     * Operation: stop all drive motors
     */
    public static void stop()
    {
        // stop all motor controllers
        rightFront.set(0.0);
        leftFront.set(0.0);
        rightRear.set(0.0);        
        leftRear.set(0.0);
    }

    /**
     * Method: drive
     * Parameters: leftSpeed, rightSpeed
     * Return: void
     * Operation: set speed of left and right motors based on indicated speed
     */

    
} //end Transmission 