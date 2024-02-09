// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

public class MotorTestCMD extends Command {
  public MotorSubsystem motorSubsystem;
  /** Creates a new MotorTest. */
  public MotorTestCMD(MotorSubsystem motorSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.motorSubsystem = motorSubsystem;
    addRequirements(motorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    motorSubsystem.setMotor(0.05);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motorSubsystem.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
