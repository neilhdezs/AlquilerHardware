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
@Table(name = "aula_informatica")
public class AulaInformatica
{
    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 2, nullable = false)
    private Integer numeroAula;

    @Column(length = 1, nullable = false)
    private Integer planta;

    public AulaInformatica()
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

    public Integer getNumeroAula()
    {
        return numeroAula;
    }

    public void setNumeroAula(Integer numeroAula)
    {
        this.numeroAula = numeroAula;
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
