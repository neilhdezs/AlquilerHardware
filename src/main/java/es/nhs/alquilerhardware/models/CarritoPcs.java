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
@Table(name = "carrito_pcs")
public class CarritoPcs
{

    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 10, nullable = false)
    private Integer numeroPcs;

    @Column(length = 1, nullable = false)
    private Integer planta;

    @Column(length = 25, nullable = false)
    private String sistemaOperativo;

    public CarritoPcs()
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

    public Integer getNumeroPcs()
    {
        return numeroPcs;
    }

    public void setNumeroPcs(Integer numeroPcs)
    {
        this.numeroPcs = numeroPcs;
    }

    public Integer getPlanta()
    {
        return planta;
    }

    public void setPlanta(Integer planta)
    {
        this.planta = planta;
    }

    public String getSistemaOperativo()
    {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo)
    {
        this.sistemaOperativo = sistemaOperativo;
    }
}
