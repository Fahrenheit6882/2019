package frc.robot;

// Import statements
import frc.globals.*;
import frc.interfaces.*;

public class Sandstorm
{
    // Sandstorm variables.
    private static boolean auto = false;

    /**
     * Team developed code for initializing the Sandstorm.
     */
    public static void init()
    {
        // determine if doing auto or vision based on physical switch position
    /*  if(hardware.robotSwitch == 1){
    *   auto = true;
    *   }
    */
        
    }
        // if auto, ensure starting value of all necessary parameters
        
     // end init

    /**
     * Team developed code for Sandstorm periodic.
     */
    public static void periodic()
    {
        // If buttons Back and Start are pressed, the start auto
        if ( hardware.driverGamepad.getRawButtonPressed(constants.btnBack) && 
             hardware.driverGamepad.getRawButtonPressed(constants.btnStart) )
        {    
          auto = true;   
        }
        //Autonomuos code
        if (auto == true)
        {
            //Drives forward 8' 4"
             hardware.driveBase.driveByInches(constants.driveSlow, 100.0);
            
        }else
        {
            hardware.driveBase.stop();
        }
        // If vision, use DriveControls to check driver input and OperatorControls to check operator input
        if(auto == false )
        {
            //hardware.pOVCamera.getVideo();
            //Listens to driver's and operator's controller input
            DriveControls.checkInput();
            OperatorControls.checkInput();
        }
    } // end periodic
} // end Sandstorm