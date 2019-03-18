package frc.interfaces;

// Import statements here
import frc.globals.*;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Transmission
{
    //Transmission varables
    private static VictorSPX rightFront;
    private static VictorSPX leftFront;
    private static VictorSPX rightRear;
    private static VictorSPX leftRear;
    private static boolean fast;
    private static double speedFactor;
    private static boolean encReset;
    private static Encoder encLeft, encRight; 
    private static double rightFactor;

    /**
     * Constructor
     * Parameters: 4 motor controllers, 1 per motor
     */
    public Transmission (VictorSPX rf, VictorSPX lf, VictorSPX rr, VictorSPX lr, Encoder r, Encoder l)
    {
        // Initialize motor controllers
        rightFront = rf;
        leftFront = lf;
        rightRear = rr;
        leftRear = lr;

        fast = true;
        speedFactor = constants.driveFast;
        rightFactor = constants.driveFast + 0.05;
        

        leftFront.setInverted(true);
        leftRear.setInverted(true);

        encRight = r;
        encLeft = l;
        
        //Inverts left encoder
        encLeft.setReverseDirection(true);
        
        //Sets inches per pulse to 18.9
        encRight.setDistancePerPulse(18.9);
        encLeft.setDistancePerPulse(18.9);
    }

    /**
     * Method: stop
     * Parameters: N/A
     * Return: void
     * Operation: stop all drive motors
     */
    public void stop()
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

        //checking if fast is true/false to adjust left & right speed
        /*
        if(fast == true)
        {
            speedFactor = constants.driveFast; 
        }else
        {
            speedFactor = constants.driveSlow;
        } 
        */
        leftSpeed *= speedFactor;
        rightSpeed *= rightFactor;

        // set motor controllers
        leftFront.set(ControlMode.PercentOutput, leftSpeed);
        leftRear.set(ControlMode.PercentOutput, leftSpeed);
        rightFront.set(ControlMode.PercentOutput, rightSpeed);
        rightRear.set(ControlMode.PercentOutput, rightSpeed);
    } // end drive

    /**
     * changeSpeed toggles the current speed factor of robot between fast and slow
     */
    public void changeSpeed()
    {
        fast = !fast;
        // System.out.println("Changing speed: " + fast);
    } // end changeSpeed
   
    /**
     * setFast forces robot to fast speed setting
     */
    public void setFast()
    {   
        fast = true;
        if(speedFactor == constants.driveFast)
        {
            speedFactor = constants.driveSuperFast;
            rightFactor = constants.driveSuperFast;
        }
        else if(speedFactor == constants.driveMed)
        {
            speedFactor = constants.driveFast;
            rightFactor = constants.driveFast + 0.05;
        }
        else if(speedFactor == constants.driveSlow)
        {
            speedFactor = constants.driveMed;
            rightFactor = constants.driveMed + 0.05;
        }
        // System.out.println("Setting fast.  Fast = " + fast);
    }//end setFast
    
    /**
     * setSlow forces robot to slow speed setting
     */
    public void setSlow()
    {
        fast = false;
        if(speedFactor == constants.driveSuperFast)
        {
            speedFactor = constants.driveFast;
            rightFactor = speedFactor + 0.05;
        }
        else if(speedFactor == constants.driveFast)
        {
            speedFactor = constants.driveMed;
            rightFactor = constants.driveMed + 0.05;
        }
        else if(speedFactor == constants.driveMed)
        {
            speedFactor = constants.driveSlow;
            rightFactor = speedFactor;
        }
        // System.out.println("Setting slow.  Fast = " + fast);
    }//end setSlow

    /**
     * turn robot left or right by degrees at a speed
     * @param degrees
     * @param speed
     * 
     */
    public boolean turnByDegrees(double degrees, double speed )
    {
       //creating motor variable
        double left = 0.0;
        double right = 0.0;
        boolean encReset = false;// delete later
        // convert from degrees to inches for travel
        double inchesToTravel= 0.0;
        //reset motor pulses
        if(encReset)
        {
            encLeft.reset();
            encRight.reset();
            encReset = false;
        }
        //checking if degrees is positive or negative
        if(degrees < 0.0)
        {
            //moving left backwards
            if(encLeft.getDistance() > inchesToTravel)
            {
                left = -speed;

            }
            //moving right forwards 
            if(encRight.getDistance() > inchesToTravel)
            {
                right = speed;
            }
        }
        //checking if degrees is positive or negative
        if(degrees > 0.0)
        {
            //moving right backwards
            if(encRight.getDistance() > inchesToTravel)
            {
                right = -speed;
            }
            //moving left forwards
            if(encLeft.getDistance() > inchesToTravel)
            {
                left = speed;
            }
        }
        if(left == 0.0 && right == 0.0)
        {
            encReset = true;
        }
        return(encReset);
    }//end turnByDegrees

    public boolean driveByInches(double speed,double inches)
    {
        //hold speed for left & right
        double left = 0.0;
        double right = 0.0;
        boolean stop = false;
        

        //this checks if the encoders are reset if not it resets
        if(encReset)
        {
            encReset = false;
            encLeft.reset();
            encRight.reset();
        }
        //checks if right side robot has gone correct distance
        if(encRight.getDistance() < inches && !stop  )
        {
            right = speed;
        }else
        {
            right = 0.0;
            stop = true;

        }
         //checks if left side robot has gone correct distance
        if(encLeft.getDistance() < inches && !stop)
        {
            left = speed;
        }else
        {
            right = 0.0;
           stop = true; 

        }
        //calls drive to make motors move
        this.drive(left, right);    
        
        //checking left and right are 0.0 then reseting encoders
        if(left == 0.0 && right == 0.0)
        {
            encReset = true;
        }
        return(encReset);
    } // end driveByInches

    public void resetEncoder()
    {
        encRight.reset();
        encLeft.reset();
    }

    public void encTest()
    {
        if(hardware.driverGamepad.getRawButtonPressed(constants.btnX))
        {
        System.out.println("Right encoder reads:" + encRight.getDistance());
        System.out.println("Left encoder reads:" + encLeft.getDistance());
        }
    }
} //end Transmission
