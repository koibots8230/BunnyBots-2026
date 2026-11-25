package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants;
import static edu.wpi.first.units.Units.RPM;
import frc.robot.subsystems.Shooter;

public class ShooterCommands{
    public static Command startShooter(Shooter shooter){
        return shooter.setVelocityCommand(Constants.shooterConstants.SHOOTER_RPM);
    }
    public static Command stopShooter(Shooter shooter){
        return shooter.setVelocityCommand(RPM.of(0));

    }
}
