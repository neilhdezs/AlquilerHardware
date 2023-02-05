package es.nhs.alquilerhardware.repository;

import es.nhs.alquilerhardware.models.ReservaCarritoPcs;
import es.nhs.alquilerhardware.models.ReservaCarritoPcsId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neil Hdez
 * this interface is a repository of the table reserva_carrito_pcs
 */
public interface IReservaCarritoPcsRepository extends JpaRepository<ReservaCarritoPcs, ReservaCarritoPcsId>
{

}