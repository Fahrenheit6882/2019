package frc.interfaces;

// Import statements
import frc.globals.*;
import edu.wpi.first.wpilibj.Joystick;
 

public class DriveControls
{
    //variables go here
    private static Joystick ctrl;
    static double rightSpeeed;
    static double leftSpeed;

    public DriveControls(Joystick dc)
    {
       ctrl = dc;
       if (Math.abs(dc.getRawAxis(constants.rightX))> constants.gamepadDeadzone){

       }
    }
   

} // end DriveControls