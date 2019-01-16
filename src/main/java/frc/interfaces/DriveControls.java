package frc.interfaces;

// Import statements
import frc.globals.*;
import edu.wpi.first.wpilibj.Joystick;
 

public class DriveControls
{
    //variables go here
    private static Joystick ctrl;
    static double rightSpeed;
    static double leftSpeed;

    public DriveControls(Joystick dc)
    {
       ctrl = dc;
       if (Math.abs(dc.getRawAxis(constants.rightY))> constants.gamepadDeadzone){
        rightSpeed = dc.getRawAxis(constants.rightY);
        }else{
            rightSpeed = 0.0;
        }
        if (Math.abs(dc.getRawAxis(constants.leftY))> constants.gamepadDeadzone){
            leftSpeed = dc.getRawAxis(constants.leftY);
        }else{
            leftSpeed = 0.0;
        }
    }
   
    // Move code above here!! In its own function.  No parameters.  No return.
    
} // end DriveControls