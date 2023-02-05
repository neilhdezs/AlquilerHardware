package es.nhs.alquilerhardware.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Neil Hdez
 * this class is a model of the table reserva_carrito_tablets
 */

@Entity
@Table(name = "reserva_carrito_tablets")
@Getter
@Setter
public class ReservaCarritoTablets
{

    /**
     * Attribute - reservation identifier
     */
    @EmbeddedId
    private ReservaCarritoTabletsId reservaCarritoTabletsId;

    /**
     * Attribute - professor identifier
     */
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor                idProfesor;

    /**
     * Attribute - classroom identifier
     */
    @ManyToOne
    @JoinColumn(name = "id_carrito_tablets")
    @MapsId("idCarritoTablets")
    private CarritoTablets          idCarritoTablets;

    /**
     * Attribute - location of the loan
     */
    @Column
    private String                  ubicacionPrestamo;

    /**
     * Constructor empty
     */
    public ReservaCarritoTablets()
    {

    }

    /**
     * Constructor with parameters
     * @param reservaCarritoTabletsId reservation identifier
     * @param idProfesor professor identifier
     * @param idCarritoTablets classroom identifier
     * @param ubicacionPrestamo location of the loan
     */
    public ReservaCarritoTablets(ReservaCarritoTabletsId reservaCarritoTabletsId, Profesor idProfesor, CarritoTablets idCarritoTablets, String ubicacionPrestamo)
    {
        this.reservaCarritoTabletsId = reservaCarritoTabletsId;
        this.idProfesor = idProfesor;
        this.idCarritoTablets = idCarritoTablets;
        this.ubicacionPrestamo = ubicacionPrestamo;
    }
}
