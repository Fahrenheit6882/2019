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
    private static boolean fast;
    private static double speedFactor;

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
        

        fast = true;

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
     * drives the robot based on a desired left and right speed.
     * @param leftSpeed
     * @param rightSpeed
     */
    public void drive(double leftSpeed, double rightSpeed )
    {
        // checking leftSpeed is between -1.0 and 1.0
        if(leftSpeed < -1.0 )
        {
            leftSpeed = -1.0;
        } else if( leftSpeed > 1.0)
        {
            leftSpeed = 1.0;
        }

        // checking rightSpeed is between -1.0 and 1.0
        if(rightSpeed < -1.0 )
        {
            rightSpeed = -1.0;
        }else if(rightSpeed > 1.0 )
        {
            rightSpeed = 1.0;
        }

        //checking if fast is true/false to adjust left & right speed
        if(fast = true)
        {
            speedFactor = constants.driveFast; 
        }else
        {
            speedFactor = constants.driveSlow;
        } 
        
        leftSpeed *= speedFactor;
        rightSpeed *= speedFactor;

        // set motor controllers
        leftFront.set(leftSpeed);
        leftRear.set(leftSpeed);
        rightFront.set(rightSpeed);
        rightRear.set(rightSpeed);
    } // end drive

    /**
     * changeSpeed toggles the current speed factor of robot between fast and slow
     */
    public void changeSpeed()
    {
        //
        fast = !(fast);
    } // end changeSpeed
   
    /**
     * setFast forces robot to fast speed setting
     */
    public void setFast()
    {
        fast = true;
    }//end setFast
    
    /**
     * setSlow forces robot to slow speed setting
     */
    public void setSlow()
    {
        fast = false;
    }//end setSlow

} //end Transmission
