package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;


@Config
public class ClawExtender {
    static DcMotorEx Arm1;
    static DcMotorEx Arm2;

    public static int min1 = 0;
    public static int max1 = 370;
    public static int min2 = 20;
    public static int max2 = 550;
    public static double verticalOffset = 59;
    public static double P1 = 1;
    public static double I1 = 1;
    public static double D1 = 100;
    public static double F1 = 1;
    public static double P2 = 1;
    public static double I2 = 1;
    public static double D2 = 100;
    public static double F2 = 1;



    public  ClawExtender(HardwareMap hardwareMap){
        this.Arm1 = hardwareMap.get(DcMotorEx.class, "Arm1");
        this.Arm2 = hardwareMap.get(DcMotorEx.class, "Arm2");

        this.reset();
    }
    public void pushClawOut(){
        this.Arm2.setPower(-.4);
        this.Arm1.setTargetPosition(max1);
        this.Arm2.setTargetPosition(max2);
    }
    public void pushClawIn() /*throws InterruptedException*/ {
       /* while(Arm1.getCurrentPosition()!=60 &&Arm2.getCurrentPosition()!=60) {
            this.Arm1.setTargetPosition(60);
            this.Arm2.setTargetPosition(60);
        }*/
            this.Arm1.setTargetPosition(min1+15);
            this.Arm2.setTargetPosition(min2+15);


    }

    public void hangyPart() {
        this.Arm1.setPower(1);
        this.Arm2.setPower(1);
        this.Arm1.setTargetPosition(min1);
        this.Arm2.setTargetPosition(min2);
    }
    public void overBlocks(){
        this.Arm1.setTargetPosition(min1);
        this.Arm2.setTargetPosition(min2);
    }
    public void armDown() {
        this.Arm2.setTargetPosition(min2);
        this.Arm2.setPower(0);
    }


    public void reset() {
        this.Arm1.setTargetPosition(0);
        this.Arm1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.Arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.Arm1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.Arm1.setPower(.4);
        this.Arm2.setTargetPosition(20);
        this.Arm1.setDirection(DcMotorSimple.Direction.REVERSE);
        this.Arm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.Arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.Arm2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.Arm2.setPower(-.4);
     }



    public void update(){
        PIDFCoefficients coefficients = new PIDFCoefficients(P1,I1,D1,F1);
        this.Arm1.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, coefficients);
        PIDFCoefficients coefficient = new PIDFCoefficients(P2,I2,D2,F2);
        this.Arm2.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, coefficient);
    }


}

