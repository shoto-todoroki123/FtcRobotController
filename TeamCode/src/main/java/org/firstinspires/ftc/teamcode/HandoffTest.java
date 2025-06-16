/*package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Intanke;
import org.firstinspires.ftc.teamcode.Lift;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;


import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp(name = "HandoffTest")
public class HandoffTest extends LinearOpMode {
    private Intanke intanke = null;
    private Lift lift = null;
    private SampleMecanumDrive drive = null;
    private ClawExtender extender = null;



    @Override
    public void runOpMode(){
         intanke = new Intanke(hardwareMap);
         lift =  new Lift(hardwareMap);
         drive = new SampleMecanumDrive(hardwareMap);
         drive.setPoseEstimate(new Pose2d(0,0,Math.toRadians(90)));
         drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         extender = new ClawExtender(hardwareMap);

         waitForStart();

         while (opModeIsActive()) {
             drive.setWeightedDrivePower(
                 new Pose2d(
                     -gamepad1.left_stick_y,
                     -gamepad1.left_stick_x,
                     -gamepad1.right_stick_x
                 )
             );
             Pose2d poseEstimate = drive.getPoseEstimate();
             telemetry.addData("x", poseEstimate.getX());
             telemetry.addData("y", poseEstimate.getY());
             telemetry.addData("heading", poseEstimate.getHeading());
             int currentPosition = lift.liftMotor.getCurrentPosition();
             telemetry.addData("motor position:", currentPosition);
             //int currentPositionTwo = intanke.liftMotor.getCurrentPosition();
             telemetry.addData("front motor position:", currentPositionTwo);
             telemetry.update();

             telemetry.update();
             if(gamepad2.y){
                 double y = 61.5* gamepad2.left_stick_y+61.5;
                 intanke.setClawAngle((int)y);
             }
             double line = .5*gamepad2.right_stick_y+.5;
             lift.setLiftPosition((int) line);
             if (gamepad2.a){
                 intanke.intakeIn();
             }
             if (gamepad2.b){
                 intanke.intakeOut();
             }
             if (gamepad2.x){
                 intanke.intakeStop();
             }
             if (gamepad1.left_bumper){
                 drive.setPoseEstimate(new Pose2d(0,0,Math.toRadians(90)));

             }
             if (gamepad1.right_bumper){
                 Trajectory traj = drive.trajectoryBuilder(poseEstimate)
                         .lineToLinearHeading(new Pose2d(0, 0, Math.toRadians(90)))
                         .build();
                 drive.followTrajectory(traj);

             }
             if (gamepad2.dpad_up){
                 lift.bucketRecieve();
             }
             if(gamepad2.dpad_down){
                 lift.bucketDump();
             }
             if(gamepad2.dpad_left){
                // intanke.clawUp();
             }
             if(gamepad2.dpad_right){
               //  intanke.clawDown();
             }
            /* if(gamepad2.left_bumper){
                 extender.pushClawIn();
             }
             if(gamepad2.right_bumper){
                 extender.pushClawOut();
             }*/
            /* intanke.update();
             drive.update();
         }
    }

}*/
