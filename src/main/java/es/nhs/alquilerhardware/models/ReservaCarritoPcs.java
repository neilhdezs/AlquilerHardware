package es.nhs.alquilerhardware.models;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 11/01/2023
 */

@Entity
@Table(name = "reserva_carrito_pcs")
public class ReservaCarritoPcs
{

    @EmbeddedId
    private ReservaCarritoPcsId reservaCarritoPcsId;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor idProfesor;

    @ManyToOne
    @JoinColumn(name = "id_carrito_pcs")
    @MapsId("idCarritoPcs")
    private CarritoPcs idCarritoPcs;

    @Column
    private String ubicacionPrestamo;

    public ReservaCarritoPcs()
    {

    }

    public ReservaCarritoPcs(ReservaCarritoPcsId reservaCarritoPcsId, Profesor idProfesor, CarritoPcs idCarritoPcs, String ubicacionPrestamo)
    {
        this.reservaCarritoPcsId = reservaCarritoPcsId;
        this.idProfesor = idProfesor;
        this.idCarritoPcs = idCarritoPcs;
        this.ubicacionPrestamo = ubicacionPrestamo;
    }

    public ReservaCarritoPcsId getReservaCarritoPcsId()
    {
        return reservaCarritoPcsId;
    }

    public void setReservaCarritoPcsId(ReservaCarritoPcsId reservaCarritoPcsId)
    {
        this.reservaCarritoPcsId = reservaCarritoPcsId;
    }

    public Profesor getIdProfesor()
    {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor)
    {
        this.idProfesor = idProfesor;
    }

    public CarritoPcs getIdCarritoPcs()
    {
        return idCarritoPcs;
    }

    public void setIdCarritoPcs(CarritoPcs idCarritoPcs)
    {
        this.idCarritoPcs = idCarritoPcs;
    }

	public String getUbicacionPrestamo()
    {
        return ubicacionPrestamo;
    }

    public void setUbicacionPrestamo(String ubicacionPrestamo)
    {
        this.ubicacionPrestamo = ubicacionPrestamo;
    }
}
