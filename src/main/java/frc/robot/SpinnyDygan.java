package frc.robot;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import com.revrobotics.spark.config.SparkFlexConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.epilogue.NotLogged;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;



@logged
public class SpinnyDugan extends SubsystemBase{
    //DuganConstants FirstLinearVelocity;
    //DuganConstants SecondLinearVelocity;
    //DuganConstants FirstCircularVelocity;
    //DuganConstants SecondCircularVelocity;



    private Voltage  fixedMotorVoltage;
    private AngularVelocity fixedMotorVelocity;
    private Current fixedMotorCurrent;
    private AngularVelocity fixedMotorSetpoint;
    private SparkFlexConfig fixedMotorConfig;
    private Spark fixedMotor;

    public SpinnyDugan() {
        fixedMotor = new Spark(DuganConstants.duganConstants.MOTOR_ID, MotorType.kBrushless)
        fixedMotorConfig = new SparkFlexConfig();
        
        
    }
}


/// OLD CODE:
/*package frc.robot;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.epilogue.NotLogged;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


@logged
public class SpinnyDygan extends SubsystemBase{

    DuganConstants FirstLinearVelocity = new DuganConstants();
    DuganConstants SecondLinearVelocity = new DuganConstants();
    DuganConstants FirstCircularVelocity = new DuganConstants();
    DuganConstants SecondCircularVelocity = new DuganConstants();
    DuganConstants SHOOTER_RPM = new DuganConstants();
    









}"""
*/



