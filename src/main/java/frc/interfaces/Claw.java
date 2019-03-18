package frc.interfaces;

import com.revrobotics.CANSparkMax;
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
    private static boolean docked;

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

    /**
     * Method: open
     * Parameters: N/A
     * Return: void
     * Operation: fully open the claw
     */
    public void Blalala()
    {
        if(true)
        {
            ClawMotor.set(constants.clawFast);
        } else
        {
            ClawMotor.set(0);
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
        if(hardware.clawCloseSwitch.get())
        {
            ClawMotor.set(-constants.clawFast);
        } else
        {
            ClawMotor.set(0);
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
        docked = true;
    }

    public void Deploy()
    {
        updown.set(Value.kForward);
        docked = false;
    }

    public void AttackAndCruise(double speed)
    {
        if(speed > 0)
        {
            ClawMotor.set(speed);
        }
        else if(hardware.clawCloseSwitch.get() && speed < 0)
        {
            ClawMotor.set(speed);            
        }
        else
        {
            ClawMotor.set(0); 
        }
        // System.out.println("Speed: " + speed);
    }
    //For calling the state of the updown pistons
    public static boolean updownCheck()
    {
        return docked;
    }
} // end Claw