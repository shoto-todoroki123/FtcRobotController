package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous(name = "AutonomousTesting")
public class AutonomousTesting extends LinearOpMode {
    private Intanke intanke = null;
    private Lift lift = null;
    private SampleMecanumDrive drive = null;
    private ClawExtender extender = null;
    private Trajectory traj1;
    private Trajectory traj2;


    @Override
    public void runOpMode(){
        intanke = new Intanke(hardwareMap);
        lift =  new Lift(hardwareMap);
        drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(new Pose2d(41.25,63.5,Math.toRadians(-90)));
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extender = new ClawExtender(hardwareMap);


         traj1 =  drive.trajectoryBuilder(drive.getPoseEstimate())
                .lineToLinearHeading(new Pose2d(0,35, Math.toRadians(-90)))
                .addDisplacementMarker(() -> drive.followTrajectoryAsync(traj2))
                .build();
         traj2 = drive.trajectoryBuilder(traj1.end(), true)
                .splineToLinearHeading(new Pose2d(48.07,41,Math.toRadians(90.1)),Math.toRadians(270))
                .addTemporalMarker(2.5, () ->{
                  intanke.clawDown();
                  intanke.intakeIn();
                })
                .build();

        waitForStart();

        drive.followTrajectoryAsync(traj1);

        while (opModeIsActive()) {

            Pose2d poseEstimate = drive.getPoseEstimate();
            telemetry.addData("x", poseEstimate.getX());
            telemetry.addData("y", poseEstimate.getY());
            telemetry.addData("heading", poseEstimate.getHeading());
            telemetry.update();

            intanke.update();
            drive.update();
        }
    }

}
