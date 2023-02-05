package es.nhs.alquilerhardware.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Neil Hdez
 * this class is a model of the table profesor
 */
@Entity
@Table(name = "profesor")
@Getter
@Setter
public class Profesor
{

    /**
     * Attribute - professor identifier
     */
    @Id
    @Column(length = 10)
    private Long   id;

    /**
     * Attribute - professor name
     */
    @Column(length = 25, nullable = false)
    private String nombre;

    /**
     * Attribute - professor surname
     */
    @Column(length = 50, nullable = false)
    private String apellidos;

    public Profesor()
    {
    }
}
