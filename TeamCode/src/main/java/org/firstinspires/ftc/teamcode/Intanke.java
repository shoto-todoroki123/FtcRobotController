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
    Servo liftServo;
    Servo clawServo;
    Servo clawWrist;
    public static int maxTicks = 50;
    public static double mg = 10;
   public static double verticalOffset = 59;
    public static int clawGrab = -120;
    public static int clawFold = 15;
    public static int wristturned = 90;
    public static int wristzero = 0;


    public boolean newTargetPosition = true;
   // public double jigglePower = 1;
    public double p = 25;
    public double i = 0;
    public Intanke(HardwareMap hardwareMap) {
        this.liftServo = hardwareMap.get(Servo.class, "lift");
        this.clawServo = hardwareMap.get(Servo.class, "clawServo");
        this.clawWrist = hardwareMap.get(Servo.class, "wristServo");
        this.reset();
    }

    public void reset() {
        //this.liftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        //this.liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //this.liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       // this.setClawAngle(0);
       // this.clawServo(DcMotor.RunMode.RUN_TO_POSITION);
        //this.liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       // this.liftMotor.setPower(.5);
        //this.jigglePower = 1;
    }




   // public void setClawAngle(int ticks) {
       // this.liftMotor.setTargetPosition(Math.min(maxTicks, Math.max(0, ticks)));
//       int ticks = (int) ((288.0 / 360.0) * degrees);
  //     this.liftMotor.setTargetPosition(Math.min(maxTicks, Math.max(0, ticks)));

    //}
   public void update(){
        /*int currentPosition = this.liftMotor.getCurrentPosition();
        double theta = currentPosition-verticalOffset;
       //double f = mg*Math.sin(theta*(Math.PI/144.0));
        double f = 0;
        PIDFCoefficients coefficients = this.liftMotor.getPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER);
        coefficients.f = f;
        coefficients.p = p;
        coefficients.i = i;
        this.liftMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, coefficients);
        if(!this.liftMotor.isBusy()){
            newTargetPosition = false;
        }*/
       // if(newTargetPosition){
            //this.liftMotor.setPower(jigglePower);
        //}else {
          //  this.liftMotor.setPower(0);
       // }
    }
    public void intakeIn(){
        this.clawServo.setPosition(.65);
    }
    public void intakeOut(){
        this.clawServo.setPosition(0.35);
    }
    public void intakeStop(){
        this.clawServo.setPosition(.5);
    }
    /*public void clawUp(){
        this.liftMotor.setTargetPosition(Math.min(maxTicks,this.liftMotor.getCurrentPosition()));
        newTargetPosition = true;
    }
    public void clawDown(){
        this.liftMotor.setTargetPosition(Math.min(maxTicks,this.liftMotor.getCurrentPosition()));
        newTargetPosition = true;
    }*/
    /*public void clawLift(double power){
       this.liftMotor.setPower(power);
    }*/
   // public void jiggleEncoderTicks(){
     //  jigglePower = jigglePower*-1;

    //}
    public void wristTurned(){
        this.clawWrist.setPosition(.1);
    }
    public void wristHalfTurned(){
        this.clawWrist.setPosition(0.5);
    }
    public void wristZero(){
        this.clawWrist.setPosition(0.3);
    }
    public void wristotherturn(){
        this.clawWrist.setPosition(.6);
    }
    public void clawUp(){
        this.liftServo.setPosition(1);
    }
    public void clawDown(){
        this.liftServo.setPosition(0);
    }

}
