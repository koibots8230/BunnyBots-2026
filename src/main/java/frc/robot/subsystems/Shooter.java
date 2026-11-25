package frc.robot.subsystems;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.Constants;
import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.RPM;
import static edu.wpi.first.units.Units.Volts;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkBase.ControlType;
//import com.revrobotics.spark.SparkBase.ResetMode; This caused an error, solution was to put import com.revrobotics.ResetMode(6 lines above)
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.epilogue.NotLogged;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;



@Logged
public class Shooter extends SubsystemBase{


    private final SparkFlex fixedMotor;
    private final SparkFlexConfig fixedMotorConfig;
    private SparkClosedLoopController fixedMotorController;


    private Voltage  fixedMotorVoltage;
    private AngularVelocity fixedMotorVelocity;
    private Current fixedMotorCurrent;
    private AngularVelocity fixedMotorSetpoint;


    public Shooter() {
        fixedMotor = new SparkFlex(Constants.shooterConstants.MOTOR_ID, SparkLowLevel.MotorType.kBrushless);
        fixedMotorConfig = new SparkFlexConfig();
        fixedMotorConfig.closedLoop.feedForward.kV(Constants.shooterConstants.FIXEDMOTOR_FEEDFORWARD.kv);// Example of value, adjust as needed
        fixedMotorConfig.closedLoop.p(Constants.shooterConstants.FIXEDMOTOR_PID.kp);
        fixedMotorConfig.idleMode(IdleMode.kCoast);
        fixedMotorConfig.smartCurrentLimit((int) Constants.shooterConstants.FIXEDMOTOR_CURRENT_LIMIT.in(Amps));
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
        //fixedMotorSetpoint = RPM.of(fixedMotor.getSetpoint());    //on refrence sheet, there is no getSetpoint line
    }

    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
        fixedMotorVelocity = fixedMotorSetpoint;
    }

    private void shoot(AngularVelocity fixedMotorVelocity) {
        fixedMotorController.setSetpoint(fixedMotorVelocity.in(RPM), ControlType.kVelocity);
        fixedMotorSetpoint = fixedMotorVelocity;
    }

    public boolean atSpeed(){
        return fixedMotorVelocity.in(RPM) > fixedMotorSetpoint.in(RPM) - 20;
    }

    public Command setVelocityCommand(AngularVelocity fixedMotorVelocity) {
        return Commands.runOnce(() -> shoot(fixedMotorVelocity), this);
    }
}
