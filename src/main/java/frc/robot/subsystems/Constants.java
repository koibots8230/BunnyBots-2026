package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.RPM;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecondPerSecond;
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
        public static final AngularAcceleration MOTOR_VELOCITY = RadiansPerSecondPerSecond.of(1.0 * Math.PI);//1.0 * Math.PI is a placeholder value, adjust as needed
        public static final AngularVelocity SHOOTER_RPM = RPM.of(1000);
        public static final int MOTOR_ID = 20;
        public static final Current FIXEDMOTOR_CURRENT_LIMIT = Amps.of(40);
        public static final PIDGains FIXEDMOTOR_PID = new PIDGains.Builder().kp(0.0001).build();
        public static final FeedforwardGains FIXEDMOTOR_FEEDFORWARD = new FeedforwardGains.Builder().kv(0.0019).build();

    }

    //public static final String FIXEDMOTOR_FEEDFORWARD = null;
    //public static final String FIXEDMOTOR_CURRENT_LIMIT = null;
}
