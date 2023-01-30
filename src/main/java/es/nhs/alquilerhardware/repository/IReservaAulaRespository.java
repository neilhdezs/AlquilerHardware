package es.nhs.alquilerhardware.repository;

import es.nhs.alquilerhardware.models.ReservaAula;
import es.nhs.alquilerhardware.models.ReservaAulaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaAulaRespository extends JpaRepository<ReservaAula, ReservaAulaId>
{

}

