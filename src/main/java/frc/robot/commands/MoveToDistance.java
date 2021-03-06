/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.limelight;

public class MoveToDistance extends CommandBase {
  /**
   * Creates a new MoveToDistance.
   */

  double m_target;
  limelight m_limelight; 

  driveTrain m_driveTrain; 
  public MoveToDistance(double target, driveTrain dt, limelight lm) {
    m_driveTrain = dt;
    m_target = target; 
    m_limelight = lm; 
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      //TODO add driving part, based off of negative/positive distance to target
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double distanceDifference = Math.abs(m_target - m_limelight.getDistanceToTarget()); 
    return distanceDifference <= 1;
  }
}
