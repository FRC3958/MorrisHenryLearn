/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.drivingCommand;
import frc.robot.commands.spin;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.singleMotor;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final XboxController driverController = new XboxController(Constants.XboxPort);

  public driveTrain m_DrivingTrain = new driveTrain();
  public singleMotor m_singleMotor = new singleMotor(); 

  public drivingCommand m_drivingCommand = new drivingCommand(m_DrivingTrain, driverController); 
  public spin m_spin = new spin(m_singleMotor); 

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
 
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    SmartDashboard.putNumber("Speed", .5);    //puts speed limiter 
    SmartDashboard.putNumber("Front Speed", .1);
    SmartDashboard.putString("Limelight IP", "http://10.39.58.11:5801/");     //type this in browser to get camera feed 
    
    // Configure the button bindings
    configureButtonBindings();
  }

  /*
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@linkpP
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
  */
  private void configureButtonBindings() {
    m_DrivingTrain.setDefaultCommand(m_drivingCommand);
    
        //TODO change smartDashboard speed to something else, "Speed" is the limit for the driveTrain 
    new JoystickButton(driverController, Constants.aButtonController)   //makes button 
      .whenPressed(() -> m_singleMotor.setMotor(SmartDashboard.getNumber("Front Speed", .5)))   //grabs speed to set from smartDashboard
      .whenReleased(() -> m_singleMotor.setMotor(0))  //lambda, for minor functions that don't deserve
      ;                                               //a full command, directly call method from subsystem

    new JoystickButton(driverController, Constants.bButtonController)   //bound to b 
      .whenPressed(() -> table.getEntry("ledMode").setNumber(1))
      .whenReleased(() -> table.getEntry("ledMode").setNumber(0))   //lambda to turn led on/off on limelight
      ; 

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
 // public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
   // return m_autoCommand;
  }

