package es.nhs.alquilerhardware.models.modelsRest;

import es.nhs.alquilerhardware.models.ReservaAula;
import es.nhs.alquilerhardware.models.ReservaCarritoPcs;
import es.nhs.alquilerhardware.models.ReservaCarritoTablets;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Neil Hdez
 *
 * Class that contains the list of reservations
 */
@Getter
@Setter
public class Reservas
{

    /**
     * Attribute - List of classroom reservations
     */
    private List<ReservaAula>           listaReservasAulas;

    /**
     * Attribute - List of tablet reservations
     */
    private List<ReservaCarritoTablets> listaReservasTablets;

    /**
     * Attribute - List of computer reservations
     */
    private List<ReservaCarritoPcs>     listaReservasOrdenadores;

    /**
     * Constructor with parameters
     */
    public Reservas(List<ReservaAula> listaReservasAulas, List<ReservaCarritoTablets> listaReservasTablets, List<ReservaCarritoPcs> listaReservasOrdenadores)
    {
        this.listaReservasAulas = listaReservasAulas;
        this.listaReservasTablets = listaReservasTablets;
        this.listaReservasOrdenadores = listaReservasOrdenadores;
    }

}
