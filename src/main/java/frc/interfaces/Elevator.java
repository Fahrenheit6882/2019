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
    private static void presetMove(double position)
    {
      //Moves arm down if pot reading is more than desired reading
      if(hardware.potArm.get() >= position + 5)
      {
        liftRight.set(ControlMode.PercentOutput, -constants.elevatorFast);
        liftLeft.set(ControlMode.PercentOutput, -constants.elevatorFast);
      }
      //Moves arm up if pot reading is less than desired reading
      else if (hardware.potArm.get()<= position - 5)
      {
        liftRight.set(ControlMode.PercentOutput, constants.elevatorFast);
        liftLeft.set(ControlMode.PercentOutput, constants.elevatorFast);
      }
    }
    /***
     * Move to the lowest setting to pick up from the ground
     * @return  true when reached; false otherwise
     */
    public boolean Rock ()
    {
      boolean arrived = false;

      //presetMove(0.0);

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

      presetMove(75.0);

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

      presetMove(170.1);

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

      presetMove(100.5);

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

      presetMove(234.88);
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

      // move Tigger
      liftRight.set(ControlMode.PercentOutput, speed);
      liftLeft.set(ControlMode.PercentOutput, speed);
    }
} // end Elevator