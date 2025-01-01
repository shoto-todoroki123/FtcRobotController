package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class ClawExtender {
    Servo left, right;
    double D1 = 3.1415;
    double D2 = 3.1415;
    double offset = 1;

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

}