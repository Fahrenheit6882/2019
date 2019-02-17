package frc.interfaces;

import com.revrobotics.CANSparkMax.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import statements
import frc.globals.*;


public class Claw
{
    // private variables
    private static CANSparkMax ClawMotor;

    /**
     * Constructor
     * Parameters: motor controllers and/or solenoids required for Claw
     */
    public Claw(CANSparkMax c)
    {
        ClawMotor = c;
    }
    //For fine tuning the claw motor
    public static void clawFineTune()
    {
        
    }
    /**
     * Method: open
     * Parameters: N/A
     * Return: void
     * Operation: fully open the claw
     */
    public static void open()
    {
        System.out.println("Open claw.");
        //clawMove(degrees, constants.clawFast)
    }
    /**
     * Method: close
     * Parameters: N/A
     * Return: void
     * Operation: fully close the claw
     */
    public static void close()
    {
        System.out.println("Close claw");
        //clawMove(degrees, constants.clawFast)
    }

    /**
     * Method: gripCargo
     * Parameters: N/A
     * Return: void
     * Operation: partially close the claw to grip cargo
     */
    public static void gripCargo()
    {
        System.out.println("Grip cargo.");
        //clawMove(degrees, constants.clawFast)
    }
    /**
     * Method: holdHatch
     * Parameters: N/A
     * Return: void
     * Operation: partially open the claw to hold hatch panel
     */
    public static void holdHatch()
    {
        System.out.println("Hold hatch panel");
        //clawMove(degrees, constants.clawFast)
    }
    /**
     * Method: boop
     * Parameters: N/A
     * Return: void
     * Operation: activate pneumatic piston or equivalent to push game piece out of claw
     */
    public static void boop()
    {
        System.out.println("BettyBoop!");   
        hardware.Booper.set(Value.kForward);
        hardware.Booper.set(Value.kReverse);

    }
    public static void bettyOff()
    {
        hardware.Booper.set(Value.kOff);
    }

    //ForMovement of claw up and down
    public static void upClaw()
    {
        hardware.updown.set(Value.kReverse);
        hardware.updown2.set(Value.kReverse);
    }
    
    public static void downClaw()
    {
        hardware.updown.set(Value.kForward);
        hardware.updown2.set(Value.kForward);
    }
    public static void offClaw()
    {
        hardware.updown.set(Value.kOff);
        hardware.updown2.set(Value.kOff);
    }
    //For testing the claw movement
    public static void clawTest()
    {
        if(hardware.operatorGamepad.getRawAxis(constants.rightY) > constants.gamepadDeadzone)
        {
            ClawMotor.getPIDController().setReference(constants.clawSlow * hardware.operatorGamepad.getRawAxis(constants.rightY), ControlType.kDutyCycle);
        }

        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnY))
        {
            hardware.updown.set(Value.kForward);
            hardware.updown2.set(Value.kForward);
            System.out.println("button Y is pressed");

        }else if(hardware.operatorGamepad.getRawButtonReleased(constants.btnY))
        {
            hardware.updown.set(Value.kOff);
            hardware.updown2.set(Value.kOff);
            System.out.println("button Y is not pressed");
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnA))
        {
            hardware.updown.set(Value.kReverse);
            hardware.updown2.set(Value.kReverse);
            System.out.println("button A is pressed");

        }else if(hardware.operatorGamepad.getRawButtonReleased(constants.btnA))
        {
            hardware.updown.set(Value.kOff);
            hardware.updown2.set(Value.kOff);
            System.out.println("button A is not pressed");
        
        }
        if(hardware.operatorGamepad.getRawButtonPressed(constants.btnB))
        {
            System.out.println("Is the claw closed? " + hardware.clawOpenSwitch.get());
            System.out.println("Is the claw open? " + hardware.clawOpenSwitch.get());
        }
        
    }


} // end Claw