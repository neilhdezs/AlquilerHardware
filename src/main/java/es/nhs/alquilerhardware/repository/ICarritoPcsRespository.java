package es.nhs.alquilerhardware.repository;

import es.nhs.alquilerhardware.models.CarritoPcs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neil Hdez
 * this interface is a repository of the table carrito_pcs
 */
public interface ICarritoPcsRespository extends JpaRepository<CarritoPcs, Long>
{

}
