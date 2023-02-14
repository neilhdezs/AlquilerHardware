package es.nhs.alquilerhardware.repository;

import es.nhs.alquilerhardware.models.AulaInformatica;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neil Hdez
 * this interface is a repository of the table aula_informatica
 */
public interface IAulaInformaticaRepository extends JpaRepository<AulaInformatica, Long>
{



}
