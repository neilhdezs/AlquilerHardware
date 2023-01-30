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
@Table(name = "profesor")
public class Profesor
{

    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 25, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellidos;

    public Profesor()
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

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }
}
