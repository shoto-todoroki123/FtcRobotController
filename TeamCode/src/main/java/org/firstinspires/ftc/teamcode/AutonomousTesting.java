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
    private Trajectory traj3;
    private Trajectory traj4;


    @Override
    public void runOpMode(){
        intanke = new Intanke(hardwareMap);
        lift =  new Lift(hardwareMap);
        drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(new Pose2d(41.25,63.5,Math.toRadians(-90)));
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extender = new ClawExtender(hardwareMap);


         traj1 =  drive.trajectoryBuilder(drive.getPoseEstimate())
                 .addTemporalMarker(0, ()->{
                     lift.liftMotor.setTargetPosition(503);
                     lift.bucketRecieve();
                 })
                .lineToLinearHeading(new Pose2d(0,35, Math.toRadians(-90)))
                .addDisplacementMarker(() ->{
                   lift.bucketDump();
                   sleep(1000);
                    drive.followTrajectoryAsync(traj2);
                })
                .build();
         traj2 = drive.trajectoryBuilder(traj1.end(), true)
                .splineToLinearHeading(new Pose2d(49.5,41,Math.toRadians(90.1)),Math.toRadians(270))
                .addTemporalMarker(0, () ->{
                  intanke.clawDown();
                  intanke.intakeIn();
                })
                .build();
         traj3 = drive.trajectoryBuilder(traj2.end(), true)
                 .splineToLinearHeading(new Pose2d(48.85,38.45 ,Math.toRadians(-90.)), Math.toRadians(270))
                 .addTemporalMarker(1.0, () ->{
                     intanke.clawUp();
                     intanke.intakeOut();
                 })
                .build();
         //traj4 = drive trajectoryBuilder(traj3.end(), true)
               // .splineToLinearHeading(new Pose2d(60.03, 39.63, Math.toRadians(-90)), Math.toRadians(270))






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
            lift.update();
        }
    }

}
