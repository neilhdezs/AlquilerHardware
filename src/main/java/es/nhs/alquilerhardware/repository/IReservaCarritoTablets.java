package es.nhs.alquilerhardware.repository;

import es.nhs.alquilerhardware.models.ReservaCarritoTablets;
import es.nhs.alquilerhardware.models.ReservaCarritoTabletsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaCarritoTablets extends JpaRepository<ReservaCarritoTablets, ReservaCarritoTabletsId>
{



}
