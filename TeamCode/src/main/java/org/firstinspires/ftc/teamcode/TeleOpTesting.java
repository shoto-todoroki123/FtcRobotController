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
    private boolean previousA = false;
    private boolean previousLT = false;
    private FtcDashboard dashboard;


    @Override
    public void runOpMode() throws InterruptedException {
        intanke = new Intanke(hardwareMap);
        extender = new ClawExtender(hardwareMap);
        lift = new Lift(hardwareMap, extender);
        drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(new Pose2d(0, 0, Math.toRadians(90)));
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        clawIsForward = true;
        previousA = false;
        previousLT = false;
        dashboard = FtcDashboard.getInstance();
        telemetry = dashboard.getTelemetry();


        waitForStart();{

//         lift.reset();

            while (opModeIsActive()) {
                Pose2d poseEstimate = drive.getPoseEstimate();
                telemetry.addData("x", poseEstimate.getX());
                telemetry.addData("y", poseEstimate.getY());
                telemetry.addData("heading", poseEstimate.getHeading());
                //int currentPosition = intanke.liftMotor.getCurrentPosition();
                //telemetry.addData("motor position:", currentPosition);
                int curren = lift.liftMotor.getCurrentPosition();
                telemetry.addData("motor position two:", curren);
                int currentPosition = ClawExtender.Arm1.getCurrentPosition();
                telemetry.addData("Arm1:", currentPosition);
                int Position = ClawExtender.Arm2.getCurrentPosition();
                telemetry.addData("Arm2:", Position);
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
                } else {
                    drive.setWeightedDrivePower(
                            new Pose2d(
                                    gamepad1.left_stick_y,
                                    -gamepad1.left_stick_x,
                                    gamepad1.right_stick_x
                            )
                    );
                }
                drive.update();
                telemetry.update();
            }
        }


    }
}

