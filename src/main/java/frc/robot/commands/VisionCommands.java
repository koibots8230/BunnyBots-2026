package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants.VisionConstants;
import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.PhotonPipelineResult;

public class VisionCommands {
    public static Command alignToDepot(PhotonCamera camera) {
        PIDController turnPID = new PIDController(VisionConstants.TURN_PID, 0, 0);
        turnPID.setSetpoint(0);

        return Commands.run(() -> {
            PhotonTrackedTargt depotTarget = getDepotTarget(camera);
            boolean depotVisible = (depotTarget != null);

            double turnToDepot = 0.0;
            if (depotVisible) {
                turnToDepot = turnPID.
            }
        })
    }
}
