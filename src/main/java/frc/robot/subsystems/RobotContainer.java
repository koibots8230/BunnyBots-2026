// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
    Shooter shooter = new Shooter();
    Controller controller = new Controller();

  }

  private void configureBindings() {
    Trigger shootTrigger  = new Trigger();
    shootTrigger.onTrue(startShooter);
    shootTrigger.onFalse(stopShooter);
    




  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
