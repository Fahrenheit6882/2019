package frc.globals;

// Import statements
import frc.interfaces.*;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.*;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Consolidate all the hardware declarations into one place.
 */
public class hardware
{
    // **********************************************
    // DIGITAL I/O CLASSES
    // **********************************************
    // ==============================================
    // PWM CLASSES
    // ==============================================
    // ----------------------------------------------
    // SPARKS
    //-----------------------------------------------

    // ----------------------------------------------
    // VICTORS
    //-----------------------------------------------
        
    // ==============================================
    // CAN CLASSES
    // ==============================================
    // ----------------------------------------------
    // TALONS
    // ----------------------------------------------


    // ==============================================
    // DIGITAL INPUTS
    // ==============================================
    // ----------------------------------------------
    // SINGLE AND DOUBLE THROW SWITCHES
    // ----------------------------------------------


    // ----------------------------------------------
    // LIMIT SWITCHES
    // ----------------------------------------------

    public static DigitalInput clawCloseSwitch = new DigitalInput(0);
    public static DigitalInput clawOpenSwitch = new DigitalInput(1);

    // ----------------------------------------------
    // ENCODERS
    // ----------------------------------------------

    //-----------------------------------------------
    //POTENTIOMETERS
    //-----------------------------------------------
    
    public static AnalogPotentiometer potArm = new AnalogPotentiometer(0, 360, 30);
    // public static AnalogPotentiometer potClaw = new AnalogPotentiometer(0,360, 30);
    

    // **********************************************
    // SOLENOID I/O CLASSES
    // **********************************************
    // ==============================================
    // SOLENOIDS
    // ==============================================
    // ----------------------------------------------
    // SINGLE SOLENOIDS
    // ----------------------------------------------


    // ----------------------------------------------
    // DOUBLE SOLENOIDS
    // ----------------------------------------------
    // public static DoubleSolenoid Betty = new DoubleSolenoid(0, 1);
    // public static DoubleSolenoid updown = new DoubleSolenoid(2, 3);
    
    // 0 and 1 are dummy port values
    // ***********************************************
    // DRIVER STATION AND RIO CONNECTIONS
    // ***********************************************
    // ===============================================
    // CAMERA CONNECTIONS
    // ===============================================
    //Initializes a USB Camera
    public static UsbCamera pOVCamera = new UsbCamera("driverCamera", 0);

    // ===============================================
    // DRIVER STATION
    // ===============================================
    public static DriverStation ds = DriverStation.getInstance();

    // =============================================== 
    // JOYSTICKS
    // ===============================================
    //Initializes 2 Logitech Gamepads: one for driver, one for operator.
    public static Joystick driverGamepad    = new Joystick(3);
    public static Joystick operatorGamepad  = new Joystick(1);
    public static DriveControls driverCntrl = new DriveControls(driverGamepad);
    public static OperatorControls operatorCntrl = new OperatorControls(operatorGamepad);
    
    // ***********************************************
    // INTERFACES
    // ***********************************************
    public static Elevator Tigger = new Elevator(new TalonSRX(0), new TalonSRX(1));
    //Initializes Transmission with four Victor motor controllers: front right, back right, front left, back left.
    //Blue encoder wire goes in ports 2 (left) & 4 (right), yellow encoder wires go in ports 1 (left) & 3 (right)
    public static Transmission driveBase = new Transmission(new VictorSPX(0), new VictorSPX(1), new VictorSPX(2), new VictorSPX(3), new Encoder(2, 1, false, Encoder.EncodingType.k4X), new Encoder(4, 3, false, Encoder.EncodingType.k4X));
    public static Claw enterprise  = new Claw(new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushed), new DoubleSolenoid(0, 1), new DoubleSolenoid(2, 3));
} // end hardware