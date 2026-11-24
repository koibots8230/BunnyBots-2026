import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RPM;
import frc.robot.subsystems.shooter;

public class ShooterCommands{
    public Command startShooter(){
        shooter.setVelocityCommand(RPM.of(shooterRPM));
    }
    public Command stopShooter(){
        shooter.setVelocityCommand(RPM.of(0));

    }
}
