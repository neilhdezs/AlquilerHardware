package es.nhs.alquilerhardware.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 11/01/2023
 */
@Entity
@Table(name = "carrito_tablets")
public class CarritoTablets
{

    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 10, nullable = false)
    private Integer numeroTablets;

    @Column(length = 1, nullable = false)
    private Integer planta;

    public CarritoTablets()
    {

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getNumeroTablets()
    {
        return numeroTablets;
    }

    public void setNumeroTablets(Integer numeroTablets)
    {
        this.numeroTablets = numeroTablets;
    }

    public Integer getPlanta()
    {
        return planta;
    }

    public void setPlanta(Integer planta)
    {
        this.planta = planta;
    }
}
