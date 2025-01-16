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
    private TrajectorySequence traj6;
    private TrajectorySequence traj7;
    private TrajectorySequence traj8;
    private TrajectorySequence traj9;
    private TrajectorySequence traj10;
    private TrajectorySequence traj11;
    private TrajectorySequence traj12;
    private TrajectorySequence traj13;
    private TrajectorySequence traj14;



    @Override
    public void runOpMode(){
        intanke = new Intanke(hardwareMap);
        lift =  new Lift(hardwareMap);
        drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(new Pose2d(41.25,63.5,Math.toRadians(-90)));
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extender = new ClawExtender();


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
         traj0 = drive.trajectorySequenceBuilder(new Pose2d(-0.54, 34.03, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-29.71, 36.19), Math.toRadians(212.82))
                .splineTo(new Vector2d(-36.96, 8.26), Math.toRadians(-90.00))
                .build();
         traj2 = drive.trajectorySequenceBuilder(new Pose2d(-36.96, 8.26, Math.toRadians(-90.00)))
                .splineTo(new Vector2d(-44.68, 20.45), Math.toRadians(100.36))
                .splineTo(new Vector2d(-45.30, 25.23), Math.toRadians(93.75))
                .splineTo(new Vector2d(-50.55, 55.79), Math.toRadians(102.86))
                .build();
         traj3 = drive.trajectorySequenceBuilder(new Pose2d(-50.55, 55.79, Math.toRadians(102.86)))
                .splineTo(new Vector2d(-47.61, 15.20), Math.toRadians(267.90))
                .build();
         traj4 = drive.trajectorySequenceBuilder(new Pose2d(-56.83, 62.13, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-57.55, 41.18), Math.toRadians(254.34))
                .splineTo(new Vector2d(-59.00, 16.13), Math.toRadians(259.01))
                .build();
         traj5 = drive.trajectorySequenceBuilder(new Pose2d(-59.00, 16.13, Math.toRadians(259.01)))
                .splineTo(new Vector2d(-62.61, 12.04), Math.toRadians(88.35))
                .splineTo(new Vector2d(-62.13, 37.57), Math.toRadians(88.93))
                .splineTo(new Vector2d(-60.92, 50.81), Math.toRadians(85.68))
                .splineTo(new Vector2d(-59.72, 63.33), Math.toRadians(99.32))
                .build();
         traj6 = drive.trajectorySequenceBuilder(new Pose2d(-61.00, 60.41, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-57.86, 36.44), Math.toRadians(-86.25))
                .splineTo(new Vector2d(-58.05, 12.28), Math.toRadians(259.60))
                .splineTo(new Vector2d(-62.96, 1.67), Math.toRadians(96.22))
                .splineTo(new Vector2d(-62.37, 28.78), Math.toRadians(90.00))
                .splineTo(new Vector2d(-62.77, 43.91), Math.toRadians(89.25))
                .splineTo(new Vector2d(-61.59, 58.64), Math.toRadians(101.85))
                .build();
         traj7 = drive.trajectorySequenceBuilder(new Pose2d(-61.59, 58.64, Math.toRadians(101.85)))
                .splineTo(new Vector2d(-49.60, 63.55), Math.toRadians(42.91))
                .splineTo(new Vector2d(-39.00, 62.37), Math.toRadians(-25.60))
                .splineTo(new Vector2d(-33.30, 61.59), Math.toRadians(-35.62))
                .splineTo(new Vector2d(-24.26, 58.05), Math.toRadians(-51.48))
                .splineTo(new Vector2d(-15.81, 46.66), Math.toRadians(-63.30))
                .splineTo(new Vector2d(-3.44, 32.91), Math.toRadians(-90.00))
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
         traj8 = drive.trajectorySequenceBuilder(new Pose2d(-3.44, 32.91, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-44.10, 62.96), Math.toRadians(90.00))
                .addTemporalMarker(()->{
                    lift.setLiftPosition(0);
                    lift.bucketRecieve();
                })
                .build();
         traj9 = drive.trajectorySequenceBuilder(new Pose2d(-44.10, 62.96, Math.toRadians(140.46)))
                .splineTo(new Vector2d(-40.76, 44.50), Math.toRadians(-38.28))
                .splineTo(new Vector2d(5.80, 33.10), Math.toRadians(-90.00))
                .addTemporalMarker( ()->{
                    lift.setLiftPosition(503);
                    lift.bucketRecieve();
                })
                .lineToLinearHeading(new Pose2d(-32.96,51.6, Math.toRadians(-90)))
                .addTemporalMarker(()->{
                    lift.bucketDump();
                })
                .build();
         traj10 = drive.trajectorySequenceBuilder(new Pose2d(5.80, 33.10, Math.toRadians(-90.00)))
                .splineTo(new Vector2d(-0.88, 53.14), Math.toRadians(144.00))
                .splineTo(new Vector2d(-13.06, 55.89), Math.toRadians(166.24))
                .splineTo(new Vector2d(-25.83, 55.89), Math.toRadians(130.29))
                .splineTo(new Vector2d(-52.16, 62.57), Math.toRadians(90.00))
                .addTemporalMarker(()->{
                    lift.setLiftPosition(0);
                    lift.bucketRecieve();
                })
                .build();
         traj11 = drive.trajectorySequenceBuilder(new Pose2d(-52.16, 62.57, Math.toRadians(147.23)))
                .splineTo(new Vector2d(-48.43, 59.62), Math.toRadians(-35.23))
                .splineTo(new Vector2d(-1.08, 32.91), Math.toRadians(-90.00))
                .addTemporalMarker( ()->{
                    lift.setLiftPosition(503);
                    lift.bucketRecieve();
                })
                .lineToLinearHeading(new Pose2d(-32.96,51.6, Math.toRadians(-90)))
                .addTemporalMarker(()->{
                    lift.bucketDump();
                })
                .build();
         traj12 = drive.trajectorySequenceBuilder(new Pose2d(-1.08, 32.91, Math.toRadians(-39.11)))
                .splineTo(new Vector2d(-6.38, 37.03), Math.toRadians(148.36))
                .splineTo(new Vector2d(-55.11, 62.77), Math.toRadians(90.00))
                .addTemporalMarker(()->{
                    lift.setLiftPosition(0);
                    lift.bucketRecieve();
                })
                .build();
         traj13 = drive.trajectorySequenceBuilder(new Pose2d(-55.11, 62.77, Math.toRadians(149.81)))
                .splineTo(new Vector2d(-45.87, 57.27), Math.toRadians(-33.64))
                .splineTo(new Vector2d(-4.62, 33.30), Math.toRadians(-90.00))
                .addTemporalMarker( ()->{
                    lift.setLiftPosition(503);
                    lift.bucketRecieve();
                })
                .lineToLinearHeading(new Pose2d(-32.96,51.6, Math.toRadians(-90)))
                .addTemporalMarker(()->{
                    lift.bucketDump();
                })
                .build();
         traj14 = drive.trajectorySequenceBuilder(new Pose2d(-4.62, 33.30, Math.toRadians(-29.72)))
                .splineTo(new Vector2d(-11.69, 37.23), Math.toRadians(147.22))
                .splineTo(new Vector2d(-62.77, 62.77), Math.toRadians(90.00))
                 .addTemporalMarker(()->{
                     lift.setLiftPosition(0);
                     lift.bucketRecieve();
                 })
                 .build();


        waitForStart();

        drive.followTrajectorySequenceAsync(traj1);
        drive.followTrajectorySequenceAsync(traj0);
        drive.followTrajectorySequenceAsync(traj2);
        drive.followTrajectorySequenceAsync(traj3);
        drive.followTrajectorySequenceAsync(traj4);
        drive.followTrajectorySequenceAsync(traj5);
        drive.followTrajectorySequenceAsync(traj6);
        drive.followTrajectorySequenceAsync(traj7);
        drive.followTrajectorySequenceAsync(traj8);
        drive.followTrajectorySequenceAsync(traj9);
        drive.followTrajectorySequenceAsync(traj10);
        drive.followTrajectorySequenceAsync(traj11);
        drive.followTrajectorySequenceAsync(traj12);
        drive.followTrajectorySequenceAsync(traj13);
        drive.followTrajectorySequenceAsync(traj14);


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
