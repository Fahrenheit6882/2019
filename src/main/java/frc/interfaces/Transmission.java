package frc.interfaces;

// Import statements here
import frc.globals.*;
import edu.wpi.first.wpilibj.Victor;

public class Transmission
{
    //Transmission varables
    private Victor rightFront;
    private Victor leftFront;
    private Victor rightRear;
    private Victor leftRear;
    private static boolean fast = true;
    public Transmission (Victor rf, Victor lf, Victor rr, Victor lr)
    {
        // Initialize motor controllers
        rightFront = rf;
        leftFront = lf;
        rightRear = rr;
        leftRear = lr;

        // TODO: Invert one side of motor controllers so that + input moves forward
    }

    public static void drive(double leftSpeed, double rightSpeed )
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
        //pressing button A turn fast false 
        if(hardware.driverGamepad.getRawButtonPressed(constants.btnA))
        {
            fast = false;
        }
        //pressing button X turn fast true
        if(hardware.driverGamepad.getRawButtonPressed(constants.btnX))
        {
            fast = true;
        }
        //checking if fast is true/false to adjust left & right speed
        if(fast = true)
        {
            leftFront = (leftSpeed * constants.driveFast);
            leftRear = (leftSpeed * constants.driveFast);  
        }else
            {
                rightFront = (rightSpeed *constants.driveSlow);
                rightRear = (rightSpeed * constants.driveSlow); 
            } 
    
    
} //end Transmission