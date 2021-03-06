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
    

    /**
     * Method: floor
     * Parameters: N/A
     * Return: void
     * Operation: bring elevator to lowest setting to allow for picking up cargo off the floor
     */
    public static void floor()
    {
      System.out.println("Floor Position");
      /*suedo code
      if(hardware.potArm.getAverageVoltage() > var)
      {
        liftRight.set(Controlmode.PercentOutput, constants.elevatorFast);
        liftleft.set(Controlmode.PercentOutput, constants.elevatorFast);
      }else if(hardware.potArm.getAverageVoltage() > var)
      {
        liftRight.set(Controlmode.PercentOutput, -constants.elevatorFast);
        liftleft.set(Controlmode.PercentOutput, -constants.elevatorFast);
      }
      */
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
      /*
      if()
      */
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
    }
    
    //For Testing Elevator motors
    public static void elevatorTest()
    {
      liftLeft.set(ControlMode.PercentOutput, (constants.driveSlow * hardware.driverGamepad.getRawAxis(constants.leftY)));
      liftRight.set(ControlMode.PercentOutput, (constants.driveSlow * hardware.driverGamepad.getRawAxis(constants.leftY)));
    }

} // end Elevator