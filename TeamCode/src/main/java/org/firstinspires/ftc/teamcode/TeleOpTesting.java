package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.geometry.Pose2d;
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
    public void runOpMode() throws InterruptedException {
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
             int curren= lift.liftMotor.getCurrentPosition();
             telemetry.addData("motor position two:", curren);
             int currentPosition = ClawExtender.Arm1.getCurrentPosition();
             telemetry.addData("Arm1:",currentPosition );
             int Position = ClawExtender.Arm2.getCurrentPosition();
             telemetry.addData("Arm2:",Position );
             int current = lift.hangMotor.getCurrentPosition();
             telemetry.addData("hanger", current);
             telemetry.update();
             if (clawIsForward) {
                 drive.setWeightedDrivePower(
                         new Pose2d(
                                 -gamepad1.left_stick_y,
                                 gamepad1.left_stick_x,
                                 gamepad1.right_stick_x
                         )
                 );
             }else{
                 drive.setWeightedDrivePower(
                         new Pose2d(
                                 gamepad1.left_stick_y,
                                - gamepad1.left_stick_x,
                                 gamepad1.right_stick_x
                         )
                 );
             }
             if(gamepad1.a && !previousA){
                clawIsForward = !clawIsForward;
             }

           if(gamepad2.left_stick_y<-.5/* && extender.Arm2.getCurrentPosition()<30*/){
                 lift.moveUp();
             }
             if(gamepad2.left_stick_y>.5){
                 lift.moveDown ();
             }
             if (gamepad2.right_trigger>0) {
                 intanke.intakeIn();
             }
             if (gamepad2.left_trigger>0){
                 intanke.intakeOut();
             }
             if(gamepad2.right_stick_y>0){
                 extender.pushClawIn();
             }
             if(gamepad2.right_stick_y<0){
                 extender.pushClawOut();
             }
             if(gamepad2.dpad_down){
                 extender.armDown();
             }
            if(gamepad2.b){
                intanke.wristZero();
            }
             if(gamepad2.a){
                 intanke.wristTurned();
             }
             if(gamepad2.y){
                 intanke.wristHalfTurned();
             }
             if(gamepad2.x){
                 intanke.wristotherturn();
             }
             if(gamepad2.right_bumper){
                 intanke.clawDown();
             }
             if(gamepad2.left_bumper){
                 intanke.clawUp();
             }
             if(gamepad1.dpad_up){
                 extender.hangyPart();
             }
             if(gamepad1.left_bumper){
                 extender.overBlocks();
             }
            /* if(gamepad2.dpad_right){
                 lift.makeliftmax();
             }*/
             intanke.update();
            // lift.update();
             drive.update();
             telemetry.update();
         }
    }



}

