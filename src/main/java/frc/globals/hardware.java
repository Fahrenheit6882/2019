package frc.globals;

// Import statements
import frc.interfaces.*;
import edu.wpi.first.wpilibj.Joystick;
//Allows program to reconize joysticks
import edu.wpi.first.wpilibj.Victor;
//Allows program to reconize victor motor controllers

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
    public static Victor frontRight = new Victor(0);
    public static Victor backRight = new Victor(1);
    public static Victor frontLeft = new Victor(2);
    public static Victor backLeft = new Victor(3);
    //Initializes 4 Victor motor controllers: front right, back right, front left, back left.

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


    // ===============================================
    // DRIVER STATION
    // ===============================================


    // ===============================================
    // JOYSTICKS
    // ===============================================
    public static Joystick driverGamepad = new Joystick(0);
    public static Joystick operatorGamepad = new Joystick(1);
    //Initializes 2 Logitech Gamepads: one for driver, one for operator.

    // ***********************************************
    // INTERFACES
    // ***********************************************

} // end hardware