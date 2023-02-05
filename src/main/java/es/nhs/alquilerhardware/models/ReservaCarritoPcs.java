package es.nhs.alquilerhardware.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Neil Hdez
 * this class is a model of the table reserva_carrito_pcs
 */

@Entity
@Table(name = "reserva_carrito_pcs")
@Getter
@Setter
public class ReservaCarritoPcs
{

    /**
     * Attribute - reservation identifier
     */
    @EmbeddedId
    private ReservaCarritoPcsId reservaCarritoPcsId;

    /**
     * Attribute - professor identifier
     */
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor            idProfesor;

    /**
     * Attribute - classroom identifier
     */
    @ManyToOne
    @JoinColumn(name = "id_carrito_pcs")
    @MapsId("idCarritoPcs")
    private CarritoPcs          idCarritoPcs;

    /**
     * Attribute - location of the loan
     */
    @Column
    private String              ubicacionPrestamo;

    /**
     * Constructor empty
     */
    public ReservaCarritoPcs()
    {

    }

    /**
     * Constructor with parameters
     * @param reservaCarritoPcsId reservation identifier
     * @param idProfesor professor identifier
     * @param idCarritoPcs classroom identifier
     * @param ubicacionPrestamo location of the loan
     */
    public ReservaCarritoPcs(ReservaCarritoPcsId reservaCarritoPcsId, Profesor idProfesor, CarritoPcs idCarritoPcs, String ubicacionPrestamo)
    {
        this.reservaCarritoPcsId = reservaCarritoPcsId;
        this.idProfesor = idProfesor;
        this.idCarritoPcs = idCarritoPcs;
        this.ubicacionPrestamo = ubicacionPrestamo;
    }
}
