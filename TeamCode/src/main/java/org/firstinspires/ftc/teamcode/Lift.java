package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

@Config

public class Lift {
    private ClawExtender extender = null;
    DcMotorEx liftMotor;
   // Servo bucketServo;
    DcMotor hangMotor;
    public static int maxTicks = 3000;
    public static int max = 2000;
    public static int legalmax = 2400;
    public static int halfmin = 1300;
    public static int minTicks = 0;
    public static double radius = 3.5;
    public static double PositionDump = 0.5;
    public static double PositionRecieve = 0;
    public static double P = 0;
    public static double I = 5;
    public static double D = 0;
    public static double F = 1;
    public static int liftUpSpeed = 550;
    public static int liftDownSpeed = 550;
    boolean Up = false;


    public Lift(HardwareMap hardwareMap) {
        this.liftMotor = hardwareMap.get(DcMotorEx.class, "liftMotor");
        //this.bucketServo = hardwareMap.get(Servo.class, "bucketServo");
        this.hangMotor = hardwareMap.get(DcMotor.class, "hanger");
        this.reset();
    }

    public void reset() {
        this.liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.setLiftHeight(0);
        this.liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.liftMotor.setPower(1);
        this.hangMotor.setPower(.05);
    }

    public void setLiftHeight(double height) {

        int ticks = (int)(height*(1/(2*Math.PI*radius))*(288));
        this.liftMotor.setTargetPosition(Math.min(maxTicks, Math.max(0, ticks)));

    }
    public void setLiftPosition(double liftPosition){
        int ticks = (int)(liftPosition*maxTicks);
        this.liftMotor.setTargetPosition(Math.min(maxTicks, Math.max(0, ticks)));
    }
    public void makeliftmax(){
        this.liftMotor.setTargetPosition(max);
    }
    public void makeliftmin(){
        this.liftMotor.setTargetPosition(minTicks);
    }
    public void half(){
        this.liftMotor.setTargetPosition(halfmin);
    }
    public void legal(){
        this.liftMotor.setTargetPosition(legalmax);

    }



    /*public void bucketRecieve(){
        this.bucketServo.setPosition(PositionRecieve);
    }
    public void bucketDump() {
        this.bucketServo.setPosition(PositionDump);
    }*/
    public void moveUp(){
     this.liftMotor.setTargetPosition(Math.min(maxTicks,this.liftMotor.getCurrentPosition()+liftUpSpeed));
     Up = true;
    }
    public void moveDown(){
        this.liftMotor.setTargetPosition(Math.max(0, this.liftMotor.getCurrentPosition()-liftDownSpeed));
        Up = false;
    }
    public void hang(){
        this.hangMotor. setTargetPosition(90);
    }
    public void hangZero(){
        this.hangMotor.setTargetPosition(0);
    }
    public void update(){
        PIDFCoefficients coefficients = new PIDFCoefficients(P,I,D,F);
        this.liftMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, coefficients);
    }
}
