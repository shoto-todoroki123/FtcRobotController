package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;


@Config
public class ClawExtender {
    DcMotorEx Arm1;
    DcMotorEx Arm2;

    public static int min = 0;
    public static int max = 60;
    public static double verticalOffset = 59;



    public  ClawExtender(HardwareMap hardwareMap){
        this.Arm1 = hardwareMap.get(DcMotorEx.class, "Arm1");
        this.Arm2 = hardwareMap.get(DcMotorEx.class, "Arm2");

        this.reset();
    }
    public void pushClawOut(){
        this.Arm1.setTargetPosition(min);
        this.Arm2.setTargetPosition(max);
    }
    public void pushClawIn(){
        this.Arm1.setTargetPosition( max);
        this.Arm2.setTargetPosition(min);
    }

     public void reset() {
        this.Arm1.setTargetPosition(0);
        this.Arm1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.Arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.Arm1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.Arm1.setPower(1);
        this.Arm2.setTargetPosition(0);
        this.Arm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.Arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.Arm2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.Arm2.setPower(1);
     }




    public void update() {
    }
}

