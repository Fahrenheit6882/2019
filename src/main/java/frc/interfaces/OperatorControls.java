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
    public void checkInput()
    {
         /**
         * Constructor
         * Parameters: Joystick
         */

        //Reads and sets speed from joysticks
        if (Math.abs(ctrl.getRawAxis(constants.leftY))> constants.gamepadDeadzone)
        {
            hardware.Tigger.RubberAndSpring(constants.elevatorSlow * ctrl.getRawAxis(constants.leftY));
        }

        if (Math.abs(ctrl.getRawAxis(constants.rightY)) > constants.gamepadDeadzone)
        {
            hardware.enterprise.AttackAndCruise(constants.clawSlow * ctrl.getRawAxis(constants.rightY));
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
            hardware.Tigger.Rock();
        }else
        {
            switch(hardware.operatorGamepad.getPOV())
            {
                case 0: 
                if(ready)
                {
                    ready = false;
                    hardware.Tigger.Spock();
                }   
                break;

                case 90:
                if(ready)
                {
                    ready = false;
                    hardware.Tigger.Scissor();
                }   
                break;

                case 180:
                if(ready)
                {
                    ready = false;
                    hardware.Tigger.Paper();
                }
                break;
                case 270:
                if(ready)
                {
                    ready = false;
                    hardware.Tigger.Lizard();
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
           
        if(hardware.operatorGamepad.getRawButton(constants.btnA))
        {
            // System.out.println("BtnA pressed.");
            hardware.enterprise.Pinch();
        }
        if(hardware.operatorGamepad.getRawButton(constants.btnB))
        {
            hardware.enterprise.Blalala();
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnX))
        {
            hardware.enterprise.Dock();
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnY))
        {
            hardware.enterprise.Deploy();
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnRB))
        {
            hardware.enterprise.Boop();
        }
        else if(hardware.operatorGamepad.getRawButtonReleased(constants.btnRB))
        {
            hardware.enterprise.Charge();
        }
    }
} // end OperatorControls