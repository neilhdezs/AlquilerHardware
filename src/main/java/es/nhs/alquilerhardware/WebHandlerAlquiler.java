package es.nhs.alquilerhardware;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 30/01/2023
 */
@Controller
public class WebHandlerAlquiler {


    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String showIndex()
    {
        return "index.html";
    }

    @RequestMapping(value = "/aulas/", method = RequestMethod.GET)
    public String showReservaAulas()
    {
        return "/reservaAula.html";
    }

    @RequestMapping(value = "/tablets/", method = RequestMethod.GET)
    public String showReservaTablets()
    {
        return "/reservaTablets.html";
    }

    @RequestMapping(value = "/pcs/", method = RequestMethod.GET)
    public String showReservaPcs()
    {
        return "/reservaPcs.html";
    }

    @RequestMapping(value = "/eliminarReserva/", method = RequestMethod.GET)
    public String showEliminarReserva()
    {
        return "/removeReserva.html";
    }

    @RequestMapping(value = "/css/tables.css" , method = RequestMethod.GET)
    public String showCssTables()
    {
        return "/css/tables.css";
    }

    @RequestMapping(value = "/js/insert_data/insertDataTableAulas.js" , method = RequestMethod.GET)
    public String showJsInsertDataTableAulas()
    {
        return "/js/insert_data/insertDataTableAulas.js";
    }

    @RequestMapping(value = "/js/insert_data/insertDataTableTablets.js" , method = RequestMethod.GET)
    public String showJsInsertDataTableTablets()
    {
        return "/js/insert_data/insertDataTableTablets.js";
    }

    @RequestMapping(value = "/js/insert_data/insertDataTablePcs.js" , method = RequestMethod.GET)
    public String showJsInsertDataTablePcs()
    {
        return "/js/insert_data/insertDataTablePcs.js";
    }

    @RequestMapping(value = "/js/query/query.js" , method = RequestMethod.GET)
    public String showJsQuery()
    {
        return "/js/query/query.js";
    }

    @RequestMapping(value = "/js/utils/utils.js" , method = RequestMethod.GET)
    public String showJsUtils()
    {
        return "/js/utils/utils.js";
    }

    @RequestMapping(value = "/js/utils/dataPicker.js" , method = RequestMethod.GET)
    public String showJsDataPicker()
    {
        return "/js/utils/dataPicker.js";
    }

    @RequestMapping(value = "/js/post_reservas/postReservaAula.js" , method = RequestMethod.GET)
    public String showJsPostReservasAulas()
    {
        return "/js/post_reservas/postReservaAula.js";
    }

    @RequestMapping(value = "/js/query/post.js" , method = RequestMethod.GET)
    public String showJsPost()
    {
        return "/js/query/post.js";
    }

    @RequestMapping(value = "/js/post_reservas/postReservaPcs.js" , method = RequestMethod.GET)
    public String showJsPostReservasPcs()
    {
        return "/js/post_reservas/postReservaPcs.js";
    }

    @RequestMapping(value = "/js/utils/confirmAll.js" , method = RequestMethod.GET)
    public String showJsConfirm()
    {
        return "/js/utils/confirmAll.js";
    }

    @RequestMapping(value = "/js/post_reservas/postReservaTablets.js" , method = RequestMethod.GET)
    public String showJsPostReservasTablets()
    {
        return "js/post_reservas/postReservaTablets.js";
    }

    @RequestMapping(value = "/js/utils/changeIdForRemoveReservas.js" , method = RequestMethod.GET)
    public String showJsChangeIdForRemoveReservas()
    {
        return "/js/utils/changeIdForRemoveReservas.js";
    }

    @RequestMapping(value = "/js/post_reservas/postDeleteReserva.js" , method = RequestMethod.GET)
    public String showJsPostDeleteReserva()
    {
        return "/js/post_reservas/postDeleteReserva.js";
    }

}
