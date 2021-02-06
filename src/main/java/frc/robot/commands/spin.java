/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.singleMotor;



public class spin extends CommandBase {
  /**
   * Creates a new drivingCommant.
   */
  private final singleMotor m_singleMotor; 

  
  public spin(singleMotor sm) {
       m_singleMotor = sm; 
    // Use addRequirements() here to declare subsystem dependencies.              //this part is all necessary, beats me why just do it 
 // copies reference from the actual controller -> now it's static and can be used in execute()

    addRequirements(m_singleMotor);  //nothing else can use drivtrain while this command is running 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_singleMotor.setMotor(Constants.singleMotorSpeed); 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {  //TODO add stop function 
    m_singleMotor.setMotor(0); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
