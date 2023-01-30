package es.nhs.alquilerhardware.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 11/01/2023
 */

@Embeddable
public class ReservaCarritoTabletsId implements Serializable
{

    private static final long serialVersionUID = -2414994027646356688L;


    private Long idCarritoTablets;

    private Date fecha;

    public ReservaCarritoTabletsId()
    {

    }

    public ReservaCarritoTabletsId(Long idCarritoTablets, Date fecha)
    {
        this.idCarritoTablets = idCarritoTablets;
        this.fecha = fecha;
    }

    public Long getIdCarritoTablets()
    {
        return idCarritoTablets;
    }

    public void setIdCarritoTablets(Long idCarritoTablets)
    {
        this.idCarritoTablets = idCarritoTablets;
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
