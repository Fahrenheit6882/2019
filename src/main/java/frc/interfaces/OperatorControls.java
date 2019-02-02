package frc.interfaces;

import edu.wpi.first.wpilibj.Joystick;
// import statements
import frc.globals.*;
/*The left side of the controller is for elevator
* The right side of the controller is for claw/manipulator
*/
public class OperatorControls
{
    // Private variables
    private static Joystick  ctrl;
    
    public OperatorControls(Joystick oc){
        
        ctrl = oc;

    }
    public static void checkInput()
    {
        double clawSpeed;
        double elevatorSpeed;
         /**
         * Constructor
         * Parameters: Joystick
         */

        //Reads and sets speed from joysticks
        if (Math.abs(ctrl.getRawAxis(constants.leftY))> constants.gamepadDeadzone)
        {
            elevatorSpeed = ctrl.getRawAxis(constants.leftY);
        } else
        {
            elevatorSpeed = 0.0;
        }
        if (Math.abs(ctrl.getRawAxis(constants.rightY)) > constants.gamepadDeadzone)
        {
            clawSpeed = ctrl.getRawAxis(constants.rightY);
        } else
        {
            clawSpeed = 0.0;
        }
       
    }
    public static void elevatorPostition()
    {
        
    }
        /*
        * Method: operatorInput
        * Parameters: N/A
        * Return: void
        * Operation: perform actions based on operator input
        */
       
} // end OperatorControls