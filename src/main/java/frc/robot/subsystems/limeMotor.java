/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.subsystems.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class limeMotor extends SubsystemBase {
  /**
   * Creates a new limeMotor.
   */
  private WPI_TalonSRX frontTalon = new WPI_TalonSRX(Constants.limeMotor);

  public limeMotor() {

  }
  public void setSpeed(double speed){
    frontTalon.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
