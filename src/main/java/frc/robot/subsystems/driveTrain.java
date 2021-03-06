/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveTrain extends SubsystemBase {
  
  /**
   * Creates a new driveTrain.
   */

  private final WPI_TalonSRX leftTalon = new WPI_TalonSRX(Constants.TalonPortLeft);     //sets up motor controllers, make sure to use WPI_TalonSRX
  private final WPI_TalonSRX rightTalon = new WPI_TalonSRX(Constants.TalonPortRight);
  public final DifferentialDrive WeenWad =new DifferentialDrive(leftTalon, rightTalon);     //differential drive 

  public driveTrain() {
    leftTalon.setInverted(InvertType.InvertMotorOutput);
    rightTalon.setInverted(InvertType.InvertMotorOutput);
  }
  


  public void arcadeDrive(double forwardSpeed, double turnSpeed) {
    WeenWad.arcadeDrive(forwardSpeed, turnSpeed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
