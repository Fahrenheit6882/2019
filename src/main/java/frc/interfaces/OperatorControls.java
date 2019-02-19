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
            Elevator.RubberAndSprings(constants.elevatorSlow * ctrl.getRawAxis(constants.leftY));
        }
        if (ctrl.getRawAxis(constants.rightX) > constants.gamepadDeadzone)
        {
            Elevator.AttackAndCruise(constants.rightY * ctrl.getRawAxis(constants.rightY));
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
            Elevator.Rock();
        }else
        {
            switch(hardware.operatorGamepad.getPOV())
            {
                case 0: 
                if(ready)
                {
                    ready = false;
                    Elevator.Spock();
                }   
                break;

                case 90:
                if(ready)
                {
                    ready = false;
                    Elevator.Scissor();
                }   
                break;

                case 180:
                if(ready)
                {
                    ready = false;
                    Elevator.Paper();
                }
                break;
                case 270:
                if(ready)
                {
                    ready = false;
                    Elevator.Lizard();
                }
                break;
                
                case -1:
                ready = true;

                default:
                ready = true;

                break;
            }
        }
        /*Manipulator/claw preset positions
        *A is close for Hatch Panel
        *B is open for Cargo
        *X is Enterprise up
        *Y is Enterprise down
        *Right Trigger is for pneumatic piston out then in position (aka "boop")
        */
           
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnA))
        {
            Claw.Pinch();
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnB))
        {
            Claw.Blalala();
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnX))
        {
            Claw.Dock();
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnY))
        {
            Claw.Deploy();
        }
        if(hardware.operatorGamepad.getRawAxis(constants.rightTrigger) > constants.gamepadDeadzone)
        {
            Claw.Boop();
        }
        else if(hardware.operatorGamepad.getRawAxis(constants.rightTrigger) > constants.gamepadDeadzone)
        {
            Claw.Charge();
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
} // end OperatorControls