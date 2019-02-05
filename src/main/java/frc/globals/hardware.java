package frc.globals;

// Import statements
import frc.interfaces.*;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;

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


    // ----------------------------------------------
    // ENCODERS
    // ----------------------------------------------

    //-----------------------------------------------
    //POTENTIOMETERS
    //-----------------------------------------------
    
    // public static AnalogPotentiometer potArm = new AnalogPotentiometer(0, 360, 30);
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
    public static DoubleSolenoid Booper = new DoubleSolenoid(0, 1);

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
    public static Elevator lift = new Elevator(new TalonSRX(0), new TalonSRX(1));
    //Initializes Transmission with four Victor motor controllers: front right, back right, front left, back left.
    public static Transmission driveBase = new Transmission(new VictorSPX(0), new VictorSPX(1), new VictorSPX(2), new VictorSPX(3), new Encoder(1, 2, false, Encoder.EncodingType.k4X), new Encoder(3, 4, false, Encoder.EncodingType.k4X));
        
} // end hardware