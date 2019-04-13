package frc.interfaces;

// Import statements
import frc.globals.*;
import edu.wpi.first.wpilibj.Joystick; 

public class DriveControls
{
    // Private variables
    private static Joystick ctrl;
    
    public DriveControls(Joystick dc)
    {
       ctrl = dc;
       
    }

    public void checkInput()
    {
      double rightSpeed;
      double leftSpeed;

         //For even movement
         /*if(Math.abs(hardware.driverGamepad.getRawAxis(constants.leftTrigger)) > constants.gamepadDeadzone)
         {
            rightSpeed = 1;
            leftSpeed = 1;
         }
         else
         {
            rightSpeed = 0;
            leftSpeed = 0;
         }
         */
         //Reads and sets the speed from the joysticks
         if (Math.abs(ctrl.getRawAxis(constants.rightY)) > constants.gamepadDeadzone)
         {
            rightSpeed = ctrl.getRawAxis(constants.rightY);
         }else if(Math.abs(hardware.driverGamepad.getRawAxis(constants.leftTrigger)) > constants.gamepadDeadzone)
         {
            rightSpeed = -1;
         }else if(Math.abs(hardware.driverGamepad.getRawAxis(constants.rightTrigger))> constants.gamepadDeadzone)
         {
            rightSpeed = 1;
         }else{
            rightSpeed = 0.0;
         }
            
         if (Math.abs(ctrl.getRawAxis(constants.leftY)) > constants.gamepadDeadzone)
         {
            leftSpeed = ctrl.getRawAxis(constants.leftY);
         }else if(Math.abs(hardware.driverGamepad.getRawAxis(constants.leftTrigger)) > constants.gamepadDeadzone)
         {
            leftSpeed = -1;
         }else if(Math.abs(hardware.driverGamepad.getRawAxis(constants.rightTrigger)) > constants.gamepadDeadzone)
         {
            leftSpeed = 1;
         }else{
            leftSpeed = 0.0;            
         }

         hardware.driveBase.drive(leftSpeed, rightSpeed);

        //pressing button LB forces robot Slow 
        if(hardware.driverGamepad.getRawButtonPressed(constants.btnLB))
        {
            hardware.driveBase.setSlow();
        }

        //pressing button RB to toggle speed setting
        if(hardware.driverGamepad.getRawButtonPressed(constants.btnRB))
        {
            hardware.driveBase.setFast();
       }
       //Right trigger is climb
       /*if(hardware.driverGamepad.getRawAxis(constants.rightTrigger) > constants.gamepadDeadzone)
       {
         hardware.driveBase.climb();
       }
       if(hardware.driverGamepad.getRawAxis(constants.rightTrigger) < constants.gamepadDeadzone)
       {
          hardware.driveBase.retract();
       }*/
    }
} // end DriveControls