package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.service.ServiceLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//"/Transportadora"
@RestController()
public class IndexController {

    @Autowired
    private ServiceLogin serviceLogin;

    @GetMapping("/")
    public ModelAndView index() {
        return login();
    }

    @GetMapping("/Login")
    public ModelAndView login() {    
        return new ModelAndView("Login");
    }

    @GetMapping("/Opcoes")
    public ModelAndView opcoes() {
        return new ModelAndView("Opcoes");
    }
}
