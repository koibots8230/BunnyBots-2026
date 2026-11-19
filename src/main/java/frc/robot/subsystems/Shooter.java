package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.RPM;
import static edu.wpi.first.units.Units.Volts;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkFlexConfig;
import frc.robot.Constants.Constants.java;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;

@logged
public class shooter extends SubsystemBase {



  @NotLogged private final SparkFlex flywheelMotor;
  @NotLogged private final SparkFlexConfig flywheelMotorConfig;



  private Voltage flywheelVoltage;
  private AngularVelocity flywheelVelocity;
  private Current flywheelCurrent;
  private AngularVelocity flywheelSetpoint;

  private Voltage feederVoltage;
  private AngularVelocity feederVelocity;
  private Current feederCurrent;
  private AngularVelocity feederSetpoint;   


  public Shooter() {
    flywheelMotor = new SparkFlex(ShooterConstants.FLYWHEEL_MOTOR_ID, MotorType.kBrushless); // creating motor 
    flywheelMotorConfig = new SparkFlexConfig(); // creating motor
    flywheelMotorConfig.closedLoop.p(ShooterConstants.FLYWHEEL_PID.kp);
    flywheelMotorConfig.closedLoop.feedForward.kV(ShooterConstants.FLYWHEEL_FEEDFORWARD.kv);
    flywheelMotorConfig.idleMode(IdleMode.kCoast);

    flywheelMotorConfig.smartCurrentLimit((int) ShooterConstants.FLYWHEEL_CURRENT_LIMIT.in(Amps));
    flywheelMotorConfig.inverted(true);
    flywheelMotor.configure(flywheelMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    flywheelMotorController = flywheelMotor.getClosedLoopController();

    flywheelVoltage = Volts.of(0); // configuring voltage, velocity,current, and setpoint
    flywheelVelocity = RPM.of(0);
    flywheelCurrent = Amps.of(0);
    flywheelSetpoint = RPM.of(0);



    @overide
    public void periodic() {
    flywheelVoltage = Volts.of(flywheelMotor.getAppliedOutput() * flywheelMotor.getBusVoltage());
    flywheelVelocity = RPM.of(flywheelMotor.getEncoder().getVelocity());
    flywheelCurrent = Amps.of(flywheelMotor.getOutputCurrent());

    feederVoltage = Volts.of(feederMotor.getAppliedOutput() * feederMotor.getBusVoltage());
    feederVelocity = RPM.of(feederMotor.getEncoder().getVelocity());
    feederCurrent = Amps.of(feederMotor.getOutputCurrent());

    @Override
    public void simulationPeriodic() {
    flywheelVelocity = flywheelSetpoint;
    }
    private void shoot(AngularVelocity flywheelVelocity, AngularVelocity feederVelocity) {
    motorVelocity = flywheelSetpoin; //setting the velocity 
    }

    public boolean atSpeed() { //command do the spin(speed)
    return flywheelVelocity.in(RPM) > flywheelSetpoint.in(RPM) - 20.0; //run do the speed(speed)



       
    public void updateLiveTuning() {
    flywheelMotorConfig.closedLoop.p(
        SmartDashboard.getNumber("Shooter/flywheelkp", ShooterConstants.FLYWHEEL_PID.kp));
    flywheelMotorConfig.closedLoop.feedForward.kV(
        SmartDashboard.getNumber("Shooter/flywheelffkv", ShooterConstants.FLYWHEEL_FEEDFORWARD.kv));
    feederMotorConfig.closedLoop.p(
        SmartDashboard.getNumber("Shooter/intakekp", ShooterConstants.FEEDER_PID.kp));
    feederMotorConfig.closedLoop.feedForward.kV(
        SmartDashboard.getNumber("Shooter/intakeffkv", ShooterConstants.FEEDER_FEEDFORWARD.kv));

    flywheelMotor.configure(
        flywheelMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    feederMotor.configure(
        feederMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    flywheelMotorController = flywheelMotor.getClosedLoopController();
    feederMotorController = feederMotor.getClosedLoopController();
  }
  } 
}
}
}