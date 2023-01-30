package es.nhs.alquilerhardware.repository;

import es.nhs.alquilerhardware.models.AulaInformatica;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAulaInformaticaRepository extends JpaRepository<AulaInformatica, Long>
{

}
