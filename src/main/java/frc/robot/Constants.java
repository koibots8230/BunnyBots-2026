package frc.robot;

import static edu.wpi.first.units.Units.*;

import static edu.wpi.first.units.Units.Amps;

import com.revrobotics.spark.config.FeedForwardConfig;

import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.util.*;







public class Constants extends SubsystemBase{
    public static class duganConstants { 
        public static final AngularAcceleration MOTOR_VELOCITY = RadiansPerSecound.of(1.0 * Math.PI);//1.0 * Math.PI is a placeholder value, adjust as needed
        public static final AngularVelocity SHOOTER_RPM = RPM.of(1000);
        public static final int MOTOR_ID = 20;
        public static final Current FIXEDMOTOR_CURRENT_LIMIT = Amps.of(40);
        public static final PIDGains FIXEDMOTOR_PID = new PIDGains.Builder().kp(0.0001).build();
        public static final FeedForwardConfig FIXEDMOTOR_FREEFORWARD = new FeedForwardConfig.Builder().kv(0.0019).build();

    }
}