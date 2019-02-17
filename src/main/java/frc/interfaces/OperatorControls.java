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
        if (Math.abs(ctrl.getRawAxis(constants.rightX)) > constants.gamepadDeadzone)
        {
            clawSpeed = ctrl.getRawAxis(constants.rightX);
        } else
        {
            clawSpeed = 0.0;
       
        }
        /*ELEVATOR PRESET POSITIONS
        *Left bumper = Elevator Floor Position
        *
        *Left Trigger +
        *D-Pad Left = Cargo Ship Hatch Panel Scoring Position
        *D-Pad Down = Rocket Low Hatch Panel Scoring Position
        *D-Pad Right = Rocket Mid Hatch Panel Scoring Position
        *D-Pad Up = Rocket High Hatch Panel Scoring Position
        *
        *No Left Trigger +
        *D-Pad Left = Cargo Ship Cargo Scoring Position
        *D-Pad Down = Rocket Low Cargo Scoring Position
        *D-Pad Right = Rocket Mid Cargo Scoring Position
        *D-Pad Up = Rocket High Cargo Scoring Position
        */
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnLB))
        {
            //Elevator floor position
            Elevator.floor();
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.leftTrigger))
        {
            if(hardware.operatorGamepad.getPOV() == 0)
            {
                //Rocket High Hatch Panel Scoring Position
                Elevator.hatchRocketHigh();
            }
            if(hardware.operatorGamepad.getPOV() == 90)
            {
                //Rocket Mid Hatch Panel Scoring Position
                Elevator.hatchRocketMid();
            }
            if(hardware.operatorGamepad.getPOV() == 180)
            {
                //Rocket Low Hatch Panel Scoring Position
                Elevator.hatchRocketLow();
            }
            if(hardware.operatorGamepad.getPOV() == 270)
            {
                //Cargo Ship Hatch Panel Scoring Position
                Elevator.hatchCargoShip();
            }
        }else
        {
            if(hardware.operatorGamepad.getPOV() == 0)
            {
                //Rocket High Cargo Scoring Postion
                Elevator.cargoRocketHigh();
            }
            if(hardware.operatorGamepad.getPOV() == 90)
            {
                //Rocket Mid Cargo Scoring Position
                Elevator.cargoRocketMid();
            }
            if(hardware.operatorGamepad.getPOV() == 180)
            {
                //Rocket Low Cargo Scoring Position
                Elevator.cargoRocketLow();
            }
            if(hardware.operatorGamepad.getPOV() == 270)
            {
                //Cargo Ship Cargo Scoring Postion
                Elevator.cargoCargoShip();
            }
        }
        /*Manipulator/claw preset positions
        *A is open for Cargo
        *B is close for Hatch Panel
        *X is close for Cargo
        *Y is open for Hatch Panel
        *Right Trigger is for pneumatic piston out then in position (aka "boop")
        */
        
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnA))
        {
            Claw.open();
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnB))
        {
            Claw.close();
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnX))
        {
            Claw.gripCargo();
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnY))
        {
                Claw.holdHatch();
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.rightTrigger))
        {
            Claw.boop();
        }else
        {
            Claw.bettyOff();
        }
        if(hardware.operatorGamepad.getRawAxis(constants.rightY) > constants.gamepadDeadzone)
        {
            Claw.upClaw();
        }else if(hardware.operatorGamepad.getRawAxis(constants.rightY) < constants.gamepadDeadzone)
        {
            Claw.downClaw();
        }else
        {
            Claw.offClaw();
        }
    }
    /*
    * Method: operatorInput
    * Parameters: N/A
    * Return: void
    * Operation: perform actions based on operator input
    */
    
} // end OperatorControls