package es.nhs.alquilerhardware.models;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 11/01/2023
 */
@Entity
@Table(name = "reserva_aula")
public class ReservaAula
{

    @EmbeddedId
    private ReservaAulaId reservaAulaId;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor idProfesor;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    @MapsId("idAula")
    private AulaInformatica idAula;

    public ReservaAula()
    {

    }

    public ReservaAula(ReservaAulaId reservaAulaId, Profesor idProfesor, AulaInformatica idAula)
    {
        this.reservaAulaId = reservaAulaId;
        this.idProfesor = idProfesor;
        this.idAula = idAula;
    }

    public ReservaAulaId getReservaAulaId()
    {
        return reservaAulaId;
    }

    public void setReservaAulaId(ReservaAulaId reservaAulaId)
    {
        this.reservaAulaId = reservaAulaId;
    }

    public Profesor getIdProfesor()
    {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor)
    {
        this.idProfesor = idProfesor;
    }

    public AulaInformatica getIdAula()
    {
        return idAula;
    }

    public void setIdAula(AulaInformatica idAula)
    {
        this.idAula = idAula;
    }

}
