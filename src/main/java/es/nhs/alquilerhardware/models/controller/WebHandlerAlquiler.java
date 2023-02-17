package es.nhs.alquilerhardware.models.controller;

import es.nhs.alquilerhardware.models.modelsSecurity.User;
import es.nhs.alquilerhardware.security.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Neil Hdez
 * this class is used to handle the web requests
 */
@Controller
public class WebHandlerAlquiler
{

    @Autowired
    private UserService userService;

    /**
     * this method is used to show the index.html page
     *
     * @return the index.html page
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView showIndex()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Bienvenido " + user.getName());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * this method is used to show the reservaAula.html page
     *
     * @return the reservaAula.html page
     */
    @RequestMapping(value = "/aulas/", method = RequestMethod.GET)
    public ModelAndView showReservaAulas()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Bienvenido " + user.getName());
        modelAndView.setViewName("reservaAula");
        return modelAndView;
    }

    /**
     * this method is used to show the reservaTablets.html page
     *
     * @return the reservaTablets.html page
     */
    @RequestMapping(value = "/tablets/", method = RequestMethod.GET)
    public ModelAndView showReservaTablets()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Bienvenido " + user.getName());
        modelAndView.setViewName("reservaTablets");
        return modelAndView;
    }

    /**
     * this method is used to show the reservaPcs.html page
     *
     * @return the reservaPcs.html page
     */
    @RequestMapping(value = "/pcs/", method = RequestMethod.GET)
    public ModelAndView showReservaPcs()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Bienvenido " + user.getName());
        modelAndView.setViewName("reservaPcs");
        return modelAndView;
    }

    /**
     * this method is used to show the removeReserva.html page
     *
     * @return the removeReserva.html page
     */
    @RequestMapping(value = "/eliminarReserva/", method = RequestMethod.GET)
    public ModelAndView showEliminarReserva()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Bienvenido " + user.getName());
        modelAndView.setViewName("removeReserva");
        return modelAndView;
    }

    /**
     * this method is used to show login.html page
     *
     * @return the login.html page
     */
    @GetMapping(value =  "/login")
    public ModelAndView login()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * this method is used to show registration.html page
     *
     * @return the registration.html page
     */
    @GetMapping(value = "/register")
    public ModelAndView registration()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("register");
        return modelAndView;
    }

    /**
     * this method is used to create a new user
     *
     * @param user         the user to be created
     * @param bindingResult the result of the binding
     * @return the registration.html page
     */
    @PostMapping(value = "/register")
    public ModelAndView createNewUser(@Validated User user, BindingResult bindingResult)
    {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUserName(user.getUserName());
        if (userExists != null)
        {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors())
        {
            modelAndView.setViewName("register");
        } else
        {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }



}
