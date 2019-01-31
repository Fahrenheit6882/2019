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
        /*Elavator preset positions
        * up dpad + left trigger is medium RocketShip for Cargo
        * down dpad + left trigger is lower RocketShip for Cargo
        *
        * up dpad + left bumper is high CargoShip for Cargo
        * down dpad +left bumper is pick up Cargo from floor
        *
        * up dpad is medium RocketShip for HatchPanel
        * down dpad is lower RocketShip/CargoShip/LoadingZone for HatchPanel
        */
        if (hardware.operatorGamepad.getRawButtonPressed(constants.leftTrigger))
        {
            if(hardware.operatorGamepad.getPOV() == 0)
            {
            //Medium RocketShip for cargo
            }
            if(hardware.operatorGamepad.getPOV() == 180)
            {
                //Lower RocketShip for Cargo
            }

        } else 
        {
            if(hardware.operatorGamepad.getRawButtonPressed(constants.btnLB))
                {
                if(hardware.operatorGamepad.getPOV() == 0)
                {
                    //High CargoShip for cargo
                    }   
                    if(hardware.operatorGamepad.getPOV() == 180)
                    {
                    //Pick up cargo from floor
                    }
            } else
            {
                if(hardware.operatorGamepad.getPOV() == 0)
                {
                    //Medium RocketShip for hatch panel
                }
                if(hardware.operatorGamepad.getPOV() == 180)
                {
                        //Lower RocketShip for hatch panel
                }
            }
        }
        /*Manipulator/claw preset positions
        *A is open for Cargo
        *B is close for Hatch Panel
        *X is close for Cargo
        *Y is open for Hatch Panel
        */
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnA))
        {
            //Open for Cargoo
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnB))
        {
            //Close for Hatch Panel
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnX))
        {
            //Close for Cargo
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnY))
        {
            //Open for Hatch Panel
        }
    }
        /*
        * Method: operatorInput
        * Parameters: N/A
        * Return: void
        * Operation: perform actions based on operator input
        */
       
} // end OperatorControls