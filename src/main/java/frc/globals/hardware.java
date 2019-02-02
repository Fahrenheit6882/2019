package frc.globals;

// Import statements
import frc.interfaces.*;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.*;
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
    //Initializes Transmission with four Victor motor controllers: front right, back right, front left, back left.
    public static Transmission driveBase = new Transmission(new VictorSPX(0), new VictorSPX(1), new VictorSPX(2), new VictorSPX(3));
        
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


    // ===============================================
    // JOYSTICKS
    // ===============================================
    //Initializes 2 Logitech Gamepads: one for driver, one for operator.
    public static Joystick driverGamepad    = new Joystick(3);
    public static Joystick operatorGamepad  = new Joystick(1);
    public static DriveControls driverCntrl = new DriveControls(driverGamepad);
    
    // ***********************************************
    // INTERFACES
    // ***********************************************

} // end hardware