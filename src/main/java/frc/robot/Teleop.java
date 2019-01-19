package frc.robot;

// Import statements
import frc.globals.*;
import frc.interfaces.*;
public class Teleop
{
    // Teleop variables


    /**
     * Team code for initializing teleop goes here.
     */
    public static void init()
    {
        // Ensure all variables are at known default state
        hardware.driveBase.stop();
    } // end init

    /**
     * Team code for periodic teleop goes here.
     */
    public static void periodic()
    {
        // Use DriveControls to check driver input
        hardware.driverCntrl.checkInput();

        // Use OperatorControls to check operator input
        
    } // end periodic
} // end Teleop