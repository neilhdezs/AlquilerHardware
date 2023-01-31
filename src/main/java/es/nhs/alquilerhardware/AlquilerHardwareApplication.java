package es.nhs.alquilerhardware;

import org.hibernate.annotations.SQLInsert;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {"es.nhs.alquilerhardware"})
public class AlquilerHardwareApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(AlquilerHardwareApplication.class, args);
    }


}
