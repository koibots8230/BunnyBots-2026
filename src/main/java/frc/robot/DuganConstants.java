package frc.robot;


import static edu.wpi.first.units.Units.MetersPerSecond;

//Imports

import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.LinearAcceleration;
import edu.wpi.first.units.measure.Time;



public class DuganConstants {
    public static class duganConstants {
        public static final LinearVelocity FirstLinearVelocity =  MetersPerSecond.of(1.0); //1.0 is a placeholder value, adjust as needed
        public static final LinearVelocity SecondLinearVelocity = MetersPerSecond.of(2.0); //2.0 is a placeholder value, adjust as needed

        public static final AngularAcceleration FirstCircularVelocity = RadiansPerSecound.of(1.0 * Math.PI);//1.0 * Math.PI is a placeholder value, adjust as needed
        public static final AngularAcceleration SecondCircularVelocity = RadiansPerSecound.of(2.0 * Math.PI);//2.0 * Math.PI is a placeholder value, adjust as needed




        public static final int MOTOR_ID = 20;
 
    }



}


