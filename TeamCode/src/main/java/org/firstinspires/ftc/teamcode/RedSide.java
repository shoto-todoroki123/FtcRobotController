/*package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.ClawExtender;
import org.firstinspires.ftc.teamcode.Intanke;
import org.firstinspires.ftc.teamcode.Lift;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name = "RedSideBackAutonomousTesting")
public class RedSide extends LinearOpMode {
    private Intanke intanke = null;
    private Lift lift = null;
    private SampleMecanumDrive drive = null;
    private ClawExtender extender = null;


    @Override
    public void runOpMode(){
        intanke = new Intanke(hardwareMap);
        lift =  new Lift(hardwareMap);
        drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(new Pose2d(26.02,-62.52,Math.toRadians(90)));
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extender = new ClawExtender(hardwareMap);








       TrajectorySequence traj1 =  drive.trajectorySequenceBuilder(drive.getPoseEstimate())
               /* .addTemporalMarker( ()->{
                    lift.setLiftHeight(4200);
                    lift.bucketRecieve();
                })*/

/*import com.acmerobotics.roadrunner.geometry.Pose2d;.lineToLinearHeading(new Pose2d(72,0,Math.toRadians(90)))
                //.lineToLinearHeading(new Pose2d(4,-40, Math.toRadians(90)))
               /*.addTemporalMarker(()->{
                    lift.bucketDump();
                    lift.setLiftHeight(0);
                })*/

/*import com.acmerobotics.roadrunner.geometry.Pose2d;.waitSeconds(1)
                .setReversed(false)
                .lineToLinearHeading(new Pose2d(0,72,Math.toRadians(-90)))
               //.lineToLinearHeading(new Pose2d(10,-43, Math.toRadians(90)))
               /* .lineToLinearHeading(new Pose2d(49.48,-54.29, Math.toRadians(90)))
                .lineToLinearHeading(new Pose2d(59.57,-14.68, Math.toRadians(90)))
                .splineTo(new Vector2d(59.26,-46.99), Math.toRadians(90))
                .splineTo(new Vector2d(62.83,-14.37), Math.toRadians(90))
                .splineTo(new Vector2d(62.83,-45.49), Math.toRadians(90))*/

/*import com.acmerobotics.roadrunner.geometry.Pose2d;.build();
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

}*/

package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.ClawExtender;
import org.firstinspires.ftc.teamcode.Intanke;
import org.firstinspires.ftc.teamcode.Lift;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name = "RedSideBackAuto")
public class RedSide extends LinearOpMode {
    private Intanke intanke = null;
    private Lift lift = null;
    private SampleMecanumDrive drive = null;
    private ClawExtender extender = null;
    //private Trajectory traj1;




    @Override
    public void runOpMode(){
        intanke = new Intanke(hardwareMap);
        lift =  new Lift(hardwareMap);
        drive = new SampleMecanumDrive(hardwareMap);
       // drive.setPoseEstimate(new Pose2d(20,-53,Math.toRadians(90)));
        Pose2d startPose = new Pose2d(0, 0, 0);
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extender = new ClawExtender(hardwareMap);

        drive.setPoseEstimate(startPose);

        Trajectory traj1 = drive.trajectoryBuilder(startPose)
                .strafeLeft(8)

                .build();
        Trajectory traj2 = drive.trajectoryBuilder(startPose)
                .forward(25)
                .build();
        Trajectory traj3 = drive.trajectoryBuilder(startPose)
                .back(20)
                .build();
                /*.addTemporalMarker( ()->{
                    lift.setLiftPosition(5);
                    lift.bucketRecieve();
                })*/
               // .lineToLinearHeading(new Pose2d(0,-35, Math.toRadians(90)))
                /*.addTemporalMarker(()->{
                    lift.bucketDump();
                })
                .waitSeconds(1)
                .setReversed(true)
                .addTemporalMarker( () ->{
                    intanke.clawDown();
                    intanke.intakeIn();
                    lift.setLiftPosition(0);
                    lift.bucketRecieve();
                })*/
                //.setReversed(false)
                //.strafeLeft(15)
                //.waitSeconds(.1
                /* .addTrajectory(() ->{

                 })
                .forward(15)*/

                /*.back(10)
                .strafeRight(20)*/
               /* .forward(20)
                .strafeRight(15)
                .back(48)
                .forward(20)
                .strafeRight(15)
                .back(48)
                .forward(20)
                .strafeRight(15)
                .back(48)
                .strafeLeft(24)
                .back(5)*/
               // .lineToLinearHeading(new Pose2d(-25,-45, Math.toRadians(90)))
                //.splineToLinearHeading(new Pose2d(48.5,-14.59,Math.toRadians(90)),Math.toRadians(270))
                /*.addTemporalMarker( () ->{
                    intanke.clawUp();
                })
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(48.85,38.45 ,Math.toRadians(-90.)), Math.toRadians(270))
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
                .splineToLinearHeading(new Pose2d(60.62, 59.44, Math.toRadians(-90)), Math.toRadians(270))
                .addTemporalMarker(()->{
                    intanke.clawUp();
                })
                .waitSeconds(.25)
                .addTemporalMarker(()->{
                    intanke.intakeOut();
                })
                .splineToLinearHeading(new Pose2d(55.32, 54.54,Math.toRadians(-90)), Math.toRadians(270))
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
                .splineToLinearHeading(new Pose2d(67.29, 39.43,Math.toRadians(-90)), Math.toRadians(270))
                .addTemporalMarker(()->{
                    intanke.clawUp();
                })
                .waitSeconds(.25)
                .addTemporalMarker(()->{
                    intanke.intakeOut();
                })
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(55.32, 54.54,Math.toRadians(-90)), Math.toRadians(270))
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
                .splineToLinearHeading(new Pose2d(-63.17,63.17, Math.toRadians(-90))Math.toRadians(270))*/

        waitForStart();

        drive.followTrajectory(traj1);
        drive.waitForIdle();
        drive.followTrajectory(traj2);
        drive.waitForIdle();
        drive.followTrajectory(traj3);



        while (opModeIsActive()) {

           /* Pose2d poseEstimate = drive.getPoseEstimate();
            telemetry.addData("x", poseEstimate.getX());
            telemetry.addData("y", poseEstimate.getY());
            telemetry.addData("heading", poseEstimate.getHeading());
            telemetry.update();*/

            intanke.update();
            drive.update();
            lift.update();
        }
    }

}

