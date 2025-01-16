package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;


@Config
public class ClawExtender {
    DcMotorEx double_lift;

    public static int min = 0;
    public static int max = 63;

    public void ClawExtender(HardwareMap hardwareMap){
        this.double_lift = hardwareMap.get(DcMotorEx.class, "double_lift");
        this.reset();
    }
    public void pushClawOut(){
        this.double_lift.setTargetPosition(max);
    }
    public void pushClawIn(){
        this.double_lift.setTargetPosition( min);
    }
     public void reset() {
        this.double_lift.setTargetPosition(0);
        this.double_lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.double_lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.double_lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.double_lift.setPower(1);
     }


    }

