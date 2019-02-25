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
      }
      //Moves arm up if pot reading is less than desired reading
      else if (hardware.potArm.get()<= position - 5)
      {
        liftRight.set(ControlMode.PercentOutput, -constants.elevatorSlow * 0.5 );
        liftLeft.set(ControlMode.PercentOutput, -constants.elevatorSlow * 0.5);
      }
      // We have arrived at target - return true
      else
      {
        arrived = true;
        liftRight.set(ControlMode.PercentOutput, 0.0);
        liftLeft.set(ControlMode.PercentOutput, 0.0);
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
    public boolean Paper()
    {
      boolean arrived = false;

      arrived = presetMove(75.0);

      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger into position to score in mid rocket hatch panel or cargo ship cargo
     * @return true when reached; false otherwise
     */
    public boolean Scissor()
    {
      boolean arrived = false;

      arrived = presetMove(170.1);

      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger into position to score in low rocket cargo
     * @return true when reached; false otherwise
     */
    public boolean Lizard()
    {
      boolean arrived = false;

      arrived = presetMove(100.5);

      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger into position to score in mid rocket cargo
     * @return true when reached; false otherwise
     */
    public boolean Spock()
    {
      boolean arrived = false;

      arrived = presetMove(234.88);
      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger based on desired speed
     * @param speed value -1.0 to 1.0
     */
    public void RubberAndSpring(double speed)
    {
      // ensure speed is within allowable range
      if(speed > 1.0)
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

      // move Tigger
      liftRight.set(ControlMode.PercentOutput, speed);
      liftLeft.set(ControlMode.PercentOutput, speed);

      
      // System.out.println("Tigger speed: " + speed);
    }

    public static void potTest()
    {
      System.out.println("The poteniometer reads: " + hardware.potArm.get());
    }
} // end Elevator