package es.nhs.alquilerhardware.models;

import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 11/01/2023
 */

@Embeddable
public class ReservaAulaId implements Serializable
{

    @Serial
    private static final long serialVersionUID = 5633180930259958017L;

    private Long idAula;

    private Date fecha;

    public ReservaAulaId()
    {

    }

    public ReservaAulaId(Long idAula, Date fecha)
    {
        this.idAula = idAula;
        this.fecha = fecha;
    }

    public Long getIdAula()
    {
        return idAula;
    }

    public void setIdAula(Long idAula)
    {
        this.idAula = idAula;
    }

    public Date getFecha()
    {
        return this.fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }
}
