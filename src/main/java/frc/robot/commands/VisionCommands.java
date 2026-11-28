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
        PIDController turnPID = new PIDController(VisionConstants.TURN_PID.kp, 0, 0);
        turnPID.setSetpoint(0);

        return Commands.run(() -> {

        });
    }

    private static PhotonTrackedTarget getDepotTarget(PhotonCamera camera) {
        var results = camera.getAllUnreadResults();
        if (results.isEmpty()) return null;

        PhotonPipelineResult latestResult = results.get(results.size() - 1);
        if (!latestResult.hasTargets()) return null;

        for (PhotonTrackedTarget target : latestResult.getTargets()) {
            boolean isDepotTag = 
                (VisionConstants.DEPOT_TAG_ID == -1) || 
                (target.getFiducialId() == VisionConstants.DEPOT_TAG_ID);
            
            if (isDepotTag) {
                return target;
            }
        }

        return null;
    }
}
