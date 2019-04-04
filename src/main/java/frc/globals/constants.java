package frc.globals;

import edu.wpi.first.networktables.NetworkTable;

// Import statements

/**
 * Consolidate all of the constant declarations into one place.
 */
public class constants
{
    // ----------------------------------------
    // Controller constants
    // ----------------------------------------
    // controller assignments
    public static int driverController   = 0;
    public static int operaterController = 1;
    
    // Axis Indexes
    public static int leftX        = 0;
    public static int leftY        = 1;
    public static int leftTrigger  = 2;
    public static int rightTrigger = 3;
    public static int rightX       = 4;
    public static int rightY       = 5;
    
    // Button Indexes
    public static int btnA      = 1;
    public static int btnB      = 2;
    public static int btnX      = 3;
    public static int btnY      = 4;
    public static int btnLB     = 5;
    public static int btnRB     = 6;
    public static int btnBack   = 7;
    public static int btnStart  = 8;
    public static int btnLStick = 9;
    public static int btnRStick = 10;

    // ----------------------------------------
    // Hardware Tunables
    // ----------------------------------------
    // Speed Factors
    public static double driveSuperFast = 1.0;
    public static double driveFast     = 0.6;
    public static double driveMed =     0.4;
    public static double driveSlow     = 0.25;
    public static double elevatorFast = 0.7;
    public static double elevatorSlow = 0.4;
    public static double clawFast      = 1.0;
    public static double clawSlow      = 1.0;
    public static double gravityConstant = -0.15;
    
    public boolean fast = true;


    // Dead Zones
    public static double gamepadDeadzone = 0.03;
    public static double secondDeadZone = 0.25;
    

    // Forward Motion Calculations


    // Turn calculations

    //Vision Tables
    public NetworkTable newTable;

} // end constants