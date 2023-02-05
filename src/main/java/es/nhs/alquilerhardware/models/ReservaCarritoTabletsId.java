package es.nhs.alquilerhardware.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Neil Hdez
 * this class is the primary key of the table reserva_carrito_tablets
 */

@Embeddable
@Getter
@Setter
public class ReservaCarritoTabletsId implements Serializable
{

    /**
     * serial version
     */
    private static final long serialVersionUID = -2414994027646356688L;

    /**
     * Attribute - cart tablets identifier
     */
    private Long              idCarritoTablets;

    /**
     * Attribute - date of the reservation
     */
    private Date              fecha;

    /**
     * Constructor empty
     */
    public ReservaCarritoTabletsId()
    {

    }

    /**
     * Constructor with parameters
     * @param idCarritoTablets cart tablets identifier
     * @param fecha date of the reservation
     */
    public ReservaCarritoTabletsId(Long idCarritoTablets, Date fecha)
    {
        this.idCarritoTablets = idCarritoTablets;
        this.fecha = fecha;
    }
}
