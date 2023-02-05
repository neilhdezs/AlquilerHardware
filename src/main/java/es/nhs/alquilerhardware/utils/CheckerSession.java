package es.nhs.alquilerhardware.utils;

import es.nhs.alquilerhardware.models.ReservaAula;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Hdez
 * this class is used to check if the session is null or not
 */
@Service
public class CheckerSession
{

    public List<ReservaAula> checkSessionReservaAula(List<ReservaAula> reservaAulaList)
    {
        return reservaAulaList == null ? new ArrayList<>() : reservaAulaList;
    }

    public List<ReservaAula> checkSessionReservaCarritoTablets(List<ReservaAula> reservaAulaList)
    {
        return reservaAulaList == null ? new ArrayList<>() : reservaAulaList;
    }

    public List<ReservaAula> checkSessionReservaCarritoPcs(List<ReservaAula> reservaAulaList)
    {
        return reservaAulaList == null ? new ArrayList<>() : reservaAulaList;
    }

}
