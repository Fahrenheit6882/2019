package frc.interfaces;

// Import statements
import frc.globals.*;
import edu.wpi.first.wpilibj.Joystick;
 

public class DriveControls
{
    //variables go here
    private static Joystick ctrl;

    public DriveControls(Joystick dc)
    {
       ctrl = dc;
    }
   

} // end DriveControls