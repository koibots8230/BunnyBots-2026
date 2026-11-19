public class ShooterCommands{
    public Command startShooter(){
        shooter.setVelocityCommand(RPM.of(shooterRPM));
    }
    public Command stopShooter(){
        shooter.setVelocityCommand(RPM.of(0));

    }
}
