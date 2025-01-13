package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name = "RedSideBackAutonomousTesting")
public class RedSideBackAutonoumousTesting extends LinearOpMode {
    private Intanke intanke = null;
    private Lift lift = null;
    private SampleMecanumDrive drive = null;
    private ClawExtender extender = null;
    private TrajectorySequence traj1;
    private TrajectorySequence traj0;
    private TrajectorySequence traj2;
    private TrajectorySequence traj3;
    private TrajectorySequence traj4;
    private TrajectorySequence traj5;



    @Override
    public void runOpMode(){
        intanke = new Intanke(hardwareMap);
        lift =  new Lift(hardwareMap);
        drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(new Pose2d(41.25,63.5,Math.toRadians(-90)));
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extender = new ClawExtender(hardwareMap);


        traj1 =  drive.trajectorySequenceBuilder(drive.getPoseEstimate())
                .addTemporalMarker( ()->{
                    lift.setLiftPosition(503);
                    lift.bucketRecieve();
                })
                .lineToLinearHeading(new Pose2d(-32.96,51.6, Math.toRadians(-90)))
                .addTemporalMarker(()->{
                    lift.bucketDump();
                })
                .waitSeconds(1)
                .setReversed(true)
                .build();
        TrajectorySequence traj0 = drive.trajectorySequenceBuilder(new Pose2d(-0.54, 34.03, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-29.71, 36.19), Math.toRadians(212.82))
                .splineTo(new Vector2d(-36.96, 8.26), Math.toRadians(-90.00))
                .build();
        TrajectorySequence traj2 = drive.trajectorySequenceBuilder(new Pose2d(-36.96, 8.26, Math.toRadians(-90.00)))
                .splineTo(new Vector2d(-44.68, 20.45), Math.toRadians(100.36))
                .splineTo(new Vector2d(-45.30, 25.23), Math.toRadians(93.75))
                .splineTo(new Vector2d(-50.55, 55.79), Math.toRadians(102.86))
                .build();
        TrajectorySequence traj3 = drive.trajectorySequenceBuilder(new Pose2d(-50.55, 55.79, Math.toRadians(102.86)))
                .splineTo(new Vector2d(-47.61, 15.20), Math.toRadians(267.90))
                .build();
        TrajectorySequence traj4 = drive.trajectorySequenceBuilder(new Pose2d(-56.83, 62.13, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-57.55, 41.18), Math.toRadians(254.34))
                .splineTo(new Vector2d(-59.00, 16.13), Math.toRadians(259.01))
                .build();
        TrajectorySequence traj5 = drive.trajectorySequenceBuilder(new Pose2d(-59.00, 16.13, Math.toRadians(259.01)))
                .splineTo(new Vector2d(-62.61, 12.04), Math.toRadians(88.35))
                .splineTo(new Vector2d(-62.13, 37.57), Math.toRadians(88.93))
                .splineTo(new Vector2d(-60.92, 50.81), Math.toRadians(85.68))
                .splineTo(new Vector2d(-59.72, 63.33), Math.toRadians(99.32))
                .build();






        waitForStart();

        drive.followTrajectorySequenceAsync(traj1);
        drive.followTrajectorySequenceAsync(traj0);
        drive.followTrajectorySequenceAsync(traj2);
        drive.followTrajectorySequenceAsync(traj3);
        drive.followTrajectorySequenceAsync(traj4);
        drive.followTrajectorySequenceAsync(traj5);

        while (opModeIsActive()) {

            Pose2d poseEstimate = drive.getPoseEstimate();
            telemetry.addData("x", poseEstimate.getX());
            telemetry.addData("y", poseEstimate.getY());
            telemetry.addData("heading", poseEstimate.getHeading());
            telemetry.update();

            intanke.update();
            drive.update();
            lift.update();
        }
    }

}
