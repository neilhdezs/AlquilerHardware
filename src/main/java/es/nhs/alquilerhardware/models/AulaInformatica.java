package es.nhs.alquilerhardware.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Neil Hdez
 * Class that contains the information of the computer classroom
 */
@Entity
@Table(name = "aula_informatica")
@Getter
@Setter
public class AulaInformatica
{
    /**
     * Attribute - Classroom identifier
     */
    @Id
    @Column(length = 10)
    private Long    id;

    /**
     * Attribute - Classroom number
     */
    @Column(length = 2, nullable = false)
    private Integer numeroAula;

    /**
     * Attribute - Classroom floor
     */
    @Column(length = 1, nullable = false)
    private Integer planta;

    /**
     * Constructor empty
     */
    public AulaInformatica()
    {

    }
}
