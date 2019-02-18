package frc.interfaces;

import com.revrobotics.CANSparkMax.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import statements
import frc.globals.*;

//For all movements of the claw
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
    public static void clawFineTuneOpen(double speed)
    {
        if(hardware.clawOpenSwitch.get() != true)
        {
            ClawMotor.getPIDController().setReference((-constants.clawSlow * speed), ControlType.kDutyCycle);
        }else 
        {
            ClawMotor.getPIDController().setReference(0, ControlType.kDutyCycle);
        }
    }

    public static void clawFineTuneClose(double speed)
    {
        if(hardware.clawOpenSwitch.get() != true)
        {
            ClawMotor.getPIDController().setReference((constants.clawSlow * speed), ControlType.kDutyCycle);
        }else
        {
            ClawMotor.getPIDController().setReference(0, ControlType.kDutyCycle);
        }
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
        if(hardware.clawOpenSwitch.get() != true)
        {
            ClawMotor.getPIDController().setReference(-constants.clawFast, ControlType.kDutyCycle);
        }
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
        if(hardware.clawCloseSwitch.get() != true)
        {
            ClawMotor.getPIDController().setReference(constants.clawFast, ControlType.kDutyCycle);
        }
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
        if(hardware.clawCloseSwitch.get() != false)
        {
            ClawMotor.getPIDController().setReference(constants.clawFast, ControlType.kDutyCycle);
        }
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
        if(hardware.clawOpenSwitch.get() != false)
        {
            ClawMotor.getPIDController().setReference(-constants.clawFast, ControlType.kDutyCycle);
        }
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