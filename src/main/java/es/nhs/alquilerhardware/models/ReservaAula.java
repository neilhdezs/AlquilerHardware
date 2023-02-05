package es.nhs.alquilerhardware.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Neil Hdez
 * this class is a model of the table reserva_aula
 */
@Entity
@Table(name = "reserva_aula")
@Getter
@Setter
public class ReservaAula
{

    /**
     * Attribute - reservation identifier
     */
    @EmbeddedId
    private ReservaAulaId   reservaAulaId;

    /**
     * Attribute - professor identifier
     */
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor        idProfesor;

    /**
     * Attribute - classroom identifier
     */
    @ManyToOne
    @JoinColumn(name = "id_aula")
    @MapsId("idAula")
    private AulaInformatica idAula;

    /**
     * Constructor empty
     */
    public ReservaAula()
    {

    }

    /**
     * Constructor with parameters
     * @param reservaAulaId reservation identifier
     * @param idProfesor professor identifier
     * @param idAula classroom identifier
     */
    public ReservaAula(ReservaAulaId reservaAulaId, Profesor idProfesor, AulaInformatica idAula)
    {
        this.reservaAulaId = reservaAulaId;
        this.idProfesor = idProfesor;
        this.idAula = idAula;
    }
}
