package frc.interfaces;

// Import statements here
import frc.globals.*;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Transmission
{
    //Transmission varables
    private static TalonSRX rightFront;
    private static TalonSRX leftFront;
    private static VictorSPX rightRear;
    private static VictorSPX leftRear;
    private static boolean fast;
    private static double speedFactor;

    /**
     * Constructor
     * Parameters: 4 motor controllers, 1 per motor
     */
    public Transmission (TalonSRX rf, TalonSRX lf, VictorSPX rr, VictorSPX lr)
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
        rightFront.set(ControlMode.PercentOutput, 0.0);
        leftFront.set(ControlMode.PercentOutput, 0.0);
        rightRear.set(ControlMode.PercentOutput, 0.0);        
        leftRear.set(ControlMode.PercentOutput, 0.0);
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

    //     //pressing button A turn fast false 
    //     if(hardware.driverGamepad.getRawButtonPressed(constants.btnA))
    //     {
    //         fast = false;
    //     }
    //     //pressing button X turn fast true
    //     if(hardware.driverGamepad.getRawButtonPressed(constants.btnX))
    //     {
    //         fast = true;
    //    }

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
        leftFront.set(ControlMode.PercentOutput, leftSpeed);
        leftRear.set(ControlMode.PercentOutput, leftSpeed);
        rightFront.set(ControlMode.PercentOutput, rightSpeed);
        rightRear.set(ControlMode.PercentOutput, rightSpeed);
    } // end drive

    /**
     * changeSpeed toggles the current speed factor of robot between fast and slow
     */
    public static void changeSpeed()
    {
        //
        fast = !(fast);
    } // end changeSpeed
   
    /**
     * setFast forces robot to fast speed setting
     */
    public static void setFast()
    {
        fast = true;
    }//end setFast
    
    /**
     * setSlow forces robot to slow speed setting
     */
    public static void setSlow()
    {
        fast = false;
    }//end setSlow

} //end Transmission
