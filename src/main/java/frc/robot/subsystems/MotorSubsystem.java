// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix.Logger;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
public class MotorSubsystem extends SubsystemBase {
  /** Creates a new MotorSubsystem. */
  public CANSparkMax motor;
  public SysIdRoutine sysIdRoutine;
  public MotorSubsystem() {
    this.motor = new CANSparkMax(22, MotorType.kBrushless); //replace number with CS## on MotorController
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotor(double speed){
    motor.set(speed);
  }
  public void runVolts(double voltage) {
    motor.setVoltage(voltage);
    System.out.println("voltage: " + voltage);
  }
}
