package org.usfirst.frc.team4183.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import java.util.ArrayList;

import org.usfirst.frc.team4183.robot.RobotMap;
import org.usfirst.frc.team4183.robot.commands.IntakeSubsystem.Idle;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends BitBucketsSubsystem {
	
	private final WPI_TalonSRX leftIntakeMotor; 
	private final WPI_TalonSRX rightIntakeMotor; 
	private final DoubleSolenoid intakeGate;

	private static ArrayList<WPI_TalonSRX> motors;
	private static ArrayList<DoubleSolenoid> solenoids;

	public IntakeSubsystem() {
		motors = new ArrayList<WPI_TalonSRX>();
		solenoids = new ArrayList<DoubleSolenoid>();
		
		leftIntakeMotor = new WPI_TalonSRX(RobotMap.INTAKE_MOTOR_LEFT_ID);
		rightIntakeMotor = new WPI_TalonSRX(RobotMap.INTAKE_MOTOR_RIGHT_ID);
		motors.add(leftIntakeMotor);
		motors.add(rightIntakeMotor);
		
		intakeGate = new DoubleSolenoid(RobotMap.INTAKE_PNEUMA_OPEN_CHANNEL, RobotMap.INTAKE_PNEUMA_CLOSED_CHANNEL);
		solenoids.add(intakeGate);
		
	}
	public void disable() {
		setAllMotorsZero();
		closegate();
	}
	
	public void closegate() {
		intakeGate.set(DoubleSolenoid.Value.kReverse);
	}
	public void opengate() {
		intakeGate.set(DoubleSolenoid.Value.kForward);
	}
	
	private void setAllMotorsZero() 
	{
		leftIntakeMotor.set(ControlMode.PercentOutput, 0.0);
		rightIntakeMotor.set(ControlMode.PercentOutput, 0.0);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Idle());
    }
	
	@Override
	public void diagnosticsInit() {
		
		// Checks motors for any current
		for(WPI_TalonSRX talon: motors) {
			if(talon.getOutputCurrent() == 0) {
				
			}
		}
	}
	
	@Override
	public void diagnosticsCheck() {
		
	}
	@Override
	public void periodic() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void diagnosticsFlagSet() {
		// TODO Auto-generated method stub
		
	}
}
