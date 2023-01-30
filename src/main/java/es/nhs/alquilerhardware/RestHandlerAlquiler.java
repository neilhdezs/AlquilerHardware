package es.nhs.alquilerhardware;


import es.nhs.alquilerhardware.models.*;
import es.nhs.alquilerhardware.models.modelsRest.Reservas;
import es.nhs.alquilerhardware.repository.*;
import es.nhs.alquilerhardware.utils.Constants;
import es.nhs.alquilerhardware.utils.JsonUtils;
import es.nhs.alquilerhardware.utils.ReservaException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 15/01/2023
 */
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:63342"})
@RequestMapping(value = "", produces = {"application/json"})
@RestController //
@Controller
public class RestHandlerAlquiler
{

    @Autowired
    private IAulaInformaticaRepository aulaInformaticaRepository;

    @Autowired
    private ICarritoPcsRespository carritoPcsRespository;

    @Autowired
    private ICarritoTabletsRepository carritoTabletsRepository;

    @Autowired
    private IProfesorRepository profesorRepository;

    @Autowired
    private IReservaAulaRespository reservaAulaRespository;

    @Autowired
    private IReservaCarritoTablets reservaCarritoTabletsRepository;

    @Autowired
    private IReservaCarritoPcsRepository reservaCarritoPcsRepository;

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

            if (session.getAttribute(Constants.SESSION_RESERVA_AULA) == null)
            {
                session.setAttribute(Constants.SESSION_RESERVA_AULA, new ArrayList<>());  // Se Inicializa la reserva de Aulas de la sesion
            }

            if (session.getAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS) == null)
            {
                session.setAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS, new ArrayList<>());  // Se Inicializa la reserva del carrito de tablets de la sesion
            }

            if (session.getAttribute(Constants.SESSION_RESERVA_CARRITO_PCS) == null)
            {
                session.setAttribute(Constants.SESSION_RESERVA_CARRITO_PCS, new ArrayList<>());  // Se Inicializa la reserva del carrito de pcs la sesion
            }

            List<ReservaAula> listaReservasAulas = new ArrayList<>();
            List<ReservaCarritoTablets> listaReservasTablets = new ArrayList<>();
            List<ReservaCarritoPcs> listaReservasPcs = new ArrayList<>();

            // RELLENAR LAS LISTAS CON LOS DATOS DE LA BASE DE DATOS

            listaReservasAulas = reservaAulaRespository.findAll();
            listaReservasTablets = reservaCarritoTabletsRepository.findAll();
            listaReservasPcs = reservaCarritoPcsRepository.findAll();


            return ResponseEntity.ok(new Reservas(listaReservasAulas, listaReservasTablets, listaReservasPcs));
        }
        catch (Exception exception)
        {
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
            if (session.getAttribute(Constants.SESSION_RESERVA_AULA) == null)
            {
                session.setAttribute(Constants.SESSION_RESERVA_AULA, new ArrayList<>());  // Se Inicializa la reserva de Aulas de la sesion
            }

            List<ReservaAula> listaReservasAulas = new ArrayList<>();

            // RELLENAR LAS LISTAS CON LOS DATOS DE LA BASE DE DATOS

            listaReservasAulas = reservaAulaRespository.findAll();

            return ResponseEntity.ok(listaReservasAulas);
        }
        catch (Exception exception)
        {
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
            if (session.getAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS) == null)
            {
                session.setAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS, new ArrayList<>());  // Se Inicializa la reserva del carrito de tablets de la sesion
            }

            List<ReservaCarritoTablets> listaReservasTablets = new ArrayList<>();

            // RELLENAR LAS LISTAS CON LOS DATOS DE LA BASE DE DATOS

            listaReservasTablets = reservaCarritoTabletsRepository.findAll();

            return ResponseEntity.ok(listaReservasTablets);
        }
        catch (Exception exception)
        {
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
            if (session.getAttribute(Constants.SESSION_RESERVA_CARRITO_PCS) == null)
            {
                session.setAttribute(Constants.SESSION_RESERVA_CARRITO_PCS, new ArrayList<>());  // Se Inicializa la reserva del carrito de pcs la sesion
            }

            List<ReservaCarritoPcs> listaReservasPcs = new ArrayList<>();

            // RELLENAR LAS LISTAS CON LOS DATOS DE LA BASE DE DATOS

            listaReservasPcs = reservaCarritoPcsRepository.findAll();


            return ResponseEntity.ok(listaReservasPcs);
        }
        catch (Exception exception)
        {
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

        ReservaAula reservaAula = this.reservaAulaRespository.findById(new ReservaAulaId(idAula, new Date(fecha))).orElse(null);

        if (reservaAula != null)
        {
            return ResponseEntity.status(420).body("Ya existe una reserva para ese aula en esa fecha");
        }

        try
        {

            Profesor profesor;

            AulaInformatica aulaInformatica;

            profesor = this.profesorRepository.findById(idProfesor).orElse(null);

            aulaInformatica = this.aulaInformaticaRepository.findById(idAula).orElse(null);

            if (profesor != null && aulaInformatica != null)
            {

                reservaAula = new ReservaAula(new ReservaAulaId(idAula, new Date(fecha)), profesor, aulaInformatica);

                ((List<ReservaAula>)session.getAttribute(Constants.SESSION_RESERVA_AULA)).add(reservaAula);

            }
            else
            {
                return ResponseEntity.status(420).body("profesor o aula no encontrados");
            }


            return ResponseEntity.ok(reservaAula);

        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }

    }


    /**
     * Metodo en el que se genera una reserva de un carrito de tablets
     */
    @RequestMapping(method = RequestMethod.POST, value = "/tablets/")
    public ResponseEntity<?> postReservartablets(
                                                        HttpSession session,
                                                        @RequestParam(required=true) final Long idProfesor,
                                                        @RequestParam(required=true) final String aulaDestino,
                                                        @RequestParam(required=true) final Long fecha,
                                                        @RequestParam(required=true) final Long idCarritoTablets
    )
    {

        // VAMOS A VER SI HAY CARRITOS DISPONIBLES EN ESA FECHA

        ReservaCarritoTablets reservaCarritoTablets = this.reservaCarritoTabletsRepository.findById(new ReservaCarritoTabletsId(idCarritoTablets, new Date(fecha))).orElse(null);

        if (reservaCarritoTablets != null)
        {
            return ResponseEntity.status(420).body("Ya existe una reserva para ese carrito en esa fecha");
        }

        // SI NO HAY RESERVAS REALIZADAS HAY CARRITOS DISPONIBLES PARA ESA FECHA

        try
        {
            Profesor profesor;

            String aulaInformatica;

            CarritoTablets carritoTablets;

            profesor = this.profesorRepository.findById(idProfesor).orElse(null);

            carritoTablets = this.carritoTabletsRepository.findById(idCarritoTablets).orElse(null);

            if (profesor != null && carritoTablets != null)
            {
                reservaCarritoTablets = new ReservaCarritoTablets(new ReservaCarritoTabletsId(idCarritoTablets, new Date(fecha)), profesor, carritoTablets, aulaDestino);

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
                                                        @RequestParam(required=true) final Long idCarritoPcs
    )
    {

        ReservaCarritoPcs reservaCarritoPcs = this.reservaCarritoPcsRepository.findById(new ReservaCarritoPcsId(idCarritoPcs, new Date(fecha))).orElse(null);

        if (reservaCarritoPcs != null)
        {
            return ResponseEntity.status(420).body("Ya existe una reserva para ese carrito de pcs en esa fecha");
        }

        try
        {
            Profesor profesor;

            CarritoPcs carritoPcs;

            profesor = this.profesorRepository.findById(idProfesor).orElse(null);

            carritoPcs = this.carritoPcsRespository.findById(idCarritoPcs).orElse(null);

            if (profesor != null && carritoPcs != null)
            {

                reservaCarritoPcs = new ReservaCarritoPcs(new ReservaCarritoPcsId(idCarritoPcs, new Date(fecha)), profesor, carritoPcs, aulaDestino);

                ((List<ReservaCarritoPcs>)session.getAttribute(Constants.SESSION_RESERVA_CARRITO_PCS)).add(reservaCarritoPcs);


            }
            else
            {
                return ResponseEntity.status(420).body("profesor o carrito de pcs no encontrados");
            }

            return ResponseEntity.ok(reservaCarritoPcs);

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

            session.removeAttribute(Constants.SESSION_RESERVA_AULA);
            session.removeAttribute(Constants.SESSION_RESERVA_CARRITO_TABLETS);
            session.removeAttribute(Constants.SESSION_RESERVA_CARRITO_PCS);

            this.reservaAulaRespository.saveAllAndFlush(reservaAulaList);
            this.reservaCarritoTabletsRepository.saveAllAndFlush(reservaCarritoTablets);
            this.reservaCarritoPcsRepository.saveAllAndFlush(reservaCarritoPcs);

            return ResponseEntity.ok().build();
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }

    }

    /**
     * Metodo en el que se cancela una reserva de un aula
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelarAula/")
    public ResponseEntity<?> deleteCancelarReservaAula(
                                                        @RequestParam(required=true) final Long idAula,
                                                        @RequestParam(required=true) final Long fecha
    )
    {

        try
        {
            this.reservaAulaRespository.deleteById(new ReservaAulaId(idAula, new Date(fecha)));

            return ResponseEntity.ok().build();
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
                                                            @RequestParam(required=true) final Long fecha,
                                                            @RequestParam(required=true) final Long idCarritoTablets
    )
    {

        try
        {
            this.reservaCarritoTabletsRepository.deleteById(new ReservaCarritoTabletsId(idCarritoTablets, new Date(fecha)));

            return ResponseEntity.ok().build();
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
                                                                @RequestParam(required=true) final Long fecha,
                                                                @RequestParam(required=true) final Long idCarritoPcs
    )
    {

        try
        {
            this.reservaCarritoPcsRepository.deleteById(new ReservaCarritoPcsId(idCarritoPcs, new Date(fecha)));

            return ResponseEntity.ok().build();
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }

    }

}
