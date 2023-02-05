package es.nhs.alquilerhardware.repository;

import es.nhs.alquilerhardware.models.ReservaCarritoTablets;
import es.nhs.alquilerhardware.models.ReservaCarritoTabletsId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neil Hdez
 * this interface is a repository of the table reserva_carrito_tablets
 */
public interface IReservaCarritoTablets extends JpaRepository<ReservaCarritoTablets, ReservaCarritoTabletsId>
{

}
