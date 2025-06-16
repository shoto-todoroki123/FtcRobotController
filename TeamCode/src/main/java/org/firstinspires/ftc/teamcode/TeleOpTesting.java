package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp(name = "TeleOp")
public class TeleOpTesting extends LinearOpMode {
    private Intanke intanke = null;
    private Lift lift = null;
    private SampleMecanumDrive drive = null;
    private ClawExtender extender = null;
    private boolean clawIsForward = true;
    private boolean previousA =  false;
    private boolean previousLT = false;
    private FtcDashboard dashboard;



    @Override
    public void runOpMode(){
         intanke = new Intanke(hardwareMap);
         lift =  new Lift(hardwareMap);
         drive = new SampleMecanumDrive(hardwareMap);
         drive.setPoseEstimate(new Pose2d(0,0,Math.toRadians(90)));
         drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         extender = new ClawExtender(hardwareMap);
         clawIsForward = true;
         previousA = false;
         previousLT = false;
         dashboard = FtcDashboard.getInstance();
         telemetry = dashboard.getTelemetry();


         waitForStart();

         while (opModeIsActive()) {
             Pose2d poseEstimate = drive.getPoseEstimate();
             telemetry.addData("x", poseEstimate.getX());
             telemetry.addData("y", poseEstimate.getY());
             telemetry.addData("heading", poseEstimate.getHeading());
             //int currentPosition = intanke.liftMotor.getCurrentPosition();
             //telemetry.addData("motor position:", currentPosition);
             int current = lift.liftMotor.getCurrentPosition();
             telemetry.addData("motor position two:", current);
             telemetry.update();
             if (clawIsForward) {
                 drive.setWeightedDrivePower(
                         new Pose2d(
                                 gamepad1.left_stick_y,
                                 gamepad1.left_stick_x,
                                 -gamepad1.right_stick_x
                         )
                 );
             }else{
                 drive.setWeightedDrivePower(
                         new Pose2d(
                                 -gamepad1.left_stick_y,
                                 -gamepad1.left_stick_x,
                                 -gamepad1.right_stick_x
                         )
                 );
             }
             if(gamepad1.a && !previousA){
                clawIsForward = !clawIsForward;
             }

             if(gamepad2.left_stick_y<-.5){
                 lift.moveUp();
             }
             if(gamepad2.left_stick_y>.5){
                 lift.moveDown();
             }
            // if (gamepad2.right_trigger>0) {
              //   intanke.intakeIn();
             if (gamepad2.left_bumper){
                 intanke.intakeOut();
             }else {
                 intanke.intakeStop();
             }
             if (gamepad2.b){
                 lift.bucketRecieve();
             }
             if(gamepad2.x){
                 lift.bucketDump();
             }

            //intanke.clawLift(gamepad2.right_trigger-gamepad2.left_trigger);


             if(gamepad2.right_stick_y<0){
                 extender.pushClawIn();
             }
             if(gamepad2.right_stick_y>0){
                 extender.pushClawOut();
             }
             if(gamepad2.y){
                 lift.hang();
             }
             if(gamepad2.a){
                 lift.hangZero();
             }
             //if(gamepad2.left_trigger>.5 && !previousLT){
              //   intanke.jiggleEncoderTicks();
            // }
            // previousLT = gamepad2.left_trigger>.5;
             //if(gamepad2.right_trigger>.5){
             //    intanke.reset();
             //}
            if(gamepad2.dpad_right){
                intanke.wristZero();
            }
             if(gamepad2.dpad_left){
                 intanke.wristTurned();
             }
             if(gamepad2.dpad_up){
                 intanke.wristHalfTurned();
             }
             intanke.update();
             lift.update();
             drive.update();
             telemetry.update();
         }
    }

}
