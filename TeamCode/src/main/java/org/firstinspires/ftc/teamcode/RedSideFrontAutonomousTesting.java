package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name = "RedSideFrontAutonomousTesting")
public class RedSideFrontAutonomousTesting extends LinearOpMode {
    private Intanke intanke = null;
    private Lift lift = null;
    private SampleMecanumDrive drive = null;
    private ClawExtender extender = null;
    private TrajectorySequence traj1;



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
                .lineToLinearHeading(new Pose2d(0,-35, Math.toRadians(-90)))
                .addTemporalMarker(()->{
                    lift.bucketDump();
                })
                .waitSeconds(1)
                .setReversed(true)
                .addTemporalMarker( () ->{
                    intanke.clawDown();
                    intanke.intakeIn();
                    lift.setLiftPosition(0);
                    lift.bucketRecieve();
                })
                .splineToLinearHeading(new Pose2d(-49.5,-41,Math.toRadians(90.1)),Math.toRadians(270))
                .addTemporalMarker( () ->{
                    intanke.clawUp();
                })
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-48.85,-38.45 ,Math.toRadians(-90.)), Math.toRadians(270))
                .addTemporalMarker(()->{
                    intanke.intakeOut();
                })
                .waitSeconds(.5)
                .addTemporalMarker(()->{
                    lift.setLiftPosition(506);
                })
                .waitSeconds(.5)
                .addTemporalMarker(()->{
                    lift.bucketDump();
                })
                .waitSeconds(.5)
                .addTemporalMarker(()->{
                    lift.bucketRecieve();
                    lift.setLiftPosition(0);
                })
                .addTemporalMarker(()->{
                    intanke.clawDown();
                    intanke.intakeIn();
                })
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(-60.62, -59.44, Math.toRadians(-90)), Math.toRadians(270))
                .addTemporalMarker(()->{
                    intanke.clawUp();
                })
                .waitSeconds(.25)
                .addTemporalMarker(()->{
                    intanke.intakeOut();
                })
                .splineToLinearHeading(new Pose2d(-55.32, -54.54,Math.toRadians(-90)), Math.toRadians(270))
                .waitSeconds(.5)
                .addTemporalMarker(()->{
                    lift.setLiftPosition(506);
                })
                .waitSeconds(.5)
                .addTemporalMarker(()->{
                    lift.bucketDump();
                })
                .waitSeconds(.5)
                .addTemporalMarker(()->{
                    lift.bucketRecieve();
                    lift.setLiftPosition(0);
                })
                .addTemporalMarker(()->{
                    intanke.clawDown();
                    intanke.intakeIn();
                })
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-67.29, -39.43,Math.toRadians(-90)), Math.toRadians(270))
                .addTemporalMarker(()->{
                    intanke.clawUp();
                })
                .waitSeconds(.25)
                .addTemporalMarker(()->{
                    intanke.intakeOut();
                })
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(-55.32, -54.54,Math.toRadians(-90)), Math.toRadians(270))
                .waitSeconds(.5)
                .addTemporalMarker(()->{
                    lift.setLiftPosition(506);
                })
                .waitSeconds(.5)
                .addTemporalMarker(()->{
                    lift.bucketDump();
                })
                .waitSeconds(.5)
                .addTemporalMarker(()->{
                    lift.bucketRecieve();
                    lift.setLiftPosition(0);
                })
                .addTemporalMarker(()->{
                    intanke.clawDown();
                    intanke.intakeIn();
                })
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(63.17,-63.17, Math.toRadians(-90)),Math.toRadians(270))
                .build();

        waitForStart();

        drive.followTrajectorySequenceAsync(traj1);

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

