package es.nhs.alquilerhardware;


import es.nhs.alquilerhardware.models.*;
import es.nhs.alquilerhardware.models.modelsRest.Reservas;
import es.nhs.alquilerhardware.repository.*;
import es.nhs.alquilerhardware.utils.CheckerDayOfWeek;
import es.nhs.alquilerhardware.utils.CheckerSession;
import es.nhs.alquilerhardware.utils.Constants;
import es.nhs.alquilerhardware.utils.ReservaException;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Neil Hdez
 * this class is a rest controller of the application alquilerhardware
 */
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(produces = {"application/json"})
@RestController //
public class RestHandlerAlquiler
{

    //TODO: Fines de Semana
    //TODO: Cambiar for de eliminar por un for mejor

    /**
     * Logger
     */
    private final Logger LOGGER = LogManager.getLogger(RestHandlerAlquiler.class);

    /**
     * Repository - of the table aula_informatica
     */
    @Autowired
    private IAulaInformaticaRepository aulaInformaticaRepository;

    /**
     * Repository - of the table carrito_pcs
     */
    @Autowired
    private ICarritoPcsRespository carritoPcsRespository;

    /**
     * Repository - of the table carrito_tablets
     */
    @Autowired
    private ICarritoTabletsRepository carritoTabletsRepository;

    /**
     * Repository - of the table profesor
     */
    @Autowired
    private IProfesorRepository profesorRepository;

    /**
     * Repository - of the table reserva_aula
     */
    @Autowired
    private IReservaAulaRespository reservaAulaRespository;

    /**
     * Repository - of the table reserva_carrito_tablets
     */
    @Autowired
    private IReservaCarritoTablets reservaCarritoTabletsRepository;

    /**
     * Repository - of the table reserva_carrito_pcs
     */
    @Autowired
    private IReservaCarritoPcsRepository reservaCarritoPcsRepository;

    /**
     * Class - used to check the session
     */
    @Autowired
    private CheckerSession checkerSession;

    /**
     * Class - used to check the day of the week
     */
    @Autowired
    private CheckerDayOfWeek checkerDayOfWeek;


    /**
     * Metodo en el que se obtiene la lista de reservas
     */
    @RequestMapping(method = RequestMethod.GET, value = "/reservas/")
    public ResponseEntity<?> getReservas(
                                            HttpSession session
    )
    {
        try
        {
            // Comprobamos la sesion, si no hay reservas inicializamos la lista de reservas
            session.setAttribute(Constants.SESSION_RESERVA_AULA, checkerSession.checkSessionReservaAula((List<ReservaAula>) session.getAttribute(Constants.SESSION_RESERVA_AULA)));

            // Comprobamos la sesion, si no hay reservas inicializamos la lista de reservas
            session.setAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS, checkerSession.checkSessionReservaCarritoTablets((List<ReservaAula>) session.getAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS)));

            // Comprobamos la sesion, si no hay reservas inicializamos la lista de reservas
            session.setAttribute(Constants.SESSION_RESERVA_CARRITO_PCS, checkerSession.checkSessionReservaCarritoPcs((List<ReservaAula>) session.getAttribute(Constants.SESSION_RESERVA_CARRITO_PCS)));

            List<ReservaAula> listaReservasAulas = this.reservaAulaRespository.findAll();;
            List<ReservaCarritoTablets> listaReservasTablets = this.reservaCarritoTabletsRepository.findAll();
            List<ReservaCarritoPcs> listaReservasPcs = this.reservaCarritoPcsRepository.findAll();

            LOGGER.info("Se ha obtenido la lista de reservas");
            return ResponseEntity.ok(new Reservas(listaReservasAulas, listaReservasTablets, listaReservasPcs));
        }
        catch (Exception exception)
        {
            LOGGER.error("Error al obtener la lista de reservas", exception);
            return ResponseEntity.status(590).body(exception.getMessage());
        }
    }

    /**
     * Metodo en el que se obtiene la lista de reservas de Aulas
     */
    @RequestMapping(method = RequestMethod.GET, value = "/reservas/aulas/")
    public ResponseEntity<?> getReservasAulas(
                                        HttpSession session
    )
    {
        try
        {
            // Comprobamos la sesion, si no hay reservas inicializamos la lista de reservas
            session.setAttribute(Constants.SESSION_RESERVA_AULA, checkerSession.checkSessionReservaAula((List<ReservaAula>) session.getAttribute(Constants.SESSION_RESERVA_AULA)));

            List<ReservaAula> listaReservasAulas = new ArrayList<>();

            // RELLENAR LAS LISTAS CON LOS DATOS DE LA BASE DE DATOS

            listaReservasAulas = this.reservaAulaRespository.findAll();

            LOGGER.info("Se ha obtenido la lista de reservas de aulas");
            return ResponseEntity.ok(listaReservasAulas);
        }
        catch (Exception exception)
        {
            LOGGER.error("Error al obtener la lista de reservas de aulas", exception);
            return ResponseEntity.status(590).body(exception.getMessage());
        }
    }


    /**
     * Metodo en el que se obtiene la lista de reservas de Tablets
     */
    @RequestMapping(method = RequestMethod.GET, value = "/reservas/tablets/")
    public ResponseEntity<?> getReservasTablets(
                                        HttpSession session
    )
    {
        try
        {
            // Comprobamos la sesion, si no hay reservas inicializamos la lista de reservas
            session.setAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS, checkerSession.checkSessionReservaCarritoTablets((List<ReservaAula>) session.getAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS)));

            List<ReservaCarritoTablets> listaReservasTablets = new ArrayList<>();

            // RELLENAR LAS LISTAS CON LOS DATOS DE LA BASE DE DATOS

            listaReservasTablets = reservaCarritoTabletsRepository.findAll();

            LOGGER.info("Se ha obtenido la lista de reservas de tablets");
            return ResponseEntity.ok(listaReservasTablets);
        }
        catch (Exception exception)
        {
            LOGGER.error("Error al obtener la lista de reservas de tablets", exception);
            return ResponseEntity.status(590).body(exception.getMessage());
        }
    }


    /**
     * Metodo en el que se obtiene la lista de reservas de pcs
     */
    @RequestMapping(method = RequestMethod.GET, value = "/reservas/pcs/")
    public ResponseEntity<?> getReservasPcs(
            HttpSession session
    )
    {
        try
        {
            // Comprobamos la sesion, si no hay reservas inicializamos la lista de reservas
            session.setAttribute(Constants.SESSION_RESERVA_CARRITO_PCS, checkerSession.checkSessionReservaCarritoPcs((List<ReservaAula>) session.getAttribute(Constants.SESSION_RESERVA_CARRITO_PCS)));

            List<ReservaCarritoPcs> listaReservasPcs = new ArrayList<>();

            // RELLENAR LAS LISTAS CON LOS DATOS DE LA BASE DE DATOS

            listaReservasPcs = this.reservaCarritoPcsRepository.findAll();

            LOGGER.info("Se ha obtenido la lista de reservas de pcs");
            return ResponseEntity.ok(listaReservasPcs);
        }
        catch (Exception exception)
        {
            LOGGER.error("Error al obtener la lista de reservas de pcs", exception);
            return ResponseEntity.status(590).body(exception.getMessage());
        }
    }


    /**
     * Metodo en el que se genera una reserva de un aula
     */
    @RequestMapping(method = RequestMethod.POST, value = "/aula/")
    public ResponseEntity<?> postReservarAula(
                                                        HttpSession session,
                                                        @RequestParam(required=true) final Long idProfesor,
                                                        @RequestParam(required=true) final Long idAula,
                                                        @RequestParam(required=true) final Long fecha
    )
    {

        if (checkerDayOfWeek.isWeekend(new Date(fecha)))
        {
            LOGGER.error("Error al reservar el aula, no se puede reservar un aula los fines de semana");
            return ResponseEntity.status(495).body("No se puede reservar un aula los fines de semana");
        }

        // Por si Accede directamente a este endpoint sin pasar por el de getReservas, checkeamos la session y en caso de que sea nula la inicializamos
        session.setAttribute(Constants.SESSION_RESERVA_AULA, checkerSession.checkSessionReservaAula((List<ReservaAula>) session.getAttribute(Constants.SESSION_RESERVA_AULA)));

        ReservaAula reservaAula = this.reservaAulaRespository.findById(new ReservaAulaId(idAula, new Date(fecha))).orElse(null);

        if (reservaAula != null)
        {
            LOGGER.error("Error al reservar el aula, ya existe una reserva para ese aula en esa fecha");
            return ResponseEntity.status(420).body("Ya existe una reserva para ese aula en esa fecha");
        }

        try
        {
            Profesor profesor = this.profesorRepository.findById(idProfesor).orElse(null);

            AulaInformatica aulaInformatica = this.aulaInformaticaRepository.findById(idAula).orElse(null);

            if (profesor != null && aulaInformatica != null)
            {
                LOGGER.info("Se ha reservado el aula correctamente");
                reservaAula = new ReservaAula(new ReservaAulaId(idAula, new Date(fecha)), profesor, aulaInformatica);
                ((List<ReservaAula>)session.getAttribute(Constants.SESSION_RESERVA_AULA)).add(reservaAula);
            }
            else
            {
                LOGGER.error("Error al reservar el aula, profesor o aula no encontrados");
                throw new ReservaException("420", "profesor o aula no encontrados");
            }

            return ResponseEntity.ok(reservaAula);
        }
        catch (ReservaException reservaException)
        {
            LOGGER.error("Error al reservar el aula, profesor o aula no encontrados", reservaException);
            return ResponseEntity.status(420).body(reservaException.getMessage());
        }
        catch (Exception exception)
        {
            LOGGER.error("Error al reservar el aula", exception);
            return ResponseEntity.status(590).body("Error al reservar el aula");
        }
    }

    /**
     * Metodo en el que se genera una reserva de un carrito de tablets y se almacenara en la base de datos
     */
    @RequestMapping(method = RequestMethod.POST, value = "/tablets/")
    public ResponseEntity<?> postReservarTablets(
                                                        HttpSession session,
                                                        @RequestParam(required=true) final Long idProfesor,
                                                        @RequestParam(required=true) final String aulaDestino,
                                                        @RequestParam(required=true) final Long fecha,
                                                        @RequestParam(required=true) final Long idCarritoTablet
    )
    {

        if (checkerDayOfWeek.isWeekend(new Date(fecha)))
        {
            LOGGER.error("Error al reservar el carrito de tablets, no se puede reservar un carrito de tablets los fines de semana");
            return ResponseEntity.status(495).body("No se puede reservar un carrito de tablets los fines de semana");
        }

        // Por si Accede directamente a este endpoint sin pasar por el de getReservas, checkeamos la session y en caso de que sea nula la inicializamos
        session.setAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS, checkerSession.checkSessionReservaCarritoTablets((List<ReservaAula>) session.getAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS)));

        // VAMOS A VER SI HAY CARRITOS DISPONIBLES EN ESA FECHA

        ReservaCarritoTablets reservaCarritoTablets = this.reservaCarritoTabletsRepository.findById(new ReservaCarritoTabletsId(idCarritoTablet, new Date(fecha))).orElse(null);

        try
        {
            if (reservaCarritoTablets != null)
            {
                throw new ReservaException("420", "Ya existe una reserva para ese carrito de tablets en esa fecha");
            }

            // SI NO HAY RESERVAS REALIZADAS HAY CARRITOS DISPONIBLES PARA ESA FECHA

            Profesor profesor;

            CarritoTablets carritoTablets;

            profesor = this.profesorRepository.findById(idProfesor).orElse(null);

            carritoTablets = this.carritoTabletsRepository.findById(idCarritoTablet).orElse(null);

            if (profesor != null && carritoTablets != null)
            {
                LOGGER.info("Se ha reservado el carrito de tablets correctamente");
                reservaCarritoTablets = new ReservaCarritoTablets(new ReservaCarritoTabletsId(idCarritoTablet, new Date(fecha)), profesor, carritoTablets, aulaDestino);

                ((List<ReservaCarritoTablets>)session.getAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS)).add(reservaCarritoTablets);
            }
            else
            {
                throw new ReservaException("420", "profesor o carrito de tablets no encontrados");
            }

            return ResponseEntity.ok(reservaCarritoTablets);

        }
        catch (ReservaException reservaException)
        {
            return ResponseEntity.status(Integer.parseInt(reservaException.getCode())).body(reservaException.getMessage());
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }
    }


    /**
     * Metodo en el que se genera una reserva de un ordenadores
     */
    @RequestMapping(method = RequestMethod.POST, value = "/pcs/")
    public ResponseEntity<?> postReservarOrdenadores(
                                                        HttpSession session,
                                                        @RequestParam(required=true) final Long idProfesor,
                                                        @RequestParam(required=true) final String aulaDestino,
                                                        @RequestParam(required=true) final Long fecha,
                                                        @RequestParam(required=true) final Long idCarritoPc
    )
    {
        if (checkerDayOfWeek.isWeekend(new Date(fecha)))
        {
            LOGGER.error("Error al reservar el carrito de pcs, no se puede reservar un carrito de pcs los fines de semana");
            return ResponseEntity.status(495).body("No se puede reservar un carrito de pcs los fines de semana");
        }

        // Por si Accede directamente a este endpoint sin pasar por el de getReservas, checkeamos la session y en caso de que sea nula la inicializamos
        session.setAttribute(Constants.SESSION_RESERVA_CARRITO_PCS, checkerSession.checkSessionReservaCarritoPcs((List<ReservaAula>) session.getAttribute(Constants.SESSION_RESERVA_CARRITO_PCS)));

        try
        {
            ReservaCarritoPcs reservaCarritoPcs = this.reservaCarritoPcsRepository.findById(new ReservaCarritoPcsId(idCarritoPc, new Date(fecha))).orElse(null);

            if (reservaCarritoPcs != null)
            {
                throw new ReservaException("420", "Ya existe una reserva para ese carrito de pcs en esa fecha");
            }


            Profesor profesor;

            CarritoPcs carritoPcs;

            profesor = this.profesorRepository.findById(idProfesor).orElse(null);

            carritoPcs = this.carritoPcsRespository.findById(idCarritoPc).orElse(null);

            if (profesor != null && carritoPcs != null)
            {
                reservaCarritoPcs = new ReservaCarritoPcs(new ReservaCarritoPcsId(idCarritoPc, new Date(fecha)), profesor, carritoPcs, aulaDestino);

                ((List<ReservaCarritoPcs>)session.getAttribute(Constants.SESSION_RESERVA_CARRITO_PCS)).add(reservaCarritoPcs);
            }
            else
            {
                return ResponseEntity.status(420).body("profesor o carrito de pcs no encontrados");
            }

            return ResponseEntity.ok(reservaCarritoPcs);

        }
        catch (ReservaException reservaException)
        {
            return ResponseEntity.status(Integer.parseInt(reservaException.getCode())).body(reservaException.getMessage());
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }

    }


    /**
     * Metodo en el que se confirma una reserva y se almacena en la base de datos
     */
    @RequestMapping(method = RequestMethod.POST, value = "/confirmar/")
    public ResponseEntity<?> postConfirmarReserva(
                                                        HttpSession session
    )
    {
        try
        {
            List<ReservaAula> reservaAulaList = (List<ReservaAula>) session.getAttribute(Constants.SESSION_RESERVA_AULA);
            List<ReservaCarritoTablets> reservaCarritoTablets = (List<ReservaCarritoTablets>) session.getAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS);
            List<ReservaCarritoPcs> reservaCarritoPcs = (List<ReservaCarritoPcs>) session.getAttribute(Constants.SESSION_RESERVA_CARRITO_PCS);

            if (reservaAulaList != null)
            {
                LOGGER.info("Reserva Aula Insertada en la base de datos");
                this.reservaAulaRespository.saveAllAndFlush(reservaAulaList);
            }

            if (reservaCarritoTablets != null)
            {
                LOGGER.info("Reserva Carrito Tablets Insertada en la base de datos");
                this.reservaCarritoTabletsRepository.saveAllAndFlush(reservaCarritoTablets);
            }

            if (reservaCarritoPcs != null)
            {
                LOGGER.info("Reserva Carrito Pcs Insertada en la base de datos");
                this.reservaCarritoPcsRepository.saveAllAndFlush(reservaCarritoPcs);
            }

            // Limpiamos la session
            LOGGER.info("Limpiando la session");
            session.removeAttribute(Constants.SESSION_RESERVA_AULA);
            session.removeAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS);
            session.removeAttribute(Constants.SESSION_RESERVA_CARRITO_PCS);

            return ResponseEntity.ok().build();
        }
        catch (Exception exception)
        {
            LOGGER.error("Error al confirmar la reserva", exception);
            return ResponseEntity.status(590).body(exception.getMessage());
        }
    }

    /**
     * Metodo en el que se cancela una reserva de un aula
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelarAula/")
    public ResponseEntity<?> deleteCancelarReservaAula(
                                                        HttpSession session,
                                                        @RequestParam(required=true) final Long idAula,
                                                        @RequestParam(required=true) final Long fecha
    )
    {
        try
        {

            List<ReservaAula> reservaAulaList = (List<ReservaAula>) session.getAttribute(Constants.SESSION_RESERVA_AULA);

            int size = reservaAulaList.size();

            if (reservaAulaList != null)
            {
                for (int i = 0; i<size; i++)
                {
                    if (reservaAulaList.get(i).getReservaAulaId().getIdAula().equals(idAula) && reservaAulaList.get(i).getReservaAulaId().getFecha().getTime() == fecha)
                    {
                        reservaAulaList.remove(reservaAulaList.get(i));
                        session.setAttribute(Constants.SESSION_RESERVA_AULA, reservaAulaList);
                        LOGGER.info("Se ha eliminado la reserva del carrito");
                        return ResponseEntity.ok().build();
                    }
                }
            }

            if (this.reservaAulaRespository.findById(new ReservaAulaId(idAula, new Date(fecha))).orElse(null) != null)
            {
                LOGGER.info("Se ha encontrado la reserva");
                this.reservaAulaRespository.deleteById(new ReservaAulaId(idAula, new Date(fecha)));
            }
            else
            {
                throw new ReservaException("420","No se ha encontrado la reserva");
            }

            return ResponseEntity.ok().build();
        }
        catch (ReservaException reservaException)
        {
            LOGGER.error(reservaException.getMessage());
            return ResponseEntity.status(Integer.parseInt(reservaException.getCode())).body(reservaException.getMessage());
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }
    }

    /**
     * Metodo en el que se cancela una reserva de un carrito de tablets
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelarTablets/")
    public ResponseEntity<?> deleteCancelarReservaTablets(
                                                            HttpSession session,
                                                            @RequestParam(required=true) final Long idCarritoTablets,
                                                            @RequestParam(required=true) final Long fecha
    )
    {
        try
        {

            List<ReservaCarritoTablets> reservaCarritoTabletsList = (List<ReservaCarritoTablets>) session.getAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS);

            int size = reservaCarritoTabletsList.size();

            if (reservaCarritoTabletsList != null)
            {
                for (int i = 0; i<size; i++)
                {
                    if (reservaCarritoTabletsList.get(i).getReservaCarritoTabletsId().getIdCarritoTablets().equals(idCarritoTablets) && reservaCarritoTabletsList.get(i).getReservaCarritoTabletsId().getFecha().getTime() == fecha)
                    {
                        reservaCarritoTabletsList.remove(reservaCarritoTabletsList.get(i));
                        session.setAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS, reservaCarritoTabletsList);
                        LOGGER.info("Se ha eliminado la reserva de la sesion");
                        return ResponseEntity.ok().build();
                    }
                }
            }

            if (this.reservaCarritoTabletsRepository.findById(new ReservaCarritoTabletsId(idCarritoTablets, new Date(fecha))).orElse(null) != null)
            {
                LOGGER.info("Se ha encontrado la reserva");
                this.reservaCarritoTabletsRepository.deleteById(new ReservaCarritoTabletsId(idCarritoTablets, new Date(fecha)));
            }
            else
            {
                throw new ReservaException("420","No se ha encontrado la reserva");
            }

            return ResponseEntity.ok().build();

        }
        catch (ReservaException reservaException)
        {
            LOGGER.error(reservaException.getMessage());
            return ResponseEntity.status(Integer.parseInt(reservaException.getCode())).body(reservaException.getMessage());
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }
    }

    /**
     * Metodo en el que se cancela una reserva de un ordenador
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelarOrdenadores/")
    public ResponseEntity<?> deleteCancelarReservaOrdenadores(
                                                                HttpSession session,
                                                                @RequestParam(required=true) final Long idCarritoPcs,
                                                                @RequestParam(required=true) final Long fecha
    )
    {
        try
        {

            List<ReservaCarritoPcs> reservaCarritoPcsList = (List<ReservaCarritoPcs>) session.getAttribute(Constants.SESSION_RESERVA_CARRITO_PCS);

            if (reservaCarritoPcsList != null)
            {
                for (ReservaCarritoPcs reservaCarritoPcs : reservaCarritoPcsList)
                {
                    if (reservaCarritoPcs.getReservaCarritoPcsId().getIdCarritoPcs().equals(idCarritoPcs) && reservaCarritoPcs.getReservaCarritoPcsId().getFecha().getTime() == fecha)
                    {
                        reservaCarritoPcsList.remove(reservaCarritoPcs);
                        session.setAttribute(Constants.SESSION_RESERVA_CARRITO_PCS, reservaCarritoPcsList);
                        LOGGER.info("Se ha eliminado la reserva de la sesion");
                        return ResponseEntity.ok().build();
                    }
                }
            }


            if (this.reservaCarritoPcsRepository.findById(new ReservaCarritoPcsId(idCarritoPcs, new Date(fecha))).orElse(null) != null)
            {
                LOGGER.info("Se ha eliminado la reserva de la base de datos");
                this.reservaCarritoPcsRepository.deleteById(new ReservaCarritoPcsId(idCarritoPcs, new Date(fecha)));
            }
            else
            {
                throw new ReservaException("420","No se ha encontrado la reserva");
            }


            return ResponseEntity.ok().build();
        }
        catch (ReservaException exception)
        {
            LOGGER.error(exception.getMessage());
            return ResponseEntity.status(Integer.parseInt(exception.getCode())).body(exception.getMessage());
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }
    }
}
