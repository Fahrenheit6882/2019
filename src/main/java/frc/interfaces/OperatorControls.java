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
    public static boolean ready = true;
    
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
        if (ctrl.getRawAxis(constants.rightX) > constants.gamepadDeadzone)
        {
            Claw.clawFineTuneClose(ctrl.getRawAxis(constants.rightX));
        }
        else if(ctrl.getRawAxis(constants.rightX) > -constants.gamepadDeadzone)
        {
            Claw.clawFineTuneOpen(ctrl.getRawAxis(constants.rightX));
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
        }else
        {
            switch(hardware.operatorGamepad.getPOV())
            {
                case 0: 
                if(ready)
                {
                    ready = false;
                    if(hardware.operatorGamepad.getRawAxis(constants.leftTrigger) > constants.gamepadDeadzone)
                    {
                        Elevator.hatchRocketHigh();
                    }else
                    {
                        Elevator.cargoRocketHigh();
                    }
                }   
                break;

                case 90:
                if(ready)
                {
                    ready = false;
                    if(hardware.operatorGamepad.getRawAxis(constants.leftTrigger) > constants.gamepadDeadzone)
                    {
                        Elevator.hatchRocketMid();
                    }else 
                    {
                        Elevator.cargoRocketMid();
                    }
                }   
                break;

                case 180:
                if(ready)
                {
                    ready = false;
                    if(hardware.operatorGamepad.getRawAxis(constants.leftTrigger) > constants.gamepadDeadzone)
                    {
                        Elevator.hatchRocketLow();
                    }else 
                    {
                        Elevator.cargoRocketLow();
                    }
                }
                break;
                case 270:
                if(ready)
                {
                    ready = false;
                    if(hardware.operatorGamepad.getRawAxis(constants.leftTrigger) > constants.gamepadDeadzone)
                    {
                        Elevator.hatchCargoShip();
                    }else 
                    {
                        Elevator.cargoCargoShip();
                    }
                }
                break;
                
                case -1:
                ready = true;
                break;
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
        // if(hardware.operatorGamepad.getRawButtonPressed(constants.rightTrigger))
        // {
        //     Claw.boop();
        // }else
        // {
        //     Claw.bettyOff();
        // }
        // if(hardware.operatorGamepad.getRawAxis(constants.rightY) > constants.gamepadDeadzone)
        // {
        //     Claw.upClaw();
        // }else if(hardware.operatorGamepad.getRawAxis(constants.rightY) < constants.gamepadDeadzone)
        // {
        //     Claw.downClaw();
        // }else
        // {
        //     Claw.offClaw();
        // }
    }
    /*
    * Method: operatorInput
    * Parameters: N/A
    * Return: void
    * Operation: perform actions based on operator input
    */
    
} // end OperatorControls