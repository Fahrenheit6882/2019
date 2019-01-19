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
       
    }

    public static void checkInput()
    {
        //Reads and sets the speed from the joysticks
        if (Math.abs(dc.getRawAxis(constants.rightY))> constants.gamepadDeadzone){
            rightSpeed = ctrl.getRawAxis(constants.rightY);
            }else{
                rightSpeed = 0.0;
            }
            if (Math.abs(dc.getRawAxis(constants.leftY))> constants.gamepadDeadzone){
                leftSpeed = ctrl.getRawAxis(constants.leftY);
            }else{
                leftSpeed = 0.0;
            }
        }
    }
} // end DriveControls