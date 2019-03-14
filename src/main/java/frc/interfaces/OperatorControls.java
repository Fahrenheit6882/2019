package frc.interfaces;

import edu.wpi.first.wpilibj.Joystick;
// import statements
import frc.globals.*;
import frc.interfaces.Claw;

/*The left side of the controller is for elevator
* The right side of the controller is for claw/manipulator
*/
public class OperatorControls {
    // Private variables
    private static Joystick ctrl;
    public static boolean ready = true;

    // desiredPos:
    // -1 :: cleared
    // 0 :: rock
    // 1 :: paper
    // 2 :: scissor
    // 3 :: lizard
    // 4 :: spock
    private int desiredPos = -1;
    private boolean defense = false;

    public OperatorControls(Joystick oc) {

        ctrl = oc;

    }

    // For turning defense mode on and off
    public void checkInput() {
        if (hardware.operatorGamepad.getRawButtonPressed(constants.btnStart)
                && hardware.operatorGamepad.getRawButtonPressed(constants.btnBack)) {

            if (hardware.potArm.get() <= 58.0 && Claw.updownCheck()) {
                hardware.Tigger.RubberAndSpring(0.2);
            }
        } else {
            // Runs if defense == false

            /**
             * Constructor Parameters: Joystick
             */

            // Reads and sets speed from joysticks
            if (Math.abs(ctrl.getRawAxis(constants.leftY)) > constants.gamepadDeadzone) {
                hardware.Tigger.RubberAndSpring(constants.elevatorSlow * ctrl.getRawAxis(constants.leftY));
                desiredPos = -1;
            } else {
                hardware.Tigger.RubberAndSpring(0.0);
            }

            if (hardware.operatorGamepad.getRawAxis(constants.leftTrigger) > 0.3) {
                hardware.Tigger.RubberAndSpring(constants.elevatorSlow * -0.4);
            }

            if (Math.abs(ctrl.getRawAxis(constants.rightY)) > constants.gamepadDeadzone) {
                hardware.enterprise.AttackAndCruise(constants.clawSlow * ctrl.getRawAxis(constants.rightY));
            } else {
                hardware.enterprise.AttackAndCruise(0.0);
            }

            /*
             * ELEVATOR PRESET POSITIONS Left bumper = Elevator Floor Position
             *
             * D-Pad Left = Rocket Mid Hatch Panel Scoring Position D-Pad Down = Rocket Low
             * Hatch Panel Scoring Position D-Pad Right = Rocket Low Cargo Scoring Position
             * D-Pad Up = Rocket Mid Cargo Scoring Position
             */
            /*
             * if (hardware.operatorGamepad.getRawButtonPressed(constants.btnLB)) { //
             * Elevator floor position desiredPos = 0; } else { switch
             * (hardware.operatorGamepad.getPOV()) { case 0: desiredPos = 4; break;
             * 
             * case 90: desiredPos = 2; break;
             * 
             * case 180: desiredPos = 1; break;
             * 
             * case 270: desiredPos = 3; break;
             * 
             * default: break; }
             * 
             * switch (desiredPos) { case 0: hardware.Tigger.Rock(); break; case 1:
             * hardware.Tigger.Paper(); break; case 2: hardware.Tigger.Scissor(); break;
             * case 3: hardware.Tigger.Lizard(); break; case 4: hardware.Tigger.Spock();
             * break; default: break; } }
             */
            /*
             * Manipulator/claw preset positions A is close for Hatch Panel B is open for
             * Cargo X is Enterprise up Y is Enterprise down Right Bumber is for pneumatic
             * piston out then in position (aka "boop")
             */

            if (hardware.operatorGamepad.getRawButton(constants.btnA)) {
                // System.out.println("BtnA pressed.");
                hardware.enterprise.Pinch();
            }
            if (hardware.operatorGamepad.getRawButton(constants.btnB)) {
                hardware.enterprise.Blalala();
            }
            if (hardware.operatorGamepad.getRawButtonPressed(constants.btnX)) {
                hardware.enterprise.Dock();
            }
            if (hardware.operatorGamepad.getRawButtonPressed(constants.btnY)) {
                hardware.enterprise.Deploy();
            }
            if (hardware.operatorGamepad.getRawButtonPressed(constants.btnRB)) {
                hardware.enterprise.Boop();
            } else if (hardware.operatorGamepad.getRawButtonReleased(constants.btnRB)) {
                hardware.enterprise.Charge();
            }

            if (hardware.operatorGamepad.getRawButtonPressed(constants.btnBack)) {
                hardware.Tigger.potTest();
            }
            // hardware.Tigger.softStop();
        }
    }
} // end OperatorControls