
package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class singleMotor extends SubsystemBase {

    public WPI_TalonSRX myTalon = new WPI_TalonSRX(Constants.frontSingle);

    //subsystem to spin a single motor on the front of the bot at a given speed

    public singleMotor(){

    }

    public void setMotor(double speed) {
        myTalon.set(speed); 
    }
}