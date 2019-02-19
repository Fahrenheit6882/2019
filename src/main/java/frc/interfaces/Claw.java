package frc.interfaces;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import statements
import frc.globals.*;

//For all movements of the claw
public class Claw
{
    // private variables
    private static CANSparkMax ClawMotor;
    private static DoubleSolenoid Betty;
    private static DoubleSolenoid updown;

    /**
     * Constructor
     * Parameters: motor controllers and/or solenoids required for Claw
     */
    public Claw(CANSparkMax c, DoubleSolenoid b, DoubleSolenoid ud)
    {
        ClawMotor = c;
        Betty = b;
        updown = ud;
    }
    //For fine tuning the claw motor
    public void clawFineTuneOpen(double speed)
    {
        if(hardware.clawOpenSwitch.get() != true)
        {
            ClawMotor.getPIDController().setReference((-constants.clawSlow * speed), ControlType.kDutyCycle);
        }else 
        {
            ClawMotor.getPIDController().setReference(0, ControlType.kDutyCycle);
        }
    }

    public void clawFineTuneClose(double speed)
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
    public void Blalala()
    {
        if(hardware.clawOpenSwitch.get() != true)
        {
            ClawMotor.set(-constants.clawFast);
        }
        
    }
    /**
     * Method: close
     * Parameters: N/A
     * Return: void
     * Operation: fully close the claw
     */
    public void Pinch()
    {
        if(hardware.clawCloseSwitch.get() != true)
        {
            ClawMotor.set(constants.clawFast);
        }

    }
    

    /**
     * Method: boop
     * Parameters: N/A
     * Return: void
     * Operation: activate pneumatic piston or equivalent to push game piece out of claw
     */
    public void Boop()
    {
        Betty.set(Value.kForward);   
    }

    public void Charge()
    {
        Betty.set(Value.kReverse);
    }

    public void Dock()
    {
        updown.set(Value.kReverse);
    }

    public void Deploy()
    {
        updown.set(Value.kForward);
    }

    public void AttackAndCruise(double speed)
    {
        ClawMotor.set(speed);
    }
} // end Claw