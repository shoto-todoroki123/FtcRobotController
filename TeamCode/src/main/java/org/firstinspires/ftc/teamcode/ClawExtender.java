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
    public static int max1 = 300;
    public static int min2 = 0;
    public static int max2 = 310;
    public static double verticalOffset = 59;



    public  ClawExtender(HardwareMap hardwareMap){
        this.Arm1 = hardwareMap.get(DcMotorEx.class, "Arm1");
        this.Arm2 = hardwareMap.get(DcMotorEx.class, "Arm2");

        this.reset();
    }
    public void pushClawOut(){
        this.Arm1.setTargetPosition(max1);
        this.Arm2.setTargetPosition(max2);
    }
    public void pushClawIn(){
        this.Arm1.setTargetPosition( min1);
        this.Arm2.setTargetPosition(min2);
    }

     public void reset() {
        this.Arm1.setTargetPosition(0);
        this.Arm1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.Arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.Arm1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.Arm1.setPower(.05);
        this.Arm2.setTargetPosition(0);
        this.Arm1.setDirection(DcMotorSimple.Direction.REVERSE);
        this.Arm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.Arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.Arm2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.Arm2.setPower(-.05);
     }




    public void update() {
    }
}

