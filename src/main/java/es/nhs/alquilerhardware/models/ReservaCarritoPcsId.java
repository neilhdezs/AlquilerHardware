package es.nhs.alquilerhardware.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Neil Hdez
 * this class is the primary key of the table reserva_carrito_pcs
 */

@Embeddable
@Getter
@Setter
public class ReservaCarritoPcsId implements Serializable
{

    /**
     * serial version
     */
    @Serial
    private static final long serialVersionUID = -2414994027646356688L;

    /**
     * Attribute - carrito pcs identifier
     */
    private Long idCarritoPcs;

    /**
     * Attribute - date of the reservation
     */
    private Date fecha;

    /**
     * Constructor empty
     */
    public ReservaCarritoPcsId()
    {

    }

    /**
     * Constructor with parameters
     * @param idCarritoPcs carrito pcs identifier
     * @param fecha date of the reservation
     */
    public ReservaCarritoPcsId(Long idCarritoPcs, Date fecha)
    {
        this.idCarritoPcs = idCarritoPcs;
        this.fecha = fecha;
    }

}
