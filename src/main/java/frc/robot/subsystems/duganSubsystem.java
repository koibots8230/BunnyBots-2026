package frc.robot.subsystems;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.RPM;
import static edu.wpi.first.units.Units.Volts;

import com.revrobotics.PersistMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.epilogue.NotLogged;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;



@logged
public class duganSubsystem<fixedMotorConfig> extends SubsystemBase{


    @NotLogged private final Spark fixedMotor;
    @NotLogged private final SparkFlexConfig fixedMotorConfig;
    @NotLogged private SparkClosedLoopController fixedMotorController;


    private Voltage  fixedMotorVoltage;
    private AngularVelocity fixedMotorVelocity;
    private Current fixedMotorCurrent;
    private AngularVelocity fixedMotorSetpoint;


    public duganSubsystem() {
        fixedMotor = new Spark(Constants.duganConstants.MOTOR_ID, MotorType.kBrushless);
        fixedMotorConfig = new SparkFlexConfig();
        fixedMotorConfig.closedLoop.feedForward.kV(Constants.FIXEDMOTOR_FEEDFORWARD.kv);
        fixedMotorConfig.closedLoop.p(Constants.FIXEDMOTOR_PID.kp);
        fixedMotorConfig.idleMode(IdleMode.kCoast);
        fixedMotorConfig.smartCurrentLimit((int) Constants.FIXEDMOTOR_CURRENT_LIMIT.in(Amps));
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
        return Command.runOnce(() -> shoot(fixedMotorVelocity), this);
    }
}
