package frc.robot;


import static edu.wpi.first.units.Units.MetersPerSecond;

//Imports

import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.LinearAcceleration;
import edu.wpi.first.units.measure.Time;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class DuganConstants extends SubsystemBase{
    public static class duganConstants { 
        public static final AngularAcceleration MOTOR_VELOCITY = RadiansPerSecound.of(1.0 * Math.PI);//1.0 * Math.PI is a placeholder value, adjust as needed
        public static final AngularVelocity SHOOTER_RPM = RPM.of(1000);
        public static final int MOTOR_ID = 20;

    }
}