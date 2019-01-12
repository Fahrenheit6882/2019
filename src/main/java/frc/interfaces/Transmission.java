package frc.interfaces;

// Import statements here
import frc.globals.*;
import edu.wpi.first.wpilibj.Victor;

public class Transmission
{
    //Transmission varables
    private Victor rightFront;
    private Victor leftFront;
    private Victor rightRear;
    private Victor leftRear;

    public Transmission (Victor rf, Victor lf, Victor rr, Victor lr)
    {
        // Initialize motor controllers
        rightFront = rf;
        leftFront = lf;
        rightRear = rr;
        leftRear = lr;

        // TODO: Invert one side of motor controllers so that + input moves forward
    }
} //end Transmission 