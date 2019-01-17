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
    //If statements for speed controls
    if (ctrl.getRawButtonPressed(constants.btnA)){
        constants.fast = false;
    }
    if (ctrl.getRawButtonPressed(constants.btnX)){
        constants.fast = true;
    }
} // end DriveControls