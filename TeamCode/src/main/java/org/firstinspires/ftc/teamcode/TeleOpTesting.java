package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp(name = "TeleOpTesting")
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
             previousA = gamepad1.a;
             Pose2d poseEstimate = drive.getPoseEstimate();
             telemetry.addData("x", poseEstimate.getX());
             telemetry.addData("y", poseEstimate.getY());
             telemetry.addData("heading", poseEstimate.getHeading());
             telemetry.addData("liftTargetPosition",lift.liftMotor.getTargetPosition());
             telemetry.addData("actualPositionOfLift", lift.liftMotor.getCurrentPosition());
             if(gamepad2.right_stick_y<-.5){
                 lift.moveUp();
             }
             if(gamepad2.right_stick_y>.5){
                 lift.moveDown();
             }
             if (gamepad2.a) {
                 intanke.intakeIn();
             }else if (gamepad2.b){
                 intanke.intakeOut();
             }else {
                 intanke.intakeStop();
             }
             if (gamepad2.dpad_up){
                 lift.bucketRecieve();
             }
             if(gamepad2.dpad_down){
                 lift.bucketDump();
             }
             if(gamepad2.dpad_left){
                 intanke.clawUp();
             }
             if(gamepad2.dpad_right){
                 intanke.clawDown();
             }
            /* if(gamepad2.left_bumper){
                 extender.pushClawIn();
             }
             if(gamepad2.right_bumper){
                 extender.pushClawOut();
             }*/
             if(gamepad2.left_trigger>.5 && !previousLT){
                 intanke.jiggleEncoderTicks();
             }
             previousLT = gamepad2.left_trigger>.5;
             if(gamepad2.right_trigger>.5){
                 intanke.reset();
             }
             intanke.update();
             lift.update();
             drive.update();
             telemetry.update();
         }
    }

}
