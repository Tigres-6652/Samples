
package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {

  // declaracion de control
XboxController controller = new XboxController(0);
  // declaracion de electrovalvulas segun el canal de la PCM
  Solenoid piston1 = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
  Solenoid piston2 = new Solenoid(PneumaticsModuleType.CTREPCM, 1);

  // variable
  boolean Acci_Pist = false; // variable para el accionamiento de piston

  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {

    /*
     * El piston conectado por el puerto 0 de la PCM se prendera
     * cuando se mantenga presionado el boton A del control conectado
     * por el puerto 0 de la Drive Station (El piston estara afuera siempre que se presione ese boton)
     */
      piston1.set(controller.getAButtonReleased());



      /*
     * El piston conectado por el puerto 1 de la PCM se prendera
     * cuando se presione el boton B del control
     * por el puerto 0 de la Drive Station, sin la necesidad de dejarle presionado
     */

    if (controller.getBButtonReleased()) {      //Cuando se presione el boton del control entrara al if

      if (Acci_Pist) {                          /*Si detecta que la variable esta en true accionara el piston
                                                y pondra la variable en false para que la proxima vez que se 
                                                presione el boton se cambie al lugar donde la variable es false y 
                                                pondra la variable en true para que asi se cicle */
        piston2.set(true);
        Acci_Pist = false;
        
      } else {

        piston2.set(false);
        Acci_Pist = true;

      }
    }

  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
