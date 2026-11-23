package frc.robot;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import com.revrobotics.PersistMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkFlexConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.epilogue.NotLogged;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;



@logged
public class duganSubsystem extends SubsystemBase{


    @NotLogged private final SparkFlex fixedMotor;
    @NotLogged private final SparkFlexConfig fixedMotorConfig;
    @NotLogged private SparkClosedLoopController fixedMotorController;


    private Voltage  fixedMotorVoltage;
    private AngularVelocity fixedMotorVelocity;
    private Current fixedMotorCurrent;
    private AngularVelocity fixedMotorSetpoint;

    @SuppressWarnings("removal")
    public duganSubsystem() {
        fixedMotor = new Spark(DuganConstants.duganConstants.MOTOR_ID, MotorType.kBrushless);
        fixedMotorConfig = new SparkFlexConfig();
        fixedMotorConfig.closedLoop.p(DuganConstants.duganConstants.MOTOR_VELOCITY); //Ask Danial about this line, unsure if correct


        fixedMotorConfig.inverted(true); //Ask Danial about this line, unsure if correct, on code from last year, it was "true" not "inverted...true"
        fixedMotor.configure(fixedMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);



        fixedMotorController = fixedMotor.getClosedLoopController();


        fixedMotorVoltage = Volts.of(0); // Example voltage, adjust as needed
        fixedMotorVelocity = RPM.of(0); // Example velocity, adjust as needed
        fixedMotorCurrent = Amps.of(0); // Example current, adjust as needed
        fixedMotorSetpoint = RPM.of(0); // Example setpoint, adjust as needed

        
        
    }
}