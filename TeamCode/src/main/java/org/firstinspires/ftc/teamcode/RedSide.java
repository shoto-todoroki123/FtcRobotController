package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name = "RedSideBackAutonomousTesting")
public class RedSide extends LinearOpMode {
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
        drive.setPoseEstimate(new Pose2d(26.02,-62.52,Math.toRadians(90)));
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extender = new ClawExtender(hardwareMap);







       TrajectorySequence traj1 =  drive.trajectorySequenceBuilder(drive.getPoseEstimate()
                .addTemporalMarker( ()->{
                    lift.setLiftHeight(4200);
                    lift.bucketRecieve();
                })
                .splineTo(new Vector2d(0.00,-32.39), Math.toRadians(90)));
                .addTemporalMarker(()->{
                    lift.bucketDump();
                    lift.setLiftHeight(0);
                })
                .waitSeconds(1)
                .setReversed(false)
                .splineTo(new Vector2d(0.0,-35.18), Math.toRadians(90))
                .splineTo(new Vector2d(47.15,-14.37), Math.toRadians(90))
                .splineTo(new Vector2d(49.48,-54.29), Math.toRadians(90))
                .splineTo(new Vector2d(59.57,-14.68), Math.toRadians(90))
                .splineTo(new Vector2d(59.26,-46.99), Math.toRadians(90))
                .splineTo(new Vector2d(62.83,-14.37), Math.toRadians(90))
                .splineTo(new Vector2d(62.83,-45.49), Math.toRadians(90))

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
