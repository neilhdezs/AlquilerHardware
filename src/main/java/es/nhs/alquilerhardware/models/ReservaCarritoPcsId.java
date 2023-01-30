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
public class ReservaCarritoPcsId implements Serializable
{

    private static final long serialVersionUID = -2414994027646356688L;

    private Long idCarritoPcs;

    private Date fecha;

    public ReservaCarritoPcsId()
    {

    }

    public ReservaCarritoPcsId(Long idCarritoPcs, Date fecha)
    {
        this.idCarritoPcs = idCarritoPcs;
        this.fecha = fecha;
    }

    public Long getIdCarritoPcs()
    {
        return idCarritoPcs;
    }

    public void setIdCarritoPcs(Long idCarritoPcs)
    {
        this.idCarritoPcs = idCarritoPcs;
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
