package es.nhs.alquilerhardware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Neil Hdez
 * this class is the main class of the project
 */
@SpringBootApplication (scanBasePackages = {"es.nhs.alquilerhardware"})
public class AlquilerHardwareApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(AlquilerHardwareApplication.class, args);
    }
}
