package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.service.ServiceLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//"/Transportadora"
@Controller
@RestController()
public class IndexController {

    @Autowired
    private ServiceLogin serviceLogin;

    @GetMapping(value = {"/", "/Login"})
    public ModelAndView index() {
        return new ModelAndView("Login");
    }

    @GetMapping("/Opcoes")
    public ModelAndView opcoes() {
        return new ModelAndView("Opcoes");
    }
}
