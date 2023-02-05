package es.nhs.alquilerhardware.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Neil Hdez
 * this class is a model of the table carrito_tablets
 */
@Entity
@Table(name = "carrito_tablets")
@Getter
@Setter
public class CarritoTablets
{

    /**
     * Attribute - cart tablet identifier
     */
    @Id
    @Column(length = 10)
    private Long    id;

    /**
     * Attribute - number of tablets in the cart
     */
    @Column(length = 10, nullable = false)
    private Integer numeroTablets;

    /**
     * Attribute - floor number of the cart
     */
    @Column(length = 1, nullable = false)
    private Integer planta;

    public CarritoTablets()
    {
    }

}
