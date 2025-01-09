package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Intanke {
    public DcMotorEx liftMotor;
    Servo clawServo;
    public static int maxTicks = 150;
    public static double mg = 10;
   public static double verticalOffset = 59;
    public static int clawGrab = 150;
    public static int clawFold = 0;
    public boolean newTargetPosition = true;
    public double jigglePower = 1;
    public Intanke(HardwareMap hardwareMap) {
        this.liftMotor = hardwareMap.get(DcMotorEx.class, "lift");
        this.clawServo = hardwareMap.get(Servo.class, "clawServo");
        this.reset();
    }

    public void reset() {
        this.liftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        this.liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.setClawAngle(0);
        this.liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.liftMotor.setPower(1);
        this.jigglePower = 1;
    }

    public void setClawAngle(int ticks) {
        this.liftMotor.setTargetPosition(Math.min(maxTicks, Math.max(0, ticks)));
//        int ticks = (int) ((288.0 / 360.0) * degrees);
//        this.liftMotor.setTargetPosition(Math.min(maxTicks, Math.max(0, ticks)));

    }
    public void update(){
        int currentPosition = this.liftMotor.getCurrentPosition();
        double theta = currentPosition-verticalOffset;
        double f = mg*Math.sin(theta*(Math.PI/144.0));
        PIDFCoefficients coefficients = this.liftMotor.getPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER);
        coefficients.f = f;
        coefficients.p = 25;
        coefficients.i = 0;
        this.liftMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, coefficients);
        if(!this.liftMotor.isBusy()){
            newTargetPosition = false;
        }
        if(newTargetPosition){
            this.liftMotor.setPower(jigglePower);
        }else {
            this.liftMotor.setPower(0);
        }
    }
    public void intakeIn(){
        this.clawServo.setPosition(1);
    }
    public void intakeOut(){
        this.clawServo.setPosition(0);
    }
    public void intakeStop(){
        this.clawServo.setPosition(.5);
    }
    public void clawUp(){
        this.liftMotor.setTargetPosition(clawFold);
        newTargetPosition = true;
    }
    public void clawDown(){
        this.liftMotor.setTargetPosition(clawGrab);
        newTargetPosition = true;
    }
    public void jiggleEncoderTicks(){
       jigglePower = jigglePower*-1;

    }

}
