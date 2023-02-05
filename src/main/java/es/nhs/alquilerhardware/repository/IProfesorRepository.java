package es.nhs.alquilerhardware.repository;

import es.nhs.alquilerhardware.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neil Hdez
 * this interface is a repository of the table profesor
 */
public interface IProfesorRepository extends JpaRepository<Profesor, Long>
{

}
