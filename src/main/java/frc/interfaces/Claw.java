package frc.interfaces;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import statements
import frc.globals.*;

public class Claw
{
    // private variables
    public static  CANSparkMax ClawMotor;
    /**
     * Constructor
     * Parameters: motor controllers and/or solenoids required for Claw
     */
    public Claw(CANSparkMax c)
    {
        ClawMotor = c;
    }

    /**
     * Method: open
     * Parameters: N/A
     * Return: void
     * Operation: fully open the claw
     */
    public static void Blalala()
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
    public static void Pinch()
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
    public static void Boop()
    {
        hardware.Booper.set(Value.kForward);   
    }

    public static void Charge()
    {
        hardware.Booper.set(Value.kReverse);
    }

    public static void Dock()
    {
        hardware.updown.set(Value.kReverse);
    }

    public static void Deploy()
    {
        hardware.updown.set(Value.kForward);
    }

    public static void AttackAndCruise(double speed)
    {
        ClawMotor.set(speed);
    }
} // end Claw