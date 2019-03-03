package frc.interfaces;


import com.ctre.phoenix.motorcontrol.ControlMode;
// import statements
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.globals.constants;
import frc.globals.hardware;
public class Elevator
{
    // Private variables
  private static TalonSRX liftRight;
  private static TalonSRX liftLeft;
    /**
     * Constructor
     * Parameters: motor controllers and/or pneumatic solenoids and/or any necessary I/O devices
     */

    /**
     * Initializing elevators hardware
     * Parameters: N/A
     */
    public Elevator (TalonSRX l1, TalonSRX l2)
    {
      liftRight = l1;
      liftLeft = l2;
      //Left motor is inverted
      liftRight.setInverted(true);
    }

    private static boolean presetMove(double position)
    {
      boolean arrived = false;
      double eleSpeed = constants.elevatorSlow;
      double current = hardware.potArm.get();

      double delta = Math.abs(position - current);
      
      if(delta < 50)
      {
        eleSpeed = eleSpeed * .66;
      }
      else if(delta < 30)
      {
        eleSpeed = eleSpeed * 0.33;
      }
      else if(delta < 10)
      {
        eleSpeed = 0.0;
        arrived = true;
      }

      if (current < position && delta > 5)
      {
        eleSpeed = -eleSpeed;
        //System.out.println("Going up!");
      }

      liftRight.set(ControlMode.PercentOutput, eleSpeed);
      liftLeft.set(ControlMode.PercentOutput, eleSpeed);

      return arrived;
    }

    /***
     * Move to the lowest setting to pick up from the ground
     * @return  true when reached; false otherwise
     */
    public boolean Rock ()
    {
      boolean arrived = false;

      arrived = presetMove(58.0);

      // logic to move arm and check if arrived
      
      return arrived;
    }

    /***
     * Move Tigger into position to score in low rocket or cargo ship hatch panel
     * @return true when reached; false otherwise
     */
    //1' 7", 19"
    public boolean Paper()
    {
      boolean arrived = false;

      arrived = presetMove(118.0);

      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger into position to score in mid rocket hatch panel or cargo ship cargo
     * @return true when reached; false otherwise
     */
    //3' 11", 47"
    public boolean Scissor()
    {
      boolean arrived = false;

      arrived = presetMove(170.0);

      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger into position to score in low rocket cargo
     * @return true when reached; false otherwise
     */
    //2' 3.5", 27.5"
    public boolean Lizard()
    {
      boolean arrived = false;

      arrived = presetMove(226.0);

      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger into position to score in mid rocket cargo
     * @return true when reached; false otherwise
     */
    //4' 7.5", 55.5"
    public boolean Spock()
    {
      boolean arrived = false;

      arrived = presetMove(255.0);
      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger based on desired speed
     * @param speed value -1.0 to 1.0
     */
    public void RubberAndSpring(double speed)
    {
      //Please explain commented section below
      
      // ensure speed is within allowable range
      if(speed > 1.0)
      {
        speed = 1.0;
      } else if (speed < -1.0)
      {
        speed = -1.0;
      }

      if (speed > 0)  // if we are moving the arm down
      {
        // updownCheck returns true when docked
        if(hardware.enterprise.updownCheck())
        {
          if (hardware.potArm.get() < 70) // half speed when we are approaching limit
          {
            speed = speed * 0.5;
          }
          else if (hardware.potArm.get() < 55) // quarter speed because we are very close now
          {
            speed = speed * .25;
          }
          else if (hardware.potArm.get() < 40) // do not allow arm to go below this point
          {
            speed = 0.0;
          }
        }
        else  //we aren't docked, so we are deployed
        {
          if (hardware.potArm.get() < 80) // half speed when we are approaching limit
          {
            speed = speed * 0.5;
          }
          else if (hardware.potArm.get() < 70) // quarter speed because we are very close now
          {
            speed = speed * .25;
          }
          else if (hardware.potArm.get() < 60) // do not allow arm to go below this point
          {
            speed = 0.0;
          }
        }
      }

      // move Tigger
      liftRight.set(ControlMode.PercentOutput, speed);
      liftLeft.set(ControlMode.PercentOutput, speed);

      
      // System.out.println("Tigger speed: " + speed);
    }
    //Stops the 
    public void potTest()
    {
      System.out.println("The poteniometer reads: " + hardware.potArm.get());
    }

    public void stop()
    {
      liftRight.set(ControlMode.PercentOutput, 0.0);
      liftLeft.set(ControlMode.PercentOutput, 0.0);
    }
} // end Elevator