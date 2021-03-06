/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

import java.lang.Math; 


public class limelightDistance extends CommandBase {
  /**
   * Creates a new limelightDistance.
   */
  NetworkTable limetable = NetworkTableInstance.getDefault().getTable("limelight");

  public limelightDistance() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    limetable.getEntry("ledMode").setNumber(0);   //turn limelight led on 
    final NetworkTableEntry distance = limetable.getEntry("ty"); //find angle from limelight as a NetworkTableEntry
    final double doubleAngle = distance.getDouble(0.0);         //convert angle to a double
    SmartDashboard.putNumber("LimelightAngle", doubleAngle);    //puts on SmartDashboard for testing purposes, not really necessary 

    final double finalAngle = (Math.PI * (Constants.angleDefault + doubleAngle))/180; //find angle above horizon that the target is, adds in 17 because limelight is tilted up
    SmartDashboard.putNumber("final Angle", finalAngle);                              //also converts to radians for tan function, puts on SmartDashboard for testing 

    final double tanAngle = Math.tan(finalAngle);       //finds tan of angle, represents height of target/distance to target
    SmartDashboard.putNumber("TanAngle", tanAngle);     //derived from tan(angle above horizon) = height to target/distance to target, visualize as a triangle
    
    final double finalDistance = Constants.heightDifferenceInches/tanAngle;   //self explanatory
    SmartDashboard.putNumber("final distance", finalDistance); 



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    limetable.getEntry("ledMode").setNumber(1);     //turns limelight off
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
