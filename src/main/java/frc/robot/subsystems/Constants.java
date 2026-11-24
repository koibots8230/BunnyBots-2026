package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.RPM;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Volts;

import static edu.wpi.first.units.Units.Amps;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.util.PIDGains;
import frc.lib.util.FeedforwardGains;







public class Constants extends SubsystemBase{
    public static class duganConstants { 
        public static final AngularAcceleration MOTOR_VELOCITY = RadiansPerSecond.of(1.0 * Math.PI);//1.0 * Math.PI is a placeholder value, adjust as needed
        public static final AngularVelocity SHOOTER_RPM = RPM.of(1000);
        public static final int MOTOR_ID = 20;
        public static final Current FIXEDMOTOR_CURRENT_LIMIT = Amps.of(40);
        public static final PIDGains FIXEDMOTOR_PID = new PIDGains.Builder().kp(0.0001).build();
        public static final FeedforwardGains FIXEDMOTOR_FREEFORWARD = new FeedforwardGains.Builder().kv(0.0019).build();

    }

    public static final String FIXEDMOTOR_FEEDFORWARD = null;
    public static final String FIXEDMOTOR_CURRENT_LIMIT = null;
}

/* package frc.robot.subsystems;

import frc.lib.util.FeedforwardGains;
import frc.lib.util.PIDGains;

public final class Constants {
    
    public static final class ShooterConstants {
        public static final double FLYWHEEL_RPM = 3000;
        public static final int MOTOR_ID = 20;
        public static final double KP = 0.0003;
        public static final double KV = 0.00015;
        public static final int CURRENT_LIMIT_AMPS = 60;

        public static final PIDGains FLYWHEEL_PID = new PIDGains.Builder().kp(0.00055).build();
        public static final FeedforwardGains FLYWHEEL_FEEDFORWARD = new FeedforwardGains.Builder().kv(0.0019).build();

    }
}
    */