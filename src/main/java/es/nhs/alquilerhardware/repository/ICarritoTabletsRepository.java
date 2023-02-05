package es.nhs.alquilerhardware.repository;

import es.nhs.alquilerhardware.models.CarritoTablets;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neil Hdez
 * this interface is a repository of the table carrito_tablets
 */
public interface ICarritoTabletsRepository extends JpaRepository<CarritoTablets, Long>
{

}
