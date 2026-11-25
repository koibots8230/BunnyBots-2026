// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.ShooterCommands;



public class RobotContainer {
  Shooter shooter; 
  XboxController controller;
  public RobotContainer() {
    shooter = new Shooter();
    controller = new XboxController(0);
    configureBindings();

  }

  private void configureBindings() {
    Trigger shootTrigger = new Trigger(() -> controller.getRightTriggerAxis() > 0.15);
    shootTrigger.onTrue(ShooterCommands.startShooter(shooter));
    shootTrigger.onFalse(ShooterCommands.stopShooter(shooter));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
