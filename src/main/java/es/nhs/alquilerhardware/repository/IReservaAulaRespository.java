package es.nhs.alquilerhardware.repository;

import es.nhs.alquilerhardware.models.ReservaAula;
import es.nhs.alquilerhardware.models.ReservaAulaId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neil Hdez
 * this interface is a repository of the table reserva_aula
 */
public interface IReservaAulaRespository extends JpaRepository<ReservaAula, ReservaAulaId>
{

}

