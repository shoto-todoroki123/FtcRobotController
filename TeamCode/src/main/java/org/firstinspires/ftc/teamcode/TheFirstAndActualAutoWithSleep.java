package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;


@Autonomous(name = "ActualAuto(Hopefully)")
public class TheFirstAndActualAutoWithSleep extends LinearOpMode {
    private Intanke intanke = null;
    private Lift lift = null;
    private SampleMecanumDrive drive = null;
    private ClawExtender extender = null;






    @Override
    public void runOpMode() throws InterruptedException {
        intanke = new Intanke(hardwareMap);
        lift =  new Lift(hardwareMap);
        drive = new SampleMecanumDrive(hardwareMap);
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extender = new ClawExtender(hardwareMap);



        waitForStart();
        //forward
        drive.setMotorPowers(-.5,-.5,-.5,-.5);
        sleep(100);
        //left
        drive.setMotorPowers(-.5,.5,-.5,.5);
        sleep(2800);
        //forward
        drive.setMotorPowers(-.5,-.5,-.5,-.5);
        sleep(1700);
        //clip
        extender.pushClawOut();
        sleep(2000);
        lift.moveUp();
        sleep(1000);
        lift.moveDown();
        sleep(1000);
        extender.pushClawIn();
        sleep(1000);
       /* //back
        drive.setMotorPowers(.5,.5,.5,.5);
        sleep(550);
        //right
        drive.setMotorPowers(.3,-.3,.3,-.3);
        sleep(1400);
        //forward
        drive.setMotorPowers(-.5,-.5,-.5,-.5);
        sleep(2000);
        //right
        drive.setMotorPowers(.3,-.3,.3,-.3);
        sleep(500);
        //backward
        drive.setMotorPowers(.5,.5,.5,.5);
        sleep(2000);
        //left
        drive.setMotorPowers(-.3,.3,-.3,.3);
        sleep(500);
        //forward
        drive.setMotorPowers(-.5,-.5,-.5,-.5);
        sleep(2500);
        //right
        drive.setMotorPowers(.3,-.3,.3,-.3);
        sleep(300);
        //backward
        drive.setMotorPowers(.5,.5,.5,.5);
        sleep(2300);
        //forward
        drive.setMotorPowers(-.5,-.5,-.5,-.5);
        sleep(2500);
        //right
        drive.setMotorPowers(.3,-.3,.3,-.3);
        sleep(50);*/
        /*//backward
        drive.setMotorPowers(-.5,-.5,-.5,-.5);
        sleep(200);
        //left
        //forward
        drive.setMotorPowers(.5,.5,.5,.5);
        sleep(200);
        //clip
        //extender.pushClawIn();
        //extender.pushClawOut();
        //backward
        drive.setMotorPowers(-.5,-.5,-.5,-.5);
        sleep(200);
        //right
        //backward
        drive.setMotorPowers(-.5,-.5,-.5,-.5);
        sleep(200);
        //left
        //forward
        drive.setMotorPowers(.5,.5,.5,.5);
        sleep(200);
        //clip
        //extender.pushClawIn();
        //extender.pushClawOut();
        //backward
        drive.setMotorPowers(-.5,-.5,-.5,-.5);
        sleep(200);
        //right
        //backward
        drive.setMotorPowers(-.5,-.5,-.5,-.5);
        sleep(200);
        //left
        // forward
        drive.setMotorPowers(.5,.5,.5,.5);
        sleep(200);
        //clip
        //extender.pushClawIn();
        //extender.pushClawOut();
        //backward
        drive.setMotorPowers(-.5,-.5,-.5,-.5);
        sleep(200);*/

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
