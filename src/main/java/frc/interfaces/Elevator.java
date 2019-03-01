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

      //Moves arm down if pot reading is more than desired reading
      if(hardware.potArm.get() >= position + 5)
      {
        liftRight.set(ControlMode.PercentOutput, constants.elevatorSlow * 0.5);
        liftLeft.set(ControlMode.PercentOutput, constants.elevatorSlow * 0.5);
        System.out.println("Going Down");
      }
      //Moves arm up if pot reading is less than desired reading
      else if (hardware.potArm.get()<= position - 5)
      {
        liftRight.set(ControlMode.PercentOutput, -constants.elevatorSlow * 0.5 );
        liftLeft.set(ControlMode.PercentOutput, -constants.elevatorSlow * 0.5);
        System.out.println("Going up!");
      }
      // We have arrived at target - return true
      else
      {
        arrived = true;
        liftRight.set(ControlMode.PercentOutput, 0.0);
        liftLeft.set(ControlMode.PercentOutput, 0.0);
        System.out.println("You have arrived");
      }

      return arrived;
    }

    /***
     * Move to the lowest setting to pick up from the ground
     * @return  true when reached; false otherwise
     */
    public boolean Rock ()
    {
      boolean arrived = false;

      arrived = presetMove(60.0);

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

      arrived = presetMove(100.5);

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

      arrived = presetMove(222.4);

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

      arrived = presetMove(133.0);

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

      arrived = presetMove(255.8);
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
      /*if(speed > 1.0)
      {
        speed = 1.0;
      } else if (speed < -1.0)
      {
        speed = -1.0;
      }

      if (speed > 0)
      {
        speed = speed * 0.5;
      }
      */

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
    //Stops the elevator if the 
    public void softStop()
    {
      if(Claw.updownCheck())
      {
        if(hardware.potArm.get() < 58.0)
        {
          stop();
        }
      }else
      {
        if(hardware.potArm.get() < 56.0)
        {
          stop();
        }
      }
    }
} // end Elevator