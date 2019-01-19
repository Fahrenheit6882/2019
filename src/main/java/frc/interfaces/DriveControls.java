package frc.interfaces;

// Import statements
import frc.globals.*;
import edu.wpi.first.wpilibj.Joystick;
 

public class DriveControls
{
    // Private variables
    private static Joystick ctrl;
    
    public DriveControls(Joystick dc)
    {
       ctrl = dc;
       
    }

    public static void checkInput()
    {
      double rightSpeed;
      double leftSpeed;

         //Reads and sets the speed from the joysticks
         if (Math.abs(ctrl.getRawAxis(constants.rightY)) > constants.gamepadDeadzone)
         {
            rightSpeed = ctrl.getRawAxis(constants.rightY);
         }else
         {
            rightSpeed = 0.0;
         }
            
         if (Math.abs(ctrl.getRawAxis(constants.leftY)) > constants.gamepadDeadzone)
         {
            leftSpeed = ctrl.getRawAxis(constants.leftY);
         }else
         {
            leftSpeed = 0.0;            
         }

         hardware.driveBase.drive(leftSpeed,rightSpeed);
         
    }
} // end DriveControls