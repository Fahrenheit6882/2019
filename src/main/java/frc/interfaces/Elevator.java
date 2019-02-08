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
      liftLeft.setInverted(true);
    }
    
    public void ElevatorInit()
    {
      
    }
    //Moves the Elevator based on speed
    public static void fineTune(double speed)
    {
      liftRight.set(ControlMode.PercentOutput, speed * constants.elevatorSlow);
      liftLeft.set(ControlMode.PercentOutput, speed * constants.elevatorSlow);

    }

    //Elevator moves to a preset
    public static void preset(double angle, double speed)
    {
      double degrees = hardware.potArm.get();
      if(degrees <= angle)
      {
        liftRight.set(ControlMode.PercentOutput, speed);
        liftLeft.set(ControlMode.PercentOutput, speed);
      }else if(degrees >= angle)
      {
        liftRight.set(ControlMode.PercentOutput, -speed);
        liftLeft.set(ControlMode.PercentOutput, -speed);
      }
    }
    /**
     * Method: floor
     * Parameters: N/A
     * Return: void
     * Operation: bring elevator to lowest setting to allow for picking up cargo off the floor
     */
    public static void floor()
    {
      System.out.println("Floor Position");
      //ElevatorMove(angle, constants.elevatorFast);
    }
    
    /**
     * Method: cargoCargoShip
     * Parameters: N/A
     * Return: void
     * Operation: bring elevator to height necessary to score cargo in cargo ship
     */
    public static void cargoCargoShip()
    {
      System.out.println("Cargo position for CargoShip");
      preset(41.84, constants.elevatorFast);
    }

    /**
     * Method: cargoRocketLow
     * Parameters: N/A
     * Return: void
     * Operation: bring elevator to height necessary to score cargo in rocket low goal
     */
    public static void cargoRocketLow()
    {
      System.out.println("Cargo position for Rocket Low");
      preset(33.09, constants.elevatorFast);
    }

    /**
     * Method: cargoRocketMid
     * Parameters: N/A
     * Return: void
     * Operation: bring elevator to height necessary to score cargo in rocket mid goal
     */
    public static void cargoRocketMid()
    {
      System.out.println("Cargo postition for Rocket Mid");
      preset(89.85, constants.elevatorFast);
    }

    /**
     * Method: cargoRocketHigh
     * Parameters: N/A
     * Return: void
     * Operation: bring elevator to height necessary to score cargo in rocket high goal
     */
    public static void cargoRocketHigh()
    {
      System.out.println("Cargo postition for Rocket High");
      //ElevatorMove(angle, constants.elevatorFast);
    }

    /**
     * Method: hatchCargoShip
     * Parameters: N/A
     * Return: void
     * Operation: bring elevator to height necessary to score hatch on cargo ship
     */
    public static void hatchCargoShip()
    {
      System.out.println("Hatch Panel position for Cargo Ship");
      preset(10.34, constants.elevatorFast);
    }

    /**
     * Method: hatchRocketLow
     * Parameters: N/A
     * Return: void
     * Operation: bring elevator to height necessary to score hatch on rocket low goal
     */
    public static void hatchRocketLow()
    {
      System.out.println("Hatch Panel postition for Rocket Low");
      preset(10.34, constants.elevatorFast);
    }

    /**
     * Method: hatchRocketMid
     * Parameters: N/A
     * Return: void
     * Operation: bring elevator to height necessary to score hatch on rocket mid goal
     */
    public static void hatchRocketMid()
    {
      System.out.println("Hatch Panel position for Rocket Middle");
      preset(72.58, constants.elevatorFast);
    }

    /**
     * Method: hatchRocketHigh
     * Parameters: N/A
     * Return: void
     * Operation: bring elevator to height necessary to score hatch on rocket high goal
     */
    public static void hatchRocketHigh()
    {
      System.out.println("Hatch Panel position for Rocket High");
      //ElevatorMove(angle, constants.elevatorFast);
    }

} // end Elevator