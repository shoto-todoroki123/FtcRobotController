package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class ClawExtender {
    Servo left, right;
   public static double D1 = 3.1415;
    public static double D2 = 3.1415;
    public static double offset = 1;
    public static double leftMax = 0.58;
    public static double leftMin = 0.45;
    public static double rightMin = 0.4;
    public static double rightMax = 0.65;

    public ClawExtender(HardwareMap hardwareMap){
        this.left = hardwareMap.get(Servo.class, "left_slide");
        this.right = hardwareMap.get(Servo.class, "right_slide");

    }
    public void setServoAngles(double position){
        this.left.setPosition(1-position);
        this.right.setPosition(position);

    }
    public void setSlideDistance(double position){
        double theta = Math.asin((Math.sqrt(D2*D2-position*position)+offset)/D1);

    }
    public void pushClawOut(){
        this.left.setPosition(leftMax);
        this.right.setPosition(rightMin);
    }
    public void pushClawIn(){
        this.left.setPosition(leftMin);
        this.right.setPosition(rightMax);
    }

}