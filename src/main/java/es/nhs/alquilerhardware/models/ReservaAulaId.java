package es.nhs.alquilerhardware.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Neil Hdez
 * this class is the primary key of the table reserva_aula
 */

@Embeddable
@Getter
@Setter
public class ReservaAulaId implements Serializable
{

    /**
     * serial version
     */
    @Serial
    private static final long serialVersionUID = 5633180930259958017L;

    /**
     * Attribute - classroom identifier
     */
    private Long              idAula;

    /**
     * Attribute - date
     */
    private Date              fecha;

    /**
     * Constructor empty
     */
    public ReservaAulaId()
    {

    }

    /**
     * Constructor with parameters
     * @param idAula classroom identifier
     * @param fecha date
     */
    public ReservaAulaId(Long idAula, Date fecha)
    {
        this.idAula = idAula;
        this.fecha = fecha;
    }
}
