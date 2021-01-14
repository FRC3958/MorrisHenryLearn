/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveTrain extends SubsystemBase {
  /**
   * Creates a new driveTrain.
   */
  private final WPI_TalonSRX leftTalon = new WPI_TalonSRX(Constants.TalonPortLeft);
  private final WPI_TalonSRX rightTalon = new WPI_TalonSRX(Constants.TalonPortRight);
  public final DifferentialDrive WeenWad =new DifferentialDrive(leftTalon, rightTalon);

  public driveTrain() {
  }

  public void drivingMethod(XboxController controller, double speed) {
    WeenWad.arcadeDrive(controller.getRawAxis(Constants.LeftJoystickYAxis)*speed, controller.getRawAxis(Constants.RightJoystickXAxis)*speed); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
