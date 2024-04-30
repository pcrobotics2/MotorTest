// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.MotorTestCMD;
import frc.robot.commands.SysIdCMDs;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.MotorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import static edu.wpi.first.units.Units.Volts;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public CommandJoystick controller0 = new CommandJoystick(0);
  public MotorSubsystem motorSubsystem = new MotorSubsystem();
  public MotorTestCMD motorTestCMD = new MotorTestCMD(motorSubsystem);
  public SysIdCMDs sysIdCMDs;

  // Replace with CommandPS4Controller or CommandJoystick if needed

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    controller0.button(Constants.buttonList.x).toggleOnTrue(motorTestCMD);

    // Create the SysId routine
  SysIdRoutine sysIdRoutine = new SysIdRoutine(
  new SysIdRoutine.Config(),
  new SysIdRoutine.Mechanism(
    (voltage) -> this.motorSubsystem.runVolts(voltage.in(Volts)),
    null, // No log consumer, since data is recorded by URCL
    this.motorSubsystem
  )

);
  this.sysIdCMDs = new SysIdCMDs(motorSubsystem, sysIdRoutine);

// The methods below return Command objects
sysIdRoutine.quasistatic(SysIdRoutine.Direction.kForward);
sysIdRoutine.quasistatic(SysIdRoutine.Direction.kReverse);
sysIdRoutine.dynamic(SysIdRoutine.Direction.kForward);
sysIdRoutine.dynamic(SysIdRoutine.Direction.kReverse);

// AdvantageKit users should log the test state using the following configuration
// new SysIdRoutine.Config(
//   null, null, null,
//   (state) -> Logger.recorded("SysIdTestState", state.toString())
// ); 
    controller0.button(Constants.buttonList.b).toggleOnTrue(sysIdRoutine.quasistatic(SysIdRoutine.Direction.kForward)
);
    controller0.button(Constants.buttonList.a).toggleOnTrue(sysIdRoutine.quasistatic(SysIdRoutine.Direction.kReverse));
    controller0.button(Constants.buttonList.x).toggleOnTrue(sysIdRoutine.dynamic(SysIdRoutine.Direction.kForward));
    controller0.button(Constants.buttonList.y).toggleOnTrue(sysIdRoutine.dynamic(SysIdRoutine.Direction.kReverse));





  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}