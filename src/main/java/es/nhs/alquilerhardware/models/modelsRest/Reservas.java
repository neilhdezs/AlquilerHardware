package es.nhs.alquilerhardware.models.modelsRest;

import es.nhs.alquilerhardware.models.ReservaAula;
import es.nhs.alquilerhardware.models.ReservaCarritoPcs;
import es.nhs.alquilerhardware.models.ReservaCarritoTablets;

import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 19/01/2023
 */
public class Reservas
{

    private List<ReservaAula> listaReservasAulas;

    private List<ReservaCarritoTablets> listaReservasTablets;

    private List<ReservaCarritoPcs> listaReservasOrdenadores;

    public Reservas(List<ReservaAula> listaReservasAulas, List<ReservaCarritoTablets> listaReservasTablets, List<ReservaCarritoPcs> listaReservasOrdenadores)
    {
        this.listaReservasAulas = listaReservasAulas;
        this.listaReservasTablets = listaReservasTablets;
        this.listaReservasOrdenadores = listaReservasOrdenadores;
    }

    public List<ReservaAula> getListaReservasAulas()
    {
        return listaReservasAulas;
    }

    public void setListaReservasAulas(List<ReservaAula> listaReservasAulas)
    {
        this.listaReservasAulas = listaReservasAulas;
    }

    public List<ReservaCarritoTablets> getListaReservasTablets()
    {
        return listaReservasTablets;
    }

    public void setListaReservasTablets(List<ReservaCarritoTablets> listaReservasTablets)
    {
        this.listaReservasTablets = listaReservasTablets;
    }

    public List<ReservaCarritoPcs> getListaReservasOrdenadores()
    {
        return listaReservasOrdenadores;
    }

    public void setListaReservasOrdenadores(List<ReservaCarritoPcs> listaReservasOrdenadores)
    {
        this.listaReservasOrdenadores = listaReservasOrdenadores;
    }

    @Override
    public String toString()
    {
        return "Reservas{" +
                "listaReservasAulas=" + listaReservasAulas +
                ", listaReservasTablets=" + listaReservasTablets +
                ", listaReservasOrdenadores=" + listaReservasOrdenadores +
                '}';
    }
}
