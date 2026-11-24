package frc.robot;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import com.revrobotics.PersistMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.Spark;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.epilogue.NotLogged;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;



@logged
public class duganSubsystem extends SubsystemBase{


    @NotLogged private final Spark fixedMotor;
    @NotLogged private final SparkConfig fixedMotorConfig;
    @NotLogged private SparkClosedLoopController fixedMotorController;


    private Voltage  fixedMotorVoltage;
    private AngularVelocity fixedMotorVelocity;
    private Current fixedMotorCurrent;
    private AngularVelocity fixedMotorSetpoint;


    public duganSubsystem() {
        fixedMotor = new Spark(DuganConstants.duganConstants.MOTOR_ID, MotorType.kBrushless);
        fixedMotorConfig = new SparkFlexConfig();
        fixedMotorConfig.closedLoop.feedForward.kV(DuganConstants.FIXEDMOTOR_FEEDFORWARD.kv);
        fixedMotorConfig.closedLoop.p(DuganConstants.FIXEDMOTOR_PID.kp);
        fixedMotorConfig.idleMode(IdleMode.kCoast);
        fixedMotorConfig.smartCurrentLimit((int) DuganConstants.FIXEDMOTOR_CURRENT_LIMIT.in(Amps));
        fixedMotorConfig.inverted(true); 
        fixedMotor.configure(fixedMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        fixedMotorController = fixedMotor.getClosedLoopController();


        fixedMotorVoltage = Volts.of(0); // Example voltage, adjust as needed
        fixedMotorVelocity = RPM.of(0); // Example velocity, adjust as needed
        fixedMotorCurrent = Amps.of(0); // Example current, adjust as needed
        fixedMotorSetpoint = RPM.of(0); // Example setpoint, adjust as needed
    
    }

    @Override
    public void periodic() {
        fixedMotorVoltage = Volts.of(fixedMotor.getAppliedOutput() * fixedMotor.getBusVoltage());
        fixedMotorVelocity = RPM.of(fixedMotor.getEncoder().getVelocity());
        fixedMotorCurrent = Amps.of(fixedMotor.getOutputCurrent());
        fixedMotorSetpoint = RPM.of(fixedMotor.getSetpoint());
    }

    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
        fixedMotorVelocity = fixedMotorSetpoint;
    }

    private void shoot(AngularVelocity fixedMotorVelocity) {
        fixedMotorController.setpoint(fixedMotorVelocity.in(RPM), ControlType.kVelocity);
        fixedMotorSetpoint = fixedMotorVelocity;
    }

    public boolean atSpeed(){
        return fixedMotorVelocity.in(RPM) > fixedMotorSetpoint.in(RPM) - 20;
    }

    public Command setVelocityCommand(AngularVelocity fixedMotorVelocity) {
        return Commands.runOnce(() -> shoot(fixedMotorVelocity), this);
    }
}