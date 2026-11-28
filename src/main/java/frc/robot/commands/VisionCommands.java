package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
            PhotonTrackedTarget depotTarget = getDepotTarget(camera);

            double turnToDepot = 0.0;
            boolean depotVisible = (depotTarget != null);

            if (depotVisible) {
                turnToDepot = turnPID.calculate(depotTarget.getYaw());
                turnToDepot =
                    MathUtil.clamp(
                        turnToDepot,
                        -VisionConstants.MAX_TURN_SPEED,
                        VisionConstants.MAX_TURN_SPEED);
            }

            SmartDashboard.putBoolean("Vision/Depot Visible", depotVisible);
            SmartDashboard.putNumber("Vision/Turn to Depot", turnToDepot);
        }).finallyDo(() -> turnPID.close());
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
