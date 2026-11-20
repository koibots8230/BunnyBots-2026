package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.RPM;
import static edu.wpi.first.units.Units.Volts;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
   
    private final SparkFlex motor;
    private final SparkFlexConfig motorConfig;
    private SparkClosedLoopController motorController;
    private Voltage voltage;
    private AngularVelocity velocity;
    private Current current;

    public Shooter() {
        motor = new SparkFlex(ShooterConstants.MOTOR_ID, MotorType.kBrushless);
        motorConfig = new SparkFlexConfig();
        motorConfig.closedLoop.p(ShooterConstants.KP);
        motorConfig.closedLoop.feedForward.kV(ShooterConstants.KV);
        motorConfig.idleMode(IdleMode.kCoast);
        motorConfig.smartCurrentLimit((int) ShooterConstants.CURRENT_LIMIT_AMPS);
        motorConfig.inverted(true);
        motor.configure(
        motorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        motorController = motor.getClosedLoopController();

        voltage = Volts.of(0);
        velocity = RPM.of(0);
        current = Amps.of(0);
    }
        @Override
        public void periodic() {
        voltage = Volts.of(motor.getAppliedOutput() * motor.getBusVoltage());
        velocity = RPM.of(motor.getEncoder().getVelocity());
        current = Amps.of(motor.getOutputCurrent());
        }

  

}
