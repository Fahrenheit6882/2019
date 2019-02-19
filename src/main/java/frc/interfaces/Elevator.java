package frc.interfaces;


// import statements
import frc.globals.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

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
    
    /***
     * Move to the lowest setting to pick up from the ground
     * @return  true when reached; false otherwise
     */
    public static boolean Rock ()
    {
      boolean arrived = false;

      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger into position to score in low rocket or cargo ship hatch panel
     * @return true when reached; false otherwise
     */
    public static boolean Paper()
    {
      boolean arrived = false;

      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger into position to score in mid rocket hatch panel or cargo ship cargo
     * @return true when reached; false otherwise
     */
    public static boolean Scissor()
    {
      boolean arrived = false;

      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger into position to score in low rocket cargo
     * @return true when reached; false otherwise
     */
    public static boolean Lizard()
    {
      boolean arrived = false;

      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger into position to score in mid rocket cargo
     * @return true when reached; false otherwise
     */
    public static boolean Spock()
    {
      boolean arrived = false;

      // logic to move arm and check if arrived

      return arrived;
    }

    /***
     * Move Tigger based on desired speed
     * @param speed value -1.0 to 1.0
     */
    public static void RubberAndSpring(double speed)
    {
      // ensure speed is within allowable range

      // move Tigger
    }
} // end Elevator