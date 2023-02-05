package es.nhs.alquilerhardware.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Neil Hdez
 * this class is a model of the table carrito_pcs
 */
@Entity
@Table(name = "carrito_pcs")
@Getter
@Setter
public class CarritoPcs
{

    /**
     * Attribute - cart identifier
     */
    @Id
    @Column(length = 10)
    private Long    id;

    /**
     * Attribute - number of pcs in the cart
     */
    @Column(length = 10, nullable = false)
    private Integer numeroPcs;

    /**
     * Attribute - floor number of the cart
     */
    @Column(length = 1, nullable = false)
    private Integer planta;

    /**
     * Attribute - operating system of the pc
     */
    @Column(length = 25, nullable = false)
    private String  sistemaOperativo;

    /**
     * Constructor empty
     */
    public CarritoPcs()
    {

    }

}
