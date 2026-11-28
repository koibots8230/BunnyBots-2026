// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.*;
import static edu.wpi.first.units.Units.RPM;

import org.photonvision.PhotonCamera;

public class RobotContainer {
  private final XboxController controller;
  private final Shooter shooter;  
  private final PhotonCamera camera;
  
  public RobotContainer() {
    shooter = new Shooter();
    controller = new XboxController(0);
    camera = new PhotonCamera("photonvision");
    configureBindings();
  }

  private void configureBindings() {
    Trigger shootTrigger = new Trigger(() -> controller.getRightTriggerAxis() > 0.15);
    // Trigger shootTrigger = new Trigger(() -> controller.getAButton());
    shootTrigger.onTrue(shooter.setVelocityCommand(RPM.of(ShooterConstants.FLYWHEEL_RPM)));
    shootTrigger.onFalse(shooter.setVelocityCommand(RPM.of(0)));

    Trigger alignToDepot = new Trigger(() -> controller.getRightBumperButton());
    alignToDepot.whileTrue(VisionCommands.alignToDepot(camera));

  }  

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

}

