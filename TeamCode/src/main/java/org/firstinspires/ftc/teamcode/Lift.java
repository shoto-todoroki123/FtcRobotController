package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config

public class Lift {
    DcMotor liftMotor;
    Servo bucketServo;
    public static int maxTicks = 1188;
    public static double radius = 3.5;
    public static double PositionDump = .8;
    public static double PositionRecieve = .2;

    public Lift(HardwareMap hardwareMap) {
        this.liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
        this.bucketServo = hardwareMap.get(Servo.class, "bucketServo");
        this.reset();
    }

    public void reset() {
        this.liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.setLiftHeight(0);
        this.liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.liftMotor.setPower(1);
    }

    public void setLiftHeight(double height) {

        int ticks = (int)(height*(1/(2*Math.PI*radius))*(288));
        this.liftMotor.setTargetPosition(Math.min(maxTicks, Math.max(0, ticks)));

    }
    public void setLiftPosition(double liftPosition){
        int ticks = (int)(liftPosition*maxTicks);
        this.liftMotor.setTargetPosition(Math.min(maxTicks, Math.max(0, ticks)));
    }

    public void bucketRecieve(){
        this.bucketServo.setPosition(PositionRecieve);
    }
    public void bucketDump() {
        this.bucketServo.setPosition(PositionDump);
    }
}
