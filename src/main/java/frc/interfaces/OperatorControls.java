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
    private static boolean ready = true;

    
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

        //Prints out degrees from potentiometer
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnRStick))
        {
            System.out.println(hardware.potArm.get());
        }

        //Reads and sets speed from joysticks
        if (Math.abs(ctrl.getRawAxis(constants.leftY))> constants.gamepadDeadzone)
        {
            elevatorSpeed = ctrl.getRawAxis(constants.leftY);
            Elevator.fineTune(elevatorSpeed);
        } else
        {
            elevatorSpeed = 0.0;
            Elevator.fineTune(elevatorSpeed);
        }
        if (Math.abs(ctrl.getRawAxis(constants.rightY)) > constants.gamepadDeadzone)
        {
            clawSpeed = ctrl.getRawAxis(constants.rightY);
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

                default:

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
            //Open for Cargo
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
                //Cargo Ship Hatch Panel Scoring Position
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.rightTrigger))
        {
            //Pneumatic piston out then in position (aka "boop")
        }
    }
    /*
    * Method: operatorInput
    * Parameters: N/A
    * Return: void
    * Operation: perform actions based on operator input
    */
    
} // end OperatorControls