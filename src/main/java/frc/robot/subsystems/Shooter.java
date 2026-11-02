package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkFlexConfig;



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
    flywheelMotor = new SparkFlex(ShooterConstants.FLYWHEEL_MOTOR_ID, MotorType.kBrushless);
    flywheelMotorConfig = new SparkFlexConfig();

    dgsuhgdsuhgiusdhguds








  }



}