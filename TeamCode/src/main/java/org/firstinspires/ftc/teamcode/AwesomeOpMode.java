package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "AwesomeOpMode")
public class AwesomeOpMode extends LinearOpMode {
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    private DcMotor arm = null;
    private DcMotor liftFront = null;
    private DcMotor liftBack = null;
    private Servo clawBack = null;
    private DcMotor clawFront = null;
    private Servo clawFrontLeft = null;
    private Servo clawFrontRight = null;
    private DcMotor intake = null;
    private ClawExtender extender = null;

    @Override
    public void runOpMode() {
        // Initialize motors
        // frontLeft = hardwareMap.get(DcMotor.class, "front_left_motor");
        // frontRight = hardwareMap.get(DcMotor.class, "front_right_motor");
        // backLeft = hardwareMap.get(DcMotor.class, "back_left_motor");
        // backRight = hardwareMap.get(DcMotor.class, "back_right_motor");
        // //arm = hardwareMap.get(DcMotor.class, "arm_motor");
        // liftFront = hardwareMap.get(DcMotor.class, "lift_back_motor");
        // liftBack = hardwareMap.get(DcMotor.class, "lift_front_motor");
        // clawFront = hardwareMap.get(DcMotor.class, "claw_front_motor");
        // clawFrontLeft = hardwareMap.get(Servo.class, "claw_front_left_motor");
        // clawFrontRight = hardwareMap.get(Servo.class, "claw_front_right_motor");
        // clawBack = hardwareMap.get(Servo.class, "claw_back_motor");
        extender = new ClawExtender(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            double drive = gamepad1.left_stick_x;
            double strafe = gamepad1.right_stick_x;
            double rotate = gamepad1.right_stick_y;

            double lfPower = drive + strafe + rotate;
            double rfPower = drive - strafe - rotate;
            double lbPower = drive - strafe + rotate;
            double rbPower = drive + strafe - rotate;

            // frontLeft.setPower(lfPower);
            // frontRight.setPower(rfPower);
            // backLeft.setPower(lbPower);
            // backRight.setPower(rbPower);


            //     if (gamepad2.x) {
            //     //back slide go out final++
            //     //public void pickUp(){
            //     /*liftBack.setPower(1);
            //     sleep(1000);
            //     liftBack.setPower(0);
            //     sleep(500);
            //     clawFront.setPower(.4);
            //     sleep(1000);
            //     clawFront.setPower(0);
            //     sleep(500);
            //     clawFrontLeft.setPosition(1);
            //     sleep(1500);
            //     clawFrontLeft.setPosition(0);
            //     sleep(1500);
            //     clawFront.setPower(-.4);
            //     sleep(1000);
            //     clawFront.setPower(0);
            //     sleep(500);
            //     liftBack.setPower(-1);
            //     sleep(1600);*/
            //     clawFront.setPower(.8);
            //     sleep(100);
            //     ////clawFront.brake(0);
            //     }
            //   // else {
            //     //liftBack.setPower(0);
            //     //clawFront.setPower(0);
            //     //clawFrontLeft.setPosition(0);
            //     //}
            //     if(gamepad2.a){
            //         clawFront.setPower(-.8);
            //         sleep(250);
            //     }
            //     if(gamepad2.y){
            //     //clawFront.setPower(1);
            //     //sleep(100);
            //     liftFront.setPower(1);
            //     sleep(500);
            //     //liftFront.setPower(0);
            //     //sleep(500);
            //     clawBack.setPosition(1);
            //     sleep(1000);
            //     clawBack.setPosition(0);
            //     sleep(1000);
            //     liftFront.setPower(-1);
            //     sleep(250);
            //     }

            //     else{
            //     clawFront.setPower(0);
            //     liftFront.setPower(0);
            //     clawBack.setPosition(0);
            //     }
        }
    }
}
