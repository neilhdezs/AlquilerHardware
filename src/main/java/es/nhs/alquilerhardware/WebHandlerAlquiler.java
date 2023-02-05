package es.nhs.alquilerhardware;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Neil Hdez
 * this class is used to handle the web requests
 */
@Controller
public class WebHandlerAlquiler {

    /**
     * this method is used to show the index.html page
     * @return the index.html page
     */
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String showIndex()
    {
        return "index.html";
    }

    /**
     * this method is used to show the reservaAula.html page
     * @return the reservaAula.html page
     */
    @RequestMapping(value = "/aulas/", method = RequestMethod.GET)
    public String showReservaAulas()
    {
        return "/reservaAula.html";
    }

    /**
     * this method is used to show the reservaTablets.html page
     * @return the reservaTablets.html page
     */
    @RequestMapping(value = "/tablets/", method = RequestMethod.GET)
    public String showReservaTablets()
    {
        return "/reservaTablets.html";
    }

    /**
     * this method is used to show the reservaPcs.html page
     * @return the reservaPcs.html page
     */
    @RequestMapping(value = "/pcs/", method = RequestMethod.GET)
    public String showReservaPcs()
    {
        return "/reservaPcs.html";
    }

    /**
     * this method is used to show the removeReserva.html page
     * @return the removeReserva.html page
     */
    @RequestMapping(value = "/eliminarReserva/", method = RequestMethod.GET)
    public String showEliminarReserva()
    {
        return "/removeReserva.html";
    }

    /**
     * this method is used to show the tables.css file
     * @return the tables.css file
     */
    @RequestMapping(value = "/css/tables.css" , method = RequestMethod.GET)
    public String showCssTables()
    {
        return "/css/tables.css";
    }

    /**
     * this method is used to show the insertDataTableAulas.js file
     * @return the insertDataTableAulas.js file
     */
    @RequestMapping(value = "/js/insert_data/insertDataTableAulas.js" , method = RequestMethod.GET)
    public String showJsInsertDataTableAulas()
    {
        return "/js/insert_data/insertDataTableAulas.js";
    }

    /**
     * this method is used to show the insertDataTableTablets.js file
     * @return the insertDataTableTablets.js file
     */
    @RequestMapping(value = "/js/insert_data/insertDataTableTablets.js" , method = RequestMethod.GET)
    public String showJsInsertDataTableTablets()
    {
        return "/js/insert_data/insertDataTableTablets.js";
    }

    /**
     * this method is used to show the insertDataTablePcs.js file
     * @return the insertDataTablePcs.js file
     */
    @RequestMapping(value = "/js/insert_data/insertDataTablePcs.js" , method = RequestMethod.GET)
    public String showJsInsertDataTablePcs()
    {
        return "/js/insert_data/insertDataTablePcs.js";
    }

    /**
     * this method is used to show the query.js file
     * @return the query.js file
     */
    @RequestMapping(value = "/js/query/query.js" , method = RequestMethod.GET)
    public String showJsQuery()
    {
        return "/js/query/query.js";
    }

    /**
     * this method is used to show the utils.js file
     * @return the utils.js file
     */
    @RequestMapping(value = "/js/utils/utils.js" , method = RequestMethod.GET)
    public String showJsUtils()
    {
        return "/js/utils/utils.js";
    }

    /**
     * this method is used to show the dataPicker.js file
     * @return the dataPicker.js file
     */
    @RequestMapping(value = "/js/utils/dataPicker.js" , method = RequestMethod.GET)
    public String showJsDataPicker()
    {
        return "/js/utils/dataPicker.js";
    }

    /**
     * this method is used to show the postReservaAula.js file
     * @return the postReservaAula.js file
     */
    @RequestMapping(value = "/js/post_reservas/postReservaAula.js" , method = RequestMethod.GET)
    public String showJsPostReservasAulas()
    {
        return "/js/post_reservas/postReservaAula.js";
    }

    /**
     * this method is used to show the post.js file
     * @return the post.js file
     */
    @RequestMapping(value = "/js/query/post.js" , method = RequestMethod.GET)
    public String showJsPost()
    {
        return "/js/query/post.js";
    }

    /**
     * this method is used to show the postReservaPcs.js file
     * @return the postReservaPcs.js file
     */
    @RequestMapping(value = "/js/post_reservas/postReservaPcs.js" , method = RequestMethod.GET)
    public String showJsPostReservasPcs()
    {
        return "/js/post_reservas/postReservaPcs.js";
    }

    /**
     * this method is used to show the confirmAll.js file
     * @return the confirmAll.js file
     */
    @RequestMapping(value = "/js/utils/confirmAll.js" , method = RequestMethod.GET)
    public String showJsConfirm()
    {
        return "/js/utils/confirmAll.js";
    }

    /**
     * this method is used to show the postReservaTablets.js file
     * @return the postReservaTablets.js file
     */
    @RequestMapping(value = "/js/post_reservas/postReservaTablets.js" , method = RequestMethod.GET)
    public String showJsPostReservasTablets()
    {
        return "js/post_reservas/postReservaTablets.js";
    }

    /**
     * this method is used to show the changeIdForRemoveReservas.js file
     * @return the changeIdForRemoveReservas.js file
     */
    @RequestMapping(value = "/js/utils/changeIdForRemoveReservas.js" , method = RequestMethod.GET)
    public String showJsChangeIdForRemoveReservas()
    {
        return "/js/utils/changeIdForRemoveReservas.js";
    }

    /**
     * this method is used to show the postDeleteReserva.js file
     * @return the postDeleteReserva.js file
     */
    @RequestMapping(value = "/js/post_reservas/postDeleteReserva.js" , method = RequestMethod.GET)
    public String showJsPostDeleteReserva()
    {
        return "/js/post_reservas/postDeleteReserva.js";
    }

}
