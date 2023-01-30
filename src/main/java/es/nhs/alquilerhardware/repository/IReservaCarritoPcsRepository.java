package es.nhs.alquilerhardware.repository;

import es.nhs.alquilerhardware.models.ReservaCarritoPcs;
import es.nhs.alquilerhardware.models.ReservaCarritoPcsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaCarritoPcsRepository extends JpaRepository<ReservaCarritoPcs, ReservaCarritoPcsId>
{

}