package org.usfirst.frc.team1002.robot.subsystems;

import org.usfirst.frc.team1002.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    CANTalon forkliftMotor;
    DigitalInput limitSensorTop;
    DigitalInput limitSensorBot;
    
    public Forklift(){
    	forkliftMotor = new CANTalon(RobotMap.forkliftMotor);
    	limitSensorTop = new DigitalInput(RobotMap.limitTop);
    	limitSensorBot = new DigitalInput(RobotMap.limitBot);
    	this.sstopLift();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public void LiftUp(){
    	if (limitSensorTop.get()) forkliftMotor.set(-1); else forkliftMotor.set(0);
    	
    }
    
    public void sstopLift(){
    	forkliftMotor.set(0);
    }
    
    public void LiftDown(){
    	if (limitSensorBot.get()) forkliftMotor.set(1); else forkliftMotor.set(0);
    }
    
    public boolean getLimit(){
    	return limitSensorTop.get();
    }
}

